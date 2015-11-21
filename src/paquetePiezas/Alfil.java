package paquetePiezas;

public class Alfil extends Ficha {
	
	public Alfil()
	{}
	
	public Alfil(String color)
	{
		super(color);
	}
	
	public Alfil(String a, int j, int k) {
		super(a, j, k);
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean mover(int filaAnt, int colAnt, int filaN, int colN)
	{
		boolean ban = false;
		if(filaAnt!=filaN && colAnt!=colN){if((Math.abs((filaN-filaAnt))==(Math.abs(colN-colAnt)))){ban=true;}} 
				
		return ban;
}
	
	public  String getApodo()
	{
		String apodo=new String();
		apodo="A"+this.getColor();
		return apodo;
		
	}
}
