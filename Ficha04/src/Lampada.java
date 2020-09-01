public class Lampada {
    private State state;
    private double powerNormal;
    private double powerEco;

    public Lampada(double powerNormal, double powerEco) {
        this.state = State.OFF;
        this.powerNormal = powerNormal;
        this.powerEco = powerEco;
    }

    public Lampada(double powerNormal, double powerEco, State state) {
        this.state = state;
        this.powerNormal = powerNormal;
        this.powerEco = powerEco;
    }

    public Lampada(Lampada lampada) {
        this.state = lampada.getState();
        this.powerNormal = lampada.getPowerNormal();
        this.powerEco = lampada.getPowerEco();
    }

    public State getState() {
        return this.state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public double getPowerNormal() {
        return this.powerNormal;
    }

    public void setPowerNormal(double powerNormal) {
        this.powerNormal = powerNormal;
    }

    public double getPowerEco() {
        return this.powerEco;
    }

    public void setPowerEco(double powerEco) {
        this.powerEco = powerEco;
    }

    public void lampON() {
        this.state = State.ON;
    }

    public void lampECO() {
        this.state = State.ECO;
    }
/*
    public int compareTo(Lampada l) {
        return l.periodoConsumo() - this.periodoConsumo();
    }
*/
    public String toString() {
        final StringBuffer sb = new StringBuffer("Lâmpada {");
        sb.append("\tState = ").append(this.state.toString()).append("\n");
        sb.append("\tNormal power = ").append(this.powerNormal).append("W\n}");
        sb.append("\tEco power = ").append(this.powerEco).append("W\n}");
        return sb.toString();
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Lampada lampada = (Lampada) o;
        return this.state.equals(lampada.getState()) &&
                Double.compare(lampada.getPowerNormal(), this.powerNormal) == 0 &&
                Double.compare(lampada.getPowerEco(), this.powerEco) == 0;
    }

    public Lampada clone() {
        return new Lampada(this);
    }
}
