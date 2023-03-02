package dev.aj.randomdatagenerator.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Value;

import static org.junit.jupiter.api.Assertions.*;

class ATOServiceTest {
    private ATOService atoService;

    @BeforeEach
    void setUp() {
        atoService = new ATOService();
    }

    @Test
    void generateValidABN() {
        String generatedABN = atoService.generateValidABN();

        Assertions.assertEquals(11, generatedABN.length());
        Assertions.assertFalse(generatedABN.startsWith("0"));
        Assertions.assertTrue(atoService.checkABNValidity(generatedABN));
    }

    @ParameterizedTest
    @ValueSource(strings = {"26008672179", "75983011470", "72035146485", "26008672179", "94147264284"})
    void checkValidityOfABN(String abn) {
        Assertions.assertTrue(atoService.checkABNValidity(abn));
    }
}
