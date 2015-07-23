package com.loncoto.TestThread2.util;

import java.util.concurrent.atomic.AtomicInteger;

public class CompteurPartage2 {

	private AtomicInteger compteur;


	public CompteurPartage2() {
		this.compteur = new AtomicInteger(0);
	}

	public int augmenteCompteur() {
		//l'atomic integer garentie la cohérence de des opérations
		//même en cas d'accès multiple
		return this.compteur.incrementAndGet();

	}

	@Override
	public String toString() {
		return "CompteurPartage [compteur=" + compteur.get() + "]";
	}

}
