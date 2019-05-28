package aps.poo.banco.gui;

import aps.poo.banco.Banco;
import aps.poo.banco.conta.ContaBancaria;
import aps.poo.banco.conta.ContaCorrente;
import aps.poo.banco.conta.ContaPoupanca;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class FrameCriar extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textNumeroConta;
	private JTextField textSaldo;
	private static JTextField textLimiteOuTaxa;
	protected static FrameCriar frameCriar;

	/**
	 * Launch the application.
	 */
	public static void getFrameCriar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frameCriar = new FrameCriar();
					frameCriar.setLocation(FrameMain.frameMain.getX(),
							FrameMain.frameMain.getY());
					frameCriar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameCriar() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Cadastrar Contas");
		setResizable(false);
		setBounds(100, 100, 387, 310);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		setContentPane(contentPane);

		JPanel panelCadastroContas = new JPanel();
		panelCadastroContas
				.setBorder(new TitledBorder(UIManager
						.getBorder("TitledBorder.border"),
						"Cadastro de Contas", TitledBorder.CENTER,
						TitledBorder.TOP, null, new Color(0, 0, 0)));

		final JButton buttonVoltar = new JButton("Voltar");

		buttonVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));

		buttonVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameCriar.dispose();
				FrameMain.frameMain.setLocation(frameCriar.getX(),
						frameCriar.getY());
				FrameMain.frameMain.setVisible(true);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGap(126)
																		.addComponent(
																				buttonVoltar,
																				GroupLayout.PREFERRED_SIZE,
																				129,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				panelCadastroContas,
																				GroupLayout.DEFAULT_SIZE,
																				361,
																				Short.MAX_VALUE)))
										.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(
				Alignment.LEADING).addGroup(
				Alignment.TRAILING,
				gl_contentPane
						.createSequentialGroup()
						.addGap(4)
						.addComponent(panelCadastroContas,
								GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(buttonVoltar).addContainerGap()));
		panelCadastroContas.setLayout(null);

		final JLabel labelMensagem = new JLabel("");
		labelMensagem.setOpaque(true);
		labelMensagem.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelMensagem.setHorizontalAlignment(SwingConstants.CENTER);
		labelMensagem.setBounds(10, 170, 341, 14);
		panelCadastroContas.add(labelMensagem);

		final JRadioButton radioContaCorrente = new JRadioButton(
				"Conta Corrente");
		radioContaCorrente.setFont(new Font("Tahoma", Font.BOLD, 11));
		radioContaCorrente.setBounds(72, 21, 112, 23);
		radioContaCorrente.setHorizontalAlignment(SwingConstants.LEFT);
		radioContaCorrente.setSelected(true);
		buttonGroup.add(radioContaCorrente);
		panelCadastroContas.add(radioContaCorrente);

		final JRadioButton radioContaPoupanca = new JRadioButton(
				"Conta Poupanca");

		radioContaPoupanca.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonGroup.add(radioContaPoupanca);
		radioContaPoupanca.setBounds(186, 21, 119, 23);
		radioContaPoupanca.setHorizontalAlignment(SwingConstants.LEFT);
		panelCadastroContas.add(radioContaPoupanca);

		JLabel labelNumeroConta = new JLabel("N\u00FAmero da conta:");
		labelNumeroConta.setFont(new Font("Tahoma", Font.ITALIC, 11));
		labelNumeroConta.setHorizontalAlignment(SwingConstants.CENTER);
		labelNumeroConta.setBounds(101, 55, 158, 14);
		panelCadastroContas.add(labelNumeroConta);

		textNumeroConta = new JTextField();
		labelNumeroConta.setLabelFor(textNumeroConta);
		textNumeroConta.setToolTipText("");
		textNumeroConta.setBounds(99, 80, 158, 20);
		panelCadastroContas.add(textNumeroConta);
		textNumeroConta.setColumns(10);

		JLabel labelSaldo = new JLabel("Saldo:");
		labelSaldo.setFont(new Font("Tahoma", Font.ITALIC, 11));
		labelSaldo.setHorizontalAlignment(SwingConstants.CENTER);
		labelSaldo.setBounds(72, 111, 96, 14);
		panelCadastroContas.add(labelSaldo);

		textSaldo = new JTextField();
		labelSaldo.setLabelFor(textSaldo);
		textSaldo.setToolTipText("");
		textSaldo.setColumns(10);
		textSaldo.setBounds(66, 136, 102, 20);
		panelCadastroContas.add(textSaldo);

		final JLabel labelLimiteOuTaxa = new JLabel("Taxa:");
		labelLimiteOuTaxa.setFont(new Font("Tahoma", Font.ITALIC, 11));
		labelLimiteOuTaxa.setHorizontalAlignment(SwingConstants.CENTER);
		labelLimiteOuTaxa.setBounds(192, 111, 96, 14);
		panelCadastroContas.add(labelLimiteOuTaxa);

		textLimiteOuTaxa = new JTextField();
		labelLimiteOuTaxa.setLabelFor(textLimiteOuTaxa);
		textLimiteOuTaxa.setToolTipText("");
		textLimiteOuTaxa.setColumns(10);
		textLimiteOuTaxa.setBounds(186, 136, 102, 20);
		panelCadastroContas.add(textLimiteOuTaxa);

		final JButton buttonCadastrar = new JButton("Cadastrar");

		buttonCadastrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonCadastrar.setBounds(10, 200, 158, 23);
		panelCadastroContas.add(buttonCadastrar);

		final JButton buttonLimpar = new JButton("Limpar Campos");

		buttonLimpar.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonLimpar.setBounds(186, 200, 165, 23);
		panelCadastroContas.add(buttonLimpar);
		contentPane.setLayout(gl_contentPane);

		// EVENTOS

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				FrameMain.frameMain.setLocation(frameCriar.getX(),
						frameCriar.getY());
				FrameMain.frameMain.setVisible(true);
			}
		});

		radioContaPoupanca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				labelLimiteOuTaxa.setText("Limite:");
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				radioContaPoupanca.setCursor(cursor);
			}
		});

		radioContaCorrente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				labelLimiteOuTaxa.setText("Taxa:");
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				radioContaCorrente.setCursor(cursor);
			}
		});

		buttonCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				buttonCadastrar.setCursor(cursor);
			}
		});

		buttonLimpar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				buttonLimpar.setCursor(cursor);
			}
		});

		buttonVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				buttonVoltar.setCursor(cursor);
			}
		});

		buttonCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ContaBancaria conta;

				try {

					if (Banco.valueIsString(textSaldo.getText(),
							textLimiteOuTaxa.getText())) {
						throw new NumberFormatException();
					}

					long numConta = Long.parseLong(textNumeroConta.getText());
					double saldo = Double.parseDouble(textSaldo.getText());
					double taxaOuLimite = Double.parseDouble(textLimiteOuTaxa
							.getText());

					if (radioContaCorrente.isSelected()) {
						ContaCorrente contaCorrente = new ContaCorrente();
						contaCorrente.setNumeroConta(numConta);
						contaCorrente.setSaldo(saldo);
						contaCorrente.setTaxaDeOperacao(taxaOuLimite);
						conta = contaCorrente;
					} else {
						ContaPoupanca contaPoupanca = new ContaPoupanca();
						contaPoupanca.setNumeroConta(numConta);
						contaPoupanca.setSaldo(saldo);
						contaPoupanca.setLimite(taxaOuLimite);
						conta = contaPoupanca;
					}

					if (Banco.inserir(conta)) {
						Banco.addMensagem(labelMensagem,
								"Adicionado com sucesso!", "#dff0d8", "#357649");
					} else {
						Banco.addMensagem(labelMensagem,
								"A conta já existe, tente novamente!",
								"#f2dede", "#a83831");
					}

				} catch (NumberFormatException ex) {
					Banco.addMensagem(labelMensagem,
							"Verifique as informações passadas!", "#f2dede",
							"#a83831");
				}

			}
		});

		buttonLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (radioContaPoupanca.isSelected()) {
					radioContaCorrente.setSelected(true);
				}

				textNumeroConta.setText("");
				textSaldo.setText("");
				textLimiteOuTaxa.setText("");

			}
		});

	}
}
