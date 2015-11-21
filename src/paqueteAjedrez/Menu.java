package paqueteAjedrez;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {
	public Menu() {
		getContentPane().setLayout(null);
		setBounds(100, 100, 250, 330);
				
		setResizable(true);
		
		
		JButton btnNuevaPartida = new JButton("Nueva Partida");
		btnNuevaPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				setVisible(false);
				Grafico3 eligeJugador= new Grafico3();
				eligeJugador.setVisible(true);
        		
			}
		});
		btnNuevaPartida.setBounds(49, 124, 139, 23);
		getContentPane().add(btnNuevaPartida);
		
		
		JButton btnContinuarPartida = new JButton("Continuar Partida");
		btnContinuarPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				setVisible(false);
				Grafico2 partida= new Grafico2();
				partida.setVisible(true);
			}
		});
		btnContinuarPartida.setBounds(49, 191, 139, 23);
		getContentPane().add(btnContinuarPartida);
		
		JLabel lblAjedrez = new JLabel("AJEDREZ");
		lblAjedrez.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 18));
		lblAjedrez.setBounds(59, 39, 105, 31);
		getContentPane().add(lblAjedrez);
	}
	
	
}
