package com.loncoto.TestThread2.util;

import java.util.concurrent.atomic.AtomicInteger;

public class CompteurPartage2 {

	private AtomicInteger compteur;


	public CompteurPartage2() {
		this.compteur = new AtomicInteger(0);
	}

	public int augmenteCompteur() {
		//l'atomic integer garentie la coh�rence de des op�rations
		//m�me en cas d'acc�s multiple
		return this.compteur.incrementAndGet();

	}

	@Override
	public String toString() {
		return "CompteurPartage [compteur=" + compteur.get() + "]";
	}

}
