package n2exercici2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import n2exercici1.Restaurant;

public class Main {

	public static void main(String[] args) {
		
		/*
		 * Utilitzant la classe del programa anterior, crea la implementació necessària 
		perquè els objectes de la classe Restaurant estiguin ordenats per nom i per puntuació 
		en ordre ascendent. 
		Exemple: 
			nom: restaurant1, puntuació: 8
			nom: restaurant1, puntuació: 7
		 */
		
		HashSet restaurants = new HashSet();
		
		restaurants.add(new Restaurant("Wine Mood",5));
		restaurants.add(new Restaurant("Belle Buon",7));
		restaurants.add(new Restaurant("Xapaco",7));
		restaurants.add(new Restaurant("Xapaco",10));
		restaurants.add(new Restaurant("Arepa",10));
		restaurants.add(new Restaurant("Xapaco",9));
		
		//Convertir el hashSet a un ArrayList
		
		List<Restaurant> llista = new ArrayList<>(restaurants);
		
		Collections.sort(llista);
		
		for (Restaurant p: llista){
            System.out.println(p);
        }
	}
}
