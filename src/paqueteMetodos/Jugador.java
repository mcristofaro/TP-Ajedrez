package paqueteMetodos;



public class Jugador 
{
	public Jugador(String DNI, String nom, String ape)
	{
		this.apellido=ape;
		this.dni=DNI;
		this.nombre=nom;
	}
	
	private String nombre,apellido,dni;
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
