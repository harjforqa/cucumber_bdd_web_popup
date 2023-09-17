package utilities;

import java.io.IOException;

public class GetArgumentUtil {

    public static String url;
    public static String env = System.getProperty("env");
    public static String browser = System.getProperty("browser");

    public static String getCustomURL() throws IOException {
        if (env == null) {
            env = ConfigReadUtil.getPropertyValue("defaultEnv"); //default testing environment
        }

        url = ("https://www." + env + ".in/").toLowerCase();
        System.out.println("sout url:" + url);
        LogUtil.info(GetArgumentUtil.class, "Base URL: " + url);
        return url;
    }

    public static String getBrowser() throws IOException {
        if (browser == null) {
            browser = ConfigReadUtil.getPropertyValue("defaultBrowser");
        }
        return browser;
    }
}
