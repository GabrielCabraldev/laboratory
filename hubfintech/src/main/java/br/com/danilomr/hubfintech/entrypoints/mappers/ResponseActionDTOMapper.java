package br.com.danilomr.hubfintech.entrypoints.mappers;

import br.com.danilomr.hubfintech.entrypoints.dto.response.ResponseActionDTO;
import br.com.danilomr.hubfintech.usecases.entities.ActionResult;
import org.springframework.util.Assert;


public class ResponseActionDTOMapper {

    /**
     *
     * Responsável por mapear a entidade de negócio para o objeto de resposta.
     * @param actionResult
     * @return
     */
    public static ResponseActionDTO toDTO(final ActionResult actionResult) {

        Assert.notNull(actionResult, "Action result cannot be null.");

        ResponseActionDTO actionDTO = new ResponseActionDTO();
        actionDTO.setAction(actionResult.getAction());
        actionDTO.setAuthorizationCode(actionResult.getAuthorizationCode());
        actionDTO.setCode(actionResult.getCode());

        return actionDTO;
    }
}
