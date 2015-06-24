import java.util.Scanner;

public class Notes {

	public static void main(String[] args) {
		
		System.out.println("Nombre de Notes ? ");
		//Init Scanner
		Scanner reader = new Scanner(System.in);
		int nb_notes = Integer.parseInt(reader.nextLine());
		
		//Déclarations
		double[] tab_notes = new double[nb_notes];
		double moyenne = 0;
		double min = 21.0;
		double max = -1.0;
		int nbn_zero = 0;
		
		//Lecture des notes
		for (int i=0; i<tab_notes.length; i++){
			System.out.println("Saisir note n°" + (i+1));
			tab_notes[i] = Double.parseDouble(reader.nextLine());
			
			// Calcul de la moyenne + minimum + maximum	
			moyenne += tab_notes[i];
			
			if(tab_notes[i] > max){
				max = tab_notes[i];
				}
			if(tab_notes[i] < min){
				min = tab_notes[i];
			}
		}
		moyenne = moyenne / nb_notes;
		
		//Calcul nombre note > moyenne
		for (double note : tab_notes){
			if(note > moyenne){
				nbn_zero++;
			}
		}
		//Affichage résultat
		System.out.println("Moyenne = " + moyenne);
		System.out.println("Note minimum = " + min);
		System.out.println("Note maximum = " + max);
		System.out.println("Nombre note > moyenne = " + nbn_zero);
		
		//Close Scanner
		reader.close();

	}
}
