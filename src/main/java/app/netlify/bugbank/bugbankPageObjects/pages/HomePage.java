package app.netlify.bugbank.bugbankPageObjects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage {
  private final WebDriver driver;

  public HomePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10),this);
  }

  @FindBy(xpath = "//p[@id='textAccountNumber']//span")
  WebElement stringDaConta;


  public String pegarNumeroDaConta(){
    return this.stringDaConta.getText().split("\\-")[0];
  }
  public String pegarDigitoDaConta(){
    return this.stringDaConta.getText().split("\\-")[1];
  }
}
