package org.apache.commons.logging;

public class Log {
	String suffix = "[/WEB-INF/classes]";
	
	
	public String toString(){
		
		return "ClassLoadingExampleWeb " + suffix;
	}

	public void info(Object msg) {
		System.out.println(msg.toString());
	}
}
