package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dao.LoginDAO;
import modelo.Login;
import visao.JanelaLogin;

public class ControleLogin implements ActionListener{
	private JanelaLogin jan;
	private Login log;
	private LoginDAO logdao;
	
	public ControleLogin(JanelaLogin jan, Login log) {
		this.jan = jan;
		this.log = log;
		logdao = new LoginDAO();
		funcionaBotao();
	}


	private void funcionaBotao(){
		jan.getButtonAutenticar().addActionListener(this);
		jan.getButtonLimpar().addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Limpar"))
		{
			jan.limpadados();
		}
		else
		{
			if(e.getActionCommand().equals("Autenticar"))
			{
				String nome = jan.getFieldUsuario().getText();
				String senha = jan.getFieldSenha().getText();
				log.setUsuario(nome);
				log.setSenha(senha);
				
				if(nome.equals(" "))
				{
					System.out.println("Atenção: Campo 'nome' não preenchido!");
				}
				else
				{
					if(senha.equals(" "))
					{
						System.out.println("Atenção: Campo 'senha' não prenchido!");
					}
					else
					{
						if(logdao.autentica(log))
						{
							System.out.println("Autenticação realizada com sucesso!");
						}
						else
						{
							System.out.println("Atenção: Erro na autenticação!");
						}
					}
				}
				
			}
		}
		
	}
	
	

}
