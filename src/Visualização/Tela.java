package Visualização;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Tela extends JFrame {
	
	public URL som_click = getClass().getResource("/som/CLICK18C.WAV");
	public URL som_acertou = getClass().getResource("/som/acertou.wav");
	public URL som_errou = getClass().getResource("/som/errou.wav");
	public URL som_venceu = getClass().getResource("/som/venceu.wav");
	public URL som_perdeu = getClass().getResource("/som/perdeu.wav");
	public URL som_empate = getClass().getResource("/som/empate.wav");
	public ImageIcon icone = new ImageIcon(getClass().getResource("/imagem/Coda.png"));
	public JButton btn_menu = new JButton(new ImageIcon(getClass().getResource("/imagem/menu.fw.png")));
	public JLabel	bg = new JLabel(new ImageIcon(getClass().getResource("/imagem/inicial.fw.png")));
	
	public Tela(String titulo) {
		// TODO Auto-generated constructor stub
		super(titulo);
		this.setVisible(true);
		this.setSize(875,700);	
		this.add(bg);
		this.setIconImage(icone.getImage());
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
				
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
						
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setResizable(false);
	}
}
