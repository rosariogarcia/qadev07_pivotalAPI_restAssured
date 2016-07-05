package com.fundacionjala.pivotalapi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * Created by RosarioGarcia on 6/29/2016.
 */
public class PropertiesInfo {
    private static final Logger LOGGER = Logger.getLogger(PropertiesInfo.class);
    private static final String PIVOTAL_PROPERTIES = "pivotal.properties";
    private static final String URL_API = "urlApi";
    private static final String TOKEN = "token";
    private static final String PROXY = "proxy";
    private static PropertiesInfo instance;

    private Properties properties;

    private PropertiesInfo() {
        loadProperties();
    }

    public static PropertiesInfo getInstance() {
        if (instance == null) {
            instance = new PropertiesInfo();
        }
        return instance;
    }

    private void loadProperties() {
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(PIVOTAL_PROPERTIES);
            properties.load(fileInputStream);
            fileInputStream.close();
            LOGGER.info("Properties file loaded succesfully.");
        } catch (FileNotFoundException e) {
            LOGGER.fatal("Properties file not found."+e.getMessage());
        } catch (IOException e) {
            LOGGER.fatal("Properties file error."+e.getMessage());
        }
    }

    private String getProperty(String propertyKey) {
        return properties.getProperty(propertyKey);
    }

    public String getBaseUrl() {
        return getProperty(URL_API);
    }

    public String getToken() {
        return getProperty(TOKEN);
    }

    public String getProxy() {
        return getProperty(PROXY);
    }
}
