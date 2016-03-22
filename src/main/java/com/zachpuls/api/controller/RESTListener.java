package com.zachpuls.api.controller;

import com.zachpuls.api.view.form.IGenerateForm;
import org.rapidoid.http.Req;
import org.rapidoid.http.fast.On;
import org.reflections.Reflections;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by zpuls on 3/22/2016.
 */

public class RESTListener {

    private String readFile(String filename) {
        String fileData = "";

        try {
            fileData = new String(Files.readAllBytes(Paths.get(filename)), Charset.forName("UTF-8"));
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        return fileData;
    }

    public String save(Req request) {
        System.out.println("Saving new object: " + request.toString());

        return "success";
    }

    public void run() {

        On.get("/js/bootstrap.min.js").plain(readFile("src/main/resources/js/bootstrap.min.js"));
        On.get("/js/mdb.min.js").plain(readFile("src/main/resources/js/mdb.min.js"));
        On.get("/css/bootstrap.min.css").plain(readFile("src/main/resources/css/bootstrap.min.css"));
        On.get("/css/mdb.min.css").plain(readFile("src/main/resources/css/mdb.min.css"));

        new Reflections().getSubTypesOf(IGenerateForm.class).forEach(clazz -> {
            String name = clazz.getSimpleName().toLowerCase();
            On.get("/" + name).html(readFile("src/main/resources/" + clazz.getSimpleName() + ".html"));
            On.post("/" + name).plain(this::save).get("/" + name);
        });
    }
}
