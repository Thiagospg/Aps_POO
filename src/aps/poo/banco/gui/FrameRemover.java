package aps.poo.banco.gui;

import aps.poo.banco.Banco;

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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class FrameRemover extends JFrame {

	private JPanel contentPane;
	protected static FrameRemover frameRemover;
	private ImageIcon cleanIcon = new ImageIcon("imagens/lixo-icon.png");
	private JTextField textNumConta;

	/**
	 * Launch the application.
	 */
	public static void getFrameRemover() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frameRemover = new FrameRemover();
					frameRemover.setLocation(FrameMain.frameMain.getX(),
							FrameMain.frameMain.getY());
					frameRemover.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameRemover() {
		setTitle("Remover Contas");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 335, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final JButton buttonRemover = new JButton("Remover");

		buttonRemover.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonRemover.setBounds(55, 134, 96, 23);
		contentPane.add(buttonRemover);

		final JButton buttonVoltar = new JButton("Voltar");
		buttonVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));

		buttonVoltar.setBounds(177, 134, 96, 23);
		contentPane.add(buttonVoltar);

		final JLabel labelCleanIcon = new JLabel("");
		labelCleanIcon.setToolTipText("Limpa o campo");
		labelCleanIcon.setHorizontalAlignment(SwingConstants.CENTER);

		labelCleanIcon.setFont(new Font("Tahoma", Font.PLAIN, 8));
		labelCleanIcon.setBounds(282, 64, 16, 16);
		contentPane.add(labelCleanIcon);

		labelCleanIcon.setIcon(cleanIcon);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"),
				"Remo\u00E7\u00E3o de Contas", TitledBorder.CENTER,
				TitledBorder.TOP, null, Color.BLACK));
		panel.setBounds(10, 11, 309, 112);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("N\u00FAmero da Conta:");
		label.setBounds(110, 28, 88, 14);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.ITALIC, 11));
		panel.add(label);

		textNumConta = new JTextField();
		label.setLabelFor(textNumConta);
		textNumConta.setBounds(46, 53, 217, 20);
		textNumConta.setColumns(10);
		panel.add(textNumConta);

		JSeparator separator = new JSeparator();
		separator.setBounds(246, 30, 0, 2);
		separator.setForeground(Color.LIGHT_GRAY);
		panel.add(separator);

		final JLabel labelMensagem = new JLabel("");
		labelMensagem.setHorizontalAlignment(SwingConstants.CENTER);
		labelMensagem.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelMensagem.setBounds(10, 87, 289, 14);
		labelMensagem.setOpaque(true);
		panel.add(labelMensagem);

		// EVENTOS

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				FrameMain.frameMain.setLocation(frameRemover.getX(),
						frameRemover.getY());
				FrameMain.frameMain.setVisible(true);
			}
		});

		buttonRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					long numConta = Long.parseLong(textNumConta.getText());
					if (Banco.remover(numConta)) {
						Banco.addMensagem(labelMensagem,
								"Removido com sucesso!", "#dff0d8", "#357649");
					} else {
						Banco.addMensagem(labelMensagem, "Conta inexistente!",
								"#f2dede", "#a83831");
					}
				} catch (NumberFormatException ex) {
					Banco.addMensagem(labelMensagem, "Digite apenas números!",
							"#f2dede", "#a83831");
				}
			}
		});

		buttonVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameRemover.dispose();
				FrameMain.frameMain.setLocation(frameRemover.getX(),
						frameRemover.getY());
				FrameMain.frameMain.setVisible(true);
			}
		});

		labelCleanIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textNumConta.setText("");
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				labelCleanIcon.setCursor(cursor);
			}
		});

		buttonRemover.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				buttonRemover.setCursor(cursor);
			}
		});

		buttonVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				buttonVoltar.setCursor(cursor);
			}
		});

	}
}
