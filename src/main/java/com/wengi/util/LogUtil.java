/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wengi.util;

import org.slf4j.Logger;

/**
 *
 * @author jhoanseve2
 */
public interface LogUtil {
    
    default public void logInfo(Logger logger, String msg, Object ... params) {
        if(logger.isInfoEnabled())
            logger.info(msg, params);
    }
    
    default public void logDebug(Logger logger, String msg, Object ... params) {
        if(logger.isDebugEnabled())
            logger.debug(msg, params);
    }
}
