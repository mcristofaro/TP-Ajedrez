package paquetePiezas;

public class Reina extends Ficha {
	
	public Reina()
	{}

	public Reina(String a, int j, int k) {
		super(a, j, k);
		// TODO Auto-generated constructor stub
	}
	
	public Reina(String color)
	{
		super(color);
	}
	
	@Override
	public boolean mover(int filaAnt, int colAnt, int filaN, int colN)
	{
		boolean ban = false;
		if(filaAnt!=filaN && colAnt!=colN){if((Math.abs((filaN-filaAnt))==(Math.abs(colN-colAnt)))){ban=true;}} 
		if(filaAnt!=filaN && colAnt==colN){ban=true;} 
		if(filaAnt==filaN && colAnt!=colN){ban=true;} 
			
		
		return ban;
}
	public  String getApodo()
	{
		String apodo=new String();
		apodo="Q"+this.getColor();
		return apodo;
		
	}
	

}
