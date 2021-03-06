/**
 * Copyright(C), 2015, Luvina Software Company
 * MessageProperties.java, Jul 8, 2015, Nguyễn Trường Quân
 */
package net.luvina.manageuser.utils;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author LA-AM
 *
 */
@SuppressWarnings("unchecked")
public class MessageProperties {

	static private Map<String, String> data = new HashMap<String, String>();

    /**
     *
     */
    static {
        Properties prop = new Properties();
        try {
            //prop.load(MessageProperties.class.getResourceAsStream(("/message.properties")));
        	prop.load(MessageProperties.class.getResourceAsStream(("/messageMessageJP.properties")));
            prop.load(MessageProperties.class.getResourceAsStream(("/messageTableJP.properties")));
            prop.load(MessageProperties.class.getResourceAsStream(("/messageErrorJP.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Enumeration<String> en  = (Enumeration<String>)prop.propertyNames();
        while (en.hasMoreElements()) {
            String key = (String)en.nextElement();
            data.put(key, prop.getProperty(key));
        }
    }



    /**
     * getData from file properties
     * @param key key
     * @return String
     */
    static public String getMessage(String key) {
        String string = "";
        if (data.containsKey(key)) {
            string = data.get(key);
        }
        return string;
    }
}
