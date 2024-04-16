package villagegaulois;

import personnages.Gaulois;
import personnages.Personnage;
import produit.IProduit;


public class Etal <P extends IProduit > implements villagegaulois.IEtal{
	private Gaulois vendeur ;
	private P [] produits ; 
	private int nbProduit ;
	private int prixProduit ;
	
	public void installerVendeur(Gaulois vendeur, P[] produits, int prix) {
		this.vendeur = vendeur ;
		this.produits = produits ;
		this.nbProduit = produits.length ;
		this.prixProduit = prix ;
	}
	
	@Override
	public int contientProduit(String produit, int quantiteSouhaitee) {
		int quantiteAVendre = 0;
		if (nbProduit != 0 && (this.produits[0]).getNom().equals(produit)) { // comment faire le cast
			if (nbProduit >= quantiteSouhaitee) {
				quantiteAVendre = quantiteSouhaitee;
			} else {
				quantiteAVendre = nbProduit;
			}
		}
		return quantiteAVendre;
	}
	
	@Override
	public double acheterProduit(int quantiteSouhaite) {
		double prixPaye = 0;
		for (int i = nbProduit - 1; i > nbProduit - quantiteSouhaite - 1 || i > 1; i--) {
			prixPaye += produits[i].calculerPrix(prixProduit);
		}
		if (nbProduit >= quantiteSouhaite) {
			nbProduit -= quantiteSouhaite;
		} else {
			nbProduit = 0;
		}
		return prixPaye;
	}

	@Override
	public String etatEtal() {
		StringBuilder chaine = new StringBuilder(vendeur.getNom());
		if (nbProduit > 0) {
			chaine.append(" vend ");
			chaine.append(nbProduit + " produits :");
		for (int i = 0; i < nbProduit; i++) {
			chaine.append("\n- " + produits[i].descriptionProduit());
		}
		} else {
			chaine.append(" n'a plus rien à vendre.");
		}
		chaine.append("\n");
		return chaine.toString();
	}

	@Override
	public Gaulois getVendeur() {
		return vendeur;
	}

	@Override
	public double donnerPrix() {
		return prixProduit ;
	}
	
	
	
	
}
