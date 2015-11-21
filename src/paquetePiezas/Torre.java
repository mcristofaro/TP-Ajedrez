package paquetePiezas;


public class Torre extends Ficha {

	public Torre()
	{}
	public Torre(String a, int j, int k) {
		super(a, j, k);
		// TODO Auto-generated constructor stub
	}
	
	public Torre(String color)
	{
		super(color);
	}
	
	@Override
	public boolean mover(int filaAnt, int colAnt, int filaN, int colN)
	{
		boolean ban = false;
		if(filaAnt!=filaN && colAnt==colN){ban=true;} 
		if(filaAnt==filaN && colAnt!=colN){ban=true;} 
				
		return ban;
}
	
	public  String getApodo()
	{
		String apodo=new String();
		apodo="T"+this.getColor();
		return apodo;
		
	}
}
