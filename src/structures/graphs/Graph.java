package structures.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import structures.nodes.Node;

public class Graph<T> {

    // Guarda valores conuna Key(clave) y un value
    private Map<Node<T>, List<Node<T>>> mapa;

    public Graph() {
        this.mapa = new HashMap<Node<T>, List<Node<T>>>();
    }

    // Inserta un vértice o un nodo
    public void addNode(Node<T> node) {
        // NO agrega claves repetidas
        mapa.putIfAbsent(node, new ArrayList<>());
        // Mapa ahora tiene {N1:[N2], N2: [N1]}
    }

    // Grafo no dirigido
    public void addEdge(Node<T> n1, Node<T> n2) {
        addNode(n1);
        addNode(n2);
        mapa.get(n1).add(n2);
        mapa.get(n2).add(n1);
    }

    public void addConocido(Node<T> n1, Node<T> n2) {
        addNode(n1);
        addNode(n2);
        mapa.get(n1).add(n2);
        //Del mapa obtengo el listado
        //get(n1) -> Listado de N1
        //add(n2) -> agrega N2 al listado
    }

    public void printGraph() {
        for (Map.Entry<Node<T>, List<Node<T>>> entry : mapa.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            for (Node<T> neighbor : entry.getValue()) {
                System.out.print(neighbor);
            }
            System.out.println();
        }
    }

    public List<Node<T>> getNeighbors(Node<T> node) {
        return mapa.getOrDefault(node, List.of());
    }

    public void bfs(Node<T> start){
        //El set evita que pase duplicados de caminos
        Set<Node<T>> visitados = new LinkedHashSet<>();
        Queue<Node<T>> queue = new LinkedList<>();

        visitados.add(start);
        queue.add(start);

        while (!queue.isEmpty()) { //Para romper bucle, vaciar cola
            Node<T> current = queue.poll();
            System.out.print(current.getValue() + " ");

            for (Node<T> conocido : getNeighbors(current)) {
                if (!visitados.contains(conocido)) {
                    visitados.add(conocido);
                    queue.add(conocido);
                }
                
            }
        }

    }

    public void dfs(Node<T> start){
        Set<Node<T>> visitados = new LinkedHashSet<>();
        dfsRecursive(start, visitados);
    }

    private void dfsRecursive(Node<T> current, Set<Node<T>> visitados) {
        visitados.add(current);
        System.out.println(current.getValue() + " ");
        for (Node<T> conocido : getNeighbors(current)) {
            if (!visitados.contains(conocido)) {
                dfsRecursive(conocido, visitados);
            }
        }
    }
}
