package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = controlAfficherMarche.demanderInfoMarche();
		StringBuilder chaine = new StringBuilder();
		if(infosMarche.length == 0) {
			chaine.append("Le marche est vide, revenez plus tard.");
			System.out.println(chaine.toString());
		} else {
			chaine.append(nomAcheteur + ", vous trouverez au marché : \n")
			for(int i=0;i<infosMarche.length;i++) {
				chaine.append("-" + infosMarche[i] + " qui vend ");
				i++;
				chaine.append(infosMarche[i] + " ");
				i++;
				chaine.append(infosMarche[i] + ".");
			}System.out.println(chaine.toString());
		}
	}
}
