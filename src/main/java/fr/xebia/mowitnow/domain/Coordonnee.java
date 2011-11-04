package fr.xebia.mowitnow.domain;

/**
 * 
 * La classe Coordonnee représente des coordonnées sur la surface
 * 
 * @author Fares Hassak
 * 
 */
public class Coordonnee {

	/**
	 * Coordonnee sur la surface selon l'axe horizontal.
	 */
	private int x;

	/**
	 * Coordonnee sur la surface selon l'axe vertical.
	 */
	private int y;

	/**
	 * Constructeur
	 * 
	 * @param x
	 *            Coordonnee sur la surface selon l'axe horizontal.
	 * @param y
	 *            Coordonnee sur la surface selon l'axe vertical.
	 */
	public Coordonnee(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Additionne les coordonnees
	 * 
	 * @param coordonnee
	 *            Les coordonnees à ajouter avec celle de l'objet courant.
	 * @return La somme des coordonnees
	 */
	public Coordonnee add(Coordonnee coordonnee) {
		return new Coordonnee(this.x + coordonnee.getX(), this.y + coordonnee.getY());
	}

	/**
	 * Compare des coordonnees.
	 * 
	 * @param obj
	 *            Les coordonnees à comparer avec celle de l'objet courant.
	 * 
	 * @return true si les coordonn�es sont les mêmes, false sinon
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof Coordonnee) {
			Coordonnee coord = (Coordonnee) obj;
			isEquals = (this.x == coord.getX()) && (this.y == coord.getY());
		}
		return isEquals;
	}

	/**
	 * Retourne la coordonnee selon l'axe horizontal
	 * 
	 * @return x, la coordonnee de l'axe horizontal
	 */
	public int getX() {
		return x;
	}

	/**
	 * Retourne la coordonnee selon l'axe vertical
	 * 
	 * @return y, la coordonnee de l'axe vertical
	 */
	public int getY() {
		return y;
	}

}
