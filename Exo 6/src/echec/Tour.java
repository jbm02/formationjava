package echec;

public class Tour extends Piece {

	public Tour(boolean couleur, int ligne, int colonne) {
		super(couleur, ligne, colonne);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String listMouv() {
		StringBuilder lmouv = new StringBuilder();
		int ligne = this.getLigne();
		int colonne = this.getColonne();

		for (int i = 0; ligne+i <= 8; i++) {
			lmouv.append((ligne + i) + " " + colonne + "\n");
		}
		
		for (int j = 0; colonne+j <= 8; j++) {
			lmouv.append(ligne + " " + colonne+j + "\n");
		}

		for (int i = 0; ligne-i > 0; i++) {
			lmouv.append((ligne + i) + " " + colonne + "\n");
		}
		
		for (int j = 0; colonne-j > 0; j++) {
			lmouv.append(ligne + " " + (colonne-j) + "\n");
		}


		return lmouv.toString();
	}
}
