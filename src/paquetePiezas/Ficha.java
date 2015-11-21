package paquetePiezas;

public abstract class Ficha {
	
	String color;
	int x,y;
	boolean estado;
	
	
	
	
	public Ficha() 
	{}
	
	public Ficha(String color)
	{
		this.color=color;
	}

	public Ficha(String a, int j, int k)
	{
		this.color=a;
		this.x=j;
		this.y=k;
		this.estado=true;
		
	}
	
	public String getColor ()
	{
		return this.color;
	}
	
	public void cambiaEstado()
	{
		this.estado=false;
	}

	public boolean mover(int filaAnt, int filaN, int colAnt, int colN) {
		// TODO Auto-generated method stub
		return false;
	}
	public  String getApodo()
	{
		String apodo="nada";
		return apodo;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
}
	

