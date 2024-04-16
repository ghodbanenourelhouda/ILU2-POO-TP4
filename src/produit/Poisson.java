package produit;

import personnages.Unite ;

public class Poisson extends Produit {
	private String date ;
	
	public Poisson (String date ) {
		super ("poisson" , Unite.PIECE);
		this.date = date ;
	}
	
	public String descriptionProduit () {
		return nom + " pêchés " + date ;
	}

	@Override
	public double calculerPrix(int prixProduit) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
