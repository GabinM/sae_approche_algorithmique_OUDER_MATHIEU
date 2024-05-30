import java.util.List;

public class MainGraphes {
    //une zone de test

    public static void main(String[] args){
        GrapheListe gL = new GrapheListe();

        gL.ajouterArc("a","b",12);
        gL.ajouterArc("a","d",87);
        gL.ajouterArc("b","e",11);
        gL.ajouterArc("d","b",23);
        gL.ajouterArc("d","c",10);
        gL.ajouterArc("c","a",19);
        gL.ajouterArc("e","d",43); //c'est bon ça marche, cool

        String res = ""; 
        for(int i = 0; i < gL.listeNoeuds().size(); i++){
            res = "";
            res += gL.listeNoeuds().get(i);
            res += " : ";
            List<Arc> suivants = gL.suivants(gL.listeNoeuds().get(i));
            for(int j = 0; j < suivants.size(); j++){
                res += suivants.get(j);
            }
            System.out.println(res);
        }
    }
}
