package app.netlify.bugbank.bugbankPageObjects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TransacaoPage {
  private final WebDriver driver;
  WebDriverWait espera;

  public TransacaoPage(WebDriver driver) {
    this.driver = driver;
    this.espera = new WebDriverWait(driver, Duration.ofSeconds(10));
    PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10),this);
  }

  @FindBy(id = "btn-TRANSFERÊNCIA")
  WebElement botaoTransferencia;

  @FindBy(name = "accountNumber")
  WebElement inputNumeroDaConta;

  @FindBy(name = "digit")
  WebElement inputDigitoDaConta;

  @FindBy(name = "transferValue")
  WebElement inputValor;

  @FindBy(name = "description")
  WebElement inputDescricao;

  @FindBy(xpath = "//button[text()='Transferir agora']")
  WebElement inputTranferir;

  public void acessarTransferencia(){
    this.botaoTransferencia.click();
  }

}
