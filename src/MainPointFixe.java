import utils.GrapheListe;
import utils.Valeur;
import algorithms.BellmanFord;

/**
 * La classe MainPointFixe est le point d'entrée de l'application.
 * Elle crée un graphe, exécute l'algorithme de Bellman-Ford sur ce graphe à partir d'un noeud spécifique,
 * et affiche les chemins les plus courts de ce noeud à tous les autres noeuds du graphe.
 */
public class MainPointFixe {

    /**
     * Le point d'entrée de l'application.
     *
     * @param args Les arguments de la ligne de commande. Non utilisé dans cette application.
     */
    public static void main(String[] args){
        GrapheListe gL = new GrapheListe();

        gL.ajouterArc("a","b",12);
        gL.ajouterArc("a","d",87);
        gL.ajouterArc("b","e",11);
        gL.ajouterArc("d","b",23);
        gL.ajouterArc("d","c",10);
        gL.ajouterArc("c","a",19);
        gL.ajouterArc("e","d",43);

        System.out.println(gL);

        Valeur v = BellmanFord.resoudre(gL, "a");

        for (String node : gL.listeNoeuds()) {
            System.out.println("Shortest path from a to " + node + ": " + v.calculerChemin(node));
            System.out.println("point : " + node + " , poids :" + v.getValeur(node) + ", parent : " + v.getParent(node));
        }
    }
}
