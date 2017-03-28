package br.pro.hashi.ensino.desagil.lucianogic.model;


import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;


public class Main {
	public static void main(String[] args) {
		
		// Estrutura basica de um programa Swing. Nao precisa entender os detalhes por enquanto.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {

            	
            	JFrame frame = new JFrame("Portas Lógicas");
            	MainView mainView = new MainView();
            	//MainView mainView = MainView.conteudo;
            	frame.setContentPane(mainView);
            	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            	frame.setResizable(false);
            	frame.pack();
            	frame.setVisible(true);
            }
            
        });
    }
}
