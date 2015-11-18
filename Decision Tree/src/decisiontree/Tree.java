/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decisiontree;

import java.util.ArrayList;


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
    
    /**
     * Sets the root of the tree base on the given records.
     * @param records A list of records.
     */
    private void setRoot(RecordSet records)
    {
        double gain = 0;
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
    
    /**
     * Sets the children of a node by implementing the ID3 algorithm.
     * @param records Alist of classes information.
     * @param node The node to set its children.
     */
    private void setChildrenOfNode(RecordSet records, Node node)
    {
        if(node.getData() == null)
        {
            return;
        }
        ArrayList<Node> createdNodes = new ArrayList<>();
        for(String attribute : records.getAttributesOfClass(node.getData()))
        {
            double gain = 0;
            String bestClass = null;
            for(String currentClass : records.getClasses())
            {
                if(!currentClass.equals(node.getData()))
                {
                   double currentGain = records.getGain(node.getData(), attribute, currentClass);
                    if(currentGain > gain)
                    {
                        gain = currentGain;
                        bestClass= currentClass;
                    } 
                }      
            }
            Node child = new Node(bestClass, node, attribute);
            node.addChild(child);
            createdNodes.add(child);
        }
        
        for(Node createdNode : createdNodes)
        {
            setChildrenOfNode(records, createdNode);
        }
    }
    
    /**
     * Builds the decision tree base on the classes information.
     * @param records The classes information.
     * @return The root node of the tree.
     */
    public Node build(RecordSet records)
    {
        setRoot(records);
        setChildrenOfNode(records, this.root);
        return this.root;
    }
    
    
}
