package structures.trees;

import models.Person;
import structures.nodes.Node;

public class Tree<T extends Comparable<T>> {
    private Node<T> root;

    public Tree() {
        this.root = null;
    }

    // método para insertar
    public void insert(T value) {
        root = insertRecursive(root, value);
    }

    private Node<T> insertRecursive(Node<T> current, T value) {
        if (current == null) {
            return new Node<T>(value);
        }

        if (value.compareTo(current.getValue()) < 0) {
            current.setLeft(insertRecursive(current.getLeft(), value));
        } else if (value.compareTo(current.getValue()) > 0) {
            current.setRight(insertRecursive(current.getRight(), value));
        }

        return current;
    }

    // método inorder
    public void inOrder() {
        inOrderRecursive(root);
        System.out.println();
    }

    private void inOrderRecursive(Node<T> node) {
        if (node != null) {
            inOrderRecursive(node.getLeft());
            System.out.println(node.getValue() + " ");
            inOrderRecursive(node.getRight());
        }
    }

    public T search(T value) {
        return searchRecursive(root, value);
    }

    private T searchRecursive(Node<T> current, T value) {
        if (current == null)
            return null;

        int cmp = value.compareTo(current.getValue());
        if (cmp == 0) {
            return current.getValue(); 
        } else if (cmp < 0) {
            return searchRecursive(current.getLeft(), value); 
        } else {
            return searchRecursive(current.getRight(), value); 
        }
    }

    public T searchByAge(int age) {
        return searchByAgeRecursive(root, age);
    }

    private T searchByAgeRecursive(Node<T> current, int age) {
        if (current == null)
            return null;

        Person persona = (Person) current.getValue();

        if (persona.getAge() == age) {
            return current.getValue();
        } else if (age < persona.getAge()) {
            return searchByAgeRecursive(current.getLeft(), age);
        } else {
            return searchByAgeRecursive(current.getRight(), age);
        }
    }

}
