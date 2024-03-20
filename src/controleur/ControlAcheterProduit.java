package controleur;

import villagegaulois.Village;
import villagegaulois.Etal;
import personnages.Gaulois;

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
	

	public String[] listeCommercant(String produit) {
		
		Gaulois[] gauloisCommercants = village.rechercherVendeursProduit(produit);
		String[] commercants = new String[gauloisCommercants.length];
		if(gauloisCommercants.length != 0) {
			for(int i = 0; i<gauloisCommercants.length; i++) {
				commercants[i] = gauloisCommercants[i].getNom();
			}
		}
		return commercants;
	}
	
	public boolean verifierIdentite(String nomVendeur) {
		return controlVerifierIdentite.verifierIdentite(nomVendeur);
	}
	
	
	public int acheterProduit(String nomVendeur, int quantite) {
		
		Etal etalRecherche = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		
		return etalRecherche.acheterProduit(quantite);
	}
	
}

