package com.PizzaSpy.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


public class LogManager {
	
	private static LogManager instance = null;
	private File logFile;
	private PrintWriter pw;
	
	private LogManager(){
		logFile = new File("spylog");
		
		try {
			if (!logFile.exists()) {
				logFile.createNewFile();
			}
			pw = new PrintWriter(logFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static LogManager getInstance(){
		if (instance == null) {
			instance = new LogManager();	
		}
		return instance;
	}
	
	public synchronized void writeLog(String log){
		pw.println(new Date() + ": " +  log);
		pw.flush();
	}

}
