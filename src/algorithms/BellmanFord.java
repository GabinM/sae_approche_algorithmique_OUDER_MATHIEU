package algorithms;

import utils.Graphe;
import utils.Valeur;

public class BellmanFord {

    public Valeur resoudre(Graphe g, String depart) {

        Valeur v = new Valeur();

        for (int i = 0; i < g.listeNoeuds().size(); i++) {
            if (g.listeNoeuds().get(i).equals(depart)) {
                v.setValeur(g.listeNoeuds().get(i), 0);
            }
            v.setValeur(g.listeNoeuds().get(i), Double.MAX_VALUE);
        }

        return v;
    }

}
