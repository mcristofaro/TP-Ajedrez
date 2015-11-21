package paqueteAjedrez;
import paqueteMetodos.Jugador;
import paquetePiezas.Alfil;
import paquetePiezas.Caballo;
import paquetePiezas.Ficha;
import paquetePiezas.Peon;
import paquetePiezas.Reina;
import paquetePiezas.Rey;
import paquetePiezas.Torre;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import ConexionDB.MyDataAcces;

import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Grafico3 extends JFrame {
	private JTextField textJugador1;
	private JTextField textJugador2;
	private static JTextField textBlanco;
	private static JTextField textNegro;
	private String nom, ape;
	private String[] jugadores;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Grafico3 frame = new Grafico3();
					frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	public Grafico3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 380);
				
		setResizable(true);
		getContentPane().setLayout(null);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(114, 270, 89, 23);
		getContentPane().add(btnAceptar);
		
		btnAceptar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		System.out.println(textJugador1.getText());
        		System.out.println(textJugador2.getText());
        		if ((textJugador1.getText().equalsIgnoreCase(""))||(textJugador2.getText().equalsIgnoreCase("")))
        		{
        			JOptionPane.showMessageDialog(null, "¡¡Falta ingresar jugador!!");
        		}
        		else
        		{
        			jugadores=new String[2];
            		jugadores[0]=textBlanco.getText();
            		jugadores[1]=textNegro.getText();
            		setVisible(false);
            		for(int i=1;i<9;i++)
                	{
                		for(int j=1;j<9;j++)
                		{
                			if(getTableroInicial()[i][j]!=null){
                			System.out.println(getTableroInicial()[i][j].getApodo());}
                			else{System.out.println("vacio");}
                		}
                	}
            		Grafico1 g1= new Grafico1(getTableroInicial(),jugadores);
            		g1.setVisible(true);
            		
            	}
        		}
        		
        		
        });
		
		JLabel lblFichasBlancas = new JLabel("Fichas Blancas");
		lblFichasBlancas.setBounds(35, 153, 96, 14);
		getContentPane().add(lblFichasBlancas);
		
		JLabel lblFichasNegras = new JLabel("Fichas Negras");
		lblFichasNegras.setBounds(189, 153, 96, 14);
		getContentPane().add(lblFichasNegras);
		
		JLabel lblIngresarDocumentoPara = new JLabel("Ingresar Documento para registrarse");
		lblIngresarDocumentoPara.setBounds(35, 9, 250, 23);
		getContentPane().add(lblIngresarDocumentoPara);
		
		textJugador1 = new JTextField();
		textJugador1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if(getJugador(textJugador1.getText()).equalsIgnoreCase("null null"))
				{
					JOptionPane.showMessageDialog(null, "DNI Incorrecto");
					textJugador1.setText("");
				}
				else
				{
					textBlanco.setText(getJugador(textJugador1.getText()));
				}
				
			}
		});
		textJugador1.setBounds(75, 43, 86, 20);
		getContentPane().add(textJugador1);
		textJugador1.setColumns(10);
		
		textJugador2 = new JTextField();
		textJugador2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if(getJugador(textJugador2.getText()).equalsIgnoreCase("null null"))
				{
					JOptionPane.showMessageDialog(null, "DNI Incorrecto");
					textJugador2.setText("");
				}
				else
				{
					textNegro.setText(getJugador(textJugador2.getText()));
				}
				
			}
		});
		textJugador2.setBounds(75, 101, 86, 20);
		getContentPane().add(textJugador2);
		textJugador2.setColumns(10);
		
		textBlanco = new JTextField();
		textBlanco.setBounds(10, 200, 121, 20);
		getContentPane().add(textBlanco);
		textBlanco.setColumns(10);
		
		textNegro = new JTextField();
		textNegro.setBounds(172, 200, 132, 20);
		getContentPane().add(textNegro);
		textNegro.setColumns(10);
		
		
	}
	
	public String getJugador(String documento)
    {
    	String jugador;
		MyDataAcces conexion = new MyDataAcces();
        ResultSet resultado1;
        
        
        resultado1 = conexion.getQuery("select * from jugadores");
       
        try {
          while(resultado1.next()){
        	  
        	  if (documento.equalsIgnoreCase(resultado1.getString("DNI")))
        	  {
        		  nom=resultado1.getString("nombre");
            	  ape=resultado1.getString("apellido");
            	  
        	  }
        	  
          	}
        }catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        
        jugador=nom+" "+ape;
        
        return jugador;  
            
               
    }
	public Ficha[][] getTableroInicial()
	{
		Ficha[][] tableroInicial=new Ficha[9][9];
		tableroInicial[1][1]=new Torre();
		tableroInicial[1][2]=new Caballo();
		tableroInicial[1][3]=new Alfil();
		tableroInicial[1][4]=new Reina();
		tableroInicial[1][5]=new Rey();
		tableroInicial[1][6]=new Alfil();
		tableroInicial[1][7]=new Caballo();
		tableroInicial[1][8]=new Torre();
		tableroInicial[2][1]=new Peon();
		tableroInicial[2][2]=new Peon();
		tableroInicial[2][3]=new Peon();
		tableroInicial[2][4]=new Peon();
		tableroInicial[2][5]=new Peon();
		tableroInicial[2][6]=new Peon();
		tableroInicial[2][7]=new Peon();
		tableroInicial[2][8]=new Peon();
		
		tableroInicial[8][1]=new Torre();
		tableroInicial[8][2]=new Caballo();
		tableroInicial[8][3]=new Alfil();
		tableroInicial[8][4]=new Rey();
		tableroInicial[8][5]=new Reina();
		tableroInicial[8][6]=new Alfil();
		tableroInicial[8][7]=new Caballo();
		tableroInicial[8][8]=new Torre();
		tableroInicial[7][1]=new Peon();
		tableroInicial[7][2]=new Peon();
		tableroInicial[7][3]=new Peon();
		tableroInicial[7][4]=new Peon();
		tableroInicial[7][5]=new Peon();
		tableroInicial[7][6]=new Peon();
		tableroInicial[7][7]=new Peon();
		tableroInicial[7][8]=new Peon();
		
		for(int i=1;i<9;i++)
    	{
    		for(int j=1;j<9;j++)
    		{
    			if( (tableroInicial[i][j]!=null) && ( (i==1) | (i==2) ) ) {
    				tableroInicial[i][j].setColor("N");}
    			if( (tableroInicial[i][j]!=null) && ( (i==7) | (i==8) ) ) {
    				tableroInicial[i][j].setColor("B");}
    		}
    	}
		
		return tableroInicial;
	}
}
