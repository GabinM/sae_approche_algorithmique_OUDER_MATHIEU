package utils;

import java.util.List;
import java.util.ArrayList;

public class Arcs {
    
    private final String nom; //nom du noeud
    private final List<Arc> arcs; //liste des arcs

    public Arcs(String n){
        this.nom = n; 
        this.arcs = new ArrayList<>();
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
