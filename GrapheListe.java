import java.util.ArrayList;
import java.util.List;

public class GrapheListe implements Graphe{
    
    private ArrayList<String> noeuds;
    private ArrayList<Arcs> adjacence;

    GrapheListe(){
        this.noeuds = new ArrayList<String>();
        this.adjacence = new ArrayList<Arcs>();
    }

    public int getIndice(String n){
        for(int i = 0; i < this.noeuds.size(); i++){
            if(this.noeuds.get(i).equals(n)){
                return i;
            }
        }
        return -1;
    }

    public List<String> listeNoeuds(){
        return this.noeuds;
    };
    
    public List<Arc> suivants(String n){
        return this.adjacence.get(this.getIndice(n)).getArcs();
    };

    public void ajouterArc(String depart, String destination, double cout){

        int indiceD = this.getIndice(depart);

        if(indiceD == -1){ //check si le noeud départ existe et l'initialise
            this.noeuds.add(depart);
            this.adjacence.add(new Arcs(depart));
            indiceD = this.noeuds.size();
        }
        if(this.getIndice(destination) == -1){  //check si le noeud destination existe et l'initialise
            this.noeuds.add(destination);
            this.adjacence.add(new Arcs(destination));
        }

        this.adjacence.get(indiceD).ajouterArc(new Arc(destination, cout)); //ajoute le nouvel arc entre départ et destination
    }
}
