package paqueteAjedrez;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

import javax.swing.JLabel;
import javax.swing.JButton;

import ConexionDB.MyDataAcces;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import paquetePiezas.*;
public class Grafico2 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private String[] jugadores=new String[2];
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Grafico2 frame = new Grafico2();
					frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Grafico2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 235, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblElijaQuePartida = new JLabel("Elija que partida desea continuar:");
		lblElijaQuePartida.setBounds(10, 11, 173, 14);
		contentPane.add(lblElijaQuePartida);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setVisible(false);
				
				Grafico1 g1= new Grafico1(getTablaContinuar(),jugadores);
        		g1.setVisible(true);
							
			}
		});
		btnOk.setBounds(48, 245, 72, 23);
		contentPane.add(btnOk);
		
		table = new JTable(getPartida(),new String[] {"ID","Jugador1","jugador2"});
		table.setBounds(51, 57, 132, 131);
		contentPane.add(table);
	
	}
	
	public String[][] getPartida()
	{
		String[][] partidas=new String[1][3];
		MyDataAcces conexion = new MyDataAcces();
        ResultSet resultado1;
        
        resultado1 = conexion.getQuery("select * from partidas");
       
        try {
          while(resultado1.next()){
        	  partidas[0][0]=resultado1.getString("ID_Partida");
        	  partidas[0][1]=resultado1.getString("Jugador1");
        	  partidas[0][2]=resultado1.getString("Jugador2");
        	  
        	  jugadores[0]=resultado1.getString("Jugador1");
        	  jugadores[1]=resultado1.getString("Jugador2");
            	  
        	  	}
        	  
          	
        }catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
         
        
         return partidas;   
         
         
	}
	
	/*public String[] getJugadores()
    {
		String dni1,dni2;
		String [] jugadores=new String[2];
		MyDataAcces conexion = new MyDataAcces();
        ResultSet resultado1;
        
		dni1=String.valueOf(table.getValueAt(table.getSelectedRow(),1));
		dni2=String.valueOf(table.getValueAt(table.getSelectedRow(),2));
		    
        resultado1 = conexion.getQuery("select * from jugadores");
       
        try {
          while(resultado1.next()){
        	  if(dni1.equalsIgnoreCase(resultado1.getString("DNI")))
        	  {
        		  jugadores[0]=resultado1.getString("nombre")+resultado1.getString("apellido");
 
        	  }
        	  else
        	  {	
        		  if(dni2.equalsIgnoreCase(resultado1.getString("DNI")))
        		  {
        			  jugadores[1]=resultado1.getString("nombre")+resultado1.getString("apellido");
        		  }
        	  }
          }
        }catch (SQLException e) {
        		e.printStackTrace();
        	}
		return jugadores;
    	}
	*/
		public Ficha[][] getTablaContinuar()
		{
			String id;
			
			MyDataAcces conexion = new MyDataAcces();
	        ResultSet resultado1;
	        Ficha[][] tablaContinuar=new Ficha[9][9];
	        
	        //dni1=String.valueOf(table.getValueAt(table.getSelectedRow(),1));
			//dni2=String.valueOf(table.getValueAt(table.getSelectedRow(),2));
			id=String.valueOf(table.getValueAt(table.getSelectedRow(),0));
			resultado1 = conexion.getQuery("select * from posiciones");
			
			 try {
		          while(resultado1.next()){
		        	  if((id.equalsIgnoreCase(resultado1.getString("ID_Partida")))&&(jugadores[0].equalsIgnoreCase(resultado1.getString("jugador"))))
		        	  {
		        		  	  if (resultado1.getString("torre1")!=null){
			        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("torre1").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("torre1").charAt(1)))]=new Torre("B");}
			        		  if (resultado1.getString("torre2")!=null){
			        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("torre2").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("torre2").charAt(1)))]=new Torre("B");}
			        		  if (resultado1.getString("caballo1")!=null){
			        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("caballo1").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("caballo1").charAt(1)))]=new Caballo("B");}
			        		  if (resultado1.getString("caballo2")!=null){
			        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("caballo2").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("caballo2").charAt(1)))]=new Caballo("B");}
			        		  if (resultado1.getString("alfil1")!=null){
			        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("alfil1").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("alfil1").charAt(1)))]=new Alfil("B");}
			        		  if (resultado1.getString("alfil2")!=null){
			        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("alfil2").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("alfil2").charAt(1)))]=new Alfil("B");}
			        		  if (resultado1.getString("rey")!=null){
			        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("rey").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("rey").charAt(1)))]=new Rey("B");}
			        		  if (resultado1.getString("reina")!=null){
			        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("reina").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("reina").charAt(1)))]=new Reina("B");}
			        		  if (resultado1.getString("peon1")!=null){
			        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("peon1").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("peon1").charAt(1)))]=new Peon("B");}
			        		  if (resultado1.getString("peon2")!=null){
			        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("peon2").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("peon2").charAt(1)))]=new Peon("B");}
			        		  if (resultado1.getString("peon3")!=null){
			        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("peon3").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("peon3").charAt(1)))]=new Peon("B");}
			        		  if (resultado1.getString("peon4")!=null){
			        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("peon4").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("peon4").charAt(1)))]=new Peon("B");}
			        		  if (resultado1.getString("peon5")!=null){
			        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("peon5").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("peon5").charAt(1)))]=new Peon("B");}
			        		  if (resultado1.getString("peon6")!=null){
			        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("peon6").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("peon6").charAt(1)))]=new Peon("B");}
			        		  if (resultado1.getString("peon7")!=null){
			        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("peon7").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("peon7").charAt(1)))]=new Peon("B");}
			        		  if (resultado1.getString("peon8")!=null){
			        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("peon8").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("peon8").charAt(1)))]=new Peon("B");}
			        		  
		        		  
		        	  }
		        	  else
		        	  {
		        		  if((id.equalsIgnoreCase(resultado1.getString("ID_Partida")))&&(jugadores[1].equalsIgnoreCase(resultado1.getString("jugador"))))
		        		  {
		        			  
		        			  if (resultado1.getString("torre1")!=null){
				        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("torre1").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("torre1").charAt(1)))]=new Torre("N");}
				        		  if (resultado1.getString("torre2")!=null){
				        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("torre2").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("torre2").charAt(1)))]=new Torre("N");}
				        		  if (resultado1.getString("caballo1")!=null){
				        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("caballo1").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("caballo1").charAt(1)))]=new Caballo("N");}
				        		  if (resultado1.getString("caballo2")!=null){
				        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("caballo2").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("caballo2").charAt(1)))]=new Caballo("N");}
				        		  if (resultado1.getString("alfil1")!=null){
				        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("alfil1").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("alfil1").charAt(1)))]=new Alfil("N");}
				        		  if (resultado1.getString("alfil2")!=null){
				        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("alfil2").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("alfil2").charAt(1)))]=new Alfil("N");}
				        		  if (resultado1.getString("rey")!=null){
				        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("rey").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("rey").charAt(1)))]=new Rey("N");}
				        		  if (resultado1.getString("reina")!=null){
				        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("reina").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("reina").charAt(1)))]=new Reina("N");}
				        		  if (resultado1.getString("peon1")!=null){
				        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("peon1").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("peon1").charAt(1)))]=new Peon("N");}
				        		  if (resultado1.getString("peon2")!=null){
				        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("peon2").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("peon2").charAt(1)))]=new Peon("N");}
				        		  if (resultado1.getString("peon3")!=null){
				        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("peon3").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("peon3").charAt(1)))]=new Peon("N");}
				        		  if (resultado1.getString("peon4")!=null){
				        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("peon4").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("peon4").charAt(1)))]=new Peon("N");}
				        		  if (resultado1.getString("peon5")!=null){
				        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("peon5").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("peon5").charAt(1)))]=new Peon("N");}
				        		  if (resultado1.getString("peon6")!=null){
				        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("peon6").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("peon6").charAt(1)))]=new Peon("N");}
				        		  if (resultado1.getString("peon7")!=null){
				        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("peon7").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("peon7").charAt(1)))]=new Peon("N");}
				        		  if (resultado1.getString("peon8")!=null){
				        		  tablaContinuar[Integer.parseInt(String.valueOf(resultado1.getString("peon8").charAt(0)))][Integer.parseInt(String.valueOf(resultado1.getString("peon8").charAt(1)))]=new Peon("N");}
				        			  
			        	  }
		        			  
		        	  }
		        	  
		        	  
		            	  
		        	  	}
		        	
		        	}catch (SQLException e) {
		          // TODO Auto-generated catch block
		        		e.printStackTrace();
		        	}
			 for(int i=1;i<9;i++)
		    	{
		    		for(int j=1;j<9;j++)
		    		{if(tablaContinuar[i][j]!=null){
		    			System.out.println(tablaContinuar[i][j].getApodo());}
		    		}
		    	}
			 return tablaContinuar;
		}
	
	}
