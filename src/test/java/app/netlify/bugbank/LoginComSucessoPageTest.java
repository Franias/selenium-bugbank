package app.netlify.bugbank;

import app.netlify.bugbank.bugbankPageObjects.pages.CadastroPage;
import app.netlify.bugbank.bugbankPageObjects.pages.HomePage;
import app.netlify.bugbank.bugbankPageObjects.pages.LoginPage;
import app.netlify.bugbank.testData.CadastroTestData;
import app.netlify.bugbank.utils.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class LoginComSucessoPageTest extends BaseTest {
  private final WebDriver driver = getDriver();

  private CadastroPage cadastroPage;
  private LoginPage loginPage;
  private CadastroTestData cadastroTestData;

  @BeforeEach
  void init() {
    this.cadastroTestData = new CadastroTestData();
    this.loginPage = new LoginPage(driver);
    this.cadastroPage = new CadastroPage(driver)
        .cadastrarUsuario(cadastroTestData.getEmail(), cadastroTestData.getNome(), cadastroTestData.getSenha());
  }

  @Test
  @DisplayName("Deve logar o usuário com sucesso")
  public void deveLogarComSucesso(){
    loginPage.loginUsuario(cadastroTestData.getEmail(), cadastroTestData.getSenha());
  }
}
