package xyz.javalab.spark;

import static spark.Spark.*;

public class $5_Utilities {

    public static void main(String[] args) {
        /*
         * This is how you set on which port the application will run.
         */
        port(8080);

        /*
         * And this is how you map static files. The folder must be in the classpath
         * and will be made available as http://host:port/mappedFolder
         */
        staticFileLocation("/static");
        get("/spark", (req, res) -> "<img src=\"img/spark.svg\">");

        /*
         * The number of threads can be changed.
         */
        int maxThreads = 8;
        int minThreads = 2;
        int timeOutMillis = 30000; // thread idle timeout (ms)
        threadPool(maxThreads, minThreads, timeOutMillis);

        /*
         * There is a way to wait for the server initialization. This is useful if you have another
         * thread that wants to run something (e.g. health check) right after the server is up.
         */
        // awaitInitialization();

        /*
         * SSL support is given by the secure() method.
         */
        // secure(keystoreFile, keystorePassword, truststoreFile, truststorePassword);
    }

}
