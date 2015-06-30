package Banque;

public class CompteSG implements ICompteBancaire {
	private double solde;

	public CompteSG(double solde) {
		this.solde = solde;
	}

	public CompteSG() {
		this.solde = 0.0;
	}

	@Override
	public void depot(double montant) {
		this.solde += montant;
	}

	@Override
	public boolean retrait(double montant) {
		if (montant > solde) {
			this.solde -= montant;
			return true;
		}
		return false;
	}

	@Override
	public double consultation() {
		return this.solde;

	}

	public String toString() {
		return "Je suis un compte SG contenant " + solde + " €";
	}
	
	public int compareTo(ICompteBancaire o) {
		if (this.consultation() < o.consultation())
			return -1;
		if (this.consultation() > o.consultation())
			return 1;
		return 0;
	}

}
