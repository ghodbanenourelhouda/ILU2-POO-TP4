package produit;

import personnages.Gaulois;
import personnages.Unite ;

public class Sanglier extends Produit {
	private int poids ;
	private Gaulois chasseur ;
	
	public Sanglier (int poids, Gaulois chasseur) {
		super ("sanglier" , Unite.KILOGRAMME);
		this.poids = poids ;
		this.chasseur = chasseur ;
	}
	
	public String descriptionProduit () {
		return nom + "de " + unite + "chassé par " + chasseur ;
	}
	
	
	
}
