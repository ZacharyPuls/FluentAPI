package com.zachpuls.api.model;

import com.zachpuls.website.model.Person;

/**
 * Created by jenni on 3/21/2016.
 */
public class TestPersonDataset extends Dataset {

    @Override
    public void load() {
        for (int i = 0; i < 12; ++i) {
            Person person = new Person();
            person.employeeId = "1234";
            person.firstName = "John";
            person.lastName = "Doe";

            data.add(person);
        }
    }

    @Override
    public void save() {
        // noop
    }
}
