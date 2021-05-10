package gerenciadores;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import classes.Produto;

public class GerenciadorDeNotas {
	
	private Calendar cal = Calendar.getInstance(); //Inicializa calendário para pegar valores
	private List<Produto> carrinhoCliente = new ArrayList<Produto>();
	private String nomeCliente;
	private String cpfCliente;
	private int idVendedor;
	private String diaDeHoje = Integer.toString(cal.get(Calendar.DAY_OF_MONTH)) +
			Integer.toString(cal.get(Calendar.MONTH)+1) + //Mês esta errado
			Integer.toString(cal.get(Calendar.YEAR));
	//pega o dia de hoje
	
	//recebe os dados para impressao da nota
	public void setDados(List<Produto> carrinhoCliente, String nomeCliente, String cpfCliente, int idVendedor) {
		this.carrinhoCliente = carrinhoCliente;
		this.nomeCliente = nomeCliente;
		this.cpfCliente = cpfCliente;
		this.idVendedor = idVendedor;
	}
	
	//imprime nota depois de receber os dados
	public boolean imprimeNota() throws IOException {
		
		File arquivo = new File("Nota_" + nomeCliente + "_" + diaDeHoje + ".txt"); //arquivo tera nome do cliente como nome e data atual
		FileWriter fw = new FileWriter(arquivo);
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write("Nome do Cliente: " + nomeCliente);
		bw.newLine();
		bw.write("CPF do Cliente: " + cpfCliente);
		bw.newLine();
		bw.write("Vendedor: " + Integer.toString(idVendedor));
		bw.newLine();
		
		double valorFinal = 0;
		
		//Percorre o carrinho, imprimindo item por item
		for(int i=0; i<carrinhoCliente.size(); i++) {
			
			//Realiza a baixa no estoque
			carrinhoCliente.get(i).setQtdEstoque(carrinhoCliente.get(i).getQtdEstoque() - carrinhoCliente.get(i).getQtdComprada());
			
			double precoProduto = carrinhoCliente.get(i).getPreco();
			int qtdProduto = carrinhoCliente.get(i).getQtdComprada();
			double valorGeral = precoProduto*qtdProduto;
			//Calculo do valor de determinado produto
			
			bw.newLine();		
			bw.write("CodProduto: " + carrinhoCliente.get(i).getCodProduto() + 
					" | Produto: " + carrinhoCliente.get(i).getNome() +
					" | Valor Unitário: " + precoProduto +
					" | Quantidade: " + qtdProduto +
					" | Valor Geral: " + valorGeral);
			valorFinal += valorGeral;
			//Calculo do valor final
			bw.newLine();
		}
		
		bw.newLine();
		bw.write("Valor Final da Nota: " + valorFinal + " reais.");
		
		bw.close();
		fw.close();
		
		return false;
	}

}
