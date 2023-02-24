package com.perficient.restassuredtest.placeschema;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Place {
    private Location location;
    private int accuracy;
    private String name;
    private String phone_number;
    private String address;
    private List <String> types;
    private String website;
    private String language;

    public void setTypes(String shoe_park, String shop) {
    }
}
