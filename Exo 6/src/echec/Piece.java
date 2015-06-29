package echec;

public abstract class Piece {
	private boolean couleur;
	private int ligne;
	private int colonne;
	
	public Piece(boolean couleur, int ligne, int colonne){
		this.couleur = couleur;
		this.ligne = ligne;
		this.colonne = colonne;
	}
	
	public boolean isCouleur() {
		return couleur;
	}
	public void setCouleur(boolean couleur) {
		this.couleur = couleur;
	}
	public int getLigne() {
		return ligne;
	}
	public void setLigne(int ligne) {
		this.ligne = ligne;
	}
	public int getColonne() {
		return colonne;
	}
	public void setColonne(int colonne) {
		this.colonne = colonne;
	}
	
	public abstract String listMouv();
	
}
