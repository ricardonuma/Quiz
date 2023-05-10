package Visualização;
import java.applet.AudioClip;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Controle.ControleMenu;


public class TelaMenu extends JFrame {

	public static AudioClip som;
	public static URL caminhoSom;
	public static String modo_jogo = "";
	public URL som_click = getClass().getResource("/som/CLICK18C.WAV");
	public ImageIcon icone = new ImageIcon(getClass().getResource("/imagem/Coda.png"));
	
	public JButton btn_jogar = new JButton(new ImageIcon(getClass().getResource("/imagem/jogar.fw.png")));
	public JButton btn_ranking = new JButton(new ImageIcon(getClass().getResource("/imagem/ranking.fw.png")));
	public JButton btn_regras = new JButton(new ImageIcon(getClass().getResource("/imagem/regras.fw.png")));
	public JButton btn_sair = new JButton(new ImageIcon(getClass().getResource("/imagem/sair.fw.png")));
	
	JLabel bg = new JLabel(new ImageIcon(getClass().getResource("/imagem/inicial.fw.png")));
	
	public TelaMenu(){
		super("EcoQuiz");
		this.setVisible(true);
		this.setSize(875,700);
		this.add(bg);
		this.setIconImage(icone.getImage());
				
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
										
		bg.add(btn_jogar);
		bg.add(btn_ranking);
		bg.add(btn_regras);
		bg.add(btn_sair);
		
		btn_jogar.setLocation(225, 100);
		btn_ranking.setLocation(450, 100);
		btn_regras.setLocation(225, 300);
		btn_sair.setLocation(450, 300);
		
		btn_jogar.setSize(200, 200);
		btn_ranking.setSize(200, 200);
		btn_regras.setSize(200, 200);
		btn_sair.setSize(200, 200);
		
		btn_jogar.setToolTipText("Jogar");
		btn_ranking.setToolTipText("Ranking");
		btn_regras.setToolTipText("Regras");
		btn_sair.setToolTipText("Sair");
				
		btn_jogar.setBorderPainted(false);
		btn_ranking.setBorderPainted(false);
		btn_regras.setBorderPainted(false);
		btn_sair.setBorderPainted(false);
				
		btn_jogar.setContentAreaFilled(false);
		btn_ranking.setContentAreaFilled(false);
		btn_regras.setContentAreaFilled(false);
		btn_sair.setContentAreaFilled(false);
		
		btn_jogar.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btn_jogar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		    	btn_jogar.setIcon(new ImageIcon(getClass().getResource("/imagem/jogar.fw - Copy.png")));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btn_jogar.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		    	btn_jogar.setIcon(new ImageIcon(getClass().getResource("/imagem/jogar.fw.png")));
		    }
		});
		
		btn_ranking.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btn_ranking.setCursor(new Cursor(Cursor.HAND_CURSOR));
		    	btn_ranking.setIcon(new ImageIcon(getClass().getResource("/imagem/ranking.fw - Copy.png")));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btn_ranking.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		    	btn_ranking.setIcon(new ImageIcon(getClass().getResource("/imagem/ranking.fw.png")));
		    }
		});
		
		btn_regras.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btn_regras.setCursor(new Cursor(Cursor.HAND_CURSOR));
		    	btn_regras.setIcon(new ImageIcon(getClass().getResource("/imagem/regras.fw - Copy.png")));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btn_regras.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		    	btn_regras.setIcon(new ImageIcon(getClass().getResource("/imagem/regras.fw.png")));
		    }
		});
		
		btn_sair.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btn_sair.setCursor(new Cursor(Cursor.HAND_CURSOR));
		    	btn_sair.setIcon(new ImageIcon(getClass().getResource("/imagem/sair.fw - Copy.png")));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btn_sair.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		    	btn_sair.setIcon(new ImageIcon(getClass().getResource("/imagem/sair.fw.png")));
		    }
		});
		
		ControleMenu controleMenu = new ControleMenu(this);
		btn_jogar.addActionListener(controleMenu);
		btn_ranking.addActionListener(controleMenu);
		btn_regras.addActionListener(controleMenu);
		btn_sair.addActionListener(controleMenu);
		
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setResizable(false);
		
		TelaCartas.id_jogador1 = "";
		TelaCartas.id_jogador2 = "";
		TelaCartas.nome_jogador1 = "";
		TelaCartas.nome_jogador2 = "";
		TelaCartas.score1 = 0;
		TelaCartas.score2 = 0;
		TelaCartas.escolhida = "";
		TelaCartas.feitas.clear();		
		TelaCartas.perguntas.clear();		
		TelaCartas.pulos = 2;
		TelaCartas.vidas = 3;
		TelaCartas.vez_jogador = "1";
		TelaPergunta.rb_escolhido = "";
		TelaPergunta.erros = 0;
	}
			
}
