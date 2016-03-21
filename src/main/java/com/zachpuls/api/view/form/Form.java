package com.zachpuls.api.view.form;

import com.zachpuls.api.model.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zpuls on 3/17/2016.
 */

public class Form {

    private List<Element> elements = new ArrayList<>();

    public void addElement(Element element) {
        elements.add(element);
    }
}
