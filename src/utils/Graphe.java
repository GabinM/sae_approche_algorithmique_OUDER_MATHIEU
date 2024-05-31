package utils;

import java.util.List;

/**
 * L'interface Graphe définit les méthodes nécessaires pour manipuler un graphe.
 * Un graphe est constitué de noeuds, et chaque noeud peut avoir une liste d'arcs sortants.
 */
public interface Graphe {

    /**
     * Renvoie la liste des noms de tous les noeuds dans le graphe.
     *
     * @return Une liste de chaînes de caractères représentant les noms des noeuds.
     */
    public List<String> listeNoeuds();

    /**
     * Renvoie la liste des arcs sortants d'un noeud spécifique.
     *
     * @param n Le nom du noeud dont on veut obtenir les arcs sortants.
     * @return Une liste d'arcs sortants du noeud spécifié.
     */
    public List<Arc> suivants(String n);
}