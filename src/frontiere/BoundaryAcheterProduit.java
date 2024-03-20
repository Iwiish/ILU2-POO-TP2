package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if(controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			System.out.println("Quel produit voulez-vous acheter ?");
			String produit = scan.next();
			
			String[] listeCommercant = controlAcheterProduit.listeCommercant(produit);
			
			if(listeCommercant.length == 0) {
				System.out.println("Désolé personne ne vend ce produit");
			}else {
				for(int i = 0; i<listeCommercant.length; i ++) {
					System.out.println((i+1) + ". " + listeCommercant[i]);
				}
				
				int numCommercant;
	            while (true) {
	                numCommercant = Clavier.entrerEntier("Chez quel commercant voulez-vous acheter vos " + produit);
	                if (numCommercant >= 1 && numCommercant <= listeCommercant.length) {
	                    break;
	                } else {
	                    System.out.println("Veuillez entrer un chiffre positif et inférieur ou égal à " + listeCommercant.length);
	                }
	            }

		        System.out.println(numCommercant);
		        
				String nomVendeur = listeCommercant[numCommercant-1];
				
				int quantite = Clavier.entrerEntier("Combien de " + produit + " voulez-vous acheter ?");
				
				int quantiteAchete = controlAcheterProduit.acheterProduit(nomVendeur, quantite);
				
				if(quantiteAchete<quantite && quantiteAchete != 0) {
					System.out.println(nomAcheteur + " veut acheter " + quantite + " " + produit 
							+ ", malheureusement il n'en reste que " + quantiteAchete + "." + nomAcheteur + " vide le stock de " + nomVendeur);
				}else if(quantiteAchete == 0) {
					System.out.println(nomAcheteur + " veut acheter " + quantite + " " + produit 
							+ ", malheureusement il n'y en a plus.");
				}else {
					System.out.println(nomAcheteur + " achète " + quantite + " " + produit + ".");
				}
			
		}
	}else {
		System.out.println("Je suis désolée " + nomAcheteur + " mais il faut être un habitant de notre village pour commercer ici.");
	}

	}
	
}

