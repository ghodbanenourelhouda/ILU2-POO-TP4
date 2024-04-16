package villagegaulois;

import produit.IProduit;

public class Salade implements IProduit{
	
	private String nom ;
	public Salade (String nom) {
		this.nom = nom ;
	}
	
	@Override
	public double calculerPrix(int prixProduit) {
        return prixProduit; 
    }

	@Override
	public String descriptionProduit() {
		return "Salade";
	}

	@Override
	public String getNom() {
		return nom ;
	}
}
