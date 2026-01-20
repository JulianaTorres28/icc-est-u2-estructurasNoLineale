import java.util.List;

import models.Person;
import structures.graphs.Graph;
import structures.nodes.Node;
import structures.trees.IntTree;
import structures.trees.Tree;

public class App {
    public static void main(String[] args) throws Exception {
        // runIntTree();
        // runTree();
        // runGraph();
        runGraphRecorridos();
    }

    private static void runGraphRecorridos() {
        Graph<Person> grafo = new Graph<>();
        Person pC23 = new Person("Carlos", 23);
        Person pL18 = new Person("Luis", 18);
        Person pA23 = new Person("Andres", 23);
        Person pJ25 = new Person("Juan", 25);
        Person pAn20 = new Person("Ana", 20);
        Person pAn30 = new Person("Ana", 30);

        Node<Person> nC23 = new Node<>(pC23);
        Node<Person> nL18 = new Node<>(pL18);
        Node<Person> nA23 = new Node<>(pA23);
        Node<Person> nJ25 = new Node<>(pJ25);
        Node<Person> nAn20 = new Node<>(pAn20);
        Node<Person> nAn30 = new Node<>(pAn30);

        
        grafo.addEdge(nC23, nAn30);
        grafo.addConocido(nC23, nL18);
        grafo.addConocido(nC23, nA23);
        grafo.addConocido(nL18, nJ25);
        grafo.addEdge(nL18, nA23);
        grafo.addConocido(nAn30, nAn20);


        System.out.println("=== Grafo ===");
        grafo.printGraph();

        // Recorrido BFS
        System.out.println("\n=== Recorrido BFS  ===");
        grafo.bfs(nC23);

        // Recorrido DFS
        System.out.println("\n\n=== Recorrido DFS ===");
        grafo.dfs(nC23);

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

        // Conectadps A
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
        } else {
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
