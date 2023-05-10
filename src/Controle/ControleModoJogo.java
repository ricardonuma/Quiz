package Controle;

import java.applet.Applet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Visualização.TelaCartas;
import Visualização.TelaMenu;
import Visualização.TelaModoJogo;

public class ControleModoJogo implements ActionListener {

	TelaModoJogo telaModoJogo;
	
	public ControleModoJogo(TelaModoJogo telaModoJogo) {
		// TODO Auto-generated constructor stub
		this.telaModoJogo = telaModoJogo;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(telaModoJogo.btn_menu)) {
			TelaMenu.som = Applet.newAudioClip(telaModoJogo.som_click);
			TelaMenu.som.play();
			telaModoJogo.setVisible(false);
			TelaMenu menu = new TelaMenu();
		}
		else if (e.getSource().equals(telaModoJogo.btn_jogar1)) {
			TelaMenu.som = Applet.newAudioClip(telaModoJogo.som_click);
			TelaMenu.som.play();
			TelaMenu.modo_jogo = "1";
			telaModoJogo.setVisible(false);
			TelaCartas cartas = new TelaCartas();
		}	
		else if (e.getSource().equals(telaModoJogo.btn_jogar2)) {
			TelaMenu.som = Applet.newAudioClip(telaModoJogo.som_click);
			TelaMenu.som.play();
			TelaMenu.modo_jogo = "2";
			telaModoJogo.setVisible(false);
			TelaCartas cartas = new TelaCartas();
		}
	}

}
