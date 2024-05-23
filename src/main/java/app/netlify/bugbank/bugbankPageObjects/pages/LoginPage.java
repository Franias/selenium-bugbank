package app.netlify.bugbank.bugbankPageObjects.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static app.netlify.bugbank.utils.DriverManager.driver;

public class LoginPage {

  @FindBy(name = "email")
  protected
  WebElement inputEmail;

  @FindBy(name = "password")
  protected
  WebElement inputSenha;

  @FindBy(xpath = "//button[text()='Acessar']")
  protected
  WebElement botaoAcessar;

  public LoginPage() {
    PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10),this);
  }

}
