package aps.poo.banco.gui;

import aps.poo.banco.Banco;
import aps.poo.banco.conta.ContaBancaria;
import aps.poo.banco.conta.ContaCorrente;
import aps.poo.banco.conta.ContaPoupanca;
import aps.poo.banco.util.Relatorio;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class FrameRelatorio extends JFrame {

	private JPanel contentPane;
	protected static FrameRelatorio frameRelatorio;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void getFrameRelatorio() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frameRelatorio = new FrameRelatorio();
					frameRelatorio.setLocation(FrameMain.frameMain.getX(),
							FrameMain.frameMain.getY());
					frameRelatorio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameRelatorio() {
		setResizable(false);
		setTitle("Relat\u00F3rio de Contas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 366, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel labelTodasContas = new JLabel("Todas as contas?");
		labelTodasContas.setFont(new Font("Tahoma", Font.ITALIC, 11));
		labelTodasContas.setHorizontalAlignment(SwingConstants.CENTER);
		labelTodasContas.setBounds(42, 11, 105, 14);
		contentPane.add(labelTodasContas);

		JLabel labelSelecione = new JLabel("Selecione uma conta:");
		labelSelecione.setFont(new Font("Tahoma", Font.ITALIC, 11));
		labelSelecione.setBounds(210, 11, 108, 14);
		contentPane.add(labelSelecione);

		final JRadioButton radioSim = new JRadioButton("SIM");

		radioSim.setSelected(true);
		radioSim.setFont(new Font("Tahoma", Font.ITALIC, 11));
		buttonGroup.add(radioSim);
		radioSim.setBounds(42, 32, 43, 23);
		contentPane.add(radioSim);

		final JRadioButton radioNao = new JRadioButton("N\u00C3O");

		radioNao.setFont(new Font("Tahoma", Font.ITALIC, 11));
		buttonGroup.add(radioNao);
		radioNao.setBounds(97, 32, 47, 23);
		contentPane.add(radioNao);

		final JComboBox<Long> comboConta = new JComboBox<Long>();

		comboConta.setEnabled(false);
		comboConta.setMaximumRowCount(20);
		labelSelecione.setLabelFor(comboConta);
		comboConta.setBounds(210, 32, 108, 23);

		for (ContaBancaria conta : Banco.getContas()) {
			comboConta.addItem(conta.getNumeroConta());
		}
		contentPane.add(comboConta);

		final JButton buttonVisualizar = new JButton(
				"Visualizar Relat\u00F3rio");

		buttonVisualizar.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonVisualizar.setBounds(10, 66, 340, 23);
		contentPane.add(buttonVisualizar);

		final JButton buttonVoltar = new JButton("Voltar");

		buttonVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonVoltar.setBounds(143, 369, 74, 23);
		contentPane.add(buttonVoltar);

		JSeparator separatorBaixo = new JSeparator();
		separatorBaixo.setForeground(Color.LIGHT_GRAY);
		separatorBaixo.setBounds(0, 354, 360, 2);
		contentPane.add(separatorBaixo);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(179, 0, 2, 67);
		contentPane.add(separator);

		final TextArea textRelatorio = new TextArea();
		textRelatorio.setBounds(10, 95, 340, 253);
		contentPane.add(textRelatorio);

		// EVENTOS

		radioSim.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				radioSim.setCursor(cursor);
			}
		});

		radioNao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				radioNao.setCursor(cursor);
			}
		});

		comboConta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				comboConta.setCursor(cursor);
			}
		});

		buttonVisualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				buttonVisualizar.setCursor(cursor);
			}
		});

		buttonVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				buttonVoltar.setCursor(cursor);
			}
		});

		buttonVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameRelatorio.dispose();
				FrameMain.frameMain.setLocation(frameRelatorio.getX(),
						frameRelatorio.getY());
				FrameMain.frameMain.setVisible(true);
			}
		});

		buttonVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorio relatorio = new Relatorio();

				if (radioSim.isSelected()) {
					textRelatorio.setText("");
					for (ContaBancaria conta : Banco.getContas()) {
						if (conta instanceof ContaCorrente) {
							textRelatorio.append(relatorio
									.gerarRelatorio((ContaCorrente) conta));
						} else {
							textRelatorio.append(relatorio
									.gerarRelatorio((ContaPoupanca) conta));
						}
					}
				} else {
					for (ContaBancaria conta : Banco.getContas()) {
						if (Long.parseLong(comboConta.getSelectedItem()
								.toString()) == conta.getNumeroConta()) {

							if (conta instanceof ContaCorrente) {
								textRelatorio.setText(relatorio
										.gerarRelatorio((ContaCorrente) conta));
							} else {
								textRelatorio.setText(relatorio
										.gerarRelatorio((ContaPoupanca) conta));
							}

							break;
						}
					}
				}
			}
		});

		radioSim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboConta.setEnabled(false);
			}
		});

		radioNao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboConta.setEnabled(true);
			}
		});

	}
}
