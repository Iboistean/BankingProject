package com.bankingproject.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {


        Properties prop;

    // We need to create an constructor

    public ReadConfig() {

        File src = new File("./Configuration/config.properties");
        try {

            FileInputStream fis = new FileInputStream(src);
            prop = new Properties();
            prop.load(fis);

        } catch (IOException e) {
            System.out.println("Excetion is " + e.getMessage());
        }

    }


    public String getApplicationURL ()
    {
        String url = prop.getProperty("baseURL");
        return url;


    }


    public String getUsername ()
    {
        String username = prop.getProperty("username");
        return username;


    }


    public String getPassword ()
    {
        String password = prop.getProperty("password");
        return password;


    }


    public String getChromePath ()
    {
        String chromepath = prop.getProperty("chromepath");
        return chromepath;


    }

    public String getFireFoxPath ()
    {
        String firefoxpath = prop.getProperty("firefoxpath");
        return firefoxpath;


    }


    public String getSafariPath ()
    {
        String safaripath = prop.getProperty("safaripath");
        return safaripath;


    }
}





