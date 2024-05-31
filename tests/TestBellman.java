import org.junit.jupiter.api.*;
import utils.GrapheListe;
import algorithms.BellmanFord;
import utils.Valeur;

class TestBellman {

    private GrapheListe gL;

    @BeforeEach
    public void setUp() {
        gL = new GrapheListe();
        gL.ajouterArc("a","b",12);
        gL.ajouterArc("a","d",87);
        gL.ajouterArc("b","e",11);
        gL.ajouterArc("d","b",23);
        gL.ajouterArc("d","c",10);
        gL.ajouterArc("c","a",19);
        gL.ajouterArc("e","d",43);
    }


    @Test
    public void test_01_graphe_classique(){

        Valeur v = BellmanFord.resoudre(gL, "a");

        ArrayList<String[]> res = {{null,"0.0"}, {"a","12.0"}, {"e","66.0"}, {"b","23.0"}, {"d","76.0"}};

        for(int i = 0; i < gL.listeNoeuds().size(); i++){
            assertEquals("la valeur est incorrecte", v.getValeur(gL.listeNoeuds().get(i)), res.get(i)[1]);
            assertEquals("le parent est incorrect", v.getParent(gL.listeNoeuds().get(i)), res.get(i)[0]);
        }
        
    }


}