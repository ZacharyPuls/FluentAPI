package com.zachpuls.api.layout;

import j2html.TagCreator;
import j2html.tags.ContainerTag;

import java.util.ArrayList;
import java.util.List;

import static j2html.TagCreator.*;

/**
 * Created by zpuls on 3/17/2016.
 */
public class FluidThirdsLayout implements ILayout {

    List<ContainerTag> containerTags = new ArrayList<>();

    @Override
    public ContainerTag getContainer() {
        return div().withClass("container-fluid");
    }

    public FluidThirdsLayout addComponent(ContainerTag component) {
        containerTags.add(component);
        return this;
    }

    public ContainerTag render() {

        ContainerTag left = div().withClass("col-md-4");
        ContainerTag center = div().withClass("col-md-4");
        ContainerTag right = div().withClass("col-md-4");

        for (int i = 0; i < containerTags.size(); ++i) {
            if (i % 3 == 0) {
                left.with(containerTags.get(i));
            } else if (i % 3 == 1) {
                center.with(containerTags.get(i));
            } else {
                right.with(containerTags.get(i));
            }
        }

        return getContainer().with(left, center, right);
    }

}
