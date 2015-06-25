package Program;

public class Exofonction {

	// main
	public static void main(String[] args) {
		
//		// Test nbImpaire
//		int[] tbImp = { 1, 2, 3 };
//		System.out.println("Nombre valeurs impaires: " + nbImpaire(tbImp));
		
//		//Test estPalindrome
//		System.out.println("radar :" + estPalindrome("radar"));
//		System.out.println("toto :" + estPalindrome("toto"));
		
//		//Test estPalindromeV2
//		System.out.println("radar : " + estPalindromeV2("radar"));
//		System.out.println("toto :" + estPalindromeV2("toto"));
		
//		//Test calcInteret
//		System.out.println("Nb Année : " + calcInteret(10.0, 0.1, 15.0));
		
		//Test nbRom
		System.out.println("500 = " + nbRom(9));

	}

	// nbImpaire
	public static int nbImpaire(int[] tab) {
		int nb = 0;
		for (int n : tab) {
			if (n % 2 != 0) {
				nb++;
			}
		}
		return nb;
	}

	// estPalindrome
	public static boolean estPalindrome(String chaine) {
		String palString = "";
		for (int i = chaine.length(); i > 0; i--) {
			palString += chaine.charAt(i-1);
		}

		if (chaine.equals(palString)) {
			return true;
		} else {
			return false;
		}

	}
	
	// estPalindromeV2
	public static boolean estPalindromeV2(String chaine) {
		boolean result = true;
		for(int i=0; i<chaine.length(); i++){
			if(chaine.charAt(i)!= chaine.charAt(chaine.length()-i-1)){
				result = false;
			}
		}
		return result;
	}
	
	//calcInteret
	public static int calcInteret(double initS, double taux, double FinS){
		double somme = initS;
		int nbAnnee = 0;
		while(somme < FinS){
			somme = somme + (somme*taux);
			nbAnnee++;
		}
		return nbAnnee;
	}
	
	//nbRom
	public static String nbRom(int nDec){
		String result = "";
		int calc = nDec;
		int div;

		while(calc > 0){
			     //D
				if(calc >= 500){
					div = calc/500;;
					calc -= (div*500);
					for(int i=0; i<div; i++){result += "D";}
					continue;
					}
					
				if(calc >= 100){
					div = calc/100;;
					calc -= (div*100);
					for(int i=0; i<div; i++){result += "C";}
					continue;
					}
				if(calc >=50){
					div = calc/50;;
					calc -= (div*50);
					for(int i=0; i<div; i++){result += "L";}
					continue;
					}
					
				if(calc >=10){
					div = calc/10;;
					calc -= (div*10);
					for(int i=0; i<div; i++){result += "X";}
					continue;
					}
		
			    if(calc >=5){
					div = calc/5;;
					calc -= (div*5);
					for(int i=0; i<div; i++){result += "V";}
					continue;
			    	}
			    
			    if(calc >=1){
			    	calc--;
			    	result += "I";
			    }
		}
			
		return result;
	}
	
}
