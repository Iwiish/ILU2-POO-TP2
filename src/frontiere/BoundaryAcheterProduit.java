package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		//verifier identite
		if(controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			//si ok le client donne produit qu'il est venu acheter
			StringBuilder question1 = new StringBuilder(); 
			question1.append("Quel produit voulez-vous acheter ?");
			String produit = scan.next();
			//présenter tous les vendeurs
			Gaulois[] vendeurs = controlAcheterProduit.chercherVendeurs(produit);
			if(vendeurs.length != 0) {
				Gaulois gauloisVendeur = controlAcheterProduit.choisirVendeur(vendeurs, produit);
				
				int quantite = Clavier.entrerEntier("Combien de " + produit + " voulez-vous acheter ?");
				int quantiteAcheter = controlAcheterProduit.acheterProduit(gauloisVendeur.getNom(), quantite);
				
			}else {
				System.out.println("Désolé, personne ne vend ce produit au marché.");
			}
			
		}else {
			System.out.println("Je suis désolée " + nomAcheteur + " mais il faut être un habitant de notre village pour commercer ici.");
		}
	}
}
