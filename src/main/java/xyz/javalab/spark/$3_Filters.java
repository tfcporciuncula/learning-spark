package xyz.javalab.spark;

import static spark.Spark.*;

public class $3_Filters {

    private static boolean isAuthenticated;

    public static void main(String[] args) {
        get("/filter", (req, res) -> "You've been filtered!");

        /*
         * Before filters are executed before each request,
         * while after filters are executed after each request.
         */
        before("/filter", (req, res) -> {
            res.cookie("before1", "true");
            System.out.println("The first filter was executed.");
        });

        before("/filter", (req, res) -> {
            res.cookie("before2", "true");
            System.out.println("The second filter was executed.");
        });

        after("/filter", (req, res) -> {
            res.cookie("after", "true");
            System.out.println("The last filter was executed.");
        });

        /*
         * You can call halt() to stop a request within a filter.
         */
        get("/login", (req, res) -> {
            isAuthenticated = true;
            return "You've logged in.";
        });

        get("/logout", (req, res) -> {
            isAuthenticated = false;
            return "You've logged out.";
        });

        get("/protected", (req, res) -> "This is a (super) protected page.");
        before("/protected", (req, res) -> {
            if (!isAuthenticated) {
                halt(401, "You must log in to view this page.");
            }
        });
    }

}
