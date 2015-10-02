package xyz.javalab.spark;

import com.google.gson.Gson;
import spark.ResponseTransformer;

import static spark.Spark.*;

public class $6_Rest {

    private static final Gson GSON = new Gson();

    public static void main(String[] args) {
        /*
         * REST services can be implemented by using ResponseTransformer.
         */
        get("/rest", "application/json", (request, response) -> new Person("007", "James"), new JsonTransformer());

        /*
         * Cooler way.
         */
        get("/rest/:name", "application/json", (request, response) -> new Person("007", request.params("name")), GSON::toJson);
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

    static class JsonTransformer implements ResponseTransformer {

        @Override
        public String render(Object model) {
            return GSON.toJson(model);
        }

    }

}
