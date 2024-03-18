package app.netlify.bugbank.utils;

import java.util.Random;

public class EmailGenerator {
    private static final String domain = "@test.com";
    private static final Random random = new Random();

    private static String emailAleatorio;

    private static String generateRandomEmail(String name) {
        int randomNumber = 100000000 + random.nextInt(900000000); // Generates a random 9-digit number
        return name + randomNumber + domain;
    }

    public static void gerarEmailAleatorio () {
        String name = "test";

        for (int i = 0; i < 5; i++) {
            emailAleatorio = generateRandomEmail(name);
        }
    }

    public static String getEmailAleatorio(){
        return emailAleatorio;
    }
}
