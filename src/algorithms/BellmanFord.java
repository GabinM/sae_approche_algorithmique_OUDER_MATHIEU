package algorithms;

import utils.Graphe;
import utils.Valeur;
import utils.Graphe;
import utils.Arc;

public class BellmanFord {

    public static Valeur resoudre(Graphe g, String depart){

        Valeur v = new Valeur();
        int tailleListe = g.listeNoeuds().size();

        int idDepart = 0;
        while(idDepart < tailleListe && !g.listeNoeuds().get(idDepart).equals(depart)){
            idDepart++;
        }

        for(int j = 0; j < tailleListe; j++){
            v.setValeur(g.listeNoeuds().get(j), Double.MAX_VALUE);
        }
        v.setValeur(depart,0);

        for(int k = 0; k < tailleListe; k++){
            for(int i = 0; i < tailleListe; i++){
                for(Arc a : g.suivants(g.listeNoeuds().get(i))){
                    if((v.getValeur((g.listeNoeuds().get(i))) + a.getWeight()) < v.getValeur(a.getDestination())){
                        v.setValeur(a.getDestination(), (v.getValeur((g.listeNoeuds().get(i))) + a.getWeight()));
                        v.setParent(a.getDestination(),g.listeNoeuds().get(i));
                    }
                }
            }
        }
        

        return v;

    }

}


/* algo wiki :

 fonction Bellman-Ford(G = (S, A), poids, s)
   pour u dans S faire
   |       d[u] = +∞
   |       pred[u] = null
   d[s] = 0
   //Boucle principale
   pour k = 1 jusqu'à taille(S) - 1 faire
    |      pour chaque arc (u, v) du graphe faire
    |      |    si d[u] + poids(u, v) < d[v] alors
    |      |    |    d[v] := d[u] + poids(u, v)
    |      |    |    pred[v]:= u

   retourner d, pred

*/