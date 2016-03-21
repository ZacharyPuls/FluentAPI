package com.zachpuls.api.view.render;

import j2html.tags.ContainerTag;

import static j2html.TagCreator.*;

/**
 * Created by zpuls on 3/18/2016.
 */

public class Head {

    public static ContainerTag getHead() {
        return head().with(script().withSrc("https://code.jquery.com/jquery-2.2.2.min.js"),
                script().withSrc("js/bootstrap.min.js"),
                script().withSrc("js/mdb.min.js"),
                link().withRel("stylesheet").withHref("css/bootstrap.min.css"),
                link().withRel("stylesheet").withHref("css/mdb.min.css"));
    }
}
