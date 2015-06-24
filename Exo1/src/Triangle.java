// Classe Triangle

import java.util.Scanner;

public class Triangle {

	// Main
	public static void main(String[] args) {

		int n;

		System.out.println("Choisir une taille :");
		// Scanner
		Scanner reader = new Scanner(System.in);
		n = reader.nextInt();

		for (int i = 0; i < n; i++) {

			for (int j = 0; j < n - i; j++) {

				// Test des bords
				if (j == 0 || i == 0 || j == n - i - 1) {
					System.out.print("x");
				} else {
					System.out.print("o");
				}
			}

			System.out.println();
		}
		// Fermeture Scanner
		reader.close();
	}
}
