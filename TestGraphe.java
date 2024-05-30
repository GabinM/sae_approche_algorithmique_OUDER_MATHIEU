import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestGraphe {
    
    @Test 
    public void test_01_graphe_2_noeuds(){
        GrapheListe gL = new GrapheListe();

        gL.ajouterArc("a", "b", 7);

        switch(gL.listeNoeuds().size()){
            case 0:
                throw new Error("erreur : aucun élément dans la liste des noeuds");
            case 1:
                throw new Error("erreur : un seul élément dans la liste des noeuds");
            case 2:
                break;
            default:
                throw new Error("erreur : trop d'éléments dans la liste des noeuds");
        }

        if(gL.suivants("a").get(0).getCout() != 7){
            throw new Error("erreur : le cout de l'arc est différent de 7");
        }
    }

    @Test
    public void test_02_graphe_4_noeuds(){
        GrapheListe gL = new GrapheListe();

        gL.ajouterArc("a", "b", 7);
        gL.ajouterArc("a", "c", 8);
        gL.ajouterArc("d", "b", 78);

        if(gL.listeNoeuds().size() != 4){
            throw new Error("erreur : le nombre de noeuds ne correspond pas (attendu : 4, obtenu : "+gL.listeNoeuds().size()+")");
        }

    }


}
