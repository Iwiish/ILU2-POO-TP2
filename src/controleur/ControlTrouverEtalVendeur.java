package controleur;

import villagegaulois.Etal;
import personnages.Gaulois;
import villagegaulois.Village;

public class ControlTrouverEtalVendeur {
	private Village village;

	public ControlTrouverEtalVendeur(Village village) {
		this.village = village;
	}

	public Etal trouverEtalVendeur(String nomVendeur) {
		Etal etal = null;
		Gaulois gauloisTrouve = village.trouverHabitant(nomVendeur);
		if(gauloisTrouve != null) {
			etal = village.rechercherEtal(gauloisTrouve);
		}
		return etal;
	}
}
