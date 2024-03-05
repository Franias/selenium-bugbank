package app.netlify.bugbank.bugbankPageObjects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
  WebElement submitTranferir;

  @FindBy(id = "modalText")
  WebElement textoModal;

  public TransacaoPage acessarTransferencia(){
    this.botaoTransferencia.click();return this;
  }

  public TransacaoPage preencherNumeroDaConta(String numeroDaConta){
    this.inputNumeroDaConta.sendKeys(numeroDaConta);return this;
  }

  public TransacaoPage preencherDigitoDaConta(String digitoDaConta){
    this.inputDigitoDaConta.sendKeys(digitoDaConta);return this;
  }

  public TransacaoPage preencherValor(String valor){
    this.inputValor.sendKeys(valor);return this;
  }

  public TransacaoPage preencherDescricao(){
    this.inputDescricao.sendKeys("Descricao");return this;
  }

  public TransacaoPage transferirValor(){
    this.submitTranferir.click();return this;
  }

  public TransacaoPage transacao(String numeroDaConta, String digitoDaConta, String valor){
    TransacaoPage transacaoPage = new TransacaoPage(driver)
        .acessarTransferencia()
        .preencherNumeroDaConta(numeroDaConta)
        .preencherDigitoDaConta(digitoDaConta)
        .preencherValor(valor)
        .preencherDescricao()
        .transferirValor();
    return new TransacaoPage(driver);
  }

  public boolean isTransferenciaRealizadaComSucesso(){
    espera.until(ExpectedConditions.visibilityOf(textoModal));
    return textoModal.getText().equals("Transferencia realizada com sucesso");
  }

}
