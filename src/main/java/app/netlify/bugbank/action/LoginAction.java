package app.netlify.bugbank.action;

import app.netlify.bugbank.bugbankPageObjects.pages.LoginPage;


public class LoginAction extends LoginPage {
  public void preencherEmail(String email){
    inputEmail.sendKeys(email);
  }
  public void preencherSenha(String senha){
    inputSenha.sendKeys(senha);
  }
  public void entrarUsuario(){
    botaoAcessar.click();
  }

  public void logarUsuario(String email,String senha){
    preencherEmail(email);
    preencherSenha(senha);
    entrarUsuario();
  }
}
