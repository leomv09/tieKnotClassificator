/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decisiontree;


/**
 * Defines the tree class.
 * @author Leo
 */
public class Tree {
    
    
    private Node root;
    
    /**
     * Creates a new instance of tree.
     */
    public Tree()
    {
        this.root = null;
    }

    
    /**
     * Obtains the root node of the tree.
     * @return 
     */
    public Node getRoot() {
        return root;
    }

    /**
     * Sets the root node of the tree.
     * @param root Root node.
     */
    public void setRoot(Node root) {
        this.root = root;
    }
    
    private void setRoot(RecordSet records)
    {
        double gain = -1;
        String rootValue = null;
        for(String className : records.getClasses())
        {
            double currentGain = records.getGain(className);
            if(currentGain > gain)
            {
                gain = currentGain;
                rootValue = className;
            }
        }
        
        this.root.setData(rootValue);
    }
    
    public void build(RecordSet records)
    {
        setRoot(records);
    }
    
    
}
