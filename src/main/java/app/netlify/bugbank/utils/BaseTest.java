package app.netlify.bugbank.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;

public abstract class BaseTest extends utils.DriverManager {
    private static final String URL = "https://bugbank.netlify.app/";

    @BeforeEach
    public void setUp() throws IOException {
        getDriver().get(URL);
    }

    @AfterEach
    public void finish(){
//        quitDriver();
    }
}