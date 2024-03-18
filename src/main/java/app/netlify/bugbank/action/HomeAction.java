package app.netlify.bugbank.action;

import app.netlify.bugbank.bugbankPageObjects.pages.HomePage;

public class HomeAction extends HomePage {
  static String numeroConta;
  static String digitoConta;

  public boolean visualizarAreaLogada() {
    return textoNomeHome.isDisplayed();
  }

  public void obterDigitoENumeroConta() {
    numeroConta = stringDaConta.getText().split("\\-")[0];
    digitoConta = stringDaConta.getText().split("\\-")[1];
  }

  public void clickBotaoSairHome() {
    botaoSair.click();
  }

  public void clickBotaoTransacao() {
    botaoTransferencia.click();
  }

  public String getNumeroConta(){
    return numeroConta;
  }

  public String getDigitoConta(){
    return digitoConta;
  }
}
