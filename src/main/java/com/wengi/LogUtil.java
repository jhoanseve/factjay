/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wengi;

import org.slf4j.Logger;

/**
 *
 * @author jhoanseve2
 */
public class LogUtil {
    
    public static void logInfo(Logger logger, String msg, Object ... params) {
        if(logger.isInfoEnabled())
            logger.info(msg, params);
    }
    
    public static void logDebug(Logger logger, String msg, Object ... params) {
        if(logger.isDebugEnabled())
            logger.debug(msg, params);
    }
}
