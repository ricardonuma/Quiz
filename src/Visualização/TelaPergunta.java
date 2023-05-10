package Visualização;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import Controle.ControlePergunta;


public class TelaPergunta extends Tela {

	public static String rb_escolhido = "";
	public static int erros = 0;
	
	public JLabel	img_pulo1 = new JLabel(new ImageIcon(getClass().getResource("/imagem/vivo.fw.png")));
	public JLabel	img_pulo2 = new JLabel(new ImageIcon(getClass().getResource("/imagem/vivo.fw.png")));	
	public JLabel	img_vida1 = new JLabel(new ImageIcon(getClass().getResource("/imagem/vivo.fw.png")));
	public JLabel	img_vida2 = new JLabel(new ImageIcon(getClass().getResource("/imagem/vivo.fw.png")));
	public JLabel	img_vida3 = new JLabel(new ImageIcon(getClass().getResource("/imagem/vivo.fw.png")));
	
	public JLabel	lbl_jogador = new JLabel("Jogadores: ");
	public JLabel	lbl_nome1 = new JLabel();
	public JLabel	lbl_nome2 = new JLabel();	
	public JLabel	lbl_vez1 = new JLabel("Vez: ");
	public JLabel	lbl_vez2 = new JLabel();
	
	public int timeRemaining = 30;
	public JLabel	lbl_tempo1 = new JLabel("Tempo: ");
	public JLabel lbl_tempo2 = new JLabel(String.valueOf(timeRemaining));
		
	public JTextArea lbl_pergunta = new JTextArea();	
	public JRadioButton rb_1 = new JRadioButton();
	public JRadioButton rb_2 = new JRadioButton();
	public JRadioButton rb_3 = new JRadioButton();
	public JRadioButton rb_4 = new JRadioButton();
	ButtonGroup btng = new ButtonGroup();
	
	public JButton btn_responder = new JButton(new ImageIcon(getClass().getResource("/imagem/responder.fw.png")));
	public JButton btn_pular = new JButton(new ImageIcon(getClass().getResource("/imagem/pular.fw.png")));
		
	public TelaPergunta(){
		super("EcoQuiz");
		
		bg.add(lbl_jogador);
		bg.add(lbl_nome1);	
		bg.add(lbl_tempo1);
		bg.add(lbl_pergunta);
		bg.add(rb_1);
		bg.add(rb_2);
		bg.add(rb_3);
		bg.add(rb_4);
		bg.add(btn_responder);
				
		lbl_jogador.setLocation(670, 5);
		lbl_tempo1.setLocation(400, 90);	
				
		lbl_jogador.setFont(new Font("Arial", Font.ITALIC, 20)); 
		lbl_jogador.setSize(150, 25);
		lbl_tempo1.setFont(new Font("Arial", Font.ITALIC, 20)); 
		lbl_tempo1.setSize(100, 20);
		lbl_pergunta.setSize(675, 50);
		lbl_pergunta.setFont(new Font("Arial Black", Font.LAYOUT_LEFT_TO_RIGHT, 14)); 		
				
		rb_1.setSize(1000, 25);
		rb_2.setSize(1000, 25);
		rb_3.setSize(1000, 25);
		rb_4.setSize(1000, 25);
		btn_responder.setSize(100, 50);
				
		lbl_pergunta.setWrapStyleWord(true);
		lbl_pergunta.setLineWrap(true);
		lbl_pergunta.setEditable(false);
		
		btn_responder.setToolTipText("Responder");
	    
		btn_responder.setBorderPainted(false);		
		btn_responder.setContentAreaFilled(false);
		rb_1.setBackground(Color.WHITE);
		rb_2.setBackground(Color.WHITE);
		rb_3.setBackground(Color.WHITE);
		rb_4.setBackground(Color.WHITE);
		
		btng.add(rb_1);
		btng.add(rb_2);
		btng.add(rb_3);
		btng.add(rb_4);
						
		btn_responder.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btn_responder.setCursor(new Cursor(Cursor.HAND_CURSOR));
		    	btn_responder.setIcon(new ImageIcon(getClass().getResource("/imagem/responder.fw - Copy.png")));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btn_responder.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		    	btn_responder.setIcon(new ImageIcon(getClass().getResource("/imagem/responder.fw.png")));
		    }
		});		
								
		ControlePergunta controlePergunta = new ControlePergunta(this);
		btn_menu.addActionListener(controlePergunta);
		btn_responder.addActionListener(controlePergunta);		
						
		controlePergunta.bindNome();
		controlePergunta.bindPergunta();
		controlePergunta.bindRespostas();	
		controlePergunta.verificaModoJogo();
		controlePergunta.controlaTimer();				
	}		
	
}
