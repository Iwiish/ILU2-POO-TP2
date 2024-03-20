package frontiere;

import controleur.ControlLibererEtal;
import villagegaulois.Etal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		Etal vendeurReconnu = controlLibererEtal.isVendeur(nomVendeur);
		
		if(vendeurReconnu == null) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui !");
		}else {
			String[] donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			
			if(donneesEtal[0] == "true") {
				System.out.println("Vous avez vendu " + donneesEtal[4] + " sur " + donneesEtal[3] + " produit.");
				System.out.println("Au revoir "+ nomVendeur + ", passez une bonne journée.");
			}
		}
	}

}
