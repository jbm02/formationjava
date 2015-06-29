package echec;

public class Pion extends Piece {

	public Pion(boolean couleur, int ligne, int colonne) {
		super(couleur, ligne, colonne);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String listMouv() {
		StringBuilder lmouv = new StringBuilder();
		int ligne = this.getLigne();
		int colonne = this.getColonne();
		if (this.isCouleur()) {
			if (ligne + 1 <= 8)
				lmouv.append((ligne + 1) + "-" + colonne);
		}
		else{
			if (ligne - 1 >0){
				lmouv.append((ligne - 1) + "-" + colonne);
			}
		}
		
		return lmouv.toString();
	}
}
