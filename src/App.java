import java.util.List;

import models.Person;
import structures.graphs.Graph;
import structures.nodes.Node;
import structures.trees.IntTree;
import structures.trees.Tree;

public class App {
    public static void main(String[] args) throws Exception {
        //runIntTree();
        //runTree();
        runGraph();
    }

    private static void runGraph() {
        Graph<String> graph = new Graph<>();

        Node<String> nA = new Node<String>("A");
        Node<String> nB = new Node<String>("B");
        Node<String> nC = new Node<String>("C");
        Node<String> nD = new Node<String>("D");

        graph.addNode(nA);
        graph.addEdge(nA, nB);
        graph.addEdge(nA, nC);
        graph.addEdge(nB, nD);
        graph.addEdge(nC, nD);
        graph.printGraph();

        //Conectadps A 
        List<Node<String>> neighbors = graph.getNeighbors(nA);
        System.out.print("Neightbors de A: ");
        for (Node<String> neighbor : neighbors) {
            System.out.print(neighbor + " ");
        }
    
    }

    private static void runTree() {
        Tree<Person> tree = new Tree<Person>();
        tree.insert(new Person("Pablo", 21));
        tree.insert(new Person("Maria", 23));
        tree.insert(new Person("Ana", 25));
        tree.insert(new Person("Pedro", 23));
        tree.insert(new Person("Luis", 19));
        System.out.println("\nIn-Order");
        tree.inOrder();   

        Person findPerson = tree.searchByAge(23);
        if (findPerson != null) {
            System.out.println(findPerson);
        } else{
            System.out.println("No se econtro");
        }

    }

    private static void runIntTree() {
        IntTree tree = new IntTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(3);
        tree.insert(15);
        System.out.println("\nPre-Order");
        tree.preOrder();
        System.out.println("\nPos-Order");
        tree.posOrder();
        System.out.println("\nIn-Order");
        tree.inOrder();    
        System.out.println("\nSize");
        System.out.println(tree.size());

    }



}
