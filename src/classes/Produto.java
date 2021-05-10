package classes;

public class Produto {
	private int codProduto;
	private String nome;
	private double preco;
	private int qtdEstoque; //Quantidade desse produto em estoque
	private int qtdComprada; //Quantidade solicitada na hora da venda 
	
	public Produto(String codProduto, String nome, String preco, String qtd){
		this.codProduto = Integer.parseInt(codProduto);
		this.nome = nome;
		this.preco = Double.parseDouble(preco);
		this.qtdEstoque = Integer.parseInt(qtd);
	}
	
	public int getCodProduto() {
		return codProduto;
	}
	public String getNome() {
		return nome;
	}
	public double getPreco() {
		return preco;
	}
	public int getQtdEstoque() {
		return qtdEstoque;
	}
	public void setCodProduto(int codProduto) {
		this.codProduto = codProduto;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public void setQtdEstoque(int qtd) {
		this.qtdEstoque = qtd;
	}
	public int getQtdComprada() {
		return qtdComprada;
	}
	public void setQtdComprada(int qtdComprada) {
		this.qtdComprada = qtdComprada;
	}
}
