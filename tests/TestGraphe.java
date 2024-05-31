import org.junit.jupiter.api.*;
import utils.GrapheListe;

import static org.junit.jupiter.api.Assertions.*;

/**
 * La classe TestGraphe contient des tests unitaires pour la classe GrapheListe.
 * Elle teste les différentes méthodes de la classe GrapheListe sur différents graphes et vérifie les résultats obtenus.
 */
public class TestGraphe {

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
        gL.ajouterArc("a", "b", 7);
    }

    /**
     * Teste l'initialisation du graphe.
     */
    @Test
    public void test_01_graphe_initialisation() {
        assertEquals(2, gL.listeNoeuds().size(), "Erreur lors de l'initialisation du graphe : le nombre de noeuds ne correspond pas.");
    }

    /**
     * Teste l'ajout d'un arc dans le graphe.
     */
    @Test
    public void test_02_graphe_ajout_arc() {
        assertEquals(1, gL.suivants("a").size(), "Erreur lors de l'ajout d'un arc : le nombre de noeuds suivants ne correspond pas.");
        assertEquals(7, gL.suivants("a").getFirst().getWeight(), "Erreur lors de l'ajout d'un arc : le cout de l'arc ne correspond pas.");
    }

    /**
     * Teste l'ajout de noeuds supplémentaires dans le graphe.
     */
    @Test
    public void test_03_graphe_ajout_noeuds_supplementaires() {
        gL.ajouterArc("a", "c", 8);
        gL.ajouterArc("d", "b", 78);
        assertEquals(4, gL.listeNoeuds().size(), "Erreur lors de l'ajout de noeuds supplémentaires : le nombre de noeuds ne correspond pas.");
    }

    /**
     * Teste l'ajout d'un arc avec un coût négatif dans le graphe.
     */
    @Test
    public void test_04_graphe_ajout_arc_cout_negatif() {
        assertThrows(IllegalArgumentException.class, () -> gL.ajouterArc("a", "b", -7));
    }

    /**
     * Teste la méthode suivants avec un noeud non existant dans le graphe.
     */
    @Test
    public void test_05_graphe_suivants_noeud_non_existant() {
        assertThrows(IllegalArgumentException.class, () -> gL.suivants("e"));
    }

    /**
     * Teste la méthode suivants avec un noeud sans suivants dans le graphe.
     */
    @Test
    public void test_06_graphe_suivants_noeud_sans_suivants() {
        gL.ajouterArc("b", "a", 7);
        assertEquals(1, gL.suivants("b").size(), "Erreur : le nombre de noeuds suivants ne correspond pas.");
    }

    /**
     * Teste l'ajout d'un arc avec le même noeud de départ et d'arrivée dans le graphe.
     */
    @Test
    public void test_07_graphe_ajout_arc_meme_noeud() {
        assertThrows(IllegalArgumentException.class, () -> gL.ajouterArc("a", "a", 7));
    }

    /**
     * Teste l'ajout d'un arc déjà existant dans le graphe.
     */
    @Test
    public void test_08_graphe_ajout_arc_existant() {
        gL.ajouterArc("a", "c", 8);
        assertThrows(IllegalArgumentException.class, () -> gL.ajouterArc("a", "c", 8));
    }

    /**
     * Teste la méthode toString de la classe GrapheListe.
     */
    @Test
    public void test_09_toString() {
        assertEquals("--------------------------------------\n" +
                "a -> b(7.0) \n" +
                "b -> \n" +
                "--------------------------------------", gL.toString());
    }
}