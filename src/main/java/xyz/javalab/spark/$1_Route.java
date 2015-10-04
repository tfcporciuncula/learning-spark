package xyz.javalab.spark;

import static spark.Spark.*;

public class $1_Route {

    public static void main(String[] args) {
        /*
         * All HTTP methods are supported.
         */
        get    ("/method", (req, res) -> "GET!    \n");
        post   ("/method", (req, res) -> "POST!   \n");
        put    ("/method", (req, res) -> "PUT!    \n");
        delete ("/method", (req, res) -> "DELETE! \n");
        options("/method", (req, res) -> "OPTIONS!\n");
        head   ("/method", (req, res) -> "HEAD!   \n");
        trace  ("/method", (req, res) -> "TRACE!  \n");
        connect("/method", (req, res) -> "CONNECT!\n");

        /*
         * Named parameters can be used.
         */
        get("/param/:name", (req, res) -> "Name = " + req.params("name"));

        /*
         * Wildcards can also be used (for mapping and also as parameters).
         */
        get("/wild1/*", (req, res) -> "Hello *");
        get("/wild2/*/*", (req, res) -> "Hello: " + req.splat()[0] + ", " + req.splat()[1]);
    }

}
