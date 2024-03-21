package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlTrouverEtalVendeur {
	private Village village;

	public ControlTrouverEtalVendeur(Village village) {
		this.village = village;
	}

	public Etal trouverEtalVendeur(String nomVendeur) {
		Gaulois gauloisVendeur = village.trouverHabitant(nomVendeur);
		Etal etal = null;
		if(gauloisVendeur != null)
			etal = village.rechercherEtal(gauloisVendeur);
		return etal;
	}
}
