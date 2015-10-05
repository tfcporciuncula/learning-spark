package xyz.javalab.spark;

import com.google.gson.Gson;

import static spark.Spark.*;

public class $6_Rest {

    private static final Gson GSON = new Gson();

    public static void main(String[] args) {
        /*
         * REST services can be implemented by using ResponseTransformer. The second parameter is optional and
         * defines the accept type. This is used in case the client sends a request with an Accept header field.
         */
        get("/rest", "application/json", (req, res) -> new Person("007", "James"), new JsonTransformer());

        /*
         * Cooler way.
         */
        get("/rest/:name", "application/json", (req, res) -> new Person("007", req.params("name")), GSON::toJson);

        /*
         * Simpler way.
         */
        get("/rests", "application/json", (req, res) -> GSON.toJson(new Person("007", "James Bond")));
    }

    static class Person {

        private String id;

        private String name;

        public Person(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

    static class JsonTransformer implements spark.ResponseTransformer {

        @Override
        public String render(Object model) {
            return GSON.toJson(model);
        }

    }

}
