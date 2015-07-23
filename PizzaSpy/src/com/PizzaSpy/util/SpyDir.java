package com.PizzaSpy.util;

import java.io.File;
import java.util.ArrayList;

public class SpyDir implements Runnable {

	private String nom;
	private String path;
	private File rep;
	private ArrayList<File> fileList;
	private LogManager lm;
	private static boolean mustStop = false;

	public SpyDir(String nom, String path) {
		this.nom = nom;
		this.path = path;
		rep = new File(path);
		fileList = new ArrayList<File>();

		for (File file : rep.listFiles()) {
			fileList.add(file);
		}
		
		lm = LogManager.getInstance();
	}

	public static void setMustStop(boolean stop){
		mustStop = stop;
	}
	
	@Override
	public void run() {
		
		while (!mustStop) {
			scanDir();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private void scanDir() {
		ArrayList<File> currentList = new ArrayList<File>();
		ArrayList<File> deletedList = new ArrayList<File>();
		ArrayList<File> addedList = new ArrayList<File>();
		for (File file : rep.listFiles()) {
			currentList.add(file);
		}
		

		for (File fold : fileList) {
			if (!currentList.contains(fold)) {
				deletedList.add(fold);
				System.out.println(nom + ": " + path + "/" + fold.getName() + " supprimé !");
				lm.writeLog(nom + ": " + path + "/" + fold.getName() + " supprimé !");
			}
		}
		
		for (File fnew : currentList) {
			if (!fileList.contains(fnew)) {
				addedList.add(fnew);
				System.out.println(nom + ": " + path + "/" + fnew.getName() + " créé !");
				lm.writeLog(nom + ": " + path + "/" + fnew.getName() + " créé !");
			}
		}
		
		this.fileList = currentList;
	}

}
