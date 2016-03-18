package com.zachpuls.website.model;

import com.zachpuls.api.model.IGenerateForm;

/**
 * Created by zpuls on 3/17/2016.
 */

public class WorkOrder implements IGenerateForm {
    public String workOrderNumber;
    public String workOrderName;
    public String workOrderDescription;
    public String assignedTo;
}
