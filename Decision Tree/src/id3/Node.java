package id3;

import java.util.LinkedList;
import java.util.List;

/**
 * Class that defines a node of a tree.
 * @author Leo
 */
public class Node {
    
    private final List<Node> children;
    private Node parent;
    private String data;
    private String relation;
    
    /***
     * Creates a new object of a tree node.
     * 
     * @param data The node data.
     * @param parent The parent node.
     * @param relation The type of parent-child relation.
     */
    public Node(String data, Node parent, String relation) {
        this.data = data;
        this.parent = parent;
        this.children = new LinkedList<>();
        this.relation = relation;
    }

    /**
     * Creates a new object of tree node.
     * @param data The node data.
     */
    public Node(String data) {
        this.children = new LinkedList<>();
        this.data = data;
        this.parent = null;
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
