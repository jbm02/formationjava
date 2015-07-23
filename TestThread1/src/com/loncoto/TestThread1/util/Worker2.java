package com.loncoto.TestThread1.util;

public class Worker2 extends Thread {
	
	private String nom;
	private boolean mustStop;
	
	public  Worker2(String nom) {
		this.nom = nom;
		mustStop = false;
	}
	
	public void setMustStop(boolean mustStop) {
		this.mustStop = mustStop;
	}
	
	@Override
	public void run() {
		double d = 0.0;
		for(long l= 0; l < 10000000000L; l++){
			d = Math.sqrt(1.0+l);
			d = d*2.0;
			if (l % 100000000 == 0) {
				System.out.println(nom + ": l = " + l + " d = " + d);
				if (mustStop) {
					System.out.println(nom + " a recu l'ordre de s'arreter");
					return;
				}
			}
		}
	}
}
