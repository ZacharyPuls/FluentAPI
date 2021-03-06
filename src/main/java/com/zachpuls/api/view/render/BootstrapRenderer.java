package com.zachpuls.api.view.render;

import com.google.gson.Gson;
import com.zachpuls.api.util.Utils;
import com.zachpuls.api.view.layout.CardLayout;
import com.zachpuls.api.view.layout.FluidThirdsLayout;
import com.zachpuls.api.model.FieldType;
import com.zachpuls.api.view.form.FormIgnore;
import com.zachpuls.api.view.form.IGenerateForm;
import com.zachpuls.api.view.layout.Panel;
import j2html.tags.ContainerTag;
import org.apache.commons.lang3.StringUtils;
import org.reflections.Reflections;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static j2html.TagCreator.*;

/**
 * Created by zpuls on 3/17/2016.
 */

public class BootstrapRenderer {

    public String getName() {
        return "Material Design Bootstrap Renderer";
    }

    public String renderForm(Class<?> clazz) {

        ContainerTag formData = form();
        List<String> inputIds = new ArrayList<>();

        for (Field field : clazz.getFields()) {
            if (!field.isAnnotationPresent(FormIgnore.class)) {
                formData.with(
                        fieldset().withClass("form-group").with(
                                label().attr("for", field.getName()).withText(Utils.parseName(field.getName())),
                                input().withId(field.getName()).withType(FieldType.fromClass(field.getType()))
                                        .withClass("form-control")
                        )
                );

                inputIds.add("$('" + field.getName() + ").val()");
            }
        }

        formData.with(
                a().withId("btnSubmit").withClass("btn btn-default waves-effect waves-light").withText("Submit"),
                script().withText("$('#btnSubmit').click(function(){$.ajax({type:'POST',url:'/" + clazz.getSimpleName().toLowerCase() + "',data:" + new Gson().toJson(inputIds) + "});});"
                ));

        formData.with(a().withId("btnCancel").withClass("btn btn-default waves-effect waves-light").withText("Cancel"));

        return html().with(
                Head.getHead(),
                body().with(
                        new FluidThirdsLayout().addComponent(div()).addComponent(
                                div().withClass("card").with(
                                        div().withClass("card-content").with(
                                                h4(),
                                                formData
                                        ))).addComponent(div()).render()
                )).render();
    }


    public void renderAll() throws FileNotFoundException {
        new Reflections().getSubTypesOf(IGenerateForm.class).forEach(clazz -> {
            try {
                new FileOutputStream("src/main/resources/" + clazz.getSimpleName() + ".html").write(this.renderForm(clazz).getBytes(Charset.forName("UTF-8")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        try {
            new FileOutputStream("src/main/resources/People.html").write(
                    html().with(Head.getHead(), body().with(new CardLayout().render())).render().getBytes(Charset.forName("UTF-8")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
