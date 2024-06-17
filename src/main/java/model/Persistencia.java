package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Persistencia {
	
	public static ArrayList<Usuario> lista = new ArrayList<Usuario>(); 
	
	public static ArrayList<Usuario> getLista() { 
		return lista; 
	}  

	public boolean cadastrar(Usuario user) { 

		if (user != null) { 
		lista.add(user); 
		return true; 
		} else { 
		return false; 
		} 
	} 
	 
	public static void importar(String nomedoarquivo){ 
		try { 
		FileReader arq = new FileReader(nomedoarquivo); 
		BufferedReader lerArq = new BufferedReader(arq); 
		
		//criar Strings para armazenar informações do usuário 
		String id, nome, login, senha; 
		id = lerArq.readLine(); // lê a primeira linha
		
		while (id != null) { 
			nome = lerArq.readLine(); 
			login = lerArq.readLine(); 
			senha = lerArq.readLine(); 
			lista.add(new Usuario(nome, login, senha)); 
			id = lerArq.readLine(); // lê da segunda até a última linha 
		} 

		arq.close(); 
			
		} catch (IOException e) { 
			System.err.printf("Erro na abertura do arquivo: %s.", e.getMessage()); 
		} 
	} 

	 
	public static void exportar(String nomedoarquivo) throws IOException { 	 
		FileWriter arq = new FileWriter(nomedoarquivo); 
		PrintWriter gravarArq = new PrintWriter(arq); 
		
		for (Usuario user : lista) { 
			gravarArq.println(user); 
		} 
			gravarArq.close(); 
		}
}
