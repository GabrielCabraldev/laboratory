package br.com.danilomr.hubfintech.entrypoints.mappers;

import br.com.danilomr.hubfintech.entrypoints.dto.response.ResponseActionDTO;
import br.com.danilomr.hubfintech.fixtures.ActionResultFixture;
import br.com.danilomr.hubfintech.usecases.entities.ActionResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class ResponseActionDTOMapperUnitTest {

    @Test
    public void shouldConvertActionResult() {

        final ActionResult actionResult = ActionResultFixture.defaultValues();
        final ResponseActionDTO response = ResponseActionDTOMapper.toDTO(actionResult);

        assertNotNull(response);
        assertEquals(response.getCode(), actionResult.getCode());
        assertEquals(response.getAuthorizationCode(), actionResult.getAuthorizationCode());
        assertEquals(response.getAction(), actionResult.getAction());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailActionNull() {
        ResponseActionDTOMapper.toDTO(null);
    }
}
