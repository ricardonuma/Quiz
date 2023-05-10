package Controle;

import java.applet.Applet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;

import Modelo.Jogador;
import Modelo.JogadorDAO;
import Visualização.TelaMenu;
import Visualização.TelaRanking;

public class ControleRanking implements ActionListener {

	TelaRanking telaRanking;
	
	public ControleRanking(TelaRanking telaRanking) {
		// TODO Auto-generated constructor stub
		this.telaRanking = telaRanking;
	}
	
	public void bindLista(String id)
    {					
		ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
		JogadorDAO dao = new JogadorDAO();
		telaRanking.model.setColumnIdentifiers(telaRanking.colunas);
		jogadores = (ArrayList<Jogador>) dao.getJogadores();
		
		if(jogadores.size() > 0)
		{
			for (int i = 0; i < jogadores.size(); i++){
				String posicao = jogadores.get(i).getPosicao();
				String score = jogadores.get(i).getScore();
				String nome = jogadores.get(i).getNome();
				String id_jogador = jogadores.get(i).getId();
				
				Object[] dados = { id_jogador, posicao, score, nome };
				telaRanking.model.addRow(dados);
			}
		}
		
		telaRanking.tabela.setModel(telaRanking.model);
		telaRanking.sc_pane.setViewportView(telaRanking.tabela);
				
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );		
		for(int x = 0; x < telaRanking.tabela.getColumnCount(); x++)
			telaRanking.tabela.getColumnModel().getColumn(x).setCellRenderer( centerRenderer );
		
		telaRanking.tabela.getColumnModel().getColumn(0).setWidth(0);
		telaRanking.tabela.getColumnModel().getColumn(0).setMinWidth(0);
		telaRanking.tabela.getColumnModel().getColumn(0).setMaxWidth(0);
		telaRanking.tabela.getColumnModel().getColumn(1).setMaxWidth(180);
		telaRanking.tabela.getColumnModel().getColumn(1).setMinWidth(180);
		telaRanking.tabela.getColumnModel().getColumn(2).setMaxWidth(160);
		telaRanking.tabela.getColumnModel().getColumn(2).setMinWidth(160);
			
		if(jogadores.size() > 0)
		{
			if(id == "")
				telaRanking.tabela.setRowSelectionInterval(0, 0);
			else
			{
				for(int i = 0; i < telaRanking.model.getRowCount(); i++)
				{
					if(id.contains(telaRanking.model.getValueAt(i, 0).toString()))
						telaRanking.tabela.setRowSelectionInterval(i, i);
				}
			}		
		}
    }
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(telaRanking.btn_menu)) {
			TelaMenu.som = Applet.newAudioClip(telaRanking.som_click);
			TelaMenu.som.play();
			telaRanking.setVisible(false);
			TelaMenu menu = new TelaMenu();
		}
	}

}
