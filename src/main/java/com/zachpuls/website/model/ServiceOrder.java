package com.zachpuls.website.model;

import com.zachpuls.api.model.IGenerateForm;

/**
 * Created by zpuls on 3/17/2016.
 */

public class ServiceOrder implements IGenerateForm {
    public String serviceOrderNumber;
    public String serviceOrderName;
    public String serviceOrderDescription;
    public String price;
}
