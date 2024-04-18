package villagegaulois;

import personnages.Gaulois;
import produit.IProduit;

public interface IEtal {
	Gaulois getVendeur();
	double donnerPrix();
	int contientProduit(String produit, int quantiteSouhaitee);
	double acheterProduit(int quantiteSouhaitee);
	String etatEtal();
}
