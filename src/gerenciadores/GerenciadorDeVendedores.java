package gerenciadores;

import java.util.ArrayList;
import java.util.List;

import classes.Vendedor;

public class GerenciadorDeVendedores {
	
	private List<Vendedor> listaDeVendedores = new ArrayList<Vendedor>();
	//Lista de todos os vendedores
	
	public void addVendedor(String nome, String cpf, String idGerado, boolean permissao) {
		//Recebe dados do vendedor
		
		Vendedor v = new Vendedor(nome, cpf, idGerado, permissao);
		//Vendedor é instanciado e acrescentado a lista
		listaDeVendedores.add(v);		
	}

	public List<Vendedor> getListaDeVendedores() {
		return listaDeVendedores;
		//Retorna a lista criada
	}

}
