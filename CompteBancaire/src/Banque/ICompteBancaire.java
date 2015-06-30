package Banque;

public interface ICompteBancaire extends Comparable<ICompteBancaire>{
	public void depot(double montant);
	public boolean retrait(double montant);
	public double consultation();
}
