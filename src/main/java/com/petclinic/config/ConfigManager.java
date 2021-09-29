package com.petclinic.config;

import org.aeonbits.owner.ConfigCache;

public class ConfigManager {

    private ConfigManager() {
    }

    public static EnvConfig getEnvConfig() {
        return ConfigCache.getOrCreate(EnvConfig.class);
    }
}
