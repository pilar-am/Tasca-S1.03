package n1exercici1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		
		/*
		 * - Exercici 1
		Crea una classe anomenada Month amb un atribut "name" (que emmagatzemarà el nom del mes de l'any). 
		Afegeix 11 objectes Month (cadascun amb el seu atribut diferent) en un ArrayList, 
		a excepció de l'objecte amb atribut "Agost". Després, efectua la inserció en el lloc que correspon 
		a aquest mes i demostra que l’ArrayList manté l'ordre correcte.

		Converteix l’ArrayList de l’exercici anterior en un HashSet i assegura’t que no permet duplicats.

		Recorre la llista amb un for i amb un iterador.
		 */
		
		ArrayList<Month> months = new ArrayList<>();
		
		//Mesos de l'any menys l'agost
		months.add(new Month("Gener"));
		months.add(new Month("Febrer"));
		months.add(new Month("Març"));
		months.add(new Month("Abril"));
		months.add(new Month("Maig"));
		months.add(new Month("Juny"));
		months.add(new Month("Juliol"));
		months.add(new Month("Setembre"));
		months.add(new Month("Octubre"));
		months.add(new Month("Novembre"));
		months.add(new Month("Desembre"));
		
		//Es recorre la llista amb un for
		System.out.println("LLISTA RECORREGUDA AMB UN FOR");
        for (Month m: months){
            System.out.println(m);
        }
        System.out.println();
		
		//S'inserta l'agost
		months.add(7,new Month("Agost"));
		
		//Es recorre la llista amb un iterador
		System.out.println("LLISTA RECORREGUDA AMB UN ITERADOR");
		Iterator<Month> it = months.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		//Converteix l’ArrayList en un HashSet
		HashSet<Month> hashMonths = new HashSet<>(months);
		
		System.out.println();
		System.out.println("HASHSET RECORREGUT AMB UN FOR");
        for (Month m: hashMonths){
            System.out.println(m);
        }
		
        //S'afegeix de nou el mes de febrer
        hashMonths.add(new Month("Febrer"));
        
        //No es duplica l'entrada "Febrer"
		System.out.println();
		System.out.println("HASHSET RECORREGUT AMB UN ITERADOR");
		Iterator<Month> ite = hashMonths.iterator();
		while (ite.hasNext()) {
			System.out.println(ite.next());
		}
	}

}
