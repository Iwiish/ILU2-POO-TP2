package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					System.out.println("Bienvenue villageois" + nomVisiteur);
					StringBuilder questionV1 = new StringBuilder(); 
					question.append("Quelle est votre force ?"); 
					int force = Clavier.entrerEntier(question.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur, force);
					
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		
		System.out.println("Bienvenue druide" + nomVisiteur);
		StringBuilder questionD1 = new StringBuilder(); 
		questionD1.append("Quelle est votre force ?"); 
		int forceDruide = Clavier.entrerEntier(questionD1.toString());
		
		int effetPotionMax;
		int effetPotionMin;
		
		do {
			StringBuilder questionD2 = new StringBuilder(); 
			questionD2.append("Quelle est la force de la potion la plus faible que vous produisez ?");
			effetPotionMin = Clavier.entrerEntier(questionD2.toString());
			
			StringBuilder questionD3 = new StringBuilder(); 
			questionD3.append("Quelle est la force de la potion la plus forte que vous produisez ?");
			effetPotionMax = Clavier.entrerEntier(questionD3.toString());
			
			if(effetPotionMax<effetPotionMin) {
				System.out.println("Attention Druide, vous vous êtes trompé entre le minimum et le maximum");
			}
		}while(effetPotionMax<effetPotionMin);
		
		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetPotionMin, effetPotionMax);
			
	}
	
	
}
