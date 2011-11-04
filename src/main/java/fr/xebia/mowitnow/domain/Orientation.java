package fr.xebia.mowitnow.domain;

/**
 * Représente la liste des orientations possibles selon la notation anglaise :
 * Nord, Est, Sud, Ouest.
 * 
 * Cette liste est triée afin de faciliter le changement d'orientation
 * (gauche,droite).
 * 
 * Chaque orientation est défini par une coordonnée indiquant la direction selon
 * l'axe honrizontal et vertical. Par exemple, la case directement au Nord de la
 * position (x, y) a pour coordonnées (x, y+1), soit la coordonnee (0,1).
 * 
 * @author Farès Hassak
 * 
 */
public enum Orientation {

	/**
	 * NORD
	 */
	N(new Coordonnee(0, 1)),

	/**
	 * EST
	 */
	E(new Coordonnee(1, 0)),

	/**
	 * SUD
	 */
	S(new Coordonnee(0, -1)),

	/**
	 * OUEST
	 */
	W(new Coordonnee(-1, 0));

	/**
	 * Indique la direction de l'orientation sous forme d'une coordonnée
	 */
	private Coordonnee direction;

	/**
	 * Constructeur
	 * 
	 * @param direction
	 * 
	 */
	private Orientation(Coordonnee direction) {
		this.direction = direction;
	}

	/**
	 * Retourne la direction
	 * 
	 * @return la coordonnee indiquant la direction
	 */
	public Coordonnee getDirection() {
		return this.direction;
	}
}
