package com.perficient.restassuredtest.stepdefinitions;

import io.cucumber.java.Before;

public class Hooks {

    @Before("@deletePlace")
    public void createPlaceBeforeDelete() {
        MyStepdefs ms = new MyStepdefs();
        ms.userHasTheRequestBody();
        ms.userSendsRequestWithCall("CREATE_PLACE", "POST");
        ms.userSeeThePlaceIsAddedOnTheMap();
    }

    @Before("@getPlace")
    public void createPlaceBeforeGet() {
        MyStepdefs ms = new MyStepdefs();
        ms.userHasTheRequestBody();
        ms.userSendsRequestWithCall("CREATE_PLACE", "POST");
        ms.userSeeThePlaceIsAddedOnTheMap();
    }
}
