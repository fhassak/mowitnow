package fr.xebia.mowitnow.domain;

/**
 * Represente la liste des pivots possible : droite et gauche Chaque pivot est
 * défini à l'aide d'une valeur numérique indiquant le sens dans lequel
 * effectuer le pivot. Cette valeur permet de déterminer la nouvelle
 * orientation.
 * 
 * @author Farès Hassak
 * 
 */
public enum Pivot {

	/**
	 * DROITE
	 */
	D(1),

	/**
	 * GAUCHE
	 */
	G(-1);

	/**
	 * Valeur du pivot
	 */
	private int valeur;

	/**
	 * Constructeur
	 * 
	 * @param pivot
	 *            la valeur du pivot
	 */
	private Pivot(int valeur) {
		this.valeur = valeur;
	}

	/**
	 * Retourne la valeur du pivot
	 * 
	 * @return la valeur du pivot
	 */
	public int getValeur() {
		return valeur;
	}

}
