/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decisiontree;

import java.util.ArrayList;

/**
 * Defines a case of the problem.
 * @author Leo
 */
public class Case {
    
    private final ArrayList<Attribute> attributes;
    private final int number;
    
    /**
     * Create a new Case object.
     * @param Number The case number.
     */
    public Case(int Number)
    {
        this.number = Number;
        this.attributes = new ArrayList<>();
    }
    
    /**
     * Add a new attribute to the attributes list.
     * @param attribute The attribute object.
     */
    public void addAttribute(Attribute attribute)
    {
        this.attributes.add(attribute);
    }

    /**
     * Obtains the attributes of the case.
     * @return 
     */
    public ArrayList<Attribute> getAttributes() {
        return attributes;
    }

    /**
     * Obtains the case number.
     * @return int case number.
     */
    public int getNumber() {
        return number;
    }
}
