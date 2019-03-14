package datos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Principal {

	public static void main(String[] args) {
		ArrayList <Alumno> alumnos= new ArrayList <Alumno>();
		ArrayList <Integer> anios=new ArrayList<Integer>();
		int opc;
		
		do {
			opc=menu();
			switch(opc) {
			case 1:
				alta(alumnos);
				break;
			case 2:
				listado(alumnos);
				break;
			case 3:
				ordenarA(alumnos);
				break;
			case 4:
				borrar(alumnos);
				break;
			case 5:
				borrarid(alumnos);
				break;
			case 6:
				modificar(alumnos);
				break;
			case 7:
				listaranio(alumnos);
				break;
			case 8:
				mostraranio(alumnos,anios);
				break;
				
				
			}
			
		}while(opc!=10);
	}



	



	






	private static int menu() {
		int opc;
		System.out.println("1.-Alta\r"
				+ "2.-Listado\r"
				+ "3.-Ordenar por apellido\r"
				+ "4.-Borrar todos los alumnos\r"
				+ "5.-Borrar a un alumno a partir de su id\r"
				+ "6.-Modificar alumno a partir de un DNI\r"
				+ "7.-Listar alumno ordenado por año\r"
				+ "8.-Mostrar nombre apellido y total de alumnos. Ordenado por Año: "
				+ "9.-Listar los alumnos por año");
		opc=Util.leerInt();
		return opc;
	}

	private static void alta(ArrayList<Alumno> alumnos) {
		Alumno aux;
		int opc;
		do {
			aux = new Alumno();
			aux.setDatos();
			alumnos.add(aux);
			System.out.println("Añadir mas alumnos: 1-->SI 2-->NO");
			opc=Util.leerInt(1,2);	
		}while(opc!=2);
		
	}
	private static void listado(ArrayList<Alumno> alumnos) {
		int opc;
		
	 System.out.println("Listado por: 1-->for 2-->for_each 3-->Iterator 4-->List_iterator ");
	 opc=Util.leerInt(1,4);
	 if(opc==1) {
		 	for(int i=0;i<alumnos.size();i++) {
				 alumnos.get(i).getDatos();		 
				 }
			 } else if(opc==2) {
				  for (Alumno alu: alumnos) {
					  alu.getDatos();
					  
				  }
				 
			 } else if(opc==3) {
				 Iterator <Alumno> a= alumnos.iterator();
				 while(a.hasNext()) {
					 Alumno aux=a.next();  //Para poder mostrar algunos  datos de un alumno en concreto puedo instanciar y luego mostrar
					 System.out.println("Se llama: "+ aux.getNombre()+" y se apellida: "+ aux.getApellido()); 
					// a.next().getDatos();
				 }
				 
			 }else {
				 ListIterator<Alumno> al= alumnos.listIterator();
				 while(al.hasNext()) {
					 al.next().getDatos();
				 }	 
				 
			 }
	}
	
	
	private static void ordenarA(ArrayList<Alumno> alumnos) {
		
		Collections.sort(alumnos);
	}
	
	private static void borrar(ArrayList<Alumno> alumnos) {
		alumnos.clear();
		
	}
	
	private static void borrarid(ArrayList<Alumno> alumnos) {
		int opc;
		int si;
		int indice=-1;
		String cpdni;
		cpdni=Util.introducirCadena("DNI: ");
		System.out.println("Borrado por: 1-->for 2-->for_each 3-->List_iterator ");
		opc=Util.leerInt(1,3);
		
		if(opc==1) {
			for(int i=0;i<alumnos.size();i++) {
					if (alumnos.get(i).getDni().compareToIgnoreCase(cpdni)==0) {
						indice=i;
						break;
					}
				}
			if(indice==-1) {
				System.out.println("El dni no se encuentra registrado :(");
			}else {
				alumnos.get(indice).getDatos();
				System.out.println("Estas seguro de eliminar: 1-->SI 2-->NO");
				si=Util.leerInt(1,2);
				if(si==1) {
					alumnos.remove(indice);
					System.out.println("La operacion se ha realizado correctamente :)");
				}else {
					System.out.println("Operacion cancelada :)");
				}
			}
			
			
		}else if(opc==2) {
			for (Alumno alu:alumnos) {
				if(alu.getDni().compareToIgnoreCase(cpdni)==0) {
					indice=alumnos.indexOf(alu);
					break;
				}
			}
			
			if(indice==-1) {
				System.out.println("El dni no se encuentra registrado :(");
			}else {
				alumnos.get(indice).getDatos();
				System.out.println("Estas seguro de eliminar: 1-->SI 2-->NO");
				si=Util.leerInt(1,2);
				if(si==1) {
					alumnos.remove(indice);
					System.out.println("La operacion se ha realizado correctamente :)");
				}else {
					System.out.println("Operacion cancelada :)");
				}
			}
			
			
			
			
		}else {
			//para obtener indice previos index
			ListIterator<Alumno> a= alumnos.listIterator();
			while(a.hasNext()) {
			 if (a.next().getDni().equalsIgnoreCase(cpdni)) {
				indice=a.previousIndex(); //a.remove() -->igual
			 }
			}
			if(indice==-1) {
				System.out.println("El dni no se encuentra registrado :(");
			}else {
				alumnos.get(indice).getDatos();
				System.out.println("Estas seguro de eliminar: 1-->SI 2-->NO");
				si=Util.leerInt(1,2);
				if(si==1) {
					alumnos.remove(indice);
					System.out.println("La operacion se ha realizado correctamente :)");
				}else {
					System.out.println("Operacion cancelada :)");
				}
			}
		}
		
	}
	
	private static void modificar(ArrayList<Alumno> alumnos) {
		String dni;
		int indice=-1;
		int si;
		
		dni=Util.introducirCadena("Dni del Alumno: ");
		for( Alumno al:alumnos) {
			if(al.getDni().equalsIgnoreCase(dni)) {
				indice= alumnos.lastIndexOf(al);
				break;
			}
		}
		
		
		
		
		if(indice==-1) {
			System.out.println("El dni no se encuentra registrado :(");
		}else {
			alumnos.get(indice).getDatos();
			Alumno aux = new Alumno();
			System.out.println("Introduce los nuevos Datos: ");
			aux.setDatos();
			System.out.println("Estas seguro de guardar la modificacion: 1-->SI 2-->NO");
			si=Util.leerInt(1,2);
			if(si==1) {
				alumnos.set(indice, aux);
				System.out.println("La operacion se ha realizado correctamente :)");
			}else {
				System.out.println("Operacion cancelada :)");
			}
		}
	}
	
	
	private static void listaranio(ArrayList<Alumno> alumnos) {
		ArrayList<Alumno>anio= new ArrayList <Alumno>(alumnos);
		Alumno aux=new Alumno();
		int i;
		int j;
		for(i=0;i<anio.size();i++) {
			for(j=i+1;j<anio.size();j++) {
				
				if  ((anio.get(i).getAnio())> (anio.get(j).getAnio())) {
					
					aux=anio.get(i);
					anio.set(i, anio.get(j));
					anio.set(j, aux);
					
				}
			}
		}
		for(i=0;i<anio.size();i++) {
			anio.get(i).getDatos();
		}
		
	}
	
	private static void mostraranio(ArrayList<Alumno> alumnos, ArrayList<Integer> anios) {
		
		boolean esta=false;
		int numero;
		int total;
		int j;
		int i;
		
		for(i=0;i<alumnos.size();i++) {
			numero=alumnos.get(i).getAnio();
			if (!(esta(numero,anios))) {
				anios.add(numero);
			}
		}
		
		for(i=0;i<anios.size();i++) {
			total=0;
			System.out.println("Alumnos del año: "+anios.get(i));
			for(j=0;j<alumnos.size();j++) {
				if((alumnos.get(j).getAnio())==anios.get(i)) {
					System.out.println(alumnos.get(j).getNombre()+' '+alumnos.get(j).getApellido());
					total=total+1;
				}
			}
			if(j==alumnos.size()) {
				System.out.println("Total de alumnos: "+total);
			}
			
			
		}
		
		
	}

	private static boolean esta(int numero, ArrayList<Integer> anios) {
		boolean esta=false;
		for(int i=0;i<anios.size();i++) {
			if((anios.get(i))==numero) {
				esta=true;
				break;
				
			}
		}
		return esta;
	}

	
	
	


}
