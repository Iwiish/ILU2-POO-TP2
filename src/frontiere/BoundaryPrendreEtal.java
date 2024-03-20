package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean nomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		
		if(!nomVendeurConnu){
			System.out.println("Je suis désolée " + nomVendeur + " mais il faut être un habitant de notre village pour commercer ici.");
		}else {
			System.out.println("Bonjour " + nomVendeur + " , je vais regarder si je peux vous trouver un étal.");
			boolean etalDisponible = controlPrendreEtal.resteEtals();
			if(!etalDisponible) {
				System.out.println("Désolée " + nomVendeur + " je n'ai plus d'étal qui ne soit pas occupé.");
			}else {
				System.out.println("C'est parfait, il me reste un étal pour vous !");
				installerVendeur(nomVendeur);
			}
		}
		
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("Il me faudrait quelques renseignements\n\rQuel produit souhaitez-vous vendre ?");
		String produit = scan.next();
		
		StringBuilder question2 = new StringBuilder(); 
		question2.append("Combien souhaitez-vous en vendre ?");
		int nbProduit = Clavier.entrerEntier(question2.toString());
		
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		
		if(numeroEtal != -1) {
			System.out.println("Le vendeur " + nomVendeur + " s'est installé à l'étal n°" + numeroEtal);
		}
	
	}
}
