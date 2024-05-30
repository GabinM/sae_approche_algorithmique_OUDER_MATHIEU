import algorithms.Dijkstra;
import utils.GrapheListe;
import utils.Valeur;

public class MainDijkstra {
    public static void main(String[] args) {
        GrapheListe gL = new GrapheListe();

        gL.ajouterArc("a","b",12);
        gL.ajouterArc("a","d",87);
        gL.ajouterArc("b","e",11);
        gL.ajouterArc("d","b",23);
        gL.ajouterArc("d","c",10);
        gL.ajouterArc("c","a",19);
        gL.ajouterArc("e","d",43);

        // Create a Dijkstra object
        Dijkstra dijkstra = new Dijkstra();

        // Calculate the shortest paths from node A to all other nodes
        Valeur v = dijkstra.resoudre(gL, "A");

        // Display the shortest paths
        for (String node : gL.listeNoeuds()) {
            System.out.println("Shortest path from A to " + node + ": " + v.calculerChemin(node));
        }
    }
}