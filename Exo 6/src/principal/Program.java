package principal;

import echec.*;

public class Program {

	public static void main(String[] args) {
		Pion p = new Pion(false, 2, 3);
		System.out.println(p.listMouv());
	}

}
