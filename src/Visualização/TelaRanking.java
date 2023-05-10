package Visualização;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Controle.ControleRanking;


public class TelaRanking extends Tela {
			
	public String[] colunas = new String[]{ "ID", "Ranking", "Pontos","Jogador" };	
	public JTable tabela = new JTable(7,4);
	public DefaultTableModel model = new DefaultTableModel();		
	public JScrollPane sc_pane = new JScrollPane();
	
	public TelaRanking(String id){
		super("EcoQuiz");
		
		bg.add(sc_pane);
		sc_pane.setLocation(125, 90);
		sc_pane.setSize(625, 407);
		Border border = new LineBorder(Color.BLACK, 3);
		sc_pane.setBorder(border);
		tabela.setFont(new Font("Arial", Font.BOLD, 30)); 		
		tabela.setRowHeight(50);
		tabela.getTableHeader().setFont( new Font( "Arial" , Font.BOLD, 40 ));
		tabela.setEnabled(false);
						
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
		
		ControleRanking controleRanking = new ControleRanking(this);
		btn_menu.addActionListener(controleRanking);
		
		controleRanking.bindLista(id);		
	}
				
}
