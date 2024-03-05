package app.netlify.bugbank;

import app.netlify.bugbank.bugbankPageObjects.pages.AcessoNegadoPage;
import app.netlify.bugbank.bugbankPageObjects.pages.LoginPage;
import app.netlify.bugbank.testData.LoginTestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import app.netlify.bugbank.utils.BaseTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AcessoNegadoPageTest extends BaseTest {
    private final WebDriver driver = getDriver();

    @Test
    @DisplayName("Deve negar acesso, usuário ou senha inválido")
    void deveRedirecionarParaPaginaDeAcessoNegado() throws IOException {
        LoginTestData loginTestData = new LoginTestData();
        LoginPage loginPage = new LoginPage(driver);
        AcessoNegadoPage acessoNegadoPage = new AcessoNegadoPage(driver);

        loginPage.loginCandidato(loginTestData.getEmail(), loginTestData.getSenha());

        assertTrue(acessoNegadoPage.isModalAcessoNegadoVisivel(loginTestData.getTextoAcessoNegado()));
    }
}
