package n1exercici3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	/*
	 * - Exercici 3
		Donat el fitxer countrties.txt (revisa l'apartat recursos) que conté països i capitals. 
		El programa ha de llegir el fitxer i guardar les dades en un HashMap<String, String>. 
		El programa demana el nom de l’usuari/ària, i després ha de mostrar un país de forma aleatòria, 
		guardat en el HashMap. Es tracta de què l’usuari/ària ha d’escriure el nom de la capital del país 
		en qüestió. Si l’encerta se li suma un punt. Aquesta acció es repeteix 10 vegades. Un cop demanades 
		les capitals de 10 països de forma aleatòria, llavors s’ha de guardar en un fitxer 
		anomenat classificacio.txt, el nom de l’usuari/ària i la seva puntuació.
	 */
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
	    Map<String,String> paisos = new HashMap<>();
	    
	    llegirArxiu("C:\\Users\\prueba\\Documents\\EclipseWorkSpace\\TascaS1.03\\src\\n1exercici3\\countries.txt", paisos);
	    
//	    paisos.forEach((key, value) -> System.out.println(key + ": " + value));
	     
	    String nom = Main.demanarDades();
	    
	    int puntuacio = Main.calcularPuntuacio(paisos);
	    
	    System.out.println("La teva puntuació " + puntuacio);
	    
	    escriureArxiu(nom, puntuacio, "C:\\Users\\prueba\\Documents\\EclipseWorkSpace\\TascaS1.03\\src\\n1exercici3\\puntuacio.txt");
	    	    	    
	}
	
	//Llegeig el nom de l'usuari
	static String demanarDades() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Nom d'usuari: ");
		String nom = entrada.nextLine();
		return nom;	
	}
	
	//Llegeix un arxiu txt
	static void llegirArxiu(String path, Map<String,String> paisos) {
		
		File archivo = null;
	    FileReader fr = null;
	    BufferedReader br = null;
	    try {
	    	archivo = new File(path);
	    	fr = new FileReader (archivo);
	        br = new BufferedReader(fr);
	        
	         // Lectura del fitxer
	         String linea;
	         while((linea=br.readLine())!=null) {
	        	
	        	 String[] cadenas = linea.split(" ");
	        	 
	        	 for (int i=0;i<cadenas.length-1;i++) {
	        		 if (i%2 ==0) {
	        			 paisos.put(cadenas[i], cadenas[i+1]);
	        		 }
	        	 }
	         }
	    	
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	}

	//Es calcula la puntuació del joc
	static int calcularPuntuacio(Map<String,String> paisos) {
		
		int numero = (int)(Math.random()*50+1);
	    Random       random    = new Random();
	    List<String> claus      = new ArrayList<String>(paisos.keySet());
	    String       randomClaus = claus.get( random.nextInt((int)(Math.random()*50+1)) );
	    String       value     = paisos.get(randomClaus);
		
	    int puntuacio =0;
	    String resposta;
	    
	    Scanner entrada = new Scanner(System.in);
	    for (int i=0; i<10; i++) {
	    	String pais = claus.get( random.nextInt((int)(Math.random()*50+1)));
	    	System.out.println("Pais: " + pais);
	    	resposta = entrada.nextLine();
	    		    	
	    	if ((paisos.get(pais)).equals(resposta)) {
	    		puntuacio++;
	    	}
	    }
		return puntuacio;
	}
	
	static void escriureArxiu(String nom, int puntuacio, String path) {
        FileWriter fitxer = null;
        PrintWriter pw = null;
        try
        {
        	fitxer = new FileWriter(path);
            pw = new PrintWriter(fitxer);

            pw.println("Usuari: " + nom + "  Puntuació: " + puntuacio);
            
            System.out.println("Dades guardades");

        } catch (Exception e) {
        	System.out.println(e.getMessage());
           
        } finally {
           try {
        	   if (fitxer != null)  fitxer.close();
           } catch (Exception e2) {
        	   System.out.println(e2.getMessage());
           }
        }
		
		
	}
	
	
}
