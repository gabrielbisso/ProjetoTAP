package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import modelo.Login;


public class LoginDAO {
	File Arquivo;

	public LoginDAO()
	{
		Arquivo = new File("ProjetoFinalGabrielBisso/senhas.txt");
	}
	
	public boolean autentica(Login l)
	{
		boolean resp = false;
		
		try {
			FileReader fr = new FileReader(Arquivo);
			BufferedReader br = new BufferedReader(fr);
			
			String linha = null;
			String[] campos = new String[2];
			
			try {
				while((linha = br.readLine())!=null)
				{
					campos = linha.split("#");
					if(campos[0].equals(l.getUsuario()))
					{
						if(campos[1].equals(l.getSenha()))
						{
							resp=true;
							break;
						}
					}
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resp;
	}
}
