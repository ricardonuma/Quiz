package Visualização;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import Controle.ControleCartas;


public class TelaCartas extends Tela {

	public static String id_jogador1 = "";
	public static String id_jogador2 = "";
	public static String nome_jogador1 = "";
	public static String nome_jogador2 = "";
	public static int vidas = 3;
	public static int pulos = 2;
	public static int score1 = 0;
	public static int score2 = 0;
	public static String escolhida = "";
	public static ArrayList<String> feitas = new ArrayList<String>();
	public static ArrayList<String> perguntas = new ArrayList<String>();	
	public static int total_pulos = 2;
	public static JLabel	lbl_pulo = new JLabel("Pulos: ");	
	public static int total_vidas = 3;
	public static JLabel	lbl_vida = new JLabel("Vidas: ");	
	public static int total_perguntas = 10;
	public static String vez_jogador = "1";	
	
	public JLabel	img_pulo1 = new JLabel(new ImageIcon(getClass().getResource("/imagem/vivo.fw.png")));
	public JLabel	img_pulo2 = new JLabel(new ImageIcon(getClass().getResource("/imagem/vivo.fw.png")));	
	public JLabel	img_vida1 = new JLabel(new ImageIcon(getClass().getResource("/imagem/vivo.fw.png")));
	public JLabel	img_vida2 = new JLabel(new ImageIcon(getClass().getResource("/imagem/vivo.fw.png")));
	public JLabel	img_vida3 = new JLabel(new ImageIcon(getClass().getResource("/imagem/vivo.fw.png")));
	
	public JLabel	lbl_jogador = new JLabel();
	public JLabel	lbl_nome1 = new JLabel();
	public JLabel	lbl_nome2 = new JLabel();
	public JLabel	lbl_vez1 = new JLabel("Vez: ");
	public JLabel	lbl_vez2 = new JLabel();
			
	public JButton btn_carta1 = new JButton(new ImageIcon(getClass().getResource("/imagem/cat1.fw.png")));
	public JButton btn_carta2 = new JButton(new ImageIcon(getClass().getResource("/imagem/cat2.fw.png")));
	public JButton btn_carta3 = new JButton(new ImageIcon(getClass().getResource("/imagem/cat3.fw.png")));
	public JButton btn_carta4 = new JButton(new ImageIcon(getClass().getResource("/imagem/cat4.fw.png")));
	public JButton btn_carta5 = new JButton(new ImageIcon(getClass().getResource("/imagem/cat5.fw.png")));
	public JButton btn_carta6 = new JButton(new ImageIcon(getClass().getResource("/imagem/cat6.fw.png")));
	public JButton btn_carta7 = new JButton(new ImageIcon(getClass().getResource("/imagem/cat7.fw.png")));
	public JButton btn_carta8 = new JButton(new ImageIcon(getClass().getResource("/imagem/cat8.fw.png")));
	public JButton btn_carta9 = new JButton(new ImageIcon(getClass().getResource("/imagem/cat9.fw.png")));
	public JButton btn_carta10 = new JButton(new ImageIcon(getClass().getResource("/imagem/cat10.fw.png")));	
		
	public TelaCartas(){
		super("EcoQuiz");
		
		bg.setIcon(new ImageIcon(getClass().getResource("/imagem/jogo.fw.png")));
		
		bg.add(lbl_jogador);
		bg.add(lbl_nome1);	
		bg.add(btn_carta1);
		bg.add(btn_carta2);
		bg.add(btn_carta3);
		bg.add(btn_carta4);
		bg.add(btn_carta5);
		bg.add(btn_carta6);
		bg.add(btn_carta7);
		bg.add(btn_carta8);
		bg.add(btn_carta9);
		bg.add(btn_carta10);
		
		lbl_jogador.setLocation(670, 5);		
		btn_carta1.setLocation(40, 120);
		btn_carta2.setLocation(201, 120);
		btn_carta3.setLocation(362, 120);
		btn_carta4.setLocation(523, 120);
		btn_carta5.setLocation(684, 120);
		btn_carta6.setLocation(40, 320);
		btn_carta7.setLocation(201, 320);
		btn_carta8.setLocation(362, 320);
		btn_carta9.setLocation(523, 320);
		btn_carta10.setLocation(684, 320);
		
		lbl_jogador.setFont(new Font("Arial", Font.ITALIC, 20)); 
		lbl_jogador.setSize(150, 25);
		btn_carta1.setSize(146, 189);
		btn_carta2.setSize(146, 189);
		btn_carta3.setSize(146, 189);
		btn_carta4.setSize(146, 189);
		btn_carta5.setSize(146, 189);
		btn_carta6.setSize(146, 189);
		btn_carta7.setSize(146, 189);
		btn_carta8.setSize(146, 189);
		btn_carta9.setSize(146, 189);
		btn_carta10.setSize(146, 189);
				
		btn_carta1.setToolTipText("Carta 1");
		btn_carta2.setToolTipText("Carta 2");
		btn_carta3.setToolTipText("Carta 3");
		btn_carta4.setToolTipText("Carta 4");
		btn_carta5.setToolTipText("Carta 5");
		btn_carta6.setToolTipText("Carta 6");
		btn_carta7.setToolTipText("Carta 7");
		btn_carta8.setToolTipText("Carta 8");
		btn_carta9.setToolTipText("Carta 9");
		btn_carta10.setToolTipText("Carta 10");
		
		Border border = new LineBorder(Color.BLACK, 3);
		btn_carta1.setBorder(border);
		btn_carta2.setBorder(border);
		btn_carta3.setBorder(border);
		btn_carta4.setBorder(border);
		btn_carta5.setBorder(border);
		btn_carta6.setBorder(border);
		btn_carta7.setBorder(border);
		btn_carta8.setBorder(border);
		btn_carta9.setBorder(border);
		btn_carta10.setBorder(border);
				
		btn_carta1.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btn_carta1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		    	btn_carta1.setIcon(new ImageIcon(getClass().getResource("/imagem/cat1.fw - Copy.png")));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btn_carta1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		    	btn_carta1.setIcon(new ImageIcon(getClass().getResource("/imagem/cat1.fw.png")));
		    }
		});
		
		btn_carta2.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btn_carta2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		    	btn_carta2.setIcon(new ImageIcon(getClass().getResource("/imagem/cat2.fw - Copy.png")));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btn_carta2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		    	btn_carta2.setIcon(new ImageIcon(getClass().getResource("/imagem/cat2.fw.png")));
		    }
		});
				
		btn_carta3.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btn_carta3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		    	btn_carta3.setIcon(new ImageIcon(getClass().getResource("/imagem/cat3.fw - Copy.png")));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btn_carta3.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		    	btn_carta3.setIcon(new ImageIcon(getClass().getResource("/imagem/cat3.fw.png")));
		    }
		});
		
		btn_carta4.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btn_carta4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		    	btn_carta4.setIcon(new ImageIcon(getClass().getResource("/imagem/cat4.fw - Copy.png")));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btn_carta4.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		    	btn_carta4.setIcon(new ImageIcon(getClass().getResource("/imagem/cat4.fw.png")));
		    }
		});
		
		btn_carta5.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btn_carta5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		    	btn_carta5.setIcon(new ImageIcon(getClass().getResource("/imagem/cat5.fw - Copy.png")));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btn_carta5.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		    	btn_carta5.setIcon(new ImageIcon(getClass().getResource("/imagem/cat5.fw.png")));
		    }
		});
		
		btn_carta6.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btn_carta6.setCursor(new Cursor(Cursor.HAND_CURSOR));
		    	btn_carta6.setIcon(new ImageIcon(getClass().getResource("/imagem/cat6.fw - Copy.png")));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btn_carta6.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		    	btn_carta6.setIcon(new ImageIcon(getClass().getResource("/imagem/cat6.fw.png")));
		    }
		});
		
		btn_carta7.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btn_carta7.setCursor(new Cursor(Cursor.HAND_CURSOR));
		    	btn_carta7.setIcon(new ImageIcon(getClass().getResource("/imagem/cat7.fw - Copy.png")));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btn_carta7.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		    	btn_carta7.setIcon(new ImageIcon(getClass().getResource("/imagem/cat7.fw.png")));
		    }
		});
		
		btn_carta8.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btn_carta8.setCursor(new Cursor(Cursor.HAND_CURSOR));
		    	btn_carta8.setIcon(new ImageIcon(getClass().getResource("/imagem/cat8.fw - Copy.png")));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btn_carta8.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		    	btn_carta8.setIcon(new ImageIcon(getClass().getResource("/imagem/cat8.fw.png")));
		    }
		});
		
		btn_carta9.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btn_carta9.setCursor(new Cursor(Cursor.HAND_CURSOR));
		    	btn_carta9.setIcon(new ImageIcon(getClass().getResource("/imagem/cat9.fw - Copy.png")));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btn_carta9.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		    	btn_carta9.setIcon(new ImageIcon(getClass().getResource("/imagem/cat9.fw.png")));
		    }
		});
		
		btn_carta10.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btn_carta10.setCursor(new Cursor(Cursor.HAND_CURSOR));
		    	btn_carta10.setIcon(new ImageIcon(getClass().getResource("/imagem/cat10.fw - Copy.png")));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btn_carta10.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		    	btn_carta10.setIcon(new ImageIcon(getClass().getResource("/imagem/cat10.fw.png")));
		    }
		});
		
		ControleCartas controleCartas = new ControleCartas(this);
		controleCartas.sorteiaCartas();
								
		btn_menu.addActionListener(controleCartas);
		btn_carta1.addActionListener(controleCartas);
		btn_carta2.addActionListener(controleCartas);
		btn_carta3.addActionListener(controleCartas);
		btn_carta4.addActionListener(controleCartas);
		btn_carta5.addActionListener(controleCartas);
		btn_carta6.addActionListener(controleCartas);
		btn_carta7.addActionListener(controleCartas);
		btn_carta8.addActionListener(controleCartas);
		btn_carta9.addActionListener(controleCartas);
		btn_carta10.addActionListener(controleCartas);
												
		controleCartas.bindNome();		
		controleCartas.verificaModoJogo();
		controleCartas.controlaCartas();
	}			
	    
}
