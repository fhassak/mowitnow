package fr.xebia.mowitnow.controller;

/**
 * Cette classe permet d'envoyer une commande à la tondeuse (pivoter, avancer).
 * 
 * @author Farès Hassak
 * 
 */
public class Controlleur {

	/**
	 * Lance l'éxecution d'une commande.
	 * 
	 * @param commande
	 *            la commande à executer
	 */
	public void execute(Commande commande) {
		commande.execute();
	}
}
