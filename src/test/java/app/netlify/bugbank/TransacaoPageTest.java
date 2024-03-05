package app.netlify.bugbank;

import app.netlify.bugbank.bugbankPageObjects.pages.CadastroPage;
import app.netlify.bugbank.bugbankPageObjects.pages.HomePage;
import app.netlify.bugbank.bugbankPageObjects.pages.LoginPage;
import app.netlify.bugbank.bugbankPageObjects.pages.TransacaoPage;
import app.netlify.bugbank.testData.CadastroTestData;
import app.netlify.bugbank.utils.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TransacaoPageTest extends BaseTest {
  private final WebDriver driver = getDriver();
  private TransacaoPage transacaoPage;
  private CadastroPage cadastroPage;
  private LoginPage loginPage;
  private HomePage homePage;
  CadastroTestData cadastroTestData = new CadastroTestData();

  @BeforeEach
  void init() {
    this.transacaoPage = new TransacaoPage(driver);
    this.cadastroPage = new CadastroPage(driver)
        .cadastrarUsuario(cadastroTestData.getEmail(), cadastroTestData.getNome(), cadastroTestData.getSenha());
    this.loginPage = new LoginPage(driver)
        .loginUsuario(cadastroTestData.getEmail(), cadastroTestData.getSenha());
    this.homePage = new HomePage(driver);
    cadastroTestData.digitoDaConta = homePage.pegarDigitoDaConta();
    cadastroTestData.numeroDaConta = homePage.pegarNumeroDaConta();
    homePage.sairDaHome();
  }

  @Test
  @DisplayName("Deve transferir para uma conta")
  public void deveTransferirComSucesso(){
    CadastroPage cadastroPage= new CadastroPage(driver)
        .cadastrarUsuario("nome2@email.com", "ciclano", "senha");
    LoginPage login = new LoginPage(driver)
        .loginUsuario("nome2@email.com","senha");
    transacaoPage.transacao(cadastroTestData.numeroDaConta,cadastroTestData.digitoDaConta,"300");

    assertTrue(transacaoPage.isTransferenciaRealizadaComSucesso());
  }

}
