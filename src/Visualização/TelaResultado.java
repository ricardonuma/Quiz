package Visualização;
import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import Controle.ControleResultado;


public class TelaResultado extends Tela {
	
	public JButton btn_menu = new JButton(new ImageIcon(getClass().getResource("/imagem/menu.fw.png")));
	public JLabel	lbl_resultado = new JLabel();
	public JLabel	lbl_resultado2 = new JLabel();
	public JButton btn_cartas = new JButton();
	
	
	public TelaResultado(String resultado, String nome, String score){
		super("EcoQuiz");
				
		ControleResultado controleResultado = new ControleResultado(this);
		controleResultado.getTela(resultado, nome, score);
		
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
				
		btn_menu.addActionListener(controleResultado);
	}
						
}
