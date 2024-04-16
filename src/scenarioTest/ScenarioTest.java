package scenarioTest;

import personnages.Gaulois;
import produit.Poisson;
import produit.Produit;
import produit.Sanglier;
import villagegaulois.Etal; 
import villagegaulois.IEtal;

public class ScenarioTest {
	public static void main(String[] args) {
//		IEtal[] etals = new IEtal[3];
//		Etal<Sanglier> etalSanglier = new Etal<>();
//		etals[0] = (IEtal) etalSanglier ;   // Page 3
//		etals[0].occuperEtal(new Gaulois("Ordralfabétix", 12), new Poisson("lundi"), 10);

		
//		IEtal<Poisson> etalPoisson = new Etal<>();
//		marche[0] = etalSanglier;
//		marche[1] = etalPoisson;
		
		
//		IEtal<Sanglier>[] marche = new IEtal[3];  //Avant la modification
//		IEtal<Sanglier>[] marche = new IEtal[3];  // Pour préciser que des étals acceptent uniquement sangliers
//		IEtal<Sanglier> etalSanglier = new Etal<>();
		
		Gaulois ordralfabetix = new Gaulois("Ordralfabétix", 9);
		Gaulois obelix = new Gaulois("Obélix", 20);
		Gaulois asterix = new Gaulois("Astérix", 6);
		
		Sanglier sanglier1 = new Sanglier(2000, obelix);
		Sanglier sanglier2 = new Sanglier(1500, obelix);
		Sanglier sanglier3 = new Sanglier(1000, asterix);
		Sanglier sanglier4 = new Sanglier(500, asterix);

		Sanglier[] sangliersObelix = {sanglier1, sanglier2};
		Sanglier[] sangliersAsterix = {sanglier3, sanglier4};
		
		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = {poisson1};
		
		Etal<Sanglier> etalSanglierObelix = new Etal<>();
		Etal<Sanglier> etalSanglierAsterix = new Etal<>();
		Etal<Poisson> etalPoisson = new Etal<>();
		
		IEtal[] marche = new IEtal[3];
		marche[0] = etalSanglierAsterix;
        marche[1] = etalSanglierObelix;
        marche[2] = etalPoisson;
        
		
		etalSanglierObelix.installerVendeur(obelix, sangliersObelix, 8);
		etalSanglierAsterix.installerVendeur(asterix, sangliersAsterix,10);
		etalPoisson.installerVendeur(ordralfabetix, poissons,7);
		
		
		System.out.println ("ETAT MARCHE");
		String etatMarche1 = etalSanglierAsterix.etatEtal() ;
		System.out.println (etatMarche1 );
		String etatMarche2 = etalSanglierObelix.etatEtal() ;
		System.out.println (etatMarche2 );
		String etatMarche3 = etalPoisson.etatEtal() ;
		System.out.println (etatMarche3);
		
		int nombreSangliersAchetes = 0;
        int indexEtal = 0;
        double totalPrix = 0;
        while (nombreSangliersAchetes < 3 && indexEtal < marche.length) {
            int quantiteDisponible = marche[indexEtal].contientProduit("sanglier", 3);
            if (quantiteDisponible > 0) {
                int quantiteAcheter = 3 - nombreSangliersAchetes; // Acheter autant que nécessaire pour atteindre 3
                if (quantiteAcheter > quantiteDisponible) { // Si la quantité à acheter est supérieure à la quantité disponible
                    quantiteAcheter = quantiteDisponible; // Ajuster la quantité à acheter à la quantité disponible
                }
                double prixTotal = marche[indexEtal].acheterProduit(quantiteAcheter);
                nombreSangliersAchetes += quantiteAcheter;
                totalPrix += prixTotal;
                System.out.println("A l'étal " + indexEtal + " je paye " +  prixTotal + " sous.");
                String etatMarche = etalSanglierAsterix.etatEtal();
                if (nombreSangliersAchetes == 3) {
                    break;
                }
            }
            indexEtal++;
        }

        
        System.out.println("Je voulais 3 sangliers, j'en ai acheté " + nombreSangliersAchetes + ".\n");
        System.out.println ("ETAT MARCHE");
		String etatMarche11 = etalSanglierAsterix.etatEtal() ;
		System.out.println (etatMarche11 );
		String etatMarche22 = etalSanglierObelix.etatEtal() ;
		System.out.println (etatMarche22 );
		String etatMarche33 = etalPoisson.etatEtal() ;
		System.out.println (etatMarche33);
	
	}
	
}
