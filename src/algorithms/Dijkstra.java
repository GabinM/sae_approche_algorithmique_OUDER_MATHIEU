package algorithms;

import utils.Arc;
import utils.Graphe;
import utils.Valeur;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra {
    public Valeur resoudre(Graphe g, String depart) {
        // On initialise les valeurs de tous les noeuds à l'infini
        Valeur v = new Valeur();
        for (String node : g.listeNoeuds()) {
            v.setValeur(node, Double.MAX_VALUE);
        }
        v.setValeur(depart, 0.0);
        // On crée une file de priorité pour les noeuds à traiter, les noeuds les plus intéressants sont ceux qui sortent en premier
        PriorityQueue<String> queue = new PriorityQueue<>(Comparator.comparing(v::getValeur));
        queue.add(depart);
        // On traite les noeuds un par un tant qu'il en reste
        while (!queue.isEmpty()) {
            // On récupère le noeud le plus intéressant
            String current = queue.poll();
            // On regarde tous les noeuds suivants
            for (Arc arc : g.suivants(current)) {
                // On regarde si on a trouvé un chemin plus court
                String next = arc.getDestination();
                double newDistance = v.getValeur(current) + arc.getWeight();
                // Si on a trouvé un chemin plus court, on met à jour les valeurs
                if (newDistance < v.getValeur(next)) {
                    v.setValeur(next, newDistance);
                    v.setParent(next, current);
                    // On retire le noeud de la file s'il y est déjà
                    if (queue.contains(next)) {
                        queue.remove(next);
                    }
                    // Pour l'y remettre avec sa nouvelle valeur, la file se chargera de le replacer au bon endroit
                    queue.add(next);
                }
            }
        }
        return v;
    }
}
