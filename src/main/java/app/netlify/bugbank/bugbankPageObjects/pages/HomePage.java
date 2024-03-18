package app.netlify.bugbank.bugbankPageObjects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static app.netlify.bugbank.utils.DriverManager.driver;

public class HomePage {
  @FindBy(id = "textName")
  protected WebElement textoNomeHome;
  @FindBy(id = "btnExit")
  protected WebElement botaoSair;
  @FindBy(xpath = "//p[@id='textAccountNumber']//span")
  protected WebElement stringDaConta;
  @FindBy(id = "btn-TRANSFERÊNCIA")
  protected WebElement botaoTransferencia;

  public HomePage() {
    PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10),this);
  }

}
