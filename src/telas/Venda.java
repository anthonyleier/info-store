package telas;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import classes.Produto;
import classes.Vendedor;
import gerenciadores.GerenciadorDeNotas;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TableColumn;

public class Venda {

	//Nossas variáveis
	private List<Produto> listaDeProdutos = new ArrayList<Produto>(); //lista recebida
	private List<Vendedor> listaDeVendedores = new ArrayList<Vendedor>(); //lista recebida
	private List<Produto> carrinhoCliente = new ArrayList<Produto>(); //carrinho criado do cliente
	
	
	//Instanciar Telas e Objetos
	BuscaProduto bp = new BuscaProduto();
	GerenciadorDeNotas gt = new GerenciadorDeNotas();
	
	//WindowBuilder Variáveis
	protected Shell shlVenda;
	private Text textNomeCli;
	private Text textCpfCli;
	private Text textIdVend;
	private Table tableCarrinho;
	private Button btnCancelar;
	private Button btnAdicionarNovoProduto;
	private Button btnFinalizarCompra;
	private TableItem linhaCarrinho;
	private TableColumn tblclmnCdigo;
	private TableColumn tblclmnNome;
	private TableColumn tblclmnValor;
	private TableColumn tblclmnQuantidade;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Venda window = new Venda();
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
		shlVenda.open();
		shlVenda.layout();
		while (!shlVenda.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlVenda = new Shell();
		shlVenda.setSize(450, 447);
		shlVenda.setText("Venda");
		shlVenda.setLayout(new GridLayout(3, false));
		
		Label lblNomeDoCliente = new Label(shlVenda, SWT.NONE);
		lblNomeDoCliente.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNomeDoCliente.setText("Nome do Cliente: ");
		
		textNomeCli = new Text(shlVenda, SWT.BORDER);
		textNomeCli.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shlVenda, SWT.NONE);
		
		Label lblCpfDoCliente = new Label(shlVenda, SWT.NONE);
		lblCpfDoCliente.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblCpfDoCliente.setText("CPF do Cliente: ");
		
		textCpfCli = new Text(shlVenda, SWT.BORDER);
		textCpfCli.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shlVenda, SWT.NONE);
		
		Label lblIdDoVendedor = new Label(shlVenda, SWT.NONE);
		lblIdDoVendedor.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblIdDoVendedor.setText("ID do Vendedor: ");
		
		textIdVend = new Text(shlVenda, SWT.BORDER);
		textIdVend.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shlVenda, SWT.NONE);
		new Label(shlVenda, SWT.NONE);
		new Label(shlVenda, SWT.NONE);
		new Label(shlVenda, SWT.NONE);
		
		tableCarrinho = new Table(shlVenda, SWT.BORDER | SWT.FULL_SELECTION);
		GridData gd_tableCarrinho = new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1);
		gd_tableCarrinho.widthHint = 367;
		gd_tableCarrinho.heightHint = 54;
		tableCarrinho.setLayoutData(gd_tableCarrinho);
		tableCarrinho.setHeaderVisible(true);
		tableCarrinho.setLinesVisible(true);
		
		tblclmnCdigo = new TableColumn(tableCarrinho, SWT.NONE);
		tblclmnCdigo.setWidth(100);
		tblclmnCdigo.setText("C\u00F3digo");
		
		tblclmnNome = new TableColumn(tableCarrinho, SWT.NONE);
		tblclmnNome.setWidth(100);
		tblclmnNome.setText("Nome");
		
		tblclmnValor = new TableColumn(tableCarrinho, SWT.NONE);
		tblclmnValor.setWidth(100);
		tblclmnValor.setText("Valor");
		
		tblclmnQuantidade = new TableColumn(tableCarrinho, SWT.NONE);
		tblclmnQuantidade.setWidth(100);
		tblclmnQuantidade.setText("Quantidade");
		
		btnCancelar = new Button(shlVenda, SWT.NONE);
		btnCancelar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Botao cancelar = fecha tela
				shlVenda.close();
			}
		});
		btnCancelar.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnCancelar.setText("Cancelar");
		
		btnAdicionarNovoProduto = new Button(shlVenda, SWT.NONE);
		btnAdicionarNovoProduto.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Botao Add Produto
				bp.setListaProdutos(listaDeProdutos);  //Envia lista de Estoque
				bp.open(); //Abre a tela de procura de produtos
				
				carrinhoCliente = bp.getCarrinho(); //Recebe a lista atualizada do Carrinho
				
				tableCarrinho.clearAll(); //limpa a tela antes de atualizar as informações (evita itens duplicados)
				
				for(int i=0;i<carrinhoCliente.size();i++) { //Percorre carrinho e exibe na tela
					linhaCarrinho = new TableItem(tableCarrinho, SWT.NONE, i);
						
					//linha = new TableItem(tabela, estilo, nLinha);
					//linha.setText(coluna, texto)
						
					//Cada conjunto de linhas corresponde a um produto
					linhaCarrinho.setText(0, Integer.toString(carrinhoCliente.get(i).getCodProduto()));
					linhaCarrinho.setText(1, carrinhoCliente.get(i).getNome());
					linhaCarrinho.setText(2, Double.toString(carrinhoCliente.get(i).getPreco()));
					linhaCarrinho.setText(3, Integer.toString(carrinhoCliente.get(i).getQtdComprada()));
				}
			}
		});
		btnAdicionarNovoProduto.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnAdicionarNovoProduto.setText("Adicionar Novo Produto");
		
		btnFinalizarCompra = new Button(shlVenda, SWT.NONE);
		btnFinalizarCompra.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Botao FinalizarCompra 
				boolean vendedorExiste = false;
				
				for(int i=0; i<listaDeVendedores.size(); i++) {
					if(textIdVend.getText().equals(listaDeVendedores.get(i).getCodVend())) {
						vendedorExiste = true; //Verifica a existencia do IDVendedor
					}
				}
				
				if(vendedorExiste) { //Caso positivo
					if(textNomeCli.getText() != "" && textCpfCli.getText() != "") { //Verifica se os campos estao preenchidos
						if(!carrinhoCliente.isEmpty()) { //Verifica se o carrinho nao esta vazio
							TemCerteza confirmacao = new TemCerteza(shlVenda, SWT.DIALOG_TRIM);
							confirmacao.open(); //Abre tela de confirmacao
							
							//Caso clicar em sim prosseguir
							if(confirmacao.result.equals(true)) {
								gt.setDados(carrinhoCliente, textNomeCli.getText(), textCpfCli.getText(), Integer.valueOf(textIdVend.getText())); //Os dados são enviados para a nota
								try {
									gt.imprimeNota(); //grava a nota no arquivo
									shlVenda.close();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						}else {
							JOptionPane.showMessageDialog(null, "O carrinho está vazio");
						}
						
					}else {
						JOptionPane.showMessageDialog(null, "Preencha todos os campos");
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "ID de Vendedor não Encontrado");
				}
			}
		});
		btnFinalizarCompra.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnFinalizarCompra.setText("Finalizar Compra");	
	}

	public void setListProdutos(List<Produto> listaProd) {	
		this.listaDeProdutos = listaProd;
	}
	
public void setListVendedores(List<Vendedor> listaVend) {
		this.listaDeVendedores = listaVend;
	}
}
