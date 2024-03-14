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
		StringBuilder chaine = new StringBuilder();
		if(nomVendeurConnu) {
			chaine.append("Je suis désolé, " + nomVendeur + " mais il faut être un habitant d'ici.");
		}
	}

	private void installerVendeur(String nomVendeur) {
		//TODO a completer
	}
}
