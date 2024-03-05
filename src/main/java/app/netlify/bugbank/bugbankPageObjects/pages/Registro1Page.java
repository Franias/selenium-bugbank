package app.netlify.bugbank.bugbankPageObjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import app.netlify.bugbank.utils.BaseTest;
import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Registro1Page extends BaseTest {
  private final WebDriver driver;
  WebDriverWait espera;

  public Registro1Page(WebDriver driver) {
    this.driver = driver;
    this.espera = new WebDriverWait(driver, Duration.ofSeconds(5));
    PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10),this);
  }

  public void acessarFormularioDeRegistro(){
    driver.findElement(By.xpath("//button[text()='Registrar']")).click();
    assertEquals(driver.findElement(By.id("btnBackButton")).getText(),"Voltar ao login");
  }

  public void preencherFormularioDeRegistro(String email, String nome, String senha) {
    List<WebElement> emailRegistro = driver.findElements(By.name("email"));
    emailRegistro.get(1).click();
    emailRegistro.get(1).sendKeys(email);
    driver.findElement(By.name("name")).sendKeys(nome);
    List<WebElement> senhaRegistro = driver.findElements(By.name("password"));
    senhaRegistro.get(1).sendKeys(senha);
    driver.findElement(By.name("passwordConfirmation")).sendKeys(senha);
    driver.findElement(By.id("toggleAddBalance")).click();
    WebElement botaoCadastrar = driver.findElement(By.xpath("//button[text()='Cadastrar']"));
    Actions actions = new Actions(driver);
    actions.moveToElement(botaoCadastrar).click().build().perform();
  }

  public void fecharModal() throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()=\"x\"]")));
    driver.findElement(By.xpath("//a[text()=\"x\"]")).click();
  }

  public void login(String email, String senha){
    driver.findElement(By.name("email")).sendKeys(email);
    driver.findElement(By.name("password")).sendKeys(senha);
    driver.findElement(By.xpath("//button[text()=\"Acessar\"]")).click();
  }
  public String pegarNumeroDaConta(){
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='textAccountNumber']//span")));
    String conta =driver.findElement(By.xpath("//p[@id='textAccountNumber']//span")).getText();
    return conta;
  }
  public void sairDaPaginaDoUsuario(){
    driver.findElement(By.id("btnExit")).click();
  }
  public void fazerTransferenciaDaConta1(String conta, String digito, String valor, String descricao){
    driver.findElement(By.id("btn-TRANSFERÊNCIA")).click();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("accountNumber")));
    driver.findElement(By.name("accountNumber")).sendKeys(conta);
    driver.findElement(By.name("digit")).sendKeys(digito);
    driver.findElement(By.name("transferValue")).sendKeys(valor);
    driver.findElement(By.name("description")).sendKeys(descricao);
    driver.findElement(By.xpath("//button[text()='Transferir agora']")).click();

  }
  public void retornarPaginaDoUsuario(){
    driver.findElement(By.id("btnBack")).click();
  }

  public void verificarSaldo(){
    String saldo = driver.findElement(By.xpath("//p[@id='textBalance']//span")).getText();
    String valor = saldo.split("\\ ")[1];
  }

  public void verificarExtrato(){
    driver.findElement(By.id("btn-EXTRATO")).click();
  }

}
