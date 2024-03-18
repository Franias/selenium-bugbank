package app.netlify.bugbank.action;

import app.netlify.bugbank.bugbankPageObjects.pages.CadastroPage;
import app.netlify.bugbank.utils.EmailGenerator;
import app.netlify.bugbank.utils.WaitElementTry;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import static app.netlify.bugbank.utils.DriverManager.driver;

public class CadastroAction extends CadastroPage {

  public void cadastrarUsuario(String email, String nome, String senha){
    botaoRegistrar.click();
    inputsEmail.get(1).sendKeys(email);
    inputNome.sendKeys(nome);
    inputsSenha.get(1).sendKeys(senha);
    inputConfirmacaoSenha.sendKeys(senha);
    ((JavascriptExecutor) driver).executeScript("return arguments[0].click();", botaoSaldo);
    WaitElementTry.waitElement(botaoCadastrar,5000);
    botaoCadastrar.click();
    WaitElementTry.waitElement(xDaModal,5000);
    xDaModal.click();
  }
  public void cadastrarUsuario () {
    botaoRegistrar.click();
    EmailGenerator.gerarEmailAleatorio();
    inputsEmail.get(1).sendKeys(EmailGenerator.getEmailAleatorio());
    inputNome.sendKeys("Fulano");
    inputsSenha.get(1).sendKeys("senha");
    inputConfirmacaoSenha.sendKeys("senha");
    ((JavascriptExecutor) driver).executeScript("return arguments[0].click();", botaoSaldo);
    WaitElementTry.waitElement(botaoCadastrar,5000);
    botaoCadastrar.click();
    WaitElementTry.waitElement(xDaModal,5000);
    xDaModal.click();
  }

}
