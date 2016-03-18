package com.zachpuls.website.model;

import com.zachpuls.api.model.FormIgnore;
import com.zachpuls.api.model.IGenerateForm;

/**
 * Created by zpuls on 3/17/2016.
 */

public class PurchaseOrder implements IGenerateForm {

    public String purchaseOrderNumber;
    public String purchaseOrderName;

    @FormIgnore
    public String dummyValue;



}
