package org.apache.commons.logging;

import org.apache.commons.logging.Log;

public class LogFactory {

	public static Log getLog(Class clazz){
		return new Log();
	}
}
