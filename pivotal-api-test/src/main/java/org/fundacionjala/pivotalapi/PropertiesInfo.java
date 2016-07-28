package org.fundacionjala.pivotalapi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * This class is a Singleton class to load
 * the variables specified in the Properties file
 *
 * @author RosarioGarcia
 */
public class PropertiesInfo {
    private static final Logger LOGGER = Logger.getLogger(PropertiesInfo.class);
    private static final String PIVOTAL_PROPERTIES = "pivotal.properties";
    private static final String URL_API = "urlApi";
    private static final String TOKEN = "token";
    private static final String PROXY = "proxy";
    private static PropertiesInfo instance;

    private Properties properties;

    /**
     * private constructor class to avoid
     * a new instance from other class
     * <p>
     * This load the properties file
     */
    private PropertiesInfo() {
        loadProperties();
    }

    /**
     * In this method make a new instance
     * if the instance is null
     *
     * @return instance
     */
    public static PropertiesInfo getInstance() {
        if (instance == null) {
            instance = new PropertiesInfo();
        }
        return instance;
    }

    /**
     * This method load values of variables
     * specified in the properties file
     */
    private void loadProperties() {
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(PIVOTAL_PROPERTIES);
            properties.load(fileInputStream);
            fileInputStream.close();
            LOGGER.info("Properties file loaded succesfully.");
        } catch (FileNotFoundException e) {
            LOGGER.fatal("Properties file not found." + e.getMessage());
        } catch (IOException e) {
            LOGGER.fatal("Properties file error." + e.getMessage());
        }
    }

    /**
     * This method extract the value of variable by property Key
     *
     * @param propertyKey
     * @return property value
     */
    private String getProperty(String propertyKey) {
        return properties.getProperty(propertyKey);
    }

    /**
     * @return URL_API
     */
    public String getBaseUrl() {
        return getProperty(URL_API);
    }

    /**
     * @return TOKEN
     */
    public String getToken() {
        return getProperty(TOKEN);
    }

    /**
     * @return PROXY
     */
    public String getProxy() {
        return getProperty(PROXY);
    }
}
