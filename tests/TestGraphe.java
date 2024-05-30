import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestGraphe {

    private GrapheListe gL;

    @BeforeEach
    public void setUp() {
        gL = new GrapheListe();
        gL.ajouterArc("a", "b", 7);
    }

    @Test
    public void test_01_graphe_initialisation() {
        assertEquals(2, gL.listeNoeuds().size(), "Erreur lors de l'initialisation du graphe : le nombre de noeuds ne correspond pas.");
    }

    @Test
    public void test_02_graphe_ajout_arc() {
        assertEquals(1, gL.suivants("a").size(), "Erreur lors de l'ajout d'un arc : le nombre de noeuds suivants ne correspond pas.");
        assertEquals(7, gL.suivants("a").getFirst().getCout(), "Erreur lors de l'ajout d'un arc : le cout de l'arc ne correspond pas.");
    }

    @Test
    public void test_03_graphe_ajout_noeuds_supplementaires() {
        gL.ajouterArc("a", "c", 8);
        gL.ajouterArc("d", "b", 78);
        assertEquals(4, gL.listeNoeuds().size(), "Erreur lors de l'ajout de noeuds supplémentaires : le nombre de noeuds ne correspond pas.");
    }

    @Test
    public void test_04_graphe_ajout_arc_cout_negatif() {
        assertThrows(IllegalArgumentException.class, () -> gL.ajouterArc("a", "b", -7));
    }
    
    @Test
    public void test_05_graphe_suivants_noeud_non_existant() {
        assertThrows(IllegalArgumentException.class, () -> gL.suivants("e"));
    }
    
    @Test
    public void test_06_graphe_suivants_noeud_sans_suivants() {
        gL.ajouterArc("b", "a", 7);
        assertEquals(1, gL.suivants("b").size(), "Erreur : le nombre de noeuds suivants ne correspond pas.");
    }
    
    @Test
    public void test_07_graphe_ajout_arc_meme_noeud() {
        assertThrows(IllegalArgumentException.class, () -> gL.ajouterArc("a", "a", 7));
    }
}