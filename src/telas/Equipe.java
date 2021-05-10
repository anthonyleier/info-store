package telas;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import classes.Vendedor;

public class Equipe {

	//Nossas Variáveis
	
	private List<Vendedor> lista; //lista de vendedores recebida
	private TableItem linha; //cada linha representa um vendedor na Table
	
	//Window Builder Variáveis
	
	protected Shell shlFuncionrios;
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Equipe window = new Equipe();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlFuncionrios.open();
		shlFuncionrios.layout();
		while (!shlFuncionrios.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlFuncionrios = new Shell();
		shlFuncionrios.setSize(450, 300);
		shlFuncionrios.setText("Funcion\u00E1rios");
		
		table = new Table(shlFuncionrios, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(0, 0, 434, 261);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnId = new TableColumn(table, SWT.NONE);
		tblclmnId.setWidth(62);
		tblclmnId.setText("ID");
		
		TableColumn tblclmnNome = new TableColumn(table, SWT.NONE);
		tblclmnNome.setWidth(164);
		tblclmnNome.setText("Nome");
		
		TableColumn tblclmnCpf = new TableColumn(table, SWT.NONE);
		tblclmnCpf.setWidth(98);
		tblclmnCpf.setText("CPF");
		
		TableColumn tblclmnAutorizcao = new TableColumn(table, SWT.NONE);
		tblclmnAutorizcao.setWidth(100);
		tblclmnAutorizcao.setText("Autorizac\u00E3o");
		
		//percorre a lista colocando na tabela
		for(int i=0;i<lista.size();i++) {
			linha = new TableItem(table, SWT.NONE, i);
				
			//linha = new TableItem(tabela, estilo, nLinha);
			//linha.setText(coluna, texto)
				
			//Cada conjunto de linhas corresponde a um produto
			linha.setText(0, lista.get(i).getCodVend());
			linha.setText(1, lista.get(i).getNomeVend());
			linha.setText(2, lista.get(i).getCpfVend());
			if(lista.get(i).isPermissao()) {
				linha.setText(3, "Sim");
			}else {
				linha.setText(3, "Não");
			}
		}
	}

	public void setLista(List<Vendedor> listaVend) {
		this.lista = listaVend;
		//recebe a lista enviada
	}
}
