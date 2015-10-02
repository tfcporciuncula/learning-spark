package xyz.javalab.spark;

import static spark.Spark.*;

public class $2_RequestAndResponse {

    public static void main(String[] args) {
        /*
         * Both Spark's Request and Response objects hold an HttpServletRequest and
         * HTTPServletResponse instances, but they provide a layer for simple calls.
         */
        get("/request", (req, res) -> buildRequestInformationPage(req));

        get("/redirect",  (req, res) -> {
            res.cookie("REDIRECT", "TRUE");
            res.redirect("/request", 301);
            return "";
        });

        get("/forbidden", (req, res) -> {
            res.status(403);
            return "Forbidden!";
        });
    }

    private static String buildRequestInformationPage(spark.Request req) {
        String page = "<h1>Request Information</h1></br>";

        page += "Protocol: </br>"        + req.protocol()      + "</br></br>";
        page += "Request headers: </br>" + req.headers()       + "</br></br>";
        page += "Host: </br>"            + req.host()          + "</br></br>";
        page += "Port: </br>"            + req.port()          + "</br></br>";
        page += "URL: </br>"             + req.url()           + "</br></br>";
        page += "Path: </br>"            + req.pathInfo()      + "</br></br>";
        page += "Method: </br>"          + req.requestMethod() + "</br></br>";
        page += "IP Address: </br>"      + req.ip()            + "</br></br>";
        page += "Attributes: </br>"      + req.attributes()    + "</br></br>";
        page += "Parameters: </br>"      + req.queryParams()   + "</br></br>";
        page += "Cookies: </br>"         + req.cookies()       + "</br></br>";
        page += "Raw: </br>"             + req.raw()           + "</br></br>";

        return page;
    }

}
