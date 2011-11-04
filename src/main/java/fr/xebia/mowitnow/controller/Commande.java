package fr.xebia.mowitnow.controller;

/**
 * 
 * Cette interface represente une instruction destinée à la tondeuse
 * 
 * @author Farès Hassak
 * 
 */
public interface Commande {

	/**
	 * Lance l'execution de la commande sur la tondeuse
	 */
	void execute();
}
