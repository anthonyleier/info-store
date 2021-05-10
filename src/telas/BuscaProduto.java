package telas;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import classes.Produto;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class BuscaProduto {

	//Nossas Variáveis
	private List<Produto> listaDeProdutos = new ArrayList<Produto>();
	private List<Produto> carrinhoCliente = new ArrayList<Produto>();
	
	//WindowBuilder Variáveis
	protected Shell shlBuscaproduto;
	private Text textIdProd;
	private Text textQtdProd;
	private Button btnBuscar;
	private Button btnCancelar;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BuscaProduto window = new BuscaProduto();
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
		shlBuscaproduto.open();
		shlBuscaproduto.layout();
		while (!shlBuscaproduto.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlBuscaproduto = new Shell();
		shlBuscaproduto.setSize(450, 300);
		shlBuscaproduto.setText("Busca de Produtos");
		shlBuscaproduto.setLayout(new GridLayout(2, false));
		
		Label lblIdDoProduto = new Label(shlBuscaproduto, SWT.NONE);
		lblIdDoProduto.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblIdDoProduto.setText("ID do Produto: ");
		
		textIdProd = new Text(shlBuscaproduto, SWT.BORDER);
		textIdProd.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblQuantidadeDesejada = new Label(shlBuscaproduto, SWT.NONE);
		lblQuantidadeDesejada.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblQuantidadeDesejada.setText("Quantidade Desejada: ");
		
		textQtdProd = new Text(shlBuscaproduto, SWT.BORDER);
		textQtdProd.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shlBuscaproduto, SWT.NONE);
		new Label(shlBuscaproduto, SWT.NONE);
		
		btnCancelar = new Button(shlBuscaproduto, SWT.NONE);
		btnCancelar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Botao Cancelar
				shlBuscaproduto.close();
			}
		});
		btnCancelar.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnCancelar.setText("Cancelar");
		
		btnBuscar = new Button(shlBuscaproduto, SWT.NONE);
		btnBuscar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Botao buscar
				//Realiza busca do produto desejado
				
				//Verifica se os campos são nulos
				if(textIdProd.getText() != "" && textQtdProd.getText() != "") {
					
					int idBuscado = Integer.parseInt(textIdProd.getText());
					int qtdBuscada = Integer.parseInt(textQtdProd.getText());
					boolean produtoEncontrado = false;
					
					for(int i=0; i<listaDeProdutos.size(); i++) { //Percorre a lista de Estoque
							
						if(idBuscado == listaDeProdutos.get(i).getCodProduto()) { //Caso encontre
							produtoEncontrado = true;
							if(qtdBuscada <= listaDeProdutos.get(i).getQtdEstoque()) {
								listaDeProdutos.get(i).setQtdComprada(qtdBuscada); //Diz quanto do produto queremos
								carrinhoCliente.add(listaDeProdutos.get(i)); //Produto acrescentado ao carrinho com sucesso
								shlBuscaproduto.close();
							}else {
								JOptionPane.showMessageDialog(null, "Quantidade em Estoque Insuficiente");
								shlBuscaproduto.close();
							}
							
						}
						
					}
					
					if(!produtoEncontrado) {
						JOptionPane.showMessageDialog(null, "Produto não Encontrado");
						shlBuscaproduto.close();
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
					shlBuscaproduto.close();
				}
			}
		});
		btnBuscar.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnBuscar.setText("Adicionar Produto");
	}
	public void setListaProdutos(List<Produto> listaDeProdutos) {
		this.listaDeProdutos = listaDeProdutos;		
	}
	public List<Produto> getCarrinho() {
		return carrinhoCliente;
	}
}
