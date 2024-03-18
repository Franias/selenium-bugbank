package app.netlify.bugbank;

import app.netlify.bugbank.action.CadastroAction;
import app.netlify.bugbank.utils.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CadastroComSucessoTest extends BaseTest {

  CadastroAction cadastroAction = new CadastroAction();

  @Test
  @DisplayName("Deve logar com sucesso")
  public void cadastrarComSucesso() {
    cadastroAction.cadastrarUsuario("test@test.com.br", "Arnold", "123456");
  }

}
