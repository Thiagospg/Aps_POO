package aps.poo.banco.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class FrameMain {

	protected static JFrame frameMain;
	private ImageIcon unicarioca = new ImageIcon(
			"imagens/logo-unicarioca-2.png");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameMain window = new FrameMain();
					window.frameMain.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrameMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frameMain = new JFrame();
		frameMain.setTitle("Atividade Pr\u00E1tica Supervisionada");
		frameMain.setResizable(false);
		frameMain.getContentPane().setBackground(Color.WHITE);
		frameMain.setBounds(100, 100, 420, 230);
		frameMain.setLocationRelativeTo(null);
		frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frameMain.setJMenuBar(menuBar);

		final JMenu mnConta = new JMenu("Conta");
		menuBar.add(mnConta);

		JMenuItem mntmCriar = new JMenuItem("Criar");

		mnConta.add(mntmCriar);

		JMenuItem mntmMovimentar = new JMenuItem("Movimentar");

		mnConta.add(mntmMovimentar);

		JMenuItem mntmRemover = new JMenuItem("Remover");

		mnConta.add(mntmRemover);

		final JMenu mnRelatorio = new JMenu("Relatorio");

		menuBar.add(mnRelatorio);

		final JMenu mnFinalizar = new JMenu("Finalizar");

		menuBar.add(mnFinalizar);
		frameMain.getContentPane().setLayout(null);

		JLabel labelUnicariocaImg = new JLabel("");
		labelUnicariocaImg.setBounds(94, 25, 249, 87);
		labelUnicariocaImg.setBackground(Color.WHITE);
		frameMain.getContentPane().add(labelUnicariocaImg);
		labelUnicariocaImg.setIcon(unicarioca);

		// EVENTOS

		mntmCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameCriar.getFrameCriar();
				frameMain.dispose();
			}
		});

		mntmMovimentar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameMovimentar.getFrameMovimentar();
				frameMain.dispose();
			}
		});

		mntmRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameRemover.getFrameRemover();
				frameMain.dispose();
			}
		});

		mnRelatorio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameRelatorio.getFrameRelatorio();
				mnRelatorio.setBackground(Color.decode("#f0f0f0"));
				mnRelatorio.setOpaque(false);
				frameMain.dispose();
			}
		});

		mnFinalizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frameMain.dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				mnFinalizar.setOpaque(true);
				mnFinalizar.setBackground(Color.decode("#a3b8cc"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				mnFinalizar.setOpaque(false);
				mnFinalizar.setBackground(Color.decode("#f0f0f0"));
			}
		});

		mnRelatorio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mnRelatorio.setOpaque(true);
				mnRelatorio.setBackground(Color.decode("#a3b8cc"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				mnRelatorio.setOpaque(false);
				mnRelatorio.setBackground(Color.decode("#f0f0f0"));
			}
		});

		mnConta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mnConta.setOpaque(true);
				mnConta.setBackground(Color.decode("#a3b8cc"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				mnConta.setOpaque(false);
				mnConta.setBackground(Color.decode("#f0f0f0"));
			}
		});
	}
}
