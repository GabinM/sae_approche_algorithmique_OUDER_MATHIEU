package algorithms;

import utils.GrapheListe;
import utils.Valeur;

public class ComparaisonAlgos {


    public static void main(String[] args) {
        ComparaisonAlgos alg = new ComparaisonAlgos();
        alg.perfDijkstra();
        //alg.perfBellmanFord();
    }

    public void perfDijkstra() {

        int nbTests = 50;
        double moyenneDijkstra = 0.0;
        // Création d'un grand graphe
        for (int test = 0; test < nbTests; test++) {
            GrapheListe gL = new GrapheListe();
            for (int i = 0; i < 250; i++) {
                for (int j = 0; j < 250; j++) {
                    if (i != j) {
                        gL.ajouterArc("n" + i, "n" + j, Math.random() * 100);
                    }
                }
            }

            // Création d'un objet Dijkstra
            Dijkstra dijkstra = new Dijkstra();

            // Mesure du temps d'exécution de l'algorithme de Dijkstra
            long startTime = System.currentTimeMillis();
            Valeur v = dijkstra.resoudre(gL, "n0");
            long endTime = System.currentTimeMillis();

            // Affichage du temps d'exécution
            moyenneDijkstra += (endTime - startTime);
            System.out.println("Temps d'exécution de l'algorithme de Dijkstra sur un grand graphe : " + (endTime - startTime) + " ms");
        }
        System.out.println("l'algorithme de dijkstra a pris en moyenne " + moyenneDijkstra / nbTests + " ms pour " + nbTests + " tests");

    }

    private void perfBellmanFord() {
        int nbTests = 50;
        double moyenneBellmanFord = 0.0;
        // Création d'un grand graphe
        for (int test = 0; test < nbTests; test++) {
            GrapheListe gL = new GrapheListe();
            for (int i = 0; i < 250; i++) {
                for (int j = 0; j < 250; j++) {
                    if (i != j) {
                        gL.ajouterArc("n" + i, "n" + j, Math.random() * 100);
                    }
                }
            }

            // Création d'un objet BellmanFord
            BellmanFord bellmanFord = new BellmanFord();
            // Mesure du temps d'exécution de l'algorithme de BellmanFord
            long startTime = System.currentTimeMillis();
            Valeur v = BellmanFord.resoudre(gL, "n0");
            long endTime = System.currentTimeMillis();

            // Affichage du temps d'exécution
            moyenneBellmanFord += (endTime - startTime);
            System.out.println("Temps d'exécution de l'algorithme de BellmanFord sur un grand graphe : " + (endTime - startTime) + " ms");
        }
        System.out.println("l'algorithme de BellmanFord a pris en moyenne " + moyenneBellmanFord / nbTests + " ms pour " + nbTests + " tests");
    }
}
