package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
					System.out.println("ERRO: nome não foi preenchido");
				}
				else
				{
					if(senha.equals(" "))
					{
						System.out.println("ERRO: senha não foi preenchido");
					}
					else
					{
						if(logdao.autentica(log))
						{
							System.out.println("Autenticação realizada com sucesso");
						}
						else
						{
							System.out.println("Falha na autenticação");
						}
					}
				}
				
			}
		}
		
	}
	
	

}
