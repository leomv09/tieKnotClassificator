package decisiontree;

import java.util.ArrayList;


/**
 * Defines the tree class.
 * 
 * @author Leo
 */
public class Tree {
    
    
    private Node root;
    
    /**
     * Creates a new instance of tree.
     */
    public Tree() {
        this.root = null;
    }
    
    /**
     * Creates a new instance of tree.
     * 
     * @param set The record set.
     */
    public Tree(RecordSet set) {
        build(set);
    }

    
    /**
     * Obtains the root node of the tree.
     * 
     * @return The root node.
     */
    public Node getRoot() {
        return root;
    }

    /**
     * Sets the root node of the tree.
     * 
     * @param root The root node.
     */
    public void setRoot(Node root) {
        this.root = root;
    }
    
    /**
     * Sets the root of the tree base on the given records.
     * 
     * @param records A list of records.
     */
    private void setRoot(RecordSet records) {
        String rootValue = null;
        double currentGain;
        double gain = 0;
        
        for (String className : records.getClasses()) {
            currentGain = records.getGain(className);
            if (currentGain > gain) {
                gain = currentGain;
                rootValue = className;
            }
        }
        
        this.root = new Node(rootValue);
    }
    
    /**
     * Sets the children of a node by implementing the ID3 algorithm.
     * 
     * @param records A list of classes information.
     * @param node The node to set its children.
     */
    private void setChildrenOfNode(RecordSet records, Node node, ArrayList<String> usedClasses) {
        ArrayList<Node> createdNodes = new ArrayList<>();
        
        for (String attribute : records.getAttributesOfClass(node.getData())) {
            String bestClass = null;
            double currentGain;
            double gain = -1;
            
            for (String currentClass : records.getClasses()) {
                if (!usedClasses.contains(currentClass)) {
                    currentGain = records.getGain(node.getData(), attribute, currentClass);
                    if (currentGain > gain) {
                        gain = currentGain;
                        bestClass = currentClass;
                        usedClasses.add(currentClass);
                    }
                }
            }
            
            Node child = new Node(bestClass, node, attribute);
            node.addChild(child);
            createdNodes.add(child);
        }
        
        for (Node createdNode : createdNodes) {
            setChildrenOfNode(records, createdNode, usedClasses);
        }
    }
    
    /**
     * Builds the decision tree base on the classes information.
     * 
     * @param records The classes information.
     * @return The root node of the tree.
     */
    public Node build(RecordSet records) {
        setRoot(records);
        ArrayList<String> usedClasses = new ArrayList<>();
        usedClasses.add(this.root.getData());
        setChildrenOfNode(records, this.root, usedClasses);
        return this.root;
    }
    
    /**
     * Obtain tab indentation that represents the tree level.
     * 
     * @param level The indentation (tree) level.
     * @return A String containing spaces.
     */
    private String getIndentation(int level)
    {
        String tab = "  ";
        String result = "";
        for(int i = 0; i < level; i++)
        {
            result+=tab;
        }
        return result;
    }
    
    /**
     * Transforms the tree into a readable string.
     * 
     * @param node The node to evaluate.
     * @param print A String that contains previous data.
     * @param indentation The indentation (branch level) level.
     */
    private void printTree(Node node, StringBuilder print, int indentation) {
        if(node.equals(this.root)) {
           print.append(getIndentation(indentation))
                .append("(root) -> ")
                .append(node.getData())
                .append("\n"); 
        }
        else {
            String nodeData = node.getData() == null ? "<leaf>" : node.getData();
            print.append(getIndentation(indentation))
                 .append(" - (")
                 .append(node.getRelation())
                 .append(") -> ")
                 .append(nodeData)
                 .append("\n"); 
        }
        
        for (Node child : node.getChildren()) {
           printTree(child, print, indentation+1); 
        }

    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        printTree(this.root, sb, 0);
        return sb.toString();
    }
}
