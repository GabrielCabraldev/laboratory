package br.com.danilomr.hubfintech.fixtures;

import br.com.danilomr.hubfintech.usecases.entities.ActionResult;

public class ActionResultFixture {

    public static ActionResult defaultValues() {
        ActionResult actionResult = new ActionResult();
        actionResult.setCode("00");
        actionResult.setAuthorizationCode("123456");
        actionResult.setAction("withdraw");

        return actionResult;
    }
}
