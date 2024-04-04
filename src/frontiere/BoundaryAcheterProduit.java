package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;
import villagegaulois.Etal;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}
	
	public void commerceNonAutoriser(String personne) {
		System.out.println("Je suis désolée " + personne +" mais il faut être un habitant de notre village pour commercer ici.");
	}

	public void acheterProduit(String nomAcheteur) {
		if(!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			commerceNonAutoriser(nomAcheteur);
		} else {
			transaction(nomAcheteur);
		}
	}
	
	public void negociation(String nomAcheteur, String nomVendeur,String nomProduit, int quantiteAcheter, int quantite) {
		if (quantite == 0) {
			System.out.println(nomAcheteur + " veut acheter " + quantite + " " + nomProduit + ", malheureusement il n’y en a plus !”");
		}
		if (quantiteAcheter > quantite) {
			System.out.println(nomAcheteur +" veut acheter " + quantiteAcheter + " " + nomProduit +", \n"
					+ "malheureusement Bonemine n’en a plus que " + quantite + ".\n"
					+ nomAcheteur + " achète tout le stock de " + nomVendeur + ".");
		}
		else
			System.out.println(nomAcheteur + " achète " + quantiteAcheter + " " + nomProduit + " à " + nomVendeur + ".");

	}
	
	public void transaction(String nomAcheteur) {
		Etal etal = null;   String produit;//initialisation du produit et de l'étal
		produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
		Gaulois[] gauloisVendeur = controlAcheterProduit.trouverVendeurProduit(produit);
		try {
			System.out.println("Chez quel commerçant voulez-vous acheter des " + produit +" ?");
			for(int i=0; i < gauloisVendeur.length ; i++)//Affichage des Marchands
				if(controlAcheterProduit.verifierIdentite(gauloisVendeur[i].getNom()))
					System.out.println((i+1)+" - " + gauloisVendeur[i].getNom() +"\n");
			
			int numVendeur = Clavier.entrerEntier("") -1;
			if(controlAcheterProduit.verifierIdentite(gauloisVendeur[numVendeur].getNom())){//Choix et vérification de l'identité du marchand
				System.out.println(nomAcheteur + "se déplace jusqu'à l'étal du vendeur " + gauloisVendeur[numVendeur].getNom());
				etal = controlAcheterProduit.trouverEtal(gauloisVendeur[numVendeur].getNom());//récup
			}else
				commerceNonAutoriser(gauloisVendeur[numVendeur].getNom());
		} catch(NullPointerException e){
			System.out.println("Désolé, personne ne vend ce produit au marché.");
		}if(etal.isEtalOccupe() ) {
			int quantity = Clavier.entrerEntier("Bonjour, " + nomAcheteur + "Combien de fleurs voulez-vous acheter ?");
			negociation(nomAcheteur, etal.getVendeur().getNom(),produit, quantity, etal.getQuantite());
			etal.acheterProduit(quantity);
		}
	}
	
}
/*StringBuilder question = new StringBuilder();
			question.append("1 - je veux acheter un produit.\n");
			question.append("2 - je veux avoir une vue d'ensemble du marché.\n");
			question.append("3 - quitter l'application.");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch(choixUtilisateur)
				case 1:
					transaction(nomAcheteur);
					break;
				case 2:
					
					break;
			} while(choixUtilisateur != 3);*/


