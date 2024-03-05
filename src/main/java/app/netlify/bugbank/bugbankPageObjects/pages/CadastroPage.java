package app.netlify.bugbank.bugbankPageObjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CadastroPage {
  private final WebDriver driver;
  WebDriverWait espera;

  public CadastroPage(WebDriver driver) {
    this.driver = driver;
    this.espera = new WebDriverWait(driver, Duration.ofSeconds(10));
    PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10),this);
  }

  @FindBy(xpath = "//button[text()='Registrar']")
  WebElement botaoRegistrar;

  @FindBys({
      @FindBy(name = "email")
  })
  List<WebElement> inputsEmail;

  @FindBy(name = "name")
  WebElement inputNome;

  @FindBys({
      @FindBy(name = "password")
  })
  List<WebElement> inputsSenha;
  @FindBy(name = "passwordConfirmation")
  WebElement inputConfirmacaoSenha;

  @FindBy(id = "toggleAddBalance")
  WebElement botaoSaldo;

  @FindBy(name = "//button[text()='Cadastrar']") //não consegui aplicar na função
  WebElement botaoCadastrar;

  public void acessarCadastro(){
    this.botaoRegistrar.click();
  }

  public void preencherEmail(String email){
    this.inputsEmail.get(1).sendKeys(email);
  }

  public void preencherNome(String nome){
    this.inputNome.sendKeys(nome);
  }

  public void preencherSenha(String senha){
    this.inputsSenha.get(1).sendKeys(senha);
  }

  public void preencherConfirmacaoSenha(String senha){
    this.inputConfirmacaoSenha.sendKeys(senha);
  }

  public void adicionarSaldo(){
    ((JavascriptExecutor) driver).executeScript("return arguments[0].click();", this.botaoSaldo);
  }

  public void finalizarCadastro(){
    espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Cadastrar']"))).click();
  }


  public CadastroPage cadastrarUsuario(String email, String nome, String senha){
    CadastroPage cadastroPage = new CadastroPage(driver);
        acessarCadastro();
        preencherEmail(email);
        preencherNome(nome);
        preencherSenha(senha);
        preencherConfirmacaoSenha(senha);
        adicionarSaldo();
        finalizarCadastro();
    return new CadastroPage(driver);
  }

}
