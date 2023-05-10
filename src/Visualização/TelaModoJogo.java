package Visualização;
import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Controle.ControleModoJogo;


public class TelaModoJogo extends Tela {

	public JButton btn_jogar1 = new JButton(new ImageIcon(getClass().getResource("/imagem/jog1.fw.png")));
	public JButton btn_jogar2 = new JButton(new ImageIcon(getClass().getResource("/imagem/jog2.fw.png")));
	
	public TelaModoJogo(){
		super("EcoQuiz");
		bg.add(btn_jogar1);
		bg.add(btn_jogar2);
						
		btn_jogar1.setLocation(187, 200);
		btn_jogar2.setLocation(487, 200);
		
		btn_jogar1.setSize(200, 200);		
		btn_jogar2.setSize(200, 200);		
				
		btn_jogar1.setToolTipText("1 Jogador");
		btn_jogar2.setToolTipText("2 Jogadores");
				
		btn_menu.setContentAreaFilled(false);
		btn_jogar1.setBorderPainted(false);		
		btn_jogar1.setContentAreaFilled(false);
		btn_jogar2.setBorderPainted(false);		
		btn_jogar2.setContentAreaFilled(false);
				
		btn_jogar1.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btn_jogar1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		    	btn_jogar1.setIcon(new ImageIcon(getClass().getResource("/imagem/jog1.fw - Copy.png")));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btn_jogar1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		    	btn_jogar1.setIcon(new ImageIcon(getClass().getResource("/imagem/jog1.fw.png")));
		    }
		});
		
		btn_jogar2.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btn_jogar2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		    	btn_jogar2.setIcon(new ImageIcon(getClass().getResource("/imagem/jog2.fw - Copy.png")));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btn_jogar2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		    	btn_jogar2.setIcon(new ImageIcon(getClass().getResource("/imagem/jog2.fw.png")));
		    }
		});
			
		ControleModoJogo controleModoJogo = new ControleModoJogo(this);
		btn_menu.addActionListener(controleModoJogo);
		btn_jogar1.addActionListener(controleModoJogo);	
		btn_jogar2.addActionListener(controleModoJogo);	
	}
		
}
