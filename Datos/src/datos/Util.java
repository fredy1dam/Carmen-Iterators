package datos;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Util {
	public static String introducirCadena(){
		 String cadena="";
		 InputStreamReader entrada =new InputStreamReader(System.in);
		 BufferedReader teclado= new BufferedReader(entrada);
		 try{
			 cadena=teclado.readLine();
		 }
		 catch(IOException er){
			 System.out.println("error al introducir datos");
			 System.exit(0);
		 }
		 return cadena;
		}
	public static String introducirCadena(String mensaje){
		 String cadena="";
		 InputStreamReader entrada =new InputStreamReader(System.in);
		 BufferedReader teclado= new BufferedReader(entrada);
		 System.out.println(mensaje);
		 try{
			 cadena=teclado.readLine();
		 }
		 catch(IOException er){
			 System.out.println("error al introducir datos");
			 System.exit(0);
		 }
		 return cadena;
		}
	public static int leerInt() {
		int num=0;
		boolean error;
		do {
			error=false;
			try{
				num=Integer.parseInt(introducirCadena());
			}
			catch(NumberFormatException e) {
				System.out.println("Error, introduce un número:");
				error=true;
			}
		}while (error);
		return num;
	}
	public static int leerInt(String mensaje) {
		int num=0;
		boolean error;
		do {
			error=false;
			 System.out.println(mensaje);
			try{
				num=Integer.parseInt(introducirCadena());
			}
			catch(NumberFormatException e) {
				System.out.println("Error, introduce un número:");
				error=true;
			}
		}while (error);
		return num;
	}
	public static int leerInt(int x, int y) {
		boolean ok;
		int num=0;
		
		do {
			ok=true;
			try {
				num=Integer.parseInt(introducirCadena());
			}catch(NumberFormatException e) {
				ok=false;
				System.out.println("ERROR INTRODUCE OTRA VEZ");
			
			}
			if(num<x||num>y) {
				ok=false;
				System.out.println("Error numero fuera de rango");
			}
			
		}while(!ok);
		
		return num;
	}
	public static char leerChar() {
		char letra;
		String frase;
		do {
			frase =introducirCadena();
			if (frase.length()!=1) {
				System.out.println("Error introduce un unico caracter");
				
			}
					
		}while(frase.length()!=1);
		letra=frase.charAt(0);
		return letra;
	}
	public static float leerFloat() {
		float num=0;
		short correcto=0;
		
		do {
			correcto=1;
			try {
				num=Float.parseFloat(introducirCadena());
			}catch(Exception e) {
				System.out.println("ERROR INTRODUCE OTRA VEZ");
				correcto=0;
			}
			
			
		}while(correcto==0);
		
		return num;
	}
	public static LocalDate leerFecha() {
		LocalDate fecha=LocalDate.now();
		String aux;
		boolean error;
		DateTimeFormatter formatear = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		do {
			error=false;
			aux=Util.introducirCadena();
			try {
				fecha=LocalDate.parse(aux, formatear);
				
			}catch(DateTimeParseException e){
				error=true;
				System.out.println("Error,Introduce fecha con formato dd/mm/aaaa: ");
			}
		}while(error);
		return fecha;
		
	}
}
