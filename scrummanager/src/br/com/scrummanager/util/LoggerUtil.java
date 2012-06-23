/**
 * 
 */
package br.com.scrummanager.util;

import org.apache.log4j.Logger;

/**
 * @author Rodolfo Chaves Fernandes
 * @date 03/03/2011
 */
public class LoggerUtil {

	private static Logger logger;

	public static void warn(String msg, Class<?> classe) {
		logger = Logger.getLogger(classe.getName());
		logger.warn(msg);
	}
	
	public static void fatal(String msg, Class<?> classe) {
		logger = Logger.getLogger(classe.getName());
		logger.fatal(msg);
	}
	
	public static void error(String msg, Class<?> classe) {
		logger = Logger.getLogger(classe.getName());
		logger.error(msg);
	}
	
	public static void info(String msg, Class<?> classe) {
		logger = Logger.getLogger(classe.getName());
		logger.info(msg);
	}
	
}
