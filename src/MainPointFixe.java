import utils.GrapheListe;
import utils.Valeur;
import algorithms.BellmanFord;

class MainPointFixe {

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

        for(int i = 0 ; i < gL.listeNoeuds().size(); i++){
            System.out.println("point : " + gL.listeNoeuds().get(i) + " , poids :" + v.getValeur(gL.listeNoeuds().get(i)) + ", parent : " + v.getParent(gL.listeNoeuds().get(i)));
        }
    }
}
