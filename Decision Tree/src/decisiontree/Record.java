package decisiontree;

import java.util.ArrayList;
import java.util.List;

/**
 * Defines a case of the problem.
 * 
 * @author Leo
 */
public class Record {
    
    private final List<Attribute> attributes;
    
    /**
     * Create a new Record object.
     */
    public Record() {
        this.attributes = new ArrayList<>();
    }
    
    /**
     * Add a new attribute to the attributes list.
     * 
     * @param attribute The attribute object.
     */
    public void addAttribute(Attribute attribute) {
        this.attributes.add(attribute);
    }
    
    /**
     * Add a new attribute to the attributes list.
     * 
     * @param className The attribute class.
     * @param value The attribute value.
     */
    public void addAttribute(String className, String value) {
        this.addAttribute(new Attribute(className, value));
    }
    
    /**
     * Check if the record contains an attribute.
     * 
     * @param className The class of attribute.
     * 
     * @return True if the record contains an attribute.
     */
    public boolean hasAttribute(String className) {
        for (Attribute attr : this.attributes) {
            if (attr.getClassName().equals(className)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Obtains the attributes of the case.
     * 
     * @return The list of attributes.
     */
    public List<Attribute> getAttributes() {
        return this.attributes;
    }
    
    /**
     * Obtains an attribute.
     * 
     * @param className The attribute class.
     * @return The attribute.
     */
    public Attribute getAttribute(String className) {
        for (Attribute attr : this.attributes) {
            if (attr.getClassName().equals(className)) {
                return attr;
            }
        }
        return null;
    }
    
    /**
     * Obtains an attribute.
     * 
     * @param index The attribute index.
     * @return The attribute.
     */
    public Attribute getAttribute(int index) {
        return this.attributes.get(index);
    }
    
    /**
     * Get the number of attributes in the record.
     * 
     * @return The number of attributes in the record.
     */
    public int size() {
        return this.attributes.size();
    }
}
