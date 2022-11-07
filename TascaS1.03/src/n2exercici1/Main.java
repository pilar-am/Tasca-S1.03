package n2exercici1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {

	public static void main(String[] args) {

		/*- Exercici 1
		 * Crea una classe anomenada Restaurant amb dos atributs: nom(String) i puntuaci�(int). 
		 * Implementa els m�todes necessaris perqu� no es puguin introduir objectes Restaurant 
		 * amb el mateix nom i la mateixa puntuaci� en un HashSet creat en el main() de l�aplicaci�.
		 */
		
		HashSet restaurantes = new HashSet();
		
		restaurantes.add(new Restaurant("Wine Mood",5));
		
		//El segon no s'insereix en el HashSet
		restaurantes.add(new Restaurant("Belle Buon",7));
		restaurantes.add(new Restaurant("Belle Buon",7));
		
		//El segon s'insereix en el hashSet perqu� la puntuaci� �s diferent
		restaurantes.add(new Restaurant("Xapaco",9));
		restaurantes.add(new Restaurant("Xapaco",10));
		
		System.out.println(restaurantes.size());
		
	}

}
