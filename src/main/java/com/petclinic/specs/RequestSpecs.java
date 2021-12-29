package com.petclinic.specs;

import com.petclinic.config.ConfigManager;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.HttpClientConfig;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.config.HttpClientConfig.httpClientConfig;
import static io.restassured.config.LogConfig.logConfig;
import static io.restassured.config.RestAssuredConfig.newConfig;
import static io.restassured.filter.log.LogDetail.ALL;
import static org.apache.http.params.CoreConnectionPNames.CONNECTION_TIMEOUT;
import static org.apache.http.params.CoreConnectionPNames.SO_TIMEOUT;

public class RequestSpecs {

    private static final String APPLICATION_JSON = ContentType.JSON.toString();
    private static final int DEFAULT_CONNECTION_TIMEOUT_IN_MILLIS = 10_000;
    private static final int DEFAULT_SOCKET_TIMEOUT_IN_MILLIS = 10_000;

    private static final List<Filter> LOGGING_FILTERS = List.of(new RequestLoggingFilter(), new ResponseLoggingFilter(), new AllureRestAssured());
    private static final HttpClientConfig HTTP_CLIENT_CONFIG = httpClientConfig().setParam(CONNECTION_TIMEOUT, DEFAULT_CONNECTION_TIMEOUT_IN_MILLIS)
            .setParam(SO_TIMEOUT, DEFAULT_SOCKET_TIMEOUT_IN_MILLIS);

    private RequestSpecs() {
    }

    public static RequestSpecification basicSpecWithTrafficLogging() {
        return basicSpec(true);
    }

    public static RequestSpecification basicSpecWithoutTrafficLogging() {
        return basicSpec(false);
    }

    public static RequestSpecification basicSpec(String accept, boolean trafficLoggingEnabled) {
        return new RequestSpecBuilder()
                .setBaseUri(ConfigManager.getEnvConfig().baseUrl())
                .setConfig(newConfig().httpClient(HTTP_CLIENT_CONFIG))
                .addFilters(trafficLoggingEnabled ? LOGGING_FILTERS : new ArrayList<Filter>())
                .setAccept(accept)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static RequestSpecification basicSpecWithBlacklistedHeaders() {
        return new RequestSpecBuilder()
                .setBaseUri(ConfigManager.getEnvConfig().baseUrl())
                .setConfig(newConfig()
                        .httpClient(HTTP_CLIENT_CONFIG)
                        .logConfig(logConfig().blacklistHeader("Accept")))
                .setAccept(APPLICATION_JSON)
                .setContentType(ContentType.JSON)
                .log(ALL)
                .build();
    }

    private static RequestSpecification basicSpec(boolean trafficLoggingEnabled) {
        return basicSpec(APPLICATION_JSON, trafficLoggingEnabled);
    }
}
