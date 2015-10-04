package xyz.javalab.spark;

import spark.ModelAndView;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;

public class $7_Templates {

    public static void main(String[] args) {
        /*
         * Templates work like the MVC's view layer. By default, Thymeleaf's HTML files
         * should be in resources/templates directory.
         */
        Map map = new HashMap();
        map.put("name", "Sam");

        get("/thymeleaf", (request, response) -> new ModelAndView(map, "thymeleaf"), new ThymeleafTemplateEngine());
    }

}
