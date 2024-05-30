package algorithms;

import utils.Arc;
import utils.Graphe;
import utils.Valeur;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra {
//4 Calcul du meilleur chemin par Dijkstra (2h30)
//4.1 Principe de l'algorithme de Dijkstra
//    L'algorithme de Dijkstra permet de construire le plus court chemin en utilisant la
//    même fonction L(X) que celle vue dans l'algorithme du point fixe. L'algorithme de
//    Dijkstra consiste à partir d'un nœud de départ et à calculer de proche en proche la
//    valeur de L(X), la distance du plus court chemin qui passe par X, et le parent de X dans
//    ce chemin.
//    Cependant, au lieu d'appliquer un calcul sur chaque nœud jusqu'à atteindre un
//    point fixe, l'algorithme de Dijkstra consiste à choisir un ordre de calcul adapté pour
//    propager les valeurs calculées sans avoir besoin de mettre à jour des valeurs une fois
//    qu'elles ont été validées.
//    Le principe général consiste à partir d'une fonction de valeur avec +∞ pour
//    chaque nœud du graphe, à attribuer une valeur de 0 au nœud de départ et à calculer
//    la valeur L des voisins de proche en proche.
//            L'astuce de cet algorithme consiste à considérer la liste de tous les nœuds du
//    graphe et de choisir comme nœud à développer le nœud X dans cette liste avec la plus
//    petite valeur L(X). Le développement du nœud consiste à estimer la valeur de ses voisins
//            (en la mettant à jour si la nouvelle valeur calculée est plus petite que la valeur déjà
//                    stockée). Une fois qu'un nœud a été développé, sa valeur ne pourra plus changer et il
//    est retiré de la liste des nœuds à traiter. En recommen¸cant à nouveau l'opération, sur
//    le prochain nœud non traité de valeur la plus faible, on traite les nœuds un à un sans
//    avoir besoin de revenir sur un nœud déjà traité.
//    Le fait que l'algorithme de Dijkstra fournit bien les plus courts chemins peut se
//    prouver mathématiquement et repose sur les éléments suivants :
//              1. tous les coûts sont positifs, l'ajout d'un arc sur un chemin ne peut donc que faire
//    croître la distance ;
//              2. lorsqu'on choisit le nœud avec la distance la plus faible dans la liste des nœuds
//    à traiter, on peut être sûr que cette valeur est définitive et qu'il n'existe pas de
//    chemin plus court que celui déjà trouvé (étant donné que tous les nœuds encore
//            non explorés ont une distance plus grande et qu'ajouter un arc augmente cette
//            distance) ;
//              3. ce nœud peut alors être développé sans risque de trouver un meilleur chemin. Il
//    peut ensuite être retiré de la liste des nœuds à traiter.
//    Les diagrammes suivants (figures 3, 4, 5, 6, 7, 8, 9) illustrent le déroulement de
//    l'algorithme. Les nœuds à traiter (c'st-à-dire ceux qui sont encore dans la liste des
//    nœuds à traiter qu'on appellera Q) sont en vert, le nœud dont on traite la valeur
//    actuellement est en rouge et les nœuds déjà traités sont représentés en blanc.

    public Valeur resoudre(Graphe g, String depart) {
        // Initialize the distance and parent maps
        Valeur v = new Valeur();
        for (String node : g.listeNoeuds()) {
            v.setValeur(node, Double.MAX_VALUE);
        }
        v.setValeur(depart, 0.0);

        // Create a priority queue to hold the nodes to be processed
        PriorityQueue<String> queue = new PriorityQueue<>(Comparator.comparing(v::getValeur));
        queue.add(depart);

        while (!queue.isEmpty()) {
            String current = queue.poll();

            for (Arc arc : g.suivants(current)) {
                String next = arc.getDestination();
                double newDistance = v.getValeur(current) + arc.getWeight();

                if (newDistance < v.getValeur(next)) {
                    v.setValeur(next, newDistance);
                    v.setParent(next, current);

                    if (queue.contains(next)) {
                        queue.remove(next);
                    }
                    queue.add(next);
                }
            }
        }

        return v;
    }

}
