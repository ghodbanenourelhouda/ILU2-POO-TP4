package scenarioTest;

import personnages.Gaulois;
import produit.Poisson;
import produit.Produit;
import produit.Sanglier;
import vilagegauloisold.DepenseMarchand;
import villagegaulois.Etal;
import villagegaulois.IEtal;
import village.IVillage;



public class Scenario {

	// La classe interne 
	
	static class Village implements IVillage {
		
		villagegaulois.IEtal[] etals = new IEtal[10];
		
		@Override
		public <P extends Produit> boolean installerVendeur(villagegaulois.Etal<P> etal, Gaulois vendeur, P[] produit,
				int prix) {
			if (etal == null || vendeur == null || produit == null || produit.length == 0 || prix <= 0) {
				return false;
		    }
			for (int i = 0; i < etals.length; i++) {
			    if (etals[i] == null) {
			       etals[i] = etal;
			       break;
			     }
			 }
			etal.installerVendeur(vendeur, produit, prix);
			return true;
		}

		@Override
		public DepenseMarchand[] acheterProduit(String produit, int quantiteSouhaitee) {
			DepenseMarchand[] depenses = new DepenseMarchand[0];
			for (IEtal etal : etals) {
				if (etal != null) {
					int quantiteDisponible = etal.contientProduit(produit, quantiteSouhaitee);
					if (quantiteDisponible > 0) {
						double prixTotal = etal.acheterProduit(quantiteDisponible);
						DepenseMarchand depense = new DepenseMarchand(etal.getVendeur(), quantiteDisponible, produit, prixTotal);
						DepenseMarchand[] newDepenses = new DepenseMarchand[depenses.length + 1];
						System.arraycopy(depenses, 0, newDepenses, 0, depenses.length);
						newDepenses[depenses.length] = depense;
						depenses = newDepenses;
						quantiteSouhaitee -= quantiteDisponible;
						if (quantiteSouhaitee <= 0) {
							break; 
						}
					}
				}
			}
            return depenses;
       }
		
		// Fonction pour l'affichage du village
		
		public String toString() {
		    StringBuilder builder = new StringBuilder();
		    int i = 0 ; 
		    for (IEtal etal : etals) {
		        if (etal != null) {
		            builder.append(etal.etatEtal()).append("\n");
		        }
		    }
		    return builder.toString();
		}
}

	
	// Le main 
	
	public static void main(String[] args) {
		
		IVillage village = new Village() ; 
		Gaulois ordralfabetix = new Gaulois("Ordralfabétix", 9);
		Gaulois obelix = new Gaulois("Obélix", 20);
		Gaulois asterix = new Gaulois("Astérix", 6);
		

		Etal<Sanglier> etalSanglierObelix = new Etal<>();
		Etal<Sanglier> etalSanglierAsterix = new Etal<>();
		Etal<Poisson> etalPoisson = new Etal<>();

		Sanglier sanglier1 = new Sanglier(2000, obelix);
		Sanglier sanglier2 = new Sanglier(1500, obelix);
		Sanglier sanglier3 = new Sanglier(1000, asterix);
		Sanglier sanglier4 = new Sanglier(500, asterix);

		Sanglier[] sangliersObelix = { sanglier1, sanglier2 };
		Sanglier[] sangliersAsterix = { sanglier3, sanglier4 };

		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = { poisson1 };

		village.installerVendeur(etalSanglierAsterix, asterix, sangliersAsterix, 10);
		village.installerVendeur(etalSanglierObelix, obelix, sangliersObelix, 8);
		village.installerVendeur(etalPoisson, ordralfabetix, poissons, 5);
		
		System.out.println(village);

		DepenseMarchand[] depense = village.acheterProduit("sanglier", 3);

		for (int i = 0; i < depense.length && depense[i] != null; i++) {
			System.out.println(depense[i]);
		}
		
		System.out.println(village);
		
		
	}

}
