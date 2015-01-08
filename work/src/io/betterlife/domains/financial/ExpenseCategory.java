package io.betterlife.domains.financial;

import io.betterlife.domains.BaseObject;

import javax.persistence.*;

/**
 * Author: Lawrence Liu(lawrence@betterlife.io)
 * Date: 10/31/14
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "ExpenseCategory.getById", query = "SELECT e FROM ExpenseCategory e WHERE e.id = :id AND e.active = TRUE"),
    @NamedQuery(name = "ExpenseCategory.getAll",  query = "SELECT e FROM ExpenseCategory e WHERE e.active = TRUE")
})
public class ExpenseCategory extends BaseObject {

    public ExpenseCategory() {}

    public ExpenseCategory(String name) {
        this();
        setName(name);
    }

    public void setName(String name) {
        setValue("name", name);
    }

    public String getName() {
        return getValue("name");
    }

}
