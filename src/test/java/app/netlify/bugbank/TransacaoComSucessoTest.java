package app.netlify.bugbank;

import app.netlify.bugbank.action.CadastroAction;
import app.netlify.bugbank.action.HomeAction;
import app.netlify.bugbank.action.LoginAction;
import app.netlify.bugbank.action.TransacaoAction;
import app.netlify.bugbank.utils.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class TransacaoComSucessoTest extends BaseTest {
  LoginAction loginAction = new LoginAction();
  CadastroAction cadastroAction = new CadastroAction();
  HomeAction homeAction = new HomeAction();
  TransacaoAction transacaoAction = new TransacaoAction();

  @BeforeEach
  void init() {
    cadastroAction.cadastrarUsuario();
    loginAction.logarUsuario();
    homeAction.obterDigitoENumeroConta();
    homeAction.clickBotaoSairHome();
  }

  @Test
  @DisplayName("Deve transferir para uma conta")
  public void deveTransferirComSucesso() {
    cadastroAction.cadastrarUsuario();
    loginAction.logarUsuario();
    homeAction.clickBotaoTransacao();
    transacaoAction.realizarTransacao();
    assertTrue(transacaoAction.viewTextoTransferenciaRealizadaComSucesso());
  }

}
