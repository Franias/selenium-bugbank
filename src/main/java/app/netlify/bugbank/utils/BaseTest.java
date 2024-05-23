package app.netlify.bugbank.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static app.netlify.bugbank.utils.DriverManager.quitDriver;

public abstract class BaseTest {
    private static final String URL = "https://bugbank.netlify.app/";

    @BeforeEach
    public void setUp() {
        DriverManager.setDriver(URL);
    }

    @AfterEach
    public void finish(){
        quitDriver();
    }

}