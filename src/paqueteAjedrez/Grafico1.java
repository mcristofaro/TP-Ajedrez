package paqueteAjedrez;
import paquetePiezas.Ficha;


import java.awt.Color;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.JButton;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;


import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.border.LineBorder;

import ConexionDB.MyDataAcces;


public class Grafico1 extends JFrame {

  
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTable tablero;
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JTextField textField_3;
	private static int a,b,c,d;
	private static Ficha[][] tab;
	private static JTextField textJugador;
	private static boolean jugador=true,finJuego=false;
	private static String[] jugadores;

	public Grafico1(Ficha[][] tableroInicial, String[] jugadore) {
        jugadores=jugadore;
    	tab=tableroInicial;
    	setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setForeground(Color.BLACK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        tablero = new JTable(actualizaTablero(tab),new String[] {
    		"A", "A", "B", "C", "D", "E", "F", "G", "H"
    	});
        tablero.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        tablero.setForeground(Color.BLACK);
        tablero.setSurrendersFocusOnKeystroke(true);
        tablero.setFillsViewportHeight(true);
        tablero.setColumnSelectionAllowed(true);
        tablero.setCellSelectionEnabled(true);
        tablero.setBackground(new Color(178, 34, 34));
        tablero.setToolTipText("");
        tablero.setVisible(true);
        tablero.setFont(new Font("Tahoma", Font.BOLD, 15));
        
        tablero.getColumnModel().getColumn(0).setPreferredWidth(45);
        //tablero.getColumnModel().getColumn(0).setMinWidth(20);
        tablero.getColumnModel().getColumn(1).setPreferredWidth(45);
        tablero.getColumnModel().getColumn(2).setPreferredWidth(45);
        tablero.getColumnModel().getColumn(3).setPreferredWidth(45);
        tablero.getColumnModel().getColumn(4).setPreferredWidth(45);
        tablero.getColumnModel().getColumn(5).setPreferredWidth(45);
        tablero.getColumnModel().getColumn(6).setPreferredWidth(45);
        tablero.getColumnModel().getColumn(7).setPreferredWidth(45);
        tablero.getColumnModel().getColumn(8).setPreferredWidth(45);
        tablero.setRowHeight(30);
        tablero.setBounds(68, 20, 370, 270);
        contentPane.add(tablero);
        
        JLabel lblFilaNro = new JLabel("Fila nro:");
        lblFilaNro.setBounds(10, 349, 83, 14);
        contentPane.add(lblFilaNro);
        
        JLabel lblLetraColumna = new JLabel("Letra Columna:");
        lblLetraColumna.setBounds(10, 374, 105, 14);
        contentPane.add(lblLetraColumna);
        
        JLabel lblMoverDesde = new JLabel("Mover desde:");
        lblMoverDesde.setBounds(10, 324, 83, 14);
        contentPane.add(lblMoverDesde);
        
        JLabel lblHasta = new JLabel("Hasta:");
        lblHasta.setBounds(10, 415, 46, 14);
        contentPane.add(lblHasta);
        
        JLabel lblNuevaFila = new JLabel("Nueva fila:");
        lblNuevaFila.setBounds(10, 440, 105, 14);
        contentPane.add(lblNuevaFila);
        
        JLabel lblNuevaColumna = new JLabel("Nueva Columna:");
        lblNuevaColumna.setBounds(10, 465, 118, 14);
        contentPane.add(lblNuevaColumna);
        
        textField = new JTextField();
        textField.setBounds(125, 346, 46, 20);
        contentPane.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(125, 371, 46, 20);
        contentPane.add(textField_1);
        
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(125, 437, 46, 20);
        contentPane.add(textField_2);
        
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(125, 462, 46, 20);
        contentPane.add(textField_3);
        setBounds(0,0,507,544);
        
        JButton btnMoverFicha = new JButton("Mover Ficha");
        btnMoverFicha.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		moverFicha();
        		if(finJuego)
        		{
        			String jugadorGanador;
            		if (jugador)
            		{jugadorGanador =jugadores[0];}
            		else
            		{jugadorGanador =jugadores[1];}
            		JOptionPane.showMessageDialog(null, "Enhorabuena, "+jugadorGanador+", has ganado el juego!!!");

        			setVisible(false);
        		}
        		
        	}
        });
        btnMoverFicha.setBackground(Color.ORANGE);
        btnMoverFicha.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnMoverFicha.setForeground(Color.BLACK);
        btnMoverFicha.setBounds(291, 461, 106, 23);
        contentPane.add(btnMoverFicha);
        
        textJugador = new JTextField();
        textJugador.setBounds(278, 387, 128, 20);
        contentPane.add(textJugador);
        textJugador.setColumns(10);
        textJugador.setText(jugadores[0]);
        
        JLabel lblJugador = new JLabel("JUGADOR: ");
        lblJugador.setFont(new Font("Arial", Font.PLAIN, 14));
        lblJugador.setBounds(305, 348, 75, 17);
        contentPane.add(lblJugador);
        
        this.addWindowListener(new WindowAdapter() {
     	   public void windowClosing(WindowEvent e) {
     		   guardarPartida();
     		   JOptionPane.showMessageDialog(null, "Partida Guardada");
     		   System.exit(0);
     	   }
     	 });
    }
  
    public static void moverFicha()
    
    {
    	boolean puedeono,puedeono2,puedeono3,comeficha;
    	String aux1, aux2;
    	a = Integer.parseInt(textField.getText());
    	aux1= textField_1.getText().toString();
    	c= Integer.parseInt(textField_2.getText());
    	aux2= textField_3.getText().toString();
    	//( )
    	if( ((a>0)&&(a<9))  &&  ((c>0)&&(c<9)) &&    ((aux1.equalsIgnoreCase("a"))||(aux1.equalsIgnoreCase("b"))||(aux1.equalsIgnoreCase("c"))||(aux1.equalsIgnoreCase("d"))||(aux1.equalsIgnoreCase("e"))||(aux1.equalsIgnoreCase("f"))||(aux1.equalsIgnoreCase("g"))||(aux1.equalsIgnoreCase("h")))   &&  ((aux2.equalsIgnoreCase("a"))||(aux2.equalsIgnoreCase("b"))||(aux2.equalsIgnoreCase("c"))||(aux2.equalsIgnoreCase("d"))||(aux2.equalsIgnoreCase("e"))||(aux2.equalsIgnoreCase("f"))||(aux2.equalsIgnoreCase("g"))||(aux2.equalsIgnoreCase("h")))  )
    	{
    	
    	switch (aux1) {
    	 
        case "a":b=1;break;
        case "b":b=2;break;
        case "c":b=3;break;
        case "d":b=4;break;
        case "e":b=5;break;
        case "f":b=6;break;
        case "g":b=7;break;
        case "h":b=8;break;
        default: break;
 
 }
    	switch (aux2) {
   	 
        case "a":d=1;break;
        case "b":d=2;break;
        case "c":d=3;break;
        case "d":d=4;break;
        case "e":d=5;break;
        case "f":d=6;break;
        case "g":d=7;break;
        case "h":d=8;break;
        default: break;
 
 }
    	comeficha=false;
    	puedeono3=false;
    	
    	if (jugador)
    		{if (tab[a][b].getColor()=="B")
    			{puedeono3=true;}}
    	else{if (tab[a][b].getColor()=="N")
		{puedeono3=true;}}
    	
    	    	
    	if (tab[c][d]==null){puedeono2=true;}
    	else {
    		if (tab[c][d].getColor()==tab[a][b].getColor()){puedeono2=false;}
    		else {puedeono2=true;
    			  comeficha=true;
    			  System.out.println(tab[c][d].getClass().toString().substring(20));
    			  if(tab[c][d].getClass().toString().substring(20).equals("Rey"))
    			  {
    				  finJuego=true;
    			  };
    		}
    	}
    	
    	puedeono= tab[a][b].mover(a, b, c, d);
    	  	
      	if ((puedeono)&&(puedeono2)&&(puedeono3))
    	{
      		if (comeficha){tab[c][d].cambiaEstado();}
    		tab[c][d]=tab[a][b];
    		tab[a][b]= null;
    		DefaultTableModel m = new DefaultTableModel(actualizaTablero(tab),new String[] {
        		"A", "A", "B", "C", "D", "E", "F", "G", "H"
        	});
        	tablero.setModel(m);;
    		if (comeficha){JOptionPane.showMessageDialog(null, "Comio ficha","ENHORABUENA!",JOptionPane.WARNING_MESSAGE);}
    		setJugador();
        	if(jugador){textJugador.setText(jugadores[0]);}
        	else{textJugador.setText(jugadores[1]);}
    		
    	}
    	else 
    	{
    		if(!puedeono3){JOptionPane.showMessageDialog(null, "Esta ficha no te pertenece","ERROR",JOptionPane.WARNING_MESSAGE);}
    		else{JOptionPane.showMessageDialog(null, "Movimiento incorrecto","ERROR",JOptionPane.WARNING_MESSAGE);}
    		
    	}
    	}
    	else
    	{
    		JOptionPane.showMessageDialog(null,"Observe bien el tablero o vaya al oculista!! gil");
    	}
    	textField.setText("");
    	textField_1.setText("");
    	textField_2.setText("");
    	textField_3.setText("");
    	
    	
    	}
    	
    
    
    public static String[][] actualizaTablero (Ficha[][] tabla)
    {
    	String[][] tablaNueva=new String[9][9];
    	for(int i=1;i<9;i++)
    	{
    		for(int j=1;j<9;j++)
    		{
    			if(tabla[i][j]!=null){tablaNueva[i][j]=tabla[i][j].getApodo();}
    		}
    	}
    	tablaNueva[0][1]="A";
    	tablaNueva[0][2]="B";
    	tablaNueva[0][3]="C";
    	tablaNueva[0][4]="D";
    	tablaNueva[0][5]="E";
    	tablaNueva[0][6]="F";
    	tablaNueva[0][7]="G";
    	tablaNueva[0][8]="H";
    	
    	tablaNueva[1][0]="1";
    	tablaNueva[2][0]="2";
    	tablaNueva[3][0]="3";
    	tablaNueva[4][0]="4";
    	tablaNueva[5][0]="5";
    	tablaNueva[6][0]="6";
    	tablaNueva[7][0]="7";
    	tablaNueva[8][0]="8";
    	
    	
    	return tablaNueva;
    }
    
    public static void setJugador()
    {
    	if (jugador){jugador=false;}
    	else{jugador=true;}
    }
    
    public void guardarPartida()
    {
    	int posi;
    	String consulta,posiTablero;
    	String[] posicionesBlanco=new String[16];
    	String[] posicionesNegro=new String[16];
    	
    	for(int i=1;i<9;i++)
    	{
    		for(int j=1;j<9;j++)
    		{

    			if(tab[i][j]!=null){
    			if(tab[i][j].getColor().equalsIgnoreCase("B"))
    			{
    				posi=posicion(tab[i][j].getClass().toString().substring(20), posicionesBlanco);
    				posiTablero=Integer.toString(i)+Integer.toString(j);
    				posicionesBlanco[posi]=posiTablero;
    				
    			}
    			else
    			{
    				posi=posicion(tab[i][j].getClass().toString().substring(20), posicionesNegro);
    				posiTablero=Integer.toString(i)+Integer.toString(j);
    				posicionesNegro[posi]=posiTablero;
    			}
    			}
    		}
    	}
    	
    	MyDataAcces conexion = new MyDataAcces();
    	
    	conexion.setQuery("truncate posiciones");
    	conexion.setQuery("truncate partidas");
    	
    	consulta="insert into partidas values('1','"+jugadores[0]+"','"+jugadores[1]+"')";
    	conexion.setQuery(consulta);
    	
    	consulta="insert into posiciones values('1','"+jugadores[0]+"','"+posicionesBlanco[0]+"','"+posicionesBlanco[1]+"','"+posicionesBlanco[2]+"','"+posicionesBlanco[3]+"','"+posicionesBlanco[4]+"','"+posicionesBlanco[5]+"','"+posicionesBlanco[6]+"','"+posicionesBlanco[7]+"','"+posicionesBlanco[8]+"','"+posicionesBlanco[9]+"','"+posicionesBlanco[10]+"','"+posicionesBlanco[11]+"','"+posicionesBlanco[12]+"','"+posicionesBlanco[13]+"','"+posicionesBlanco[14]+"','"+posicionesBlanco[15]+"')";
    	conexion.setQuery(consulta);
    	
    	consulta="insert into posiciones values('1','"+jugadores[1]+"','"+posicionesNegro[0]+"','"+posicionesNegro[1]+"','"+posicionesNegro[2]+"','"+posicionesNegro[3]+"','"+posicionesNegro[4]+"','"+posicionesNegro[5]+"','"+posicionesNegro[6]+"','"+posicionesNegro[7]+"','"+posicionesNegro[8]+"','"+posicionesNegro[9]+"','"+posicionesNegro[10]+"','"+posicionesNegro[11]+"','"+posicionesNegro[12]+"','"+posicionesNegro[13]+"','"+posicionesNegro[14]+"','"+posicionesNegro[15]+"')";
    	conexion.setQuery(consulta);
    }
    
    public int posicion(String clase,String[] posiciones)
    {
    	int pos=0;
    	switch (clase) {
		case "Torre":
			if (posiciones[0]==null){pos=0;}
			else{pos=1;}
			break;
		case "Caballo":
			if (posiciones[2]==null){pos=2;}
			else{pos=3;}
			break;
		case "Alfil":
			if (posiciones[4]==null){pos=4;}
			else{pos=5;}
			break;
		case "Reina":
			pos=6;
			break;
		case "Rey":
			pos=7;
			break;
		case "Peon":
			if (posiciones[8]==null){pos=8;}
			else
			{
				if (posiciones[9]==null){pos=9;}
				else
				{
					if (posiciones[10]==null){pos=10;}
					else
					{
						if (posiciones[11]==null){pos=11;}
						else
						{
							if (posiciones[12]==null){pos=12;}
							else
							{
								if (posiciones[13]==null){pos=13;}
								else
								{
									if (posiciones[14]==null){pos=14;}
									else
									{
										pos=15;
									}
									}
								}
								
							}
						}
					}
				}
			break;
    	}
    	return pos;	
    	
    }
   

    
    }
   