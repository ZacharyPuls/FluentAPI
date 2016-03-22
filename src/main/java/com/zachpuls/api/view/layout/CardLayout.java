package com.zachpuls.api.view.layout;

import com.zachpuls.api.model.Dataset;
import com.zachpuls.api.model.TestPersonDataset;
import com.zachpuls.api.util.Utils;
import j2html.tags.ContainerTag;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static j2html.TagCreator.*;

/**
 * Created by jenni on 3/21/2016.
 */
public class CardLayout implements ILayout {

    private Dataset dataset = new TestPersonDataset();

    public CardLayout() {
        dataset.load();
    }

    @Override
    public ContainerTag render() {

        List<ContainerTag> cards = new ArrayList<>();

        for (Object object : dataset.data) {
            ContainerTag cardContent = div().withClass("card-content white-text");

            for (Field field : object.getClass().getFields()) {
                try {
                    cardContent.with(p().withText(Utils.parseName(field.getName()) + ": " + field.get(object).toString()));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            cards.add(div().withClass("card blue darken-1").with(cardContent));
        }

        ContainerTag ret = div().withClass("row");

        for (ContainerTag card : cards) {
            ret.with(div().withClass("col-md-2").with(card));
        }

        return ret;
    }
}
