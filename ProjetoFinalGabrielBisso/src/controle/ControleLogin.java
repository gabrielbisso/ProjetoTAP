package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.LoginDAO;
import modelo.Login;
import visao.JanelaLogin;

public class ControleLogin implements ActionListener{
	private JanelaLogin JanelaLog;
	private Login log;
	private LoginDAO logdao;
	
	public ControleLogin(JanelaLogin jan, Login log) {
		this.JanelaLog = jan;
		this.log = log;
		logdao = new LoginDAO();
		funcionaBotao();
	}


	private void funcionaBotao(){
		JanelaLog.getButtonAutenticar().addActionListener(this);
		JanelaLog.getButtonLimpar().addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Limpar"))
		{
			JanelaLog.limpadados();
		}
		else
		{
			if(e.getActionCommand().equals("Autenticar"))
			{
				String nome = JanelaLog.getFieldUsuario().getText();
				String senha = JanelaLog.getFieldSenha().getText();
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
							JOptionPane.showMessageDialog(JanelaLog, "Autenticação realizada com sucesso!");
						}
						else
						{
							JOptionPane.showMessageDialog(JanelaLog, "Atenção: Erro na autenticação!");
						}
					}
				}
				
			}
		}
		
	}
	
	

}
