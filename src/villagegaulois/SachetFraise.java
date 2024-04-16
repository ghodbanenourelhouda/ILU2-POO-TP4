package villagegaulois;

import produit.IProduit;

public class SachetFraise implements IProduit{
	
	private double poids ;
	private String nom ;
	
	public SachetFraise(String nom, double poids) {
	        this.nom = nom;
	        this.poids = poids;
	 }
	
	@Override
	public String getNom() {
		return nom;
	}

	
	@Override
	public String descriptionProduit() {
		return "Sachet de Fraise" ;
	}

	@Override
	public double calculerPrix(int prixProduit) {
		return ( prixProduit * poids ) / 100;
		
	}

	
}
