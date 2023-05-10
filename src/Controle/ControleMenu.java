package Controle;

import java.applet.Applet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Visualização.TelaMenu;
import Visualização.TelaModoJogo;
import Visualização.TelaRanking;
import Visualização.TelaRegras;

public class ControleMenu implements ActionListener {
	
	TelaMenu telaMenu;
	
	public ControleMenu(TelaMenu telaMenu) {
		// TODO Auto-generated constructor stub
		this.telaMenu = telaMenu;
		//telaMenu.som = Applet.newAudioClip(TelaMenu.caminhoSom2);
		//telaMenu.som.loop();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(telaMenu.btn_jogar)){
			//telaMenu.som = Applet.newAudioClip(TelaMenu.caminhoSom);
			telaMenu.som = Applet.newAudioClip(telaMenu.som_click);
			telaMenu.som.play();
			telaMenu.setVisible(false);
			TelaModoJogo modoJogo = new TelaModoJogo();
		}		
		else if (e.getSource().equals(telaMenu.btn_ranking)){
			telaMenu.som = Applet.newAudioClip(telaMenu.som_click);
			telaMenu.som.play();
			telaMenu.setVisible(false);
			TelaRanking ranking = new TelaRanking("");
		}
		else if (e.getSource().equals(telaMenu.btn_regras)){
			telaMenu.som = Applet.newAudioClip(telaMenu.som_click);
			telaMenu.som.play();
			telaMenu.setVisible(false);
			TelaRegras regras = new TelaRegras();
		}		
		else if (e.getSource().equals(telaMenu.btn_sair)){
			telaMenu.som = Applet.newAudioClip(telaMenu.som_click);
			telaMenu.som.play();
			int ret = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Confirmação", JOptionPane.YES_NO_OPTION);
			telaMenu.som = Applet.newAudioClip(telaMenu.som_click);
			telaMenu.som.play();
			if(ret == JOptionPane.YES_NO_OPTION)
				System.exit(0);
		}
	}

}
