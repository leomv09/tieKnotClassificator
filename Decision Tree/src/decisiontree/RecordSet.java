package decisiontree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A set of records.
 * 
 * @author José Andrés García Sáenz <jags9415@gmail.com>
 */
public class RecordSet extends ArrayList<Record> {
    
    /**
     * Creating a subset that contains only those records with a specific class.
     * 
     * @param className The class to filter the result.
     * @return The subset.
     */
    public RecordSet subSet(String className) {
        RecordSet set = new RecordSet();
        
        for (Record record : this) {
            if (record.hasAttribute(className)) {
                set.add(record);
            }
        }
        
        return set;
    }
    
    /**
     * Creating a subset that contains only those records with a specific class value.
     * 
     * @param className The class to filter the result.
     * @param value The value to filter the result.
     * @return The subset.
     */
    public RecordSet subSet(String className, String value) {
        RecordSet set = new RecordSet();
        
        for (Record record : this) {
            if (record.hasAttribute(className) && record.getAttribute(className).getValue().equals(value)) {
                set.add(record);
            }
        }
        
        return set;
    }
    
    /**
     * Get the list of classes in this set.
     * 
     * @return The list of classes names.
     */
    public List<String> getClasses() {
        Set<String> classes = new HashSet<>();
        
        for (Record record : this) {
            for (Attribute attr : record.getAttributes()) {
                classes.add(attr.getClassName());
            }
        }
        
        return new ArrayList(classes);
    }
    
    /**
     * Get the entropy of a class.
     * 
     * @return The entropy.
     */
    public double getEntropy() {
        double entropy = 0;
        double proportion;
        double count;
        
        List<String> attributes = getAttributesOfClass("RESULTADO");
        
        for (String attr : attributes) {
            count = countAttributes("RESULTADO", attr);
            proportion = count / this.size();
            entropy -= proportion * (Math.log(proportion) / Math.log(2));
        }
        
        return entropy;
    }
    
    /**
     * Get the information gain of a class.
     * 
     * @param className The class.
     * @return The information gain.
     */
    public double getGain(String className) {
        double gain = getEntropy();
        double proportion;
        double count;
        
        List<String> attributes = getAttributesOfClass(className);
        
        for (String attr : attributes) {
            count = countAttributes(className, attr);
            proportion = count / this.size();
            gain -= proportion * subSet(className, attr).getEntropy();
        }
        
        return gain;
    }
    
    /**
     * Get the information gain of a class.
     * 
     * @param className The class.
     * @param attribute The attribute.
     * @param otherClass THe other class.
     * @return The information gain.
     */
    public double getGain(String className, String attribute, String otherClass) {
        RecordSet subset = this.subSet(className, attribute);
        return subset.getGain(otherClass);
    }
    
    /**
     * Get the list of attribute values for a given class.
     * 
     * @param className The class.
     * @return The list of attribute values.
     */
    private List<String> getAttributesOfClass(String className) {
        Set<String> result = new HashSet<>();
        
        for (Record record : this) {
            if (record.hasAttribute(className)) {
                result.add(record.getAttribute(className).getValue());
            }
        }
        
        return new ArrayList(result);
    }
    
    /**
     * Count the number of repetitions of a given attribute.
     * 
     * @param className The class.
     * @param value The value.
     * @return The number of repetitions.
     */
    private int countAttributes(String className, String value) {
        int count = 0;
        
        for (Record record : this) {
            if (record.hasAttribute(className) && record.getAttribute(className).getValue().equals(value)) {
                count++;
            }
        }
        
        return count;
    }
    
}
