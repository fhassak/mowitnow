package fr.xebia.mowitnow.domain;

import java.util.Observable;
import java.util.Observer;

/**
 * La classe Surface représente la pelouse rectangulaire sur laquelle se
 * trouvent les tondeuses.
 * 
 * Elle est défini par les coordonnées du coin supérieur droit, celles du coin
 * inférieur gauche étant (0,0).
 * 
 * La surface est divisé en grille afin de faciliter la navigation.
 * 
 * @author Farès Hassak
 * 
 */
public class Surface implements Observer {

	/**
	 * Coordonnee du coin supérieur droit
	 */
	private Coordonnee coinSuperieurDroit;

	/**
	 * Coordonnee du coin inférieur gauche
	 */
	private static final Coordonnee coinInferieurGauche = new Coordonnee(0, 0);

	/**
	 * Surface contenant les tondeuses,
	 * 
	 * tondeuses[x][y] est null si aucune tondeuse n'est présente aux
	 * coordonnées (x,y).
	 */
	private Tondeuse[][] tondeuses;

	/**
	 * Creation de la surface à partir des coordonnées du coin supérieur droit.
	 * 
	 * @param x
	 *            abscisse du coin supérieur droit
	 * @param y
	 *            ordonnee du coin supérieur droit
	 * 
	 * @throws IllegalArgumentException
	 *             si l'abscisse ou l'ordonnée est négative
	 */
	public Surface(int x, int y) {
		if ((x < 0) || (y < 0)) {
			throw new IllegalArgumentException("Impossible de creer la surface.");
		}
		this.coinSuperieurDroit = new Coordonnee(x, y);
		this.tondeuses = new Tondeuse[x + 1][y + 1];
	}

	/**
	 * Ajoute une tondeuse sur la surface à l'emplacement défini par les
	 * coordonnées de la tondeuse
	 * 
	 * @param tondeuse
	 *            la tondeuse
	 * 
	 * @throws IllegalArgumentException
	 *             si l'emplacement n'est pas disponible
	 */
	public void placerTondeuse(Tondeuse tondeuse) {
		Coordonnee coordonnee = tondeuse.getCoordonnee();
		if (!isEmplacementDisponible(coordonnee)) {
			throw new IllegalArgumentException("Impossible de placer la tondeuse");
		}
		int x = coordonnee.getX();
		int y = coordonnee.getY();
		tondeuses[x][y] = tondeuse;
		tondeuse.addObserver(this);
	}

	/**
	 * Vérifie si une emplacement est disponible sur la surface. L'emplacement
	 * doit etre à l'interieur de la surface et ne doit pas contenir de
	 * tondeuse.
	 * 
	 * @param coordonnee
	 *            coordonnee de l'emplacement
	 * @return true, si l'emplacement est disponible , false sinon
	 */
	public boolean isEmplacementDisponible(Coordonnee coordonnee) {
		boolean isDisponible;
		int x = coordonnee.getX();
		int y = coordonnee.getY();
		isDisponible = (isInterieur(coordonnee) && tondeuses[x][y] == null);
		return isDisponible;
	}

	/**
	 * Verifie si les coordonnées appartiennent à la surface.
	 * 
	 * @param coordonnee
	 *            les coordonnées
	 * @return true si ces coordonnées sont à l'intérieur de la surface, false
	 *         sinon
	 */
	private boolean isInterieur(Coordonnee coordonnee) {
		int x = coordonnee.getX();
		int y = coordonnee.getY();
		boolean abscisseValide = (x >= coinInferieurGauche.getX()) && (x <= coinSuperieurDroit.getX());
		boolean ordonneeValide = (y >= coinInferieurGauche.getY()) && (y <= coinSuperieurDroit.getY());
		return abscisseValide && ordonneeValide;
	}

	/**
	 * Cette méthode est appelée lorsque la tondeuse avance sur le plateau. Elle
	 * permet de mettre à jour l'emplacement de la tondeuse sur la surface.
	 * 
	 * @param observable
	 *            La tondeuse avec ses nouvelles coordonnées.
	 * @param arg
	 *            Les coordonnées précédentes de la tondeuse.
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(Observable observable, Object arg) {
		Coordonnee origine = (Coordonnee) arg;
		Tondeuse tondeuse = (Tondeuse) observable;
		tondeuses[origine.getX()][origine.getY()] = null;
		tondeuses[tondeuse.getCoordonnee().getX()][tondeuse.getCoordonnee().getY()] = tondeuse;
	}
}
