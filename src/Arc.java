class Arc {

    private String dest;
    private double cout;

    Arc(String d, double c){
        if (c < 0) {
            throw new IllegalArgumentException("Cout négatif");
        }
        this.dest = d;
        if (c < 0){
            this.cout = -1*c;
        } else {
            this.cout = c;
        }  
    }

    public String getDest(){
        return this.dest;
    }

    public double getCout(){
        return this.cout;
    }

}