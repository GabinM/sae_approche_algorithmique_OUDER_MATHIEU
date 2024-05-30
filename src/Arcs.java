import java.util.List;
import java.util.ArrayList;

public class Arcs {
    
    private String nom; //nom du noeud
    private List<Arc> arcs; //liste des arcs

    Arcs(String n){
        this.nom = n; 
        this.arcs = new ArrayList<Arc>();
    }

    public void ajouterArc(Arc a){
        this.arcs.add(a);
    }

    public List<Arc> getArcs(){
        return this.arcs;
    }

    public String getNom(){
        return this.nom;
    }
}
