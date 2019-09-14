package br.com.danilomr.hubfintech.usecases;

import br.com.danilomr.hubfintech.entrypoints.enums.ActionEnum;
import br.com.danilomr.hubfintech.entrypoints.enums.CodeEnum;
import br.com.danilomr.hubfintech.gateways.CardRepository;
import br.com.danilomr.hubfintech.gateways.TransactionRepository;
import br.com.danilomr.hubfintech.gateways.data.CardData;
import br.com.danilomr.hubfintech.gateways.data.TransactionData;
import br.com.danilomr.hubfintech.usecases.entities.ActionResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@Service
public class AddAction {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    /**
     *
     * Responsável por fazer a gravação de uma transação.
     * @param cardNumber
     * @param stringAmount
     * @return
     */
    public ActionResult execute(final String cardNumber,
                                final String stringAmount)  {

        //Busca pelo cartão utilizando o seu número
        CardData cardData = cardRepository.findByCardNumber(cardNumber);
        String authorizationCode = StringUtils.EMPTY;

        //Valida se o valor informado está nulo ou vazio.
        //Esta validação é necessária, pois se ocorre algum problema na hora em
        //que o Jackson faz o parse da requisição, o número é passado como null
        if (StringUtils.isBlank(stringAmount)) {
            return buildActionResult(authorizationCode, CodeEnum.ERROR.getCode());
        }

        //Transaforma o valor de string para número
        final BigDecimal amount = getAmount(stringAmount);

        //Obtém o código de status da transação baseado nos valores informados
        final String actionCode = getActionCode(cardData, amount);

        //No caso das informações estarem corretas, nesse ponto a transação é persistida
        if(actionCode.equals(CodeEnum.APPROVED.getCode())) {
            TransactionData transaction = saveTransaction(amount);
            cardData.getTransactions().add(transaction);
            cardData.setAvailableAmount(cardData.getAvailableAmount().subtract(amount));
            cardData = cardRepository.save(cardData);
            authorizationCode = generateAuthorizationCode();
        }

        //Monta a entidade de negócio para responder ao controller
        return buildActionResult(authorizationCode, actionCode);
    }

    private ActionResult buildActionResult(final String authorizationCode, final String actionCode) {
        ActionResult actionResult = new ActionResult();
        actionResult.setAction(ActionEnum.WITHDRAW.getDescription());
        actionResult.setAuthorizationCode(authorizationCode);
        actionResult.setCode(actionCode);

        return actionResult;
    }

    private TransactionData saveTransaction(BigDecimal amount) {

        TransactionData transactionData = new TransactionData();
        transactionData.setAmount(amount);
        transactionData.setDate(getActualDateString());

        return transactionRepository.save(transactionData);
    }

    private String getActionCode(CardData cardData, BigDecimal amount) {

        if(cardData == null) {
            return CodeEnum.INVALID_ACCOUNT.getCode();
        }else if(cardData.getAvailableAmount().subtract(amount).compareTo(BigDecimal.valueOf(0)) < 0) {
            return CodeEnum.INSUFFICIENT_FUNDS.getCode();
        }else if(cardData.getAvailableAmount().subtract(amount).compareTo(BigDecimal.valueOf(0)) >= 0) {
            return CodeEnum.APPROVED.getCode();
        }
        return CodeEnum.ERROR.getCode();
    }

    private BigDecimal getAmount(final String stringAmount) {
        return new BigDecimal(stringAmount
                .replaceAll(",","."))
                .setScale(2);
    }

    private String getActualDateString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime date = LocalDateTime.now();
        return date.format(formatter);
    }

    private String generateAuthorizationCode() {
        Random r = new Random();
        Integer code = r.nextInt((999999 - 100000) + 1) + 100000;
        return code.toString();
    }
}
