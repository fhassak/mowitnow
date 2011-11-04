package fr.xebia.mowitnow.controller;

import fr.xebia.mowitnow.domain.Pivot;
import fr.xebia.mowitnow.domain.Tondeuse;

/**
 * Cette classe représente la commande "pivoter à droite" de la tondeuse.
 * 
 * @author Farès Hassak
 * 
 */
public class PivoterDroite implements Commande {

	/**
	 * La tondeuse sur laquelle s'effectue la commande.
	 */
	private Tondeuse tondeuse;

	/**
	 * Creation de la commande
	 * 
	 * @param tondeuse
	 *            la tondeuse
	 */
	public PivoterDroite(Tondeuse tondeuse) {
		this.tondeuse = tondeuse;
	}

	/**
	 * Fait pivoter la tondeuse à droite
	 * 
	 * @see fr.xebia.mowitnow.controller.Commande#execute()
	 */
	public void execute() {
		tondeuse.pivoter(Pivot.D);
	}

}
