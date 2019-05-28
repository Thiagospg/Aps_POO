package aps.poo.banco.gui;

import aps.poo.banco.Banco;
import aps.poo.banco.conta.ContaBancaria;

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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class FrameMovimentar extends JFrame {

	private JPanel contentPane;
	private JTextField textNumConta;
	private JTextField textValor;
	private JTextField textNumContaTransf;
	protected static FrameMovimentar frameMovimentar;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private ContaBancaria conta = null;

	/**
	 * Launch the application.
	 */
	public static void getFrameMovimentar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frameMovimentar = new FrameMovimentar();
					frameMovimentar.setLocation(FrameMain.frameMain.getX(),
							FrameMain.frameMain.getY());
					frameMovimentar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameMovimentar() {
		setResizable(false);
		setTitle("Movimentar Contas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 355, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelOperacoes = new JPanel();
		panelOperacoes.setBounds(10, 5, 330, 253);
		panelOperacoes.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"),
				"Opera\u00E7\u00F5es com Contas", TitledBorder.CENTER,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panelOperacoes);
		panelOperacoes.setLayout(null);

		JLabel labelNumConta = new JLabel("Informe o n\u00FAmero da conta:");
		labelNumConta.setBounds(22, 28, 143, 14);
		labelNumConta.setFont(new Font("Tahoma", Font.ITALIC, 11));
		panelOperacoes.add(labelNumConta);

		textNumConta = new JTextField();
		labelNumConta.setLabelFor(textNumConta);
		textNumConta.setBounds(166, 25, 144, 20);
		textNumConta.setColumns(10);
		panelOperacoes.add(textNumConta);

		final JButton buttonLocalizar = new JButton("Localizar");

		buttonLocalizar.setBounds(22, 53, 288, 23);
		buttonLocalizar.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelOperacoes.add(buttonLocalizar);

		final JRadioButton radioDepositar = new JRadioButton("Depositar");
		radioDepositar.setEnabled(false);

		radioDepositar.setSelected(true);
		buttonGroup.add(radioDepositar);
		radioDepositar.setBounds(47, 114, 80, 23);
		radioDepositar.setHorizontalAlignment(SwingConstants.CENTER);
		radioDepositar.setFont(new Font("Tahoma", Font.ITALIC, 11));
		panelOperacoes.add(radioDepositar);

		final JRadioButton radioSacar = new JRadioButton("Sacar");

		radioSacar.setEnabled(false);
		buttonGroup.add(radioSacar);
		radioSacar.setBounds(129, 114, 84, 23);
		radioSacar.setHorizontalAlignment(SwingConstants.CENTER);
		radioSacar.setFont(new Font("Tahoma", Font.ITALIC, 11));
		panelOperacoes.add(radioSacar);

		final JRadioButton radioTransferir = new JRadioButton("Transferir");

		radioTransferir.setEnabled(false);
		buttonGroup.add(radioTransferir);
		radioTransferir.setBounds(215, 114, 80, 23);
		radioTransferir.setHorizontalAlignment(SwingConstants.CENTER);
		radioTransferir.setFont(new Font("Tahoma", Font.ITALIC, 11));
		panelOperacoes.add(radioTransferir);

		final JLabel labelValor = new JLabel("Informe o valor:");
		labelValor.setEnabled(false);
		labelValor.setBounds(22, 150, 126, 14);
		labelValor.setFont(new Font("Tahoma", Font.ITALIC, 11));
		panelOperacoes.add(labelValor);

		textValor = new JTextField();
		textValor.setEnabled(false);
		labelValor.setLabelFor(textValor);
		textValor.setBounds(166, 147, 144, 20);
		textValor.setColumns(10);
		panelOperacoes.add(textValor);

		final JLabel labelNumContaTransf = new JLabel(
				"N\u00FAmero da Conta destino:");
		labelNumContaTransf.setEnabled(false);
		labelNumContaTransf.setBounds(22, 181, 126, 14);
		labelNumContaTransf.setFont(new Font("Tahoma", Font.ITALIC, 11));
		panelOperacoes.add(labelNumContaTransf);

		textNumContaTransf = new JTextField();
		textNumContaTransf.setEnabled(false);
		labelNumContaTransf.setLabelFor(textNumContaTransf);
		textNumContaTransf.setBounds(166, 178, 144, 20);
		textNumContaTransf.setColumns(10);
		panelOperacoes.add(textNumContaTransf);

		final JButton buttonConfirmar = new JButton("Confirmar");
		buttonConfirmar.setEnabled(false);

		buttonConfirmar.setBounds(22, 213, 129, 23);
		buttonConfirmar.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelOperacoes.add(buttonConfirmar);

		final JButton buttonLimpar = new JButton("Limpar Campos");

		buttonLimpar.setEnabled(false);

		buttonLimpar.setBounds(181, 213, 129, 23);
		buttonLimpar.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelOperacoes.add(buttonLimpar);

		final JLabel labelMensagem = new JLabel("");
		labelMensagem.setOpaque(true);
		labelMensagem.setHorizontalAlignment(SwingConstants.CENTER);
		labelMensagem.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelMensagem.setBounds(5, 88, 321, 14);
		panelOperacoes.add(labelMensagem);

		final JButton buttonVoltar = new JButton("Voltar");
		buttonVoltar.setBounds(110, 269, 129, 23);
		contentPane.add(buttonVoltar);
		buttonVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));

		buttonVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameMovimentar.dispose();
				FrameMain.frameMain.setLocation(frameMovimentar.getX(),
						frameMovimentar.getY());
				FrameMain.frameMain.setVisible(true);
			}
		});

		// EVENTOS

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				FrameMain.frameMain.setLocation(frameMovimentar.getX(),
						frameMovimentar.getY());
				FrameMain.frameMain.setVisible(true);
			}
		});

		buttonLocalizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				buttonLocalizar.setCursor(cursor);
			}
		});

		radioDepositar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				radioDepositar.setCursor(cursor);
			}
		});

		radioSacar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				radioSacar.setCursor(cursor);
			}
		});

		radioTransferir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				radioTransferir.setCursor(cursor);
			}
		});

		buttonConfirmar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				buttonConfirmar.setCursor(cursor);
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

		buttonLocalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conta = Banco.procurarConta(Long.parseLong(textNumConta
							.getText()));
					if (conta == null) {
						Banco.addMensagem(labelMensagem, "Conta inexistente!",
								"#f2dede", "#a83831");
					} else {
						Banco.addMensagem(labelMensagem,
								"Conta localizada, selecione a operação!",
								"#dff0d8", "#357649");

						textNumConta.setEnabled(false);

						radioDepositar.setEnabled(true);
						radioSacar.setEnabled(true);
						radioTransferir.setEnabled(true);

						labelValor.setEnabled(true);

						textValor.setEnabled(true);

						buttonConfirmar.setEnabled(true);
						buttonLimpar.setEnabled(true);

					}

				} catch (NumberFormatException ex) {
					Banco.addMensagem(labelMensagem, "Digite apenas números!",
							"#f2dede", "#a83831");
				}
			}
		});

		radioDepositar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labelNumContaTransf.setEnabled(false);
				textNumContaTransf.setEnabled(false);
			}
		});

		radioSacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labelNumContaTransf.setEnabled(false);
				textNumContaTransf.setEnabled(false);
			}
		});

		radioTransferir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labelNumContaTransf.setEnabled(true);
				textNumContaTransf.setEnabled(true);
			}
		});

		buttonConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if (Banco.valueIsString(textValor.getText())) {
						throw new NumberFormatException();
					}

					if (radioDepositar.isSelected()) {

						if (conta.depositar(Double.parseDouble(textValor
								.getText()))) {
							Banco.addMensagem(labelMensagem,
									"Depósito feito com sucesso!", "#dff0d8",
									"#357649");
						} else {
							Banco.addMensagem(labelMensagem,
									"Não foi possível depositar!", "#f2dede",
									"#a83831");
						}

					} else if (radioSacar.isSelected()) {

						if (conta.sacar(Double.parseDouble(textValor.getText()))) {
							Banco.addMensagem(labelMensagem,
									"Saque feito com sucesso!", "#dff0d8",
									"#357649");
						} else {
							Banco.addMensagem(
									labelMensagem,
									"Não foi possível sacar, consulte seu saldo!",
									"#f2dede", "#a83831");
						}

					} else {
						ContaBancaria contaPara = Banco.procurarConta(Integer
								.parseInt(textNumContaTransf.getText()));

						if (contaPara != conta
								&& conta.transferir(
										Double.parseDouble(textValor.getText()),
										conta, contaPara)) {
							Banco.addMensagem(labelMensagem,
									"Transferência feita com sucesso!",
									"#dff0d8", "#357649");
						} else {
							Banco.addMensagem(
									labelMensagem,
									"Não foi possível transferir, preencha corretamente!",
									"#f2dede", "#a83831");
						}

					}
				} catch (NumberFormatException ex) {
					Banco.addMensagem(labelMensagem, "Digite apenas números!",
							"#f2dede", "#a83831");
				} catch (NullPointerException ex) {
					Banco.addMensagem(labelMensagem,
							"Conta destino inexistente!", "#f2dede", "#a83831");
				}
			}
		});

		buttonLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conta = null;

				textNumConta.setEnabled(true);
				textNumConta.setText("");

				radioDepositar.setEnabled(false);
				radioDepositar.setSelected(true);
				radioSacar.setEnabled(false);
				radioTransferir.setEnabled(false);

				labelValor.setEnabled(false);
				textValor.setEnabled(false);
				textValor.setText("");

				buttonConfirmar.setEnabled(false);
				buttonLimpar.setEnabled(false);

				textNumContaTransf.setEnabled(false);
				textNumContaTransf.setText("");
				labelNumContaTransf.setEnabled(false);

				Banco.addMensagem(labelMensagem, "", "#F0F0F0", "#F0F0F0");
			}
		});

	}
}
