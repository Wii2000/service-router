package com.andersen.tracker.web;

import soapservice.SOAPService;
import soapservice.SOAPclassComandService;

/**
 * Этот класс дает объект SOAP сервиса-команда
 */
public class TeamServiceFactory {
    private static SOAPService instance;

    private TeamServiceFactory() {
    }

    public static SOAPService getTeamService() {
        if (instance == null) {
            instance = new SOAPclassComandService()
                    .getPort(SOAPService.class);
        }
        return instance;
    }
}
