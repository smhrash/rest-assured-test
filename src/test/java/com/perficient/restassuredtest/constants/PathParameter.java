package com.perficient.restassuredtest.constants;

public enum PathParameter {

    CREATE_PLACE("/maps/api/place/add/json"),
    GET_PLACE("/maps/api/place/add/json"),
    DELETE_PLACE("/maps/api/place/add/json"),
    UPDATE_PLACE("/maps/api/place/add/json");

    private final String parameter;

    PathParameter(String parameter) {
        this.parameter = parameter;
    }

    public String param() {
        return parameter;
    }
}
