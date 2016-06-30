package com.fundacionjala.pivotalapi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by RosarioGarcia on 6/29/2016.
 */
public class PropertiesInfo {
    private static PropertiesInfo instance;

    private Properties properties;

    private PropertiesInfo() {
        loadProperties();
    }

    public static PropertiesInfo getInstance() {
        if (instance == null) {
            return new PropertiesInfo();
        }
        return instance;
    }

    private void loadProperties() {
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("pivotal.properties");
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }

    private String getProperty(String propertyKey) {
        return properties.getProperty(propertyKey);
    }
    public String getBaseUrl(){
        return getProperty("urlApi");
    }

    public String getToken(){
        return getProperty("token");
    }
}
