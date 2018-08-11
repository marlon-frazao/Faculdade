package br.edu.unifacear.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.text.Caret;

import br.edu.unifacear.model.Entrada;
import br.edu.unifacear.model.Funcionario;
import br.edu.unifacear.model.Historico;
import br.edu.unifacear.model.Produto;
import br.edu.unifacear.session.EntradaSession;
import br.edu.unifacear.session.FuncionarioSession;
import br.edu.unifacear.session.HistoricoSession;
import br.edu.unifacear.session.ProdutoSession;
import br.edu.unifacear.util.ModeloTabela;
import br.edu.unifacear.util.TabelaEntrada;
import javax.swing.JFormattedTextField;

public class TelaRegistrarEntrada extends JFrame implements ActionListener {
	
	private JButton btnSair,btnRelatorio , btnConfirmarRecebimento,btnBuscar , btnVoltar, 
					btnCadastrarFuncionario, btnConsultarFuncionario, 
					btnCadastrarProduto, btnConsultarProduto, btnEntradaProduto, 
					btnSaidaProduto, btnRejeitarRecebimento;
	private JLabel lblHome, lblFuncionario, lblEstoque, lblNumeroPedido;
	private JFrame pnlPrincipal;
	private JTextField txtNumeroPedido;
	private JTable resultBusca;
	private static TabelaEntrada modelo;
	private JScrollPane scroll;
	private JTextField txtDataRecebimento;
	private Date data;
	private Long data2;
	
	
	public TelaRegistrarEntrada() {
		super("Menu");

		pnlPrincipal = new JFrame("Loja Lupo - Estoque - Entrada");
		pnlPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
		pnlPrincipal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pnlPrincipal.setLocationRelativeTo(null);
		pnlPrincipal.setResizable(true);
		pnlPrincipal.getContentPane().setLayout(null);
		
		lblHome = new JLabel("Registrar Entradas");
		lblHome.setForeground(Color.BLACK);
		lblHome.setFont(new Font("Arial", Font.BOLD, 36));
		lblHome.setBounds(600, 50, 480, 30);
		pnlPrincipal.getContentPane().add(lblHome);
		
		lblFuncionario = new JLabel("Funcion�rios");
		lblFuncionario.setForeground(Color.BLACK);
		lblFuncionario.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		lblFuncionario.setBounds(50, 100, 250, 23);
		pnlPrincipal.getContentPane().add(lblFuncionario);
		
		lblEstoque = new JLabel("Estoque");
		lblEstoque.setForeground(Color.black);
		lblEstoque.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		lblEstoque.setBounds(50, 250, 250, 23);
		pnlPrincipal.getContentPane().add(lblEstoque);

		btnCadastrarFuncionario = new JButton("Cadastrar Funcion�rio");
		btnCadastrarFuncionario.addActionListener(this);
		btnCadastrarFuncionario.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		btnCadastrarFuncionario.setBounds(50, 150, 250, 23);
		pnlPrincipal.getContentPane().add(btnCadastrarFuncionario);

		btnConsultarFuncionario = new JButton("Consultar Funcion�rio");
		btnConsultarFuncionario.addActionListener(this);
		btnConsultarFuncionario.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		btnConsultarFuncionario.setBounds(50, 200, 250, 23);
		pnlPrincipal.getContentPane().add(btnConsultarFuncionario);
		
		btnCadastrarProduto = new JButton("Cadastrar Produto");
		btnCadastrarProduto.addActionListener(this);
		btnCadastrarProduto.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		btnCadastrarProduto.setBounds(50, 300, 250, 23);
		pnlPrincipal.getContentPane().add(btnCadastrarProduto);
		
		btnConsultarProduto = new JButton("Consultar Produto");
		btnConsultarProduto.addActionListener(this);
		btnConsultarProduto.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		btnConsultarProduto.setBounds(50, 350, 250, 23);
		pnlPrincipal.getContentPane().add(btnConsultarProduto);
		
		btnEntradaProduto = new JButton("Registrar Entradas");
		btnEntradaProduto.addActionListener(this);
		btnEntradaProduto.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		btnEntradaProduto.setBounds(50, 400, 250, 23);
		pnlPrincipal.getContentPane().add(btnEntradaProduto);
		
		btnSaidaProduto = new JButton("Registrar Sa�das");
		btnSaidaProduto.addActionListener(this);
		btnSaidaProduto.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		btnSaidaProduto.setBounds(50, 450, 250, 23);
		pnlPrincipal.getContentPane().add(btnSaidaProduto);

		btnSair = new JButton("Sair");
		btnSair.addActionListener(this);
		btnSair.setFont(new Font("Ariel", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		btnSair.setBounds(1000, 600, 100, 23);
		pnlPrincipal.getContentPane().add(btnSair);

		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(this);
		
		btnVoltar.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		btnVoltar.setBounds(1150, 600, 100, 23);
		pnlPrincipal.getContentPane().add(btnVoltar);
		
		lblNumeroPedido = new JLabel("N\u00FAmero Pedido:");
		lblNumeroPedido.setForeground(Color.BLACK);
		lblNumeroPedido.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNumeroPedido.setBounds(362, 150, 180, 23);
		pnlPrincipal.getContentPane().add(lblNumeroPedido);
		
		txtNumeroPedido = new JTextField();
		txtNumeroPedido.setFont(new Font("Arial", Font.PLAIN, 20));
		txtNumeroPedido.setEditable(true);
		txtNumeroPedido.setColumns(10);
		txtNumeroPedido.setBounds(537, 150, 222, 22);
		pnlPrincipal.getContentPane().add(txtNumeroPedido);
		
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setForeground(Color.black);
		btnBuscar.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		btnBuscar.setBounds(1130, 150, 100, 23);
		pnlPrincipal.getContentPane().add(btnBuscar);

		modelo = new TabelaEntrada();
		resultBusca = new JTable(modelo);
		resultBusca.addMouseListener(modelo);
		resultBusca.getColumnModel().getColumn(0).setPreferredWidth(95);
		resultBusca.getColumnModel().getColumn(1).setPreferredWidth(70);
		resultBusca.getColumnModel().getColumn(2).setPreferredWidth(70);
		resultBusca.getColumnModel().getColumn(3).setPreferredWidth(70);
		resultBusca.getColumnModel().getColumn(4).setPreferredWidth(70);
		resultBusca.getColumnModel().getColumn(5).setPreferredWidth(70);
		resultBusca.getColumnModel().getColumn(6).setPreferredWidth(70);
		resultBusca.getColumnModel().getColumn(7).setPreferredWidth(70);
		resultBusca.getColumnModel().getColumn(8).setPreferredWidth(70);
		resultBusca.getColumnModel().getColumn(9).setPreferredWidth(70);
		resultBusca.getColumnModel().getColumn(10).setPreferredWidth(100);
		resultBusca.getColumnModel().getColumn(11).setPreferredWidth(70);
		
		scroll = new JScrollPane(resultBusca);
		scroll.setBounds(350, 200, 900, 300);
		pnlPrincipal.getContentPane().add(scroll);
		
		btnConfirmarRecebimento = new JButton("Confirmar Recebimento");
		btnConfirmarRecebimento.addActionListener(this);
		btnConfirmarRecebimento.setFont(new Font("Arial", Font.PLAIN, 20));
		btnConfirmarRecebimento.setBounds(980, 513, 270, 53);
		pnlPrincipal.getContentPane().add(btnConfirmarRecebimento);
		
		btnRejeitarRecebimento = new JButton("Rejeitar Recebimento");
		btnRejeitarRecebimento.addActionListener(this);
		btnRejeitarRecebimento.setFont(new Font("Arial", Font.PLAIN, 20));
		btnRejeitarRecebimento.setBounds(700, 513, 270, 53);
		pnlPrincipal.getContentPane().add(btnRejeitarRecebimento);
		
		JLabel lblDataRecebimento = new JLabel("Data Recebimento: ");
		lblDataRecebimento.setForeground(Color.BLACK);
		lblDataRecebimento.setFont(new Font("Arial", Font.PLAIN, 20));
		lblDataRecebimento.setBounds(340, 543, 180, 23);
		pnlPrincipal.getContentPane().add(lblDataRecebimento);
		
		txtDataRecebimento = new JTextField();
		txtDataRecebimento.setFont(new Font("Arial", Font.PLAIN, 20));
		txtDataRecebimento.setEditable(true);
		txtDataRecebimento.setColumns(10);
		txtDataRecebimento.setBounds(515, 544, 150, 22);
		
		data = new Date(System.currentTimeMillis());
		data2 = data.getTime();
		
		System.out.println("data2: "+data2.toString());
		System.out.println("data antes format: "+data);
		SimpleDateFormat formatarDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); 
		String dat = formatarDate.format(data);
		System.out.println("data: "+dat);
		//data = Date.valueOf(dat);
		System.out.println("data de String: "+data.toString());
		txtDataRecebimento.setText(dat);
		txtDataRecebimento.setEditable(false);
		pnlPrincipal.getContentPane().add(txtDataRecebimento);
		
		btnRelatorio = new JButton("Emitir Relat�rios");
		btnRelatorio.addActionListener(this);
		btnRelatorio.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		btnRelatorio.setBounds(50, 500, 250, 23);
		pnlPrincipal.getContentPane().add(btnRelatorio);
				

		pnlPrincipal.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnCadastrarFuncionario) {
			TelaCadastrarFuncionario tcf = new TelaCadastrarFuncionario();
			pnlPrincipal.dispose();
		}else 
			if(e.getSource() == btnConsultarFuncionario) {
				TelaConsultarFuncionario tcf = new TelaConsultarFuncionario();
				pnlPrincipal.dispose();
			} else
		if(e.getSource() == btnCadastrarProduto) {
			TelaCadastrarProduto tcp = new TelaCadastrarProduto();
			pnlPrincipal.dispose();
		} else
		
		if(e.getSource() == btnConsultarProduto) {
			TelaConsultarProduto tcp = new TelaConsultarProduto();
			pnlPrincipal.dispose();
		} else
			
		if(e.getSource() == btnEntradaProduto) {
			JOptionPane.showMessageDialog(null, "Voc� J� est� na tela de Entradas");
		} else
		
		if(e.getSource() == btnSaidaProduto) {
			TelaRegistrarSaida tre = new TelaRegistrarSaida();
			pnlPrincipal.dispose();
		} else
		
		if (e.getSource() == btnVoltar) {
			TelaMenu men =new TelaMenu();
			pnlPrincipal.dispose();
		} else
		if (e.getSource() == btnSair) {
			pnlPrincipal.dispose();
		}
		else if (e.getSource() == btnBuscar) {
			EntradaSession es = new EntradaSession();
			Entrada ent = new Entrada();
			List<Entrada> le = new ArrayList<Entrada>();
			List<Produto> lp = new ArrayList<Produto>();
			
			ent=es.obterNumPed(Long.parseLong(txtNumeroPedido.getText()));
			lp = ent.getListaProdutos();
			
			modelo.removeRow();
			if(ent.getId() == 0) {
				JOptionPane.showMessageDialog(null, "Numero do pedido Inv�lido!");
			}else {
				for (int i = 0; i < lp.size(); i++) {
					modelo.addRow(lp.get(i));			
				}
			}
			System.out.println("data: "+data.toString());
			
		}else if (e.getSource() == btnConfirmarRecebimento) {
			Entrada ent = new Entrada();
			EntradaSession ses = new EntradaSession();
			List<Produto> lp = new ArrayList<Produto>();
			Produto pro = new Produto();
			ProdutoSession ps = new ProdutoSession();
			HistoricoSession hs = new HistoricoSession();
			Historico h;
			
			ent = ses.obterNumPed(Long.parseLong(txtNumeroPedido.getText()));
			ent.setDataEntrada(data);
			lp = ent.getListaProdutos();
			System.out.println("qtd antes: "+lp.get(0).getQtde());
			ses.atualizarEntrada(ent,lp);
			System.out.println("qtd depois: "+lp.get(0).getQtde());
			h = new Historico(ent.getId(), data, "Entrada OK");
			hs.inserirHistorico(h);
			
						
			JOptionPane.showMessageDialog(null,"Pedido de compra recebido com sucesso!!");
			modelo.removeRow();
			
			
		} else if(e.getSource() == btnRejeitarRecebimento) {
			EntradaSession es = new EntradaSession();
			TelaHistorico ht = new TelaHistorico(es.obterNumPed(Long.parseLong(txtNumeroPedido.getText())));
		}else if (e.getSource() == btnRelatorio) {
			TelaRelatorio tr = new TelaRelatorio();
			pnlPrincipal.dispose();
		}
	}
}
