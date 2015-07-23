package com.PizzaSpy.principal;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.PizzaSpy.data.XMLImporter;
import com.PizzaSpy.util.SpyDir;

public class Program {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		XMLImporter xml = new XMLImporter("repertoires.xml");
		ArrayList<String> repList = xml.importData();
		
		ExecutorService srv = Executors.newFixedThreadPool(repList.size());
		
		for (String rep : repList) {
			srv.execute(new SpyDir("Worker_" + rep, rep));
		}
		
		System.out.println("attempting shutdown...");
		srv.shutdown();
		
		try {
			// Attend au maximum 20s que le thread pool se termine
			System.out.println("waiting for shutdown complete...");
			srv.awaitTermination(20, TimeUnit.SECONDS);
			if(reader.hasNextLine()){
				SpyDir.setMustStop(true);
				reader.close();
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
