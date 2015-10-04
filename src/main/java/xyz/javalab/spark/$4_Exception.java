package xyz.javalab.spark;

import static spark.Spark.*;

public class $4_Exception {

    public static void main(String[] args) {
        /*
         * You can handle exceptions for all routes and filters.
         */
        get("/nullpointer", (req, res) -> {
            throw new NullPointerException("NullPointerException was thrown.");
        });

        get("/illegalstate", (req, res) -> {
            throw new IllegalStateException("Illegal state!");
        });

        exception(NullPointerException.class, (e, request, response) -> {
            response.body("NullPointerException: " + e.getMessage());
        });

        exception(IllegalStateException.class, (e, request, response) -> {
            response.body("IllegalStateException: " + e.getMessage());
        });
    }

}
