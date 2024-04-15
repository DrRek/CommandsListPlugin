package it.loneliness.mc.commandslistplugin.Model;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LogHandler {
    private String prefix;
    private Logger logger;
    private boolean debug = false;
    
    public LogHandler(Logger logger) {
        this.logger = logger;
        this.prefix = "[CommandsList] ";
        
        log("Logging ready");
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
        if (debug) {
            log("Debugging is ON");
        }
    }

    public void log(String msg, Level loggingLevel) {
        logger.log(loggingLevel, this.prefix+msg);
    }

    public void log(String msg) {
        log(msg, debug ? Level.INFO : Level.CONFIG);
    }

    public void info(String msg) {
        log(msg, Level.INFO);
    }

    public void warning(String msg) {
        log(msg, Level.WARNING);
    }

    public void severe(String msg) {
        log(msg, Level.SEVERE);
    }
}
