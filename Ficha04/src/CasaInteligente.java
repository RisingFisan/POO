import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CasaInteligente {
    private ArrayList<Lampada> lamps;

    public CasaInteligente() {
        this.lamps = new ArrayList<>();
    }

    public CasaInteligente(List<Lampada> lamps) {
        setLamps(lamps);
    }

    public List<Lampada> getLamps() {
        return this.lamps.stream()
                .map(Lampada::clone)
                .collect(Collectors.toList());
    }

    public void setLamps(List<Lampada> lamps) {
        this.lamps = new ArrayList<>();
        for(Lampada l : lamps)
            this.lamps.add(l.clone());
    }

    public void addLampada(Lampada l) {
        this.lamps.add(l.clone());
    }

    public void ligaLampadaNormal(int index) {
        this.lamps.get(index).lampON();
    }

    public void ligaLampadaEco(int index) {
        this.lamps.get(index).lampECO();
    }

    public int qtEmEco() {
        return (int) this.lamps.stream()
                .filter(l -> (l.getState() == State.ECO))
                .count();
    }
}
