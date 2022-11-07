package n3exercici1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static final String SEPARATOR=",";
	
	
	public static void main(String[] args) {
		
		/*
		 * Crea una aplicació capaç de llegir un fitxer CSV. Aquest fitxer té 3 camps: nom, cognom i DNI, 
		 * per cada registre. Es tracta d’ordenar les persones llegides del fitxer, mitjançant el seu nom, 
		 * cognom o DNI. Pots fer servir la llista que creguis més adient.
		 * 
		 * La classe principal té el següent menú:
			1.- Introduir persona.
			2.- Mostrar les persones ordenades per nom (A-Z).
			3.- Mostrar les persones ordenades per nom (Z-A).
			4.- Mostrar les persones ordenades per cognoms (A-Z).
			5.- Mostrar les persones ordenades per cognoms (Z-A).
			6.- Mostrar les persones ordenades per DNI (1-9).
			7.- Mostrar les persones ordenades per DNI (9-1).
			0.- Sortir.
		 */
		
		List <Persona> persones = obtenir(); 
		
		Scanner entrada = new Scanner(System.in);
		
		
		
		int opcio;
		do {
			menu();
			System.out.println("Opció ");
			opcio = entrada.nextInt();

			
			switch(opcio) {
			case 1:
				//System.out.println("Ingressant persones al csv");
				//persones = obtenir();
				//ingresando nueva persona y metiéndola al csv 
				//NO IMPLEMENTAT, con maven y csv
				break;
			case 2:
				Collections.sort(persones);
				for (int i = 0; i< persones.size() -1; i++) {
					System.out.println(persones.get(i));
				}
				break;
			case 3:
				persones.sort((n1, n2) -> -(n1.compareTo(n2)));
				for (int i = 1; i< persones.size() ; i++) {
					System.out.println(persones.get(i));
				}
				break;
			case 4:
		        persones.sort(new Comparator<Persona>(){
					@Override
					public int compare(Persona o1, Persona o2) {
						return o1.getCognom().compareTo(o2.getCognom());
					}
		        });
				for (int i = 0; i< persones.size() -1; i++) {
					System.out.println(persones.get(i));
				}
				break;
			case 5:
		        persones.sort(new Comparator<Persona>(){
					@Override
					public int compare(Persona o1, Persona o2) {
						return o2.getCognom().compareTo(o1.getCognom());
					}
		        });
				for (int i = 1; i< persones.size() ; i++) {
					System.out.println(persones.get(i));
				}
				break;
			case 6:
		        persones.sort(new Comparator<Persona>(){
					@Override
					public int compare(Persona o1, Persona o2) {
						return o1.getDni().compareTo(o2.getDni());
					}
		        });
				for (int i = 0; i< persones.size() -1; i++) {
					System.out.println(persones.get(i));
				}
				break;
			case 7:
		        persones.sort(new Comparator<Persona>(){
					@Override
					public int compare(Persona o1, Persona o2) {
						return o2.getDni().compareTo(o1.getDni());
					}
		        });
				for (int i = 1; i< persones.size() ; i++) {
					System.out.println(persones.get(i));
				}
				break;
			case 0:
				System.out.println("Fins la propera ");
				break;
			default:
				System.out.println("Opció no correcta");
				
			}
		}while(opcio != 0);
		
	}
	
	static void menu() {
		System.out.println ("\n-------MENÚ---------");
		String menu = "1. Introduir persona.\n"
				+ "2. Mostar les persones ordenades per nom (A-Z)\n"
				+ "3. Mostar les persones ordenades per nom (Z-A)\n"
				+ "4. Mostar les persones ordenades per cognoms (A-Z)\n"
				+ "5. Mostar les persones ordenades per cognoms (Z-A)\n"
				+ "6. Mostar les persones ordenades per DNI (1-9)\n"
				+ "7. Mostar les persones ordenades per DNI (9-1)\n"
				+ "0. Sortir";
		System.out.println (menu);
	}
	
	public static ArrayList<Persona> obtenir() {
		final String NOM_ARXIU = "C:\\Users\\prueba\\Documents\\EclipseWorkSpace\\TascaS1.03\\persones.csv";
		final String SEPARADOR = ",";
		ArrayList<Persona> persones = new ArrayList<>();
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			fileReader = new FileReader(NOM_ARXIU);
			bufferedReader = new BufferedReader(fileReader);
			String linea;
			while ((linea = bufferedReader.readLine()) != null) {
				String[] personaCsv = linea.split(SEPARADOR);
				//String[] personaComoArreglo = linea.split(SEPARADOR_CAMPO);
				//personas.add(new Persona(personaComoArreglo[0], Integer.valueOf(personaComoArreglo[1]),
					//	personaComoArreglo[2]));
				persones.add(new Persona(personaCsv[0], personaCsv[1], personaCsv[2]));
			}
		} catch (IOException e) {
			System.out.println("Excepció llegint l'arxiu: " + e.getMessage());
		} finally {
			try {
				if (fileReader != null) {
					fileReader.close();
				}
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (IOException e) {
				System.out.println("Excepció tancant: " + e.getMessage());
			}
			return persones;
		}
	}	
	
}
