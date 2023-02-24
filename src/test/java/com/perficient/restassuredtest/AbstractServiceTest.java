package com.perficient.restassuredtest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public abstract class AbstractServiceTest {

    protected JsonPath jsonPath;
    private PrintStream printStream = null;
    public static RequestSpecification req;

    {
        try {
            printStream = new PrintStream(new FileOutputStream("logging.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public RequestSpecification requestSpecification() {
        if (req == null) {
            req = new RequestSpecBuilder().setBaseUri(getGlobalValue("QA_URL"))
                    .addQueryParam("key", "qaclick123")
                    .addFilter(RequestLoggingFilter.logRequestTo(printStream))
                    .addFilter(ResponseLoggingFilter.logResponseTo(printStream))
                    .setContentType(ContentType.JSON).build();
        }
        return req;
    }

    public String getGlobalValue(String url) {
        Properties prop = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("src/main/resources/global.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(url);
    }

    public String getJsonPath(Response response, String key) {
        String resp = response.asString();
        jsonPath = new JsonPath(resp);
        return jsonPath.get(key).toString();
    }
}
