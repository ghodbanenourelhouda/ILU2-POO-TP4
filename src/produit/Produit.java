package produit;

import personnages.Unite ;

public abstract class Produit implements IProduit  {
	protected String nom ; 
	protected Unite unite ;
	
	public String getNom () {
		return nom ; 
	}
	
	public Produit (String nom , Unite unite ) {
		this.nom = nom ;
		this.unite = unite ;
	}
	
	public abstract String descriptionProduit (); 
	
	
}
	
	
