package app.netlify.bugbank;

import app.netlify.bugbank.bugbankPageObjects.pages.CadastroPage;
import app.netlify.bugbank.bugbankPageObjects.pages.LoginPage;
import app.netlify.bugbank.testData.CadastroTestData;
import app.netlify.bugbank.testData.LoginTestData;
import app.netlify.bugbank.utils.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class CadastroPageTest extends BaseTest {

  private final WebDriver driver = getDriver();

  @Test
  @DisplayName("Deve cadastrar usuario")
  void deveCadastrarUsuario(){
    CadastroTestData cadastroTestData = new CadastroTestData();
    CadastroPage cadastroPage = new CadastroPage(driver);

    cadastroPage.cadastrarUsuario(cadastroTestData.getEmail(), cadastroTestData.getNome(), cadastroTestData.getSenha());
  }



}
