package app.netlify.bugbank;

import app.netlify.bugbank.action.CadastroAction;
import app.netlify.bugbank.action.HomeAction;
import app.netlify.bugbank.action.LoginAction;
import app.netlify.bugbank.utils.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginComSucessoTest extends BaseTest {
    LoginAction loginAction = new LoginAction();
    CadastroAction cadastroAction = new CadastroAction();
    HomeAction homeAction = new HomeAction();

    @BeforeEach
    void init() {
        cadastroAction.cadastrarUsuario("email@email.com", "Fulano", "senha");
    }

    @Test
    @DisplayName("Deve logar com sucesso")
    public void logarComSucesso() {
        loginAction.preencherEmail("email@email.com");
        loginAction.preencherSenha("senha");
        loginAction.entrarUsuario();
        assertTrue(homeAction.visualizarAreaLogada());
    }

}
