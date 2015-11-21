package paquetePiezas;

public class Caballo extends Ficha {
	public Caballo()
	{}

	public Caballo(String a, int j, int k) {
		super(a, j, k);
		// TODO Auto-generated constructor stub
	}
	
	public Caballo(String color)
	{
		super(color);
	}
	
	@Override
	public boolean mover(int filaAnt, int colAnt, int filaN, int colN)
	{
		boolean ban = false;
				
		if(filaAnt!=filaN && colAnt!=colN) { if((Math.abs(filaAnt-filaN))==2 && (Math.abs(colAnt-colN))==1) {ban=true;} }
		if(filaAnt!=filaN && colAnt!=colN) { if((Math.abs(filaAnt-filaN))==1 && (Math.abs(colAnt-colN))==2) {ban=true;} }
				
		return ban;
}
	public  String getApodo()
	{
		String apodo=new String();
		apodo="C"+this.getColor();
		return apodo;
		
	}
	
	
}
