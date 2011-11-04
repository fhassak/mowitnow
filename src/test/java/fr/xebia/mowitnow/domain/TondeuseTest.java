package fr.xebia.mowitnow.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.xebia.mowitnow.controller.Avancer;
import fr.xebia.mowitnow.controller.Controlleur;
import fr.xebia.mowitnow.controller.PivoterDroite;
import fr.xebia.mowitnow.controller.PivoterGauche;

public class TondeuseTest {

	@Test
	public void test() {

		Controlleur controlleur = new Controlleur();

		Surface surface = new Surface(5, 5);

		// TONDEUSE 1
		Tondeuse tondeuse1 = new Tondeuse(1, 2, Orientation.N);
		surface.placerTondeuse(tondeuse1);

		// INSTRUCTIONS
		PivoterGauche pivoterGauche1 = new PivoterGauche(tondeuse1);
		Avancer avancer = new Avancer(surface, tondeuse1);
		controlleur.execute(pivoterGauche1);
		controlleur.execute(avancer);
		controlleur.execute(pivoterGauche1);
		controlleur.execute(avancer);
		controlleur.execute(pivoterGauche1);
		controlleur.execute(avancer);
		controlleur.execute(pivoterGauche1);
		controlleur.execute(avancer);
		controlleur.execute(avancer);
		assertEquals(1, tondeuse1.getCoordonnee().getX());
		assertEquals(3, tondeuse1.getCoordonnee().getY());
		assertEquals(Orientation.N, tondeuse1.getOrientation());

		// TONDEUSE 2
		Tondeuse tondeuse2 = new Tondeuse(3, 3, Orientation.E);
		surface.placerTondeuse(tondeuse2);

		// INSTRUCTIONS
		PivoterDroite pivoterDroite2 = new PivoterDroite(tondeuse2);
		Avancer avancer2 = new Avancer(surface, tondeuse2);
		controlleur.execute(avancer2);
		controlleur.execute(avancer2);
		controlleur.execute(pivoterDroite2);
		controlleur.execute(avancer2);
		controlleur.execute(avancer2);
		controlleur.execute(pivoterDroite2);
		controlleur.execute(avancer2);
		controlleur.execute(pivoterDroite2);
		controlleur.execute(pivoterDroite2);
		controlleur.execute(avancer2);
		assertEquals(5, tondeuse2.getCoordonnee().getX());
		assertEquals(1, tondeuse2.getCoordonnee().getY());
		assertEquals(Orientation.E, tondeuse2.getOrientation());

	}
}
