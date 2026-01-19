package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;

public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });
        app.get("/hello", ctx -> {
            var name = ctx.queryParamAsClass("name", String.class).getOrDefault("World");
            ctx.contentType("text/html");
            ctx.result("Hello, " + name + "!");
        });
        app.get("/users", ctx -> ctx.result("GET /users"));
        app.get("/courses/{id}", ctx -> {
            ctx.result("Course ID: " + ctx.pathParam("id"));
        });
        app.get("/users/{id}", ctx -> {
            ctx.result("User ID: " + ctx.pathParam("id"));
        });
        app.post("/users", ctx -> ctx.result("POST /users"));
        app.get("/users/{usersId}/post/{postId}", ctx -> {
            var usersId = ctx.pathParam("usersId");
            var postId = ctx.pathParam("postId");
            ctx.result("Course ID: " + usersId + " Lesson ID: " + postId);
        });
        app.start(7070);
    }
}
