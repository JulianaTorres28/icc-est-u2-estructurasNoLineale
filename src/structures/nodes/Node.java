
package structures.nodes;

import java.util.List;

public class Node<T> {
    private T value;
    private Node<T> left;
    private Node<T> right;

    //Listado de nodos conocidos
    private List<Node<T>> neighbors;

    public Node(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.neighbors = null;
    }

    public T getValue() { 
        return value; 
    }

    public void setValue(T value) { 
        this.value = value; 
    }
    public Node<T> getLeft() {
         return left; 
    }
    public void setLeft(Node<T> left) { 
        this.left = left; 
    }
    public Node<T> getRight() { 
        return right; 
    }
    public void setRight(Node<T> right) {
        this.right = right; 
    }

     public List<Node<T>> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<Node<T>> neighbors) {
        this.neighbors = neighbors;
    }
    
    @Override
    public String toString() {
        return "Node [" + value + "]";
    }

   
}

