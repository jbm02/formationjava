package Principal;

import java.util.ArrayList;
import java.util.Random;

import Banque.*;

public class Program {

	public static void main(String[] args) {

//		Random rd = new Random();
//		ArrayList<ICompteBancaire> list = new ArrayList<ICompteBancaire>();
//
//		for (int i = 0; i < 5; i++) {
//			if (rd.nextBoolean()) {
//				list.add(new CompteLCL(1000));
//			} else {
//				list.add(new CompteSG());
//			}
//		}
//
//		for (ICompteBancaire c : list) {
//			System.out.println(c.toString());
//		}

		ArrayList<ICompteBancaire> list_trans = new ArrayList<ICompteBancaire>();
		list_trans.add(new CompteLCL(1000));
		list_trans.add(new CompteSG(0));

		if (transfert(list_trans.get(0), list_trans.get(1), 250)) {
			System.out.println("--------------------------");
			System.out.println("Transfert réussi");
			System.out.println(list_trans.get(0).toString());
			System.out.println(list_trans.get(1).toString());
		}
		else{
			System.out.println("Transfert echoué");
		}
	}

	public static boolean transfert(ICompteBancaire source,
			ICompteBancaire destination, double montant) {

		if (source.retrait(montant)) {
			destination.depot(montant);
			return true;
		} else {
			return false;
		}

	}
}
