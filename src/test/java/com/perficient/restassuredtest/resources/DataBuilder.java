package com.perficient.restassuredtest.resources;

import com.perficient.restassuredtest.placeschema.Location;
import com.perficient.restassuredtest.placeschema.Place;

import java.util.ArrayList;
import java.util.List;

public class DataBuilder {
    private Place p;
    private Location loc;

    public Place place(){
        p = new Place();
        loc = new Location();
        loc.setLat(-38.383494);
        loc.setLng(33.427362);
        p.setLocation(loc);
        p.setAccuracy(50);
        p.setName("Retreat Apartment");
        p.setPhone_number("+1-347-320-8854");
        p.setAddress("1045 Boston Rd");
        List <String> list = new ArrayList<>();
        list.add("shoe park");
        list.add("shop");
        p.setTypes(list);
        p.setWebsite("http://google.com");
        p.setLanguage("US-EN");
        return p;
    }

    public Place place(String address, String language, String name){
        p = new Place();
        loc = new Location();
        loc.setLat(-38.383494);
        loc.setLng(33.427362);
        p.setLocation(loc);
        p.setAccuracy(50);
        p.setName(name);
        p.setPhone_number("+1-347-320-8854");
        p.setAddress(address);
        List <String> list = new ArrayList<>();
        list.add("shoe park");
        list.add("shop");
        p.setTypes(list);
        p.setWebsite("http://google.com");
        p.setLanguage(language);
        return p;
    }
}
