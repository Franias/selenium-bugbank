package app.netlify.bugbank.utils;

import java.util.concurrent.TimeUnit;

import static app.netlify.bugbank.utils.DriverManager.driver;

public class TimeoutDriver {

    public static void alterarTimeoutAppium(int segundos){
            driver.manage().timeouts().implicitlyWait(segundos, TimeUnit.SECONDS);
    }

    public static void alterarTimeoutAppiumMilissegundos(long milisegundos){
            driver.manage().timeouts().implicitlyWait(milisegundos, TimeUnit.MILLISECONDS);
    }

}
