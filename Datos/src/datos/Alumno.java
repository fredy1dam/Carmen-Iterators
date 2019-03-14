package datos;

public class Alumno implements Comparable <Alumno> {
	
	private String nombre;
	private String apellido;
	private String 	dni;
	private int edad;
	private String calificacion;
	private int anio;
	
	
	
	public Alumno() {
		super();
	}
	
	public Alumno(String nombre, String apellido, String dni, int edad, String calificacion, int anio) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.edad = edad;
		this.calificacion = calificacion;
		this.anio = anio;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
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
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	
	public void setDatos() {
		nombre= Util.introducirCadena("Nombre: ");
		apellido= Util.introducirCadena("Apellido: ");
		dni= Util.introducirCadena("Dni: ");
		edad=Util.leerInt("Edad: ");
		calificacion= Util.introducirCadena("Calificacion: ");
		anio=Util.leerInt("Año: ");
	}
	
	public void getDatos() {
		System.out.println("Nombre: "+nombre+" Apellido: "+apellido+" Dni: "+dni+" Edad: "+edad+" Calificacion: "+calificacion+" Año: "+anio);
		
	}

	@Override
	public int compareTo(Alumno a) {
		
		return  apellido.compareTo(a.getApellido());
	}
	
	

}
