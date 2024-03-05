package app.netlify.bugbank;

import app.netlify.bugbank.bugbankPageObjects.pages.CadastroPage;
import app.netlify.bugbank.bugbankPageObjects.pages.LoginPage;
import app.netlify.bugbank.bugbankPageObjects.pages.TransacaoPage;
import app.netlify.bugbank.testData.CadastroTestData;
import app.netlify.bugbank.utils.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class TransacaoPageTest extends BaseTest {
  private final WebDriver driver = getDriver();
  private TransacaoPage transacaoPage;
  private CadastroPage cadastroPage;
  private LoginPage loginPage;
  CadastroTestData cadastroTestData = new CadastroTestData();

  @BeforeEach
  void init() {
    this.transacaoPage = new TransacaoPage(driver);
    this.cadastroPage = new CadastroPage(driver)
        .cadastrarUsuario(cadastroTestData.getEmail(), cadastroTestData.getNome(), cadastroTestData.getSenha());
    this.loginPage = new LoginPage(driver)
        .loginUsuario(cadastroTestData.getEmail(), cadastroTestData.getSenha());
  }
  @Test
  @DisplayName("Deve logar o usuário com sucesso e guardar informação de conta")
  public void deveLogarComSucesso(){
    this.transacaoPage.acessarTransferencia();
  }
}
