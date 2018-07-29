package ru.testhub.portal;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TomcatStarter
{
    private static final String WEB_XML_LOCATION = "WEB-INF/web.xml";

    public static void main(String[] args) throws LifecycleException, ServletException, URISyntaxException
    {
        Path baseLocation = Paths.get(getResource("")).getParent().resolve("tomcat").toAbsolutePath();
        Path webAppLocation = Paths.get(getResource(WEB_XML_LOCATION)).getParent().getParent().toAbsolutePath();

        Tomcat tomcat = new Tomcat();

        tomcat.setBaseDir(baseLocation.toString());
        tomcat.setPort(8080);
        tomcat.getConnector();
        tomcat.addWebapp("", webAppLocation.toString());
        tomcat.start();
        tomcat.getServer().await();
    }

    private static URI getResource(String name) throws URISyntaxException, IllegalStateException
    {
        URL url = TomcatStarter.class.getClassLoader().getResource(name);

        if (url == null)
            throw new IllegalStateException("Resource '" + name + "' not found!");

        return url.toURI();
    }
}
