package com.petclinic.tests;

import com.petclinic.config.ConfigManager;
import com.petclinic.tests.tags.Regression;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Regression
public class BaseTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);

    static {
        LOGGER.info("Checking base url: {}", ConfigManager.getEnvConfig().baseUrl());
    }
}
