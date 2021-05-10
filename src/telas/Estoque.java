package telas;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;

import java.io.IOException;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import classes.Produto;

public class Estoque {
	
	//Nossas Variáveis
	private List<Produto> lista; //Lista recebida
	
	//WindowBuilder Variáveis
	protected Shell shlEstoque;
	private Table tabelaProdutos;
	private TableItem linha;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Estoque window = new Estoque();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 * @throws IOException 
	 */
	public void open() throws IOException {
		Display display = Display.getDefault();
		createContents();
		shlEstoque.open();
		shlEstoque.layout();
		while (!shlEstoque.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 * @throws IOException 
	 */
	protected void createContents() throws IOException {
		shlEstoque = new Shell();
		shlEstoque.setSize(450, 300);
		shlEstoque.setText("Estoque");
		
		tabelaProdutos = new Table(shlEstoque, SWT.BORDER | SWT.FULL_SELECTION);
		tabelaProdutos.setBounds(10, 10, 414, 241);
		tabelaProdutos.setHeaderVisible(true);
		tabelaProdutos.setLinesVisible(true);
		
		TableColumn tblclmnCodigo = new TableColumn(tabelaProdutos, SWT.NONE);
		tblclmnCodigo.setWidth(100);
		tblclmnCodigo.setText("Codigo");
		
		TableColumn tblclmnNome = new TableColumn(tabelaProdutos, SWT.NONE);
		tblclmnNome.setWidth(100);
		tblclmnNome.setText("Nome");
		
		TableColumn tblclmnValr = new TableColumn(tabelaProdutos, SWT.NONE);
		tblclmnValr.setWidth(100);
		tblclmnValr.setText("Valor");
		
		TableColumn tblclmnQuantidade = new TableColumn(tabelaProdutos, SWT.NONE);
		tblclmnQuantidade.setWidth(100);
		tblclmnQuantidade.setText("Quantidade");
		
			
		for(int i=0;i<lista.size();i++) {
			linha = new TableItem(tabelaProdutos, SWT.NONE, i);
				
			//linha = new TableItem(tabela, estilo, nLinha);
			//linha.setText(coluna, texto)
				
			//Cada conjunto de linhas corresponde a um produto
			linha.setText(0, Integer.toString(lista.get(i).getCodProduto()));
			linha.setText(1, lista.get(i).getNome());
			linha.setText(2, Double.toString(lista.get(i).getPreco()));
			linha.setText(3, Integer.toString(lista.get(i).getQtdEstoque()));
			
		}
		
	}
	
	public void setListaProd(List<Produto> lista) {
		this.lista = lista;
		//Recebe a lista
	}
}
