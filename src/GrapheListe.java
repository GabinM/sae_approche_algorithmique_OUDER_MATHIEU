import java.util.ArrayList;
import java.util.List;

public class GrapheListe implements Graphe {

    private ArrayList<String> noeuds;
    private ArrayList<Arcs> adjacence;

    GrapheListe() {
        this.noeuds = new ArrayList<String>();
        this.adjacence = new ArrayList<Arcs>();
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
    };

    public List<Arc> suivants(String n) {
        if (this.adjacence.get(this.getIndice(n)).getArcs().isEmpty()) {
            throw new IllegalArgumentException("Noeud sans suivants");
        }
        return this.adjacence.get(this.getIndice(n)).getArcs();
    };

    public void ajouterArc(String depart, String destination, double cout) {

        int indiceDepart = this.getIndice(depart);
        if (indiceDepart != -1) { // Si le noeud de départ existe déjà
            for (Arc arc : this.adjacence.get(indiceDepart).getArcs()) { // Parcourir tous les arcs du noeud de départ
                if (arc.getDest().equals(destination)) { // Si un arc vers le noeud de destination existe déjà
                    throw new IllegalArgumentException("L'arc existe déjà");
                }
            }
        }

        if (indiceDepart == -1) { // check si le noeud départ existe et l'initialise
            this.noeuds.add(depart);
            this.adjacence.add(new Arcs(depart));
        }
        if (this.getIndice(destination) == -1) { // check si le noeud destination existe et l'initialise
            this.noeuds.add(destination);
            this.adjacence.add(new Arcs(destination));
        }

        this.adjacence.get(this.getIndice(depart)).ajouterArc(new Arc(destination, cout)); // ajoute le nouvel arc entre départ et destination
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("--------------------------------------\n");
        for (Arcs arcList : adjacence) {
            sb.append(arcList.getNom());
            sb.append(" -> ");
            for (Arc arc : arcList.getArcs()) {
                sb.append(arc.getDest());
                sb.append("(");
                sb.append(arc.getCout());
                sb.append(") ");
            }
            sb.append("\n");
        }
        sb.append("--------------------------------------");
        return sb.toString();
    }
}
