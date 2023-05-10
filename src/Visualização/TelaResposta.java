package Visualização;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import Controle.ControleResposta;


public class TelaResposta extends Tela {

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
	public JButton btn_cartas = new JButton();
		
	public TelaResposta(boolean acertou){
		super("EcoQuiz");
		
		ControleResposta controleResposta = new ControleResposta(this);
		controleResposta.mostraResposta(acertou);
		
		this.add(bg);
		
		bg.add(btn_menu);						
		btn_menu.setLocation(5, 5);	
		btn_menu.setSize(75, 75);
		btn_menu.setToolTipText("Menu");
		btn_menu.setBorderPainted(false);		
		btn_menu.setContentAreaFilled(false);
				
		btn_menu.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btn_menu.setCursor(new Cursor(Cursor.HAND_CURSOR));
		    	btn_menu.setIcon(new ImageIcon(getClass().getResource("/imagem/menu.fw - Copy.png")));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btn_menu.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		    	btn_menu.setIcon(new ImageIcon(getClass().getResource("/imagem/menu.fw.png")));
		    }
		});
		
		bg.add(lbl_jogador);
		bg.add(lbl_nome1);
		bg.add(btn_cartas);
						
		lbl_jogador.setLocation(670, 5);
		btn_cartas.setLocation(330, 160);
		
		lbl_jogador.setFont(new Font("Arial", Font.ITALIC, 20)); 
		lbl_jogador.setSize(150, 25);
		btn_cartas.setSize(210, 215);		
				
		btn_cartas.setToolTipText("Ver Cartas");		
		
		btn_cartas.setOpaque(false);
		btn_cartas.setContentAreaFilled(false);
		btn_cartas.setBorderPainted(false);
				
		btn_cartas.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btn_cartas.setCursor(new Cursor(Cursor.HAND_CURSOR));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btn_cartas.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		    }
		});
				
		btn_cartas.addActionListener(controleResposta);		
		btn_menu.addActionListener(controleResposta);
						
		controleResposta.bindNome();		
		controleResposta.verificaModoJogo();	
	}	
			
}
