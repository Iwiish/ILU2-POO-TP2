package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		
		if(infosMarche.length == 0) {
			System.out.println("Le marché est vide, revenez plus tard.");
		}else {
			System.out.println(nomAcheteur + " voud trouverez au marché : ");
			for(int i=0; i<infosMarche.length; i++) {
				System.out.println("- " + infosMarche[i] + " qui vend");
				i++;
				System.out.println(infosMarche[i] + " ");
				i++;
				System.out.println(infosMarche[i]);
			}
		}
		
	}
}
