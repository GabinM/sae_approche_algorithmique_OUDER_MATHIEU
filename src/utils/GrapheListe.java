package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * La classe GrapheListe implémente l'interface Graphe.
 * Elle représente un graphe sous forme de liste d'adjacence.
 * Chaque noeud est associé à une liste d'arcs sortants.
 */
public class GrapheListe implements Graphe {

    /**
     * La liste des noms des noeuds du graphe.
     */
    private final ArrayList<String> noeuds;

    /**
     * La liste des listes d'arcs sortants pour chaque noeud.
     */
    private final ArrayList<Arcs> adjacence;

    /**
     * Constructeur de la classe GrapheListe.
     * Initialise les listes des noeuds et des listes d'arcs sortants.
     */
    public GrapheListe() {
        this.noeuds = new ArrayList<>();
        this.adjacence = new ArrayList<>();
    }

    /**
     * Constructeur de la classe GrapheListe.
     * Initialise les listes des noeuds et des listes d'arcs sortants à partir d'un fichier.
     *
     * @param nomFichier Le nom du fichier contenant les arcs du graphe.
     */
    public GrapheListe(String nomFichier) {
        this.noeuds = new ArrayList<>();
        this.adjacence = new ArrayList<>();
        try {
            List<String> lignes = Files.readAllLines(Paths.get(nomFichier));
            for (String ligne : lignes) {
                String[] elements = ligne.split("\t");
                String depart = elements[0];
                String destination = elements[1];
                double cout = Double.parseDouble(elements[2]);
                this.ajouterArc(depart, destination, cout);
            }
        } catch (IOException e) {
            throw new RuntimeException("Erreur lors de la lecture du fichier " + nomFichier, e);
        }
    }

    /**
     * Renvoie l'indice d'un noeud dans la liste des noeuds.
     *
     * @param n Le nom du noeud dont on veut obtenir l'indice.
     * @return L'indice du noeud dans la liste, ou -1 si le noeud n'existe pas.
     */
    public int getIndice(String n) {
        for (int i = 0; i < this.noeuds.size(); i++) {
            if (this.noeuds.get(i).equals(n)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Renvoie la liste des noms de tous les noeuds dans le graphe.
     *
     * @return Une liste de chaînes de caractères représentant les noms des noeuds.
     */
    public List<String> listeNoeuds() {
        return this.noeuds;
    }

    /**
     * Renvoie la liste des arcs sortants d'un noeud spécifique.
     *
     * @param n Le nom du noeud dont on veut obtenir les arcs sortants.
     * @return Une liste d'arcs sortants du noeud spécifié.
     * @throws IllegalArgumentException Si le noeud n'existe pas ou n'a pas de suivants.
     */
    public List<Arc> suivants(String n) {
        int indice = this.getIndice(n);
        if (indice == -1) {
            throw new IllegalArgumentException("Le noeud " + n + " n'existe pas dans le graphe.");
        }
        List<Arc> arcs = this.adjacence.get(indice).getArcs();
        if (arcs.isEmpty()) {
            throw new IllegalArgumentException("Le noeud " + n + " n'a pas de suivants.");
        }
        return arcs;
    }

    /**
     * Ajoute un arc entre deux noeuds dans le graphe.
     *
     * @param depart Le nom du noeud de départ de l'arc.
     * @param destination Le nom du noeud de destination de l'arc.
     * @param cout Le coût de l'arc.
     * @throws IllegalArgumentException Si le noeud de départ et le noeud de destination sont les mêmes, ou si l'arc existe déjà.
     */
    public void ajouterArc(String depart, String destination, double cout) {
        if (depart.equals(destination)) {
            throw new IllegalArgumentException("Le noeud de départ et le noeud de destination ne peuvent pas être les mêmes.");
        }

        int indiceDepart = this.getIndice(depart);
        int indiceDestination = this.getIndice(destination);

        if (indiceDepart != -1) {
            for (Arc arc : this.adjacence.get(indiceDepart).getArcs()) {
                if (arc.getDestination().equals(destination)) {
                    throw new IllegalArgumentException("L'arc existe déjà dans le graphe.");
                }
            }
        }

        if (indiceDepart == -1) {
            this.noeuds.add(depart);
            this.adjacence.add(new Arcs(depart));
            indiceDepart = this.noeuds.size() - 1;
        }

        if (indiceDestination == -1) {
            this.noeuds.add(destination);
            this.adjacence.add(new Arcs(destination));
        }

        this.adjacence.get(indiceDepart).ajouterArc(new Arc(destination, cout));
    }

    /**
     * Renvoie une représentation sous forme de chaîne de caractères du graphe.
     *
     * @return Une chaîne de caractères représentant le graphe.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("--------------------------------------\n");
        for (Arcs arcList : adjacence) {
            sb.append(arcList.getNom());
            sb.append(" -> ");
            for (Arc arc : arcList.getArcs()) {
                sb.append(arc.getDestination());
                sb.append("(");
                sb.append(arc.getWeight());
                sb.append(") ");
            }
            sb.append("\n");
        }
        sb.append("--------------------------------------");
        return sb.toString();
    }
}
