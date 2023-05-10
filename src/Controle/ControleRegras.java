package Controle;

import java.applet.Applet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Visualização.TelaMenu;
import Visualização.TelaRegras;

public class ControleRegras implements ActionListener {

	TelaRegras telaRegras;
	
	public ControleRegras(TelaRegras telaRegras) {
		// TODO Auto-generated constructor stub
		this.telaRegras = telaRegras;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(telaRegras.btn_menu)) {
			TelaMenu.som = Applet.newAudioClip(telaRegras.som_click);
			TelaMenu.som.play();
			telaRegras.setVisible(false);
			TelaMenu menu = new TelaMenu();
		}
		else if (e.getSource().equals(telaRegras.btn_jogar1)) {
			TelaMenu.som = Applet.newAudioClip(telaRegras.som_click);
			TelaMenu.som.play();
			telaRegras.lbl_modoJogo.setText("1 Jogador:");
			telaRegras.lbl_regra1.setVisible(true);
			telaRegras.lbl_regra2.setVisible(false);
		}	
		else if (e.getSource().equals(telaRegras.btn_jogar2)) {
			TelaMenu.som = Applet.newAudioClip(telaRegras.som_click);
			TelaMenu.som.play();
			telaRegras.lbl_modoJogo.setText("2 Jogadores:");
			telaRegras.lbl_regra1.setVisible(false);
			telaRegras.lbl_regra2.setVisible(true);
		}
	}

}
