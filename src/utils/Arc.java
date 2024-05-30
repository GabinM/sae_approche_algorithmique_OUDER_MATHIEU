package utils;

public class Arc {

    private final String dest;
    private final double cout;

    public Arc(String d, double c){
        if (c < 0) {
            throw new IllegalArgumentException("Cout négatif");
        }
        this.dest = d;
        this.cout = Math.abs(c);

    }

    public String getDest(){
        return this.dest;
    }

    public double getCout(){
        return this.cout;
    }

}