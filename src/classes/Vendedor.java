package classes;

public class Vendedor {
	
	private String nomeVend;
	private String cpfVend;
	private String codVend;
	private boolean permissao;
	
	public Vendedor(String nomeVend, String cpfVend, String cod, boolean permissao) {
		this.nomeVend = nomeVend;
		this.cpfVend = cpfVend;
		this.codVend = cod;
		this.permissao = permissao;
	}
	public String getNomeVend() {
		return nomeVend;
	}
	public String getCpfVend() {
		return cpfVend;
	}
	public String getCodVend() {
		return codVend;
	}
	public boolean isPermissao() {
		return permissao;
	}
}
