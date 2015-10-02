package xyz.javalab.spark;

import static spark.Spark.*;

public class $0_HelloWorld {

    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World!");
    }

}
