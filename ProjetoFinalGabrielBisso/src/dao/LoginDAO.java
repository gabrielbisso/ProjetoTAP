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
	
	public boolean autentica(Login Login)
	{
		boolean verificador = false;
		
		try {
			FileReader LeitorDoArquivo = new FileReader(Arquivo);
			BufferedReader BufferedReader = new BufferedReader(LeitorDoArquivo);
			
			String linha = null;
			String[] campos = new String[2];
			
			try {
				while((linha = BufferedReader.readLine())!=null)
				{
					campos = linha.split("#"); //Adiciona ao vetor cada componente em cada posição, sendo identificados e separados por uma #
					if(campos[0].equals(Login.getUsuario()))
					{
						if(campos[1].equals(Login.getSenha()))
						{
							verificador = true;
							break;
						}
					}
					
				}
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
			
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return verificador;
	}
}
