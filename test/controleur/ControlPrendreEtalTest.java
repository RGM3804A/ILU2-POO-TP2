package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	private Village village;
	private Chef abraracourcix;
	//private ControlVerifierIdentite controlVerifierIdentite;
	
	@BeforeEach
	public void initialiserSituation(){
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		//ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
	}
	
	@Test
	void testControlPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(new ControlVerifierIdentite(village),village);
		assertNotNull(controlPrendreEtal, "Constructeur ne renvoie pas null");
	}

	@Test
	void testResteEtals() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(new ControlVerifierIdentite(village),village);
		assertTrue(controlPrendreEtal.resteEtals());
		controlPrendreEtal.prendreEtal("Asterix", "glaive", 10);
		controlPrendreEtal.prendreEtal("Obelix", "menhir", 10);
		controlPrendreEtal.prendreEtal("Abraracourcix", "glaive", 10);
		controlPrendreEtal.prendreEtal("Bonemine", "fleurs", 10);
		controlPrendreEtal.prendreEtal("Panoramix", "chaudron", 10);
		assertFalse(controlPrendreEtal.resteEtals());
	}

	@Test
	void testPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(new ControlVerifierIdentite(village),village);
		assertTrue(controlPrendreEtal.prendreEtal("Asterix", "Glaive", 10) == 0);
	}

	@Test
	void testVerifierIdentite() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(new ControlVerifierIdentite(village),village);
		assertTrue(controlPrendreEtal.verifierIdentite("Abraracourcix"));
		assertFalse(controlPrendreEtal.verifierIdentite("Asterix"));
	}

}