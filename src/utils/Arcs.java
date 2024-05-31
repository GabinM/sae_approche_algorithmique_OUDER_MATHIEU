package utils;

import java.util.List;
import java.util.ArrayList;

/**
 * La classe Arcs représente un noeud dans un graphe, avec une liste d'arcs sortants.
 * Chaque instance de cette classe a un nom unique qui l'identifie.
 * Les arcs sortants sont stockés dans une liste.
 */
public class Arcs {

    /**
     * Le nom du noeud.
     */
    private final String nom;

    /**
     * La liste des arcs sortants du noeud.
     */
    private final List<Arc> arcs;

    /**
     * Constructeur de la classe Arcs.
     * Initialise le nom du noeud et crée une nouvelle liste pour les arcs.
     *
     * @param n Le nom du noeud.
     */
    public Arcs(String n){
        this.nom = n;
        this.arcs = new ArrayList<>();
    }

    /**
     * Ajoute un arc à la liste des arcs sortants du noeud.
     *
     * @param a L'arc à ajouter.
     */
    public void ajouterArc(Arc a){
        this.arcs.add(a);
    }

    /**
     * Retourne la liste des arcs sortants du noeud.
     *
     * @return La liste des arcs sortants du noeud.
     */
    public List<Arc> getArcs(){
        return this.arcs;
    }

    /**
     * Retourne le nom du noeud.
     *
     * @return Le nom du noeud.
     */
    public String getNom(){
        return this.nom;
    }
}