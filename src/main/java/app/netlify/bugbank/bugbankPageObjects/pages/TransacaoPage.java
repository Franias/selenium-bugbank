package app.netlify.bugbank.bugbankPageObjects.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static app.netlify.bugbank.utils.DriverManager.driver;

public class TransacaoPage {

  @FindBy(id = "btn-TRANSFERÊNCIA")
  protected WebElement botaoTransferencia;

  @FindBy(name = "accountNumber")
  protected WebElement inputNumeroDaConta;

  @FindBy(name = "digit")
  protected WebElement inputDigitoDaConta;

  @FindBy(name = "transferValue")
  protected WebElement inputValor;

  @FindBy(name = "description")
  protected WebElement inputDescricao;

  @FindBy(xpath = "//button[text()='Transferir agora']")
  protected WebElement submitTranferir;

  @FindBy(id = "modalText")
  protected WebElement textoModal;

  public TransacaoPage() {
    PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
  }

}
