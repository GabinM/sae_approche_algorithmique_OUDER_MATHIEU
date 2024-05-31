import algorithms.BellmanFord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.GrapheListe;
import utils.Valeur;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * La classe TestBellman contient des tests unitaires pour l'algorithme de Bellman-Ford.
 * Elle teste l'algorithme sur différents graphes et vérifie les résultats obtenus.
 */
public class TestBellman {

    /**
     * Le graphe sur lequel les tests sont effectués.
     */
    private GrapheListe gL;

    /**
     * Initialise le graphe avant chaque test.
     */
    @BeforeEach
    public void setUp() {
        gL = new GrapheListe();
        gL.ajouterArc("a", "b", 12);
        gL.ajouterArc("a", "d", 87);
        gL.ajouterArc("b", "e", 11);
        gL.ajouterArc("d", "b", 23);
        gL.ajouterArc("d", "c", 10);
        gL.ajouterArc("c", "a", 19);
        gL.ajouterArc("e", "d", 43);
    }

    /**
     * Teste l'algorithme de Bellman-Ford sur un graphe classique.
     */
    @Test
    public void test_01_graphe_classique() {

        Valeur v = BellmanFord.resoudre(gL, "a");

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
     * Teste l'algorithme de Bellman-Ford sur un graphe où aucun chemin n'existe.
     */
    @Test
    public void test_02_graphe_aucun_chemin() {

        gL.ajouterArc("e","f",4);

        Valeur v = BellmanFord.resoudre(gL, "f");

        ArrayList<Object[]> res = new ArrayList<>();
        res.add(new Object[]{null, Double.MAX_VALUE});
        res.add(new Object[]{null, Double.MAX_VALUE});
        res.add(new Object[]{null, Double.MAX_VALUE});
        res.add(new Object[]{null, Double.MAX_VALUE});
        res.add(new Object[]{null, Double.MAX_VALUE});
        res.add(new Object[]{null, 0.0});

        for (int i = 0; i < gL.listeNoeuds().size(); i++) {
            assertEquals(v.getValeur(gL.listeNoeuds().get(i)), res.get(i)[1], "la valeur est incorrecte");
            assertEquals(v.getParent(gL.listeNoeuds().get(i)), res.get(i)[0], "le parent est incorrect");
        }

    }

    /**
     * Teste l'algorithme de Bellman-Ford sur un graphe qui ne contient aucun noeud.
     */
    @Test
    public void test_03_graphe_aucun_noeud(){
        GrapheListe gNull = new GrapheListe();
        BellmanFord.resoudre(gNull,"a");
    }

    /**
     * Teste l'algorithme de Bellman-Ford sur un graphe où le noeud de départ n'existe pas.
     */
    @Test
    public void test_04_graphe_noeud_inexistant(){
        Valeur v = BellmanFord.resoudre(gL, "x");

        ArrayList<Object[]> res = new ArrayList<>();
        res.add(new Object[]{null, Double.MAX_VALUE});
        res.add(new Object[]{null, Double.MAX_VALUE});
        res.add(new Object[]{null, Double.MAX_VALUE});
        res.add(new Object[]{null, Double.MAX_VALUE});
        res.add(new Object[]{null, Double.MAX_VALUE});
        res.add(new Object[]{null, Double.MAX_VALUE});

        for (int i = 0; i < gL.listeNoeuds().size(); i++) {
            assertEquals(v.getValeur(gL.listeNoeuds().get(i)), res.get(i)[1], "la valeur est incorrecte");
            assertEquals(v.getParent(gL.listeNoeuds().get(i)), res.get(i)[0], "le parent est incorrect");
        }

    }

    /**
     * Teste l'algorithme de Bellman-Ford sur un graphe où plusieurs noeuds ont la même distance minimale.
     */
    @Test
    public void test_05_graphe_noeud_meme_distance_min(){

        GrapheListe g = new GrapheListe();

        g.ajouterArc("a","b",5);
        g.ajouterArc("a","c",5);
        g.ajouterArc("b","d",5);
        g.ajouterArc("c","d",5);

        Valeur v = BellmanFord.resoudre(g, "a");

        ArrayList<Object[]> res = new ArrayList<>();
        res.add(new Object[]{null, 0.0});
        res.add(new Object[]{"a", 5.0});
        res.add(new Object[]{"a", 5.0});
        res.add(new Object[]{"b", 10.0});

        for (int i = 0; i < g.listeNoeuds().size(); i++) {
            assertEquals(v.getValeur(g.listeNoeuds().get(i)), res.get(i)[1], "la valeur est incorrecte");
            assertEquals(v.getParent(g.listeNoeuds().get(i)), res.get(i)[0], "le parent est incorrect");
        }

    }

}