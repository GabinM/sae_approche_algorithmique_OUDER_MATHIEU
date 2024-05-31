import utils.GrapheListe;

/**
 * La classe MainGraphes est le point d'entrée de l'application.
 * Elle crée un graphe et affiche sa représentation sous forme de chaîne de caractères.
 */
public class MainGraphes {

    /**
     * Le point d'entrée de l'application.
     *
     * @param args Les arguments de la ligne de commande. Non utilisé dans cette application.
     */
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
    }
}
