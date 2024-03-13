package app.netlify.bugbank.utils;

import org.openqa.selenium.WebElement;

import java.util.Timer;
import java.util.TimerTask;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WaitElementTry {

    public static void waitElement(WebElement elemento, long tempoMilissegundos) {

        TimeoutDriver.alterarTimeoutAppiumMilissegundos(100);
        final long[] tempoPercorrido = {0};
        boolean encontrouElemento=false;

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                tempoPercorrido[0] += 1000;
            }
        };

        timer.scheduleAtFixedRate(task, 0, 1000);

        while (tempoPercorrido[0] < tempoMilissegundos && !encontrouElemento) {
            try {
                if(elemento.isDisplayed()){
                    encontrouElemento = true;
                }
            } catch (Exception e) {
            }
        }

        timer.cancel();

        assertTrue(elemento.isDisplayed());
        TimeoutDriver.alterarTimeoutAppium(10);
    }

}
