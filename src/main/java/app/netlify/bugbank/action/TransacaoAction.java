package app.netlify.bugbank.action;

import app.netlify.bugbank.bugbankPageObjects.pages.TransacaoPage;
import app.netlify.bugbank.utils.WaitElementTry;

public class TransacaoAction extends TransacaoPage {

  HomeAction homeAction = new HomeAction();


  public TransacaoPage acessarTransferencia(){
    this.botaoTransferencia.click();return this;
  }

  public TransacaoPage preencherNumeroDaConta(String numeroDaConta){
    this.inputNumeroDaConta.sendKeys(numeroDaConta);return this;
  }

  public TransacaoPage preencherDigitoDaConta(String digitoDaConta){
    this.inputDigitoDaConta.sendKeys(digitoDaConta);return this;
  }

  public TransacaoPage preencherValor(String valor){
    this.inputValor.sendKeys(valor);return this;
  }

  public TransacaoPage preencherDescricao(String descricao){
    this.inputDescricao.sendKeys(descricao);return this;
  }

  public TransacaoPage transferirValor(){
    this.submitTranferir.click();return this;
  }

  public void realizarTransacao() {
    preencherNumeroDaConta(homeAction.getNumeroConta());
    preencherDigitoDaConta(homeAction.getDigitoConta());
    preencherValor("300");
    preencherDescricao("Descricao");
    transferirValor();
  }

  public boolean viewTextoTransferenciaRealizadaComSucesso() {
    WaitElementTry.waitElement(textoModal,5000);
    return textoModal.getText().equals("Transferencia realizada com sucesso");
  }

}
