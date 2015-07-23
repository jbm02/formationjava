package com.loncoto.TestThread2.util;

public class Worker2 implements Runnable {

	private CompteurPartage2 compteur;
	private String nom;

	public Worker2(CompteurPartage2 compteur, String nom) {
		this.compteur = compteur;
		this.nom = nom;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100000000; i++) {
			compteur.augmenteCompteur();
			if (i % 10000000 == 0) {
				System.out.println(nom + " i = " + i);
			}

		}

	}
}
