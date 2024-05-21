package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private Properties properties;
    private final String propertyFilePath = "application.properties";

    public ConfigFileReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public void writeFileText(String validationText, String File) {
        try {
            java.io.File file = new File(File);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(validationText);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readFileText(String FileRead) {
        String textRead = null;
        try {
            FileReader reader = new FileReader(FileRead);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                textRead = line;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return textRead;
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("base.url");
        if (url != null) return url;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

    public String getApiUrl() {
        String url = properties.getProperty("api.url");
        if (url != null) return url;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

    public String getApiAgentUrl() {
        String url = properties.getProperty("api.agent.url");
        if (url != null) return url;
        else throw new RuntimeException("agent url not specified in the Configuration.properties file.");
    }

    public String getTokenSso() {
        String token = properties.getProperty("token.sso");
        if (token != null) return token;
        else throw new RuntimeException("token not specified in the Configuration.properties file.");
    }

    public String getEmail() {
        String token = properties.getProperty("dashboard.email");
        if (token != null) return token;
        else throw new RuntimeException("Email not specified in the Configuration.properties file.");
    }

    public String getPassword() {
        String token = properties.getProperty("dashboard.password");
        if (token != null) return token;
        else throw new RuntimeException("Password not specified in the Configuration.properties file.");
    }

    public String getFilePath() {
        String files = properties.getProperty("path.file");
        if (files != null) return files;
        else throw new RuntimeException("Password not specified in the Configuration.properties file.");
    }
}
