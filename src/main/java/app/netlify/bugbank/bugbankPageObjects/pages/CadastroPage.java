package app.netlify.bugbank.bugbankPageObjects.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

import static app.netlify.bugbank.utils.DriverManager.driver;

public class CadastroPage {

  @FindBy(xpath = "//button[text()='Registrar']")
  protected WebElement botaoRegistrar;

  @FindBys({
      @FindBy(name = "email")
  })
  protected List<WebElement> inputsEmail;

  @FindBy(name = "name")
  protected WebElement inputNome;

  @FindBys({
      @FindBy(name = "password")
  })
  protected List<WebElement> inputsSenha;
  @FindBy(name = "passwordConfirmation")
  protected WebElement inputConfirmacaoSenha;

  @FindBy(id = "toggleAddBalance")
  protected WebElement botaoSaldo;

  @FindBy(xpath = "//button[text()='Cadastrar']")
  protected WebElement botaoCadastrar;

  @FindBy(id = "modalText")
  WebElement numeroDaConta;

  @FindBy(xpath = "//a[text()=\"x\"]")
  protected WebElement xDaModal;

  public CadastroPage() {
    PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10),this);
  }

}
