package controleur;

import villagegaulois.Village;
import villagegaulois.Etal;
import personnages.Gaulois;
import frontiere.Clavier;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}
	
	public boolean verifierIdentite(String nomVendeur) {
		return controlVerifierIdentite.verifierIdentite(nomVendeur);
	}
	public Gaulois[] chercherVendeurs(String produit) {
		return village.rechercherVendeursProduit(produit);
	}
	
	public Gaulois choisirVendeur(Gaulois[] vendeurs, String produit) {
		for(int i = 0; i<vendeurs.length; i++) {
			Etal etalVendeurAcc = village.rechercherEtal(vendeurs[i]);
			System.out.println( i + "." + " Le vendeur + " + vendeurs[i] + " vend " + etalVendeurAcc.getQuantite() + " " + etalVendeurAcc.getProduit() + "\n");
		}

		int numVendeur = Clavier.entrerEntier("Chez quel commerçant voulez-vous acheter des " + produit + "?");
		//verification que le vendeur existe
		
		return vendeurs[numVendeur];
	}
	
	public int acheterProduit(String vendeur, int quantite) {
		
		Gaulois gauloisVendeur = village.trouverHabitant(vendeur);
		
		Etal etalRecherche = village.rechercherEtal(gauloisVendeur);
		return  etalRecherche.acheterProduit(quantite);
	
	}

}
