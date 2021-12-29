package com.petclinic.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;
import org.aeonbits.owner.Config.Sources;

@LoadPolicy(LoadType.MERGE)
@Sources({
        "system:properties",
        "classpath:env/${env}.properties"
})
public interface EnvConfig extends Config {

    @Key("base-url")
    String baseUrl();

    @Key("encoded-value")
    String encodedValue();
}
