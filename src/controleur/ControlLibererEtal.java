package controleur;

import villagegaulois.Etal;

public class ControlLibererEtal {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	public ControlLibererEtal(
			ControlTrouverEtalVendeur controlTrouverEtalVendeur) {
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public String[] libererEtal(String nomVendeur) {
		String[] donneesEtal = null;
		Etal etalTrouve = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		if(etalTrouve!= null) {
			donneesEtal = etalTrouve.etatEtal();
		}
		return donneesEtal;
	}
	
	public Etal isVendeur(String nomVendeur) {
		return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
	}

}
