package com.zachpuls.api.render;

import com.zachpuls.api.model.FieldType;
import com.zachpuls.api.model.FormIgnore;
import com.zachpuls.api.model.IGenerateForm;
import j2html.tags.ContainerTag;
import org.apache.commons.lang3.StringUtils;
import org.reflections.Reflections;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.Charset;

import static j2html.TagCreator.*;

/**
 * Created by zpuls on 3/17/2016.
 */

public class BootstrapRenderer {

    public String getName() {
        return "Bootstrap 4 Renderer";
    }

    public String render(Class<?> clazz) {

        ContainerTag formData = form();

        for (Field field : clazz.getFields()) {
            if (!field.isAnnotationPresent(FormIgnore.class)) {
                formData = formData.with(
                        fieldset().withClass("form-group").with(
                                label().attr("for", field.getName()).withText(parseName(field.getName())),
                                input().withId(field.getName()).withType(FieldType.fromClass(field.getType()))
                                        .withClass("form-control")
                        )
                );
            }
        }

        return html().with(
                Head.getHead(),
                body().with(
                        div().withClass("container-fluid").with(
                                div().withClass("row").with(
                                        div().withClass("col-md-12").with(
                                                div().withClass("card").with(
                                                        div().withClass("card-content").with(
                                                                h4(),
                                                                formData
                                                        ))
                                        )
                                )
                        )
                )).render();
    }


    public void renderAll() throws FileNotFoundException {
        new Reflections().getSubTypesOf(IGenerateForm.class).forEach(clazz -> {
            try {
                new FileOutputStream("src/main/resources/" + clazz.getSimpleName() + ".html").write(this.render(clazz).getBytes(Charset.forName("UTF-8")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    protected String parseName(String id) {
        return StringUtils.capitalize(StringUtils.join(id.split("(?=\\p{Upper})"), " "));
    }
}
