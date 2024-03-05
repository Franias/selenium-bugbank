package app.netlify.bugbank.bugbankPageObjects.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage {

  private final WebDriver driver;

  public LoginPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10),this);
  }

  @FindBy(name = "email")
  WebElement inputEmail;

  @FindBy(name = "password")
  WebElement inputSenha;

  @FindBy(xpath = "//button[text()='Acessar']")
  WebElement botaoAcessar;


  public LoginPage preencherEmail(String email){
    this.inputEmail.sendKeys(email);
    return this;
  }
  public LoginPage preencherSenha(String senha){
    this.inputSenha.sendKeys(senha);
    return this;
  }
  public LoginPage entrarUsuario(){
    this.botaoAcessar.click();
    return this;
  }

  public LoginPage loginUsuario(String email, String senha){
    LoginPage loginPage = new LoginPage(driver)
        .preencherEmail(email)
        .preencherSenha(senha)
        .entrarUsuario();
    return new LoginPage(driver);
  }
}
