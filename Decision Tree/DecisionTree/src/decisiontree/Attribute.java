/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decisiontree;

/**
 * Defines the attribute object of a class.
 * @author Leo
 */
public class Attribute {
    
    private String className;//The class the attribute belongs to.
    private String value;//The value.
    
    /**
     * Creates a new attribute object.
     * @param ClassName The class the attribute belongs to.
     * @param Value The value of the attribute.
     */
    public Attribute(String ClassName, String Value)
    {
        this.className = ClassName;
        this.value = Value;
    }

    /**
     * Obtains the class of the attribute.
     * @return String with the name of the class.
     */
    public String getClassName() {
        return className;
    }

    /**
     * Set the class name of the attribute.
     * @param className Name of the class.
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * Obtains the value of the attribute.
     * @return String value.
     */
    public String getValue() {
        return value;
    }
    
    
}
