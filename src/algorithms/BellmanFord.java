package algorithms;
import utils;

public class BellmanFord {

    public Valeur resoudre(Graphe g, String depart){

        Valeur v = new Valeur();

        for(int i = 0; i < g.listeNoeuds(); i++){
            if (g.listeNoeuds.get(i)).equals(depart){
                v.setValeur(g.listeNoeuds.get(i),0);
            }
            v.setValeur(g.listeNoeuds.get(i),double.MAX_DOUBLE);
        }

    }

}
