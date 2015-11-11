package decisiontree;

/**
 * Defines the attribute object of a class.
 * 
 * @author Leo
 */
public class Attribute {
    
    /**
     * The class the attribute belongs to.
     */
    private final String className; 
    
    /**
     * The value.
     */
    private final String value;
    
    /**
     * Creates a new attribute object.
     * 
     * @param className The class the attribute belongs to.
     * @param value The value of the attribute.
     */
    public Attribute(String className, String value)
    {
        this.className = className;
        this.value = value;
    }

    /**
     * Obtains the class of the attribute.
     * @return String with the name of the class.
     */
    public String getClassName() {
        return className;
    }

    /**
     * Obtains the value of the attribute.
     * @return String value.
     */
    public String getValue() {
        return value;
    }
}
