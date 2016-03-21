package com.zachpuls.api.model;

import com.zachpuls.api.view.form.IGenerateForm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jenni on 3/21/2016.
 */

public abstract class Dataset {

    public List<IGenerateForm> data = new ArrayList<>();

    public abstract void load();
    public abstract void save();
}
