package icroack.icroackadventures.controler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
  * @author FroggyTeam
  * Cette classe permet de lire dans un fichier
  * de configuration.
  */
public class ConfigReader {

    Properties properties;
    String urlConf;
    String dbName;
    String login ;
    String password;


    public ConfigReader(){
        this.properties = new Properties();
        this.urlConf = "config/config.conf";
        try(FileInputStream file = new FileInputStream(urlConf)) {
            properties.load(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        this.dbName = properties.getProperty("dbname");
        this.login = properties.getProperty("login");
        this.password = properties.getProperty("password");

    }

    public String getDbName() {return dbName;}

    public String getLogin() {return login;}

    public String getPassword() {return password;}

}
