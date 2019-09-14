package br.com.danilomr.hubfintech.entrypoints;

import br.com.danilomr.hubfintech.entrypoints.dto.response.DefaultErrorDTO;
import br.com.danilomr.hubfintech.entrypoints.dto.response.ResponseCardDTO;
import br.com.danilomr.hubfintech.entrypoints.mappers.ResponseCardDTOMapper;
import br.com.danilomr.hubfintech.exceptions.CardNotFoundException;
import br.com.danilomr.hubfintech.usecases.GetCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    private GetCard getCard;

    @GetMapping(value = "/{cardNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCard(@PathVariable("cardNumber") final String cardNumber) {

        try {
            final ResponseCardDTO response = ResponseCardDTOMapper.toDTO(getCard.execute(cardNumber));
            return ResponseEntity.ok(response);
        } catch (CardNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.valueOf(e.getError().getCode()))
                    .body(buildErrorResponse(e.getError().getCode(), e.getError().getMessage()));
        }
    }

    private DefaultErrorDTO buildErrorResponse(final Integer code, final String message) {

        DefaultErrorDTO errorDTO = new DefaultErrorDTO();
        errorDTO.setCode(code);
        errorDTO.setMessage(message);

        return errorDTO;
    }
}
