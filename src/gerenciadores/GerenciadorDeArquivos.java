package gerenciadores;

import java.io.*;
import java.util.*;

import classes.Produto;

public class GerenciadorDeArquivos {
	
	private List<Produto> listaDeProdutos = new ArrayList<Produto>();
	//Lista de todos os produtos
		
	public boolean leituraDeArquivos() throws IOException {
		
		File arquivo = new File("estoque.txt");
		
		if(!arquivo.exists()) return false; //Se nao existe, para por aqui.
		
		FileReader fr = new FileReader(arquivo);
		BufferedReader br = new BufferedReader(fr);
		
		while(br.ready()) {
			
			String linhaAtual = br.readLine();
			String linhaAux;
			
			//Em uma linha existe Codigo|Nome|Valor|Qtd
			
			String codigo = linhaAtual.substring(0, linhaAtual.indexOf("|"));
			linhaAux = linhaAtual.substring(linhaAtual.indexOf("|")+1);
			
			String nome = linhaAux.substring(0, linhaAux.indexOf("|"));
			linhaAux = linhaAux.substring(linhaAux.indexOf("|")+1);
			
			String valor = linhaAux.substring(0, linhaAux.indexOf("|"));
			linhaAux = linhaAux.substring(linhaAux.indexOf("|")+1);
			
			String qtd = linhaAux.substring(0);
			
			Produto p = new Produto(codigo, nome, valor, qtd);
			//Criacao do produto com base na linha
			
			listaDeProdutos.add(p);
			//Produto adicionado a lista
		}
		
		br.close();
		fr.close();
		
		return true;
	}

	public List<Produto> getListaDeProdutos() {
		return listaDeProdutos;
		//retornar Lista criada
	}
	
}
