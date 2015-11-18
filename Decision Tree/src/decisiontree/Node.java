/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decisiontree;

import java.util.LinkedList;
import java.util.List;

/**
 * Class that defines a node of a tree.
 * @author Leo
 */
public class Node {
    
    private String data;
    private Node parent;
    private List<Node> children;
    private String relation;
    
    
    /***
     * Creates a new object of a tree node.
     * @param Data The node data.
     * @param Parent The parent node.
     * @param Relation The type of parent-child relation.
     */
    public Node(String Data, Node Parent, String Relation)
    {
        this.data = Data;
        this.parent = Parent;
        this.children = new LinkedList<>();
        this.relation = Relation;
    }

    /**
     * Creates a new object of tree node.
     * @param Data The node data.
     */
    public Node(String Data)
    {
        this.data = Data;
        this.parent = null;
        this.children = new LinkedList<>();
        this.relation = null;
    }
    
    /**
     * Obtains the relation with the parent.
     * @return String object.
     */
    public String getRelation() {
        return relation;
    }

    /**
     * Sets the parent relation.
     * @param relation The relation.
     */
    public void setRelation(String relation) {
        this.relation = relation;
    }

     
    /**
     * Returns the node data.
     * @return String object with the node data.
     */
    public String getData() {
        return data;
    }

    /**
     * Sets the node data.
     * @param data String object.
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * Obtains the parent node.
     * @return Node object.
     */
    public Node getParent() {
        return parent;
    }

    /**
     * Sets the parent node.
     * @param parent Parent node.
     */
    public void setParent(Node parent) {
        this.parent = parent;
    }

    /**
     * Obtains the node's children.
     * @return List of Node.
     */
    public List<Node> getChildren() {
        return children;
    }

    /**
     * Adds a new child to the node.
     * @param child Child node.
     */
    public void addChild(Node child) {
        this.children.add(child);
    }
    
    
    
}
