package n2exercici1;

import java.util.Objects;

public class Restaurant implements Comparable<Restaurant>{

	String nom;
	int puntuacio;
	
	public Restaurant(String nom, int puntuacio) {
		super();
		this.nom = nom;
		this.puntuacio = puntuacio;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPuntuacio() {
		return puntuacio;
	}

	public void setPuntuacio(int puntuacio) {
		this.puntuacio = puntuacio;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(nom, puntuacio);
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Restaurant other = (Restaurant) obj;
		return Objects.equals(nom, other.nom) && puntuacio == other.puntuacio;
	}

	
	@Override
	public int compareTo(Restaurant o) {
		
        int resultat = this.nom.compareTo(o.nom);
        if (resultat == 0){
    		if(puntuacio > o.puntuacio) {
    			return -1;
    		}
    		if(puntuacio < o.puntuacio) {
    			return 1;
    		}
    		resultat = 0;
    		return resultat;
        }
        return resultat;
	}

	@Override
	public String toString() {
		return "Restaurant [nom=" + nom + ", puntuacio=" + puntuacio + "]";
	}
}
