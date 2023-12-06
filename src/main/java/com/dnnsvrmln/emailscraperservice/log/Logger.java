package com.dnnsvrmln.emailscraperservice.log;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class Logger {

    public void logInfo(String infoMessage) {
        var formattedInfoMessage = String.format("[INFO] %s", infoMessage);
        log.error(formattedInfoMessage);
    }

    public void logWarn(String warnMessage, Object object) {
        var formattedWarnMessage = String.format("[INFO] %s", warnMessage);
        log.warn(formattedWarnMessage, object);
    }

    public void logError(String errorMessage, Object object) {
        var formattedErrorMessage = String.format("[ERROR] %s", errorMessage);
        log.error(formattedErrorMessage, object);
    }

}
