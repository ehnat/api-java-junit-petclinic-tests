package com.petclinic.tests.basic;

import com.petclinic.config.ConfigManager;
import com.petclinic.tests.BaseTest;
import com.petclinic.tests.tags.Smoke;
import org.junit.jupiter.api.DisplayName;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Encoding/Decoding:")
public class EncodeDecodeTest extends BaseTest {

    @Smoke
    @DisplayName("should decode Base64 encoded value")
    void shouldDecodeValue() {
        //given
        var encodedValue = ConfigManager.getEnvConfig().encodedValue();
        System.out.printf("Encoded value: %s%n", encodedValue);

        //when
        var decodedValue = new String(Base64.getDecoder().decode(encodedValue));
        System.out.printf("Decoded value: %s%n", decodedValue);

        //then
        assertAll("decoded value:",
                () -> assertEquals("basic value", decodedValue)
        );

        //when
        var secondEncodedValue = new String(Base64.getEncoder().encodeToString(decodedValue.getBytes(StandardCharsets.UTF_8)));
        System.out.printf("Encoded value (again): %s%n", secondEncodedValue);

        //then
        assertAll("encoded value:",
                () -> assertEquals(encodedValue, secondEncodedValue)
        );
    }
}
