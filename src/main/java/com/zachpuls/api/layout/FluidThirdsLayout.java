package com.zachpuls.api.layout;

import j2html.TagCreator;
import j2html.tags.ContainerTag;

/**
 * Created by zpuls on 3/17/2016.
 */
public class FluidThirdsLayout implements ILayout {

    @Override
    public ContainerTag getContainer() {
        return TagCreator.div().withClass("container-fluid");
    }

}
