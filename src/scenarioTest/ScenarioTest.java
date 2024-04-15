package scenarioTest;

import personnages.Gaulois;
import produit.Poisson;
import produit.Produit;
import produit.Sanglier;
import villagegaulois.Etal;
import villagegaulois.IEtal;

public class ScenarioTest {
	public static void main(String[] args) {
		IEtal[] etals = new IEtal[3];
		Etal<Sanglier> etalSanglier = new Etal<>();
		etals[0] = (IEtal) etalSanglier ;   // Page 3
		etals[0].occuperEtal(new Gaulois("Ordralfabétix", 12), new Poisson("lundi"), 10);

		
		
//		IEtal<Poisson> etalPoisson = new Etal<>();
//		marche[0] = etalSanglier;
//		marche[1] = etalPoisson;
		
		
//		IEtal<Sanglier>[] marche = new IEtal[3];  //Avant la modification
//		IEtal<Sanglier>[] marche = new IEtal[3];  // Pour préciser que des étals acceptent uniquement sangliers
//		IEtal<Sanglier> etalSanglier = new Etal<>();
		
		
	}
	
}
