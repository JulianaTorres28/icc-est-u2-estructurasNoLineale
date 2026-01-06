import models.Person;
import structures.trees.IntTree;
import structures.trees.Tree;

public class App {
    public static void main(String[] args) throws Exception {
        //runIntTree();
        runTree();
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
