package com.loncoto.TestThread2.principal;

import com.loncoto.TestThread2.util.CompteurPartage;
import com.loncoto.TestThread2.util.CompteurPartage2;
import com.loncoto.TestThread2.util.Worker1;
import com.loncoto.TestThread2.util.Worker2;

public class Program {

	public static void main(String[] args) {
		CompteurPartage2 compteur = new CompteurPartage2();
		Thread t1 = new Thread(new Worker2(compteur, "w1"));
		Thread t2 = new Thread(new Worker2(compteur, "w2"));
		Thread t3 = new Thread(new Worker2(compteur, "w3"));
		
		System.out.println("demarrage");
		System.out.println(compteur);
		t1.start();
		t2.start();
		t3.start();
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		System.out.println(compteur);

	}

}
