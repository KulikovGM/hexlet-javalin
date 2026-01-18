package org.example.hexlet;

import io.javalin.Javalin;

public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });
        app.get("/hello", ctx -> {
	    var name = ctx.queryParamAsClass("name", String.class).getOrDefault("World!");
 	    ctx.contentType("text/html");
   	    ctx.result("Hello, " + name + "!");
	});
        app.get("/users", ctx -> ctx.result("GET /users"));
        app.post("/users", ctx -> ctx.result("POST /users"));
        app.start(7070);
    }
}
