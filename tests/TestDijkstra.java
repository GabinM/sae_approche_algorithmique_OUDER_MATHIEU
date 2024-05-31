import algorithms.Dijkstra;
import org.junit.jupiter.api.Test;
import utils.GrapheListe;
import utils.Valeur;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * La classe TestDijkstra contient des tests unitaires pour l'algorithme de Dijkstra.
 * Elle teste l'algorithme sur différents graphes et vérifie les résultats obtenus.
 */
public class TestDijkstra {

    /**
     * Teste l'algorithme de Dijkstra sur un graphe classique.
     */
    @Test
    public void test_01_graphe_classique() {
        // Création d'un graphe simple
        GrapheListe gL = new GrapheListe();
        gL.ajouterArc("a", "b", 12);
        gL.ajouterArc("a", "d", 87);
        gL.ajouterArc("b", "e", 11);
        gL.ajouterArc("d", "b", 23);
        gL.ajouterArc("d", "c", 10);
        gL.ajouterArc("c", "a", 19);
        gL.ajouterArc("e", "d", 43);

        // Création d'un objet Dijkstra
        Dijkstra dijkstra = new Dijkstra();

        // Calcul des chemins les plus courts à partir du nœud A vers tous les autres nœuds
        Valeur v = dijkstra.resoudre(gL, "a");

        // Vérification des chemins les plus courts
        ArrayList<Object[]> res = new ArrayList<>();
        res.add(new Object[]{null, 0.0});
        res.add(new Object[]{"a", 12.0});
        res.add(new Object[]{"e", 66.0});
        res.add(new Object[]{"b", 23.0});
        res.add(new Object[]{"d", 76.0});

        for (int i = 0; i < gL.listeNoeuds().size(); i++) {
            assertEquals(v.getValeur(gL.listeNoeuds().get(i)), res.get(i)[1], "la valeur est incorrecte");
            assertEquals(v.getParent(gL.listeNoeuds().get(i)), res.get(i)[0], "le parent est incorrect");
        }
    }

    /**
     * Teste l'algorithme de Dijkstra sur un graphe vide.
     */
    @Test
    public void test_02_graphe_vide() {
        // Création d'un graphe vide
        GrapheListe gL = new GrapheListe();

        // Création d'un objet Dijkstra
        Dijkstra dijkstra = new Dijkstra();

        // Tentative de calcul des chemins les plus courts à partir d'un nœud inexistant
        try {
            Valeur v = dijkstra.resoudre(gL, "a");
        } catch (Exception e) {
            // Vérification que l'exception est bien levée
            assertInstanceOf(IllegalArgumentException.class, e);
        }
    }

    /**
     * Teste l'algorithme de Dijkstra sur un graphe avec plusieurs nœuds.
     */
    @Test
    public void test_03_noeuds_multiples() {
        // Création d'un graphe avec plusieurs nœuds et arcs
        GrapheListe gL = new GrapheListe();
        gL.ajouterArc("a", "b", 12);
        gL.ajouterArc("a", "d", 87);
        gL.ajouterArc("b", "e", 11);
        gL.ajouterArc("d", "b", 23);
        gL.ajouterArc("d", "c", 10);
        gL.ajouterArc("c", "a", 19);
        gL.ajouterArc("e", "d", 43);
        gL.ajouterArc("a", "e", 20); // Chemin alternatif de a à e

        // Création d'un objet Dijkstra
        Dijkstra dijkstra = new Dijkstra();

        // Calcul des chemins les plus courts à partir du nœud A vers tous les autres nœuds
        Valeur v = dijkstra.resoudre(gL, "a");

        // Vérification que le chemin le plus court de a à e est bien a -> e et non a -> b -> e
        assertEquals(v.getParent("e"), "a", "le parent est incorrect");
    }

    /**
     * Teste l'algorithme de Dijkstra sur un graphe avec des chemins parallèles.
     */
    @Test
    public void test_04_chemins_paralleles() {
        // Création d'un graphe avec des chemins parallèles
        GrapheListe gL = new GrapheListe();
        gL.ajouterArc("a", "b", 12);
        gL.ajouterArc("a", "c", 10);
        gL.ajouterArc("b", "d", 5);
        gL.ajouterArc("c", "d", 5);
        gL.ajouterArc("d", "a", 100);
        gL.ajouterArc("a", "d", 20); // Chemin parallèle de a à d

        // Création d'un objet Dijkstra
        Dijkstra dijkstra = new Dijkstra();

        // Calcul des chemins les plus courts à partir du nœud A vers tous les autres nœuds
        Valeur v = dijkstra.resoudre(gL, "a");

        // Vérification que le chemin le plus court de a à d est bien a -> c -> d et non a -> d
        assertEquals(v.getParent("d"), "c", "le parent est incorrect");
    }

    /**
     * Teste l'algorithme de Dijkstra sur un graphe non connecté.
     */
    @Test
    public void test_05_graphe_non_connecte() {
        // Création d'un graphe non connecté
        GrapheListe gL = new GrapheListe();
        gL.ajouterArc("a", "b", 12);
        gL.ajouterArc("c", "d", 10); // Nœuds c et d non connectés aux autres nœuds

        // Création d'un objet Dijkstra
        Dijkstra dijkstra = new Dijkstra();

        // Calcul des chemins les plus courts à partir du nœud A vers tous les autres nœuds
        try {
            Valeur v = dijkstra.resoudre(gL, "a");
        } catch (Exception e) {
            // Vérification que l'exception est bien levée
            assertInstanceOf(IllegalArgumentException.class, e);
        }
    }
}