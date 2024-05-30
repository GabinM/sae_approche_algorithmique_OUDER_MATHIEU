package utils;

import java.util.ArrayList;
import java.util.List;

public class GrapheListe implements Graphe {

    private final ArrayList<String> noeuds;
    private final ArrayList<Arcs> adjacence;

    public GrapheListe() {
        this.noeuds = new ArrayList<>();
        this.adjacence = new ArrayList<>();
    }

    public int getIndice(String n) {
        for (int i = 0; i < this.noeuds.size(); i++) {
            if (this.noeuds.get(i).equals(n)) {
                return i;
            }
        }
        return -1;
    }

    public List<String> listeNoeuds() {
        return this.noeuds;
    }

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

        this.adjacence.get(indiceDepart).getArcs().add(new Arc(destination, cout));
    }

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
