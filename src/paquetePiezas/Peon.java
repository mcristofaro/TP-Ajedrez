package paquetePiezas;

public class Peon extends Ficha {
	
	public Peon()
	{}

	public Peon(String a, int j, int k) {
		super(a, j, k);
		// TODO Auto-generated constructor stub
	}
	
	public Peon(String color)
	{
		super(color);
	}
	
	@Override
	public boolean mover(int filaAnt, int colAnt, int filaN, int colN)
	{
		boolean ban = false;
		if(filaAnt!=filaN && colAnt==colN && this.getColor()=="N") { if(filaAnt+1==filaN) {ban=true;} }
		if(filaAnt!=filaN && colAnt==colN && this.getColor()=="B") { if(filaAnt-1==filaN) {ban=true;} }
		//if(filaAnt!=filaN && colAnt!=colN) { if(filaAnt+1==filaN && colAnt+1==colN) {ban=true;} }
		//if(filaAnt!=filaN && colAnt!=colN) { if(filaAnt+1==filaN && colAnt-1==colN) {ban=true;} }
				
		return ban;
}
	public  String getApodo()
	{
		String apodo=new String();
		apodo="P"+this.getColor();
		return apodo;
		
	}
 
}
