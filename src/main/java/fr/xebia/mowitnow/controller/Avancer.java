package fr.xebia.mowitnow.controller;

import fr.xebia.mowitnow.domain.Coordonnee;
import fr.xebia.mowitnow.domain.Surface;
import fr.xebia.mowitnow.domain.Tondeuse;

/**
 * Cette classe représente la commande "avancer" de la tondeuse. Elle permet à
 * la tondeuse d'avancer d'une case dans la direction à laquelle elle fait face.
 * Si le mouvement est impossible, la tondeuse ne bouge pas et conserve son
 * orientation.
 * 
 * @author Farès Hassak
 * 
 */
public class Avancer implements Commande {

	/**
	 * La tondeuse sur laquelle la commande est exécuté.
	 */
	private Tondeuse tondeuse;

	/**
	 * La surface sur laquelle se trouve la tondeuse
	 */
	private Surface surface;

	/**
	 * Création de la commande "Avancer"
	 * 
	 * @param surface
	 *            la surface
	 * @param tondeuse
	 *            la tondeuse
	 * 
	 */
	public Avancer(Surface surface, Tondeuse tondeuse) {
		this.tondeuse = tondeuse;
		this.surface = surface;
	}

	/**
	 * Fait avancer la tondeuse d'une case en fonction de son orientation.
	 * 
	 * Si le mouvement n'est pas possible, la commande n'est pas éxécuté.
	 * 
	 * @see fr.xebia.mowitnow.controller.Commande#execute()
	 */
	public void execute() {
		Coordonnee origine = tondeuse.getCoordonnee();
		Coordonnee caseSuivante = tondeuse.getOrientation().getDirection();
		Coordonnee destination = origine.add(caseSuivante);
		if (surface.isEmplacementDisponible(destination)) {
			tondeuse.avance(destination);
		}
	}
}
