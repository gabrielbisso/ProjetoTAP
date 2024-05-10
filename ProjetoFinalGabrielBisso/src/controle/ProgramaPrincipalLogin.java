package controle;

import modelo.Login;
import visao.JanelaLogin;

public class ProgramaPrincipalLogin {
	public static void main(String[] args) {
		JanelaLogin JanelaLog= new JanelaLogin();
		JanelaLog.setVisible(true);
		Login l = new Login();
		ControleLogin conLog = new ControleLogin(JanelaLog, l);
	}
}
