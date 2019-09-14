package br.com.danilomr.hubfintech.entrypoints;

import br.com.danilomr.hubfintech.entrypoints.dto.request.RequestActionDTO;
import br.com.danilomr.hubfintech.entrypoints.dto.response.ResponseActionDTO;
import br.com.danilomr.hubfintech.entrypoints.enums.ActionEnum;
import br.com.danilomr.hubfintech.entrypoints.enums.CodeEnum;
import br.com.danilomr.hubfintech.entrypoints.mappers.ResponseActionDTOMapper;
import br.com.danilomr.hubfintech.usecases.AddAction;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

@MessageEndpoint
public class TcpServerEndpoint {

    @Autowired
    private AddAction addAction;

    @ServiceActivator(inputChannel = "inboundChannel")
    public byte[] process(byte[] message) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        try {
            //Parse da mensagem de input para string.
            String stringRequest = new String(message);

            //Mapeamento do request para o objeto de entrada.
            RequestActionDTO request = mapper.readValue(stringRequest, RequestActionDTO.class);

            //Valida se o atributo action é válido.
            if(StringUtils.isBlank(request.getAction()) ||
                    !request.getAction().equalsIgnoreCase(ActionEnum.WITHDRAW.getDescription())) {
                return mapper.writeValueAsString(buildErrorResponse()).getBytes();
            }

            //Efetua a chamada ao serviço de inclusão de transação e mapeia
            //o resultado obtido para o objeto de resposta.
            ResponseActionDTO responseDTO = ResponseActionDTOMapper.
                    toDTO(addAction.execute(request.getCardNumber(), request.getAmount()));

            String response = mapper.writeValueAsString(responseDTO);

            return response.getBytes();

        } catch (Exception e) {
            return mapper.writeValueAsString(buildErrorResponse()).getBytes();
        }
    }

    private ResponseActionDTO buildErrorResponse() {
        ResponseActionDTO response = new ResponseActionDTO();
        response.setAction(ActionEnum.WITHDRAW.getDescription());
        response.setCode(CodeEnum.ERROR.getCode());
        response.setAuthorizationCode(StringUtils.EMPTY);

        return response;
    }

}
