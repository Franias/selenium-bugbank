package app.netlify.bugbank.bugbankPageObjects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AcessoNegadoPage {
  private final WebDriver driver;
  WebDriverWait espera;
  public AcessoNegadoPage(WebDriver driver) {
    this.driver = driver;
    this.espera = new WebDriverWait(driver, Duration.ofSeconds(10));
    PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10),this);
  }

  @FindBy(id = "modalText")
  WebElement modalTextoAcessoNegado;

  public boolean isModalAcessoNegadoVisivel(String texto) {
    espera.until(ExpectedConditions.visibilityOf(modalTextoAcessoNegado));
    return modalTextoAcessoNegado.getText().equals(texto);
  }

}
