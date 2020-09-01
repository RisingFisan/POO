import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class GestaoEncomendas {

    private TreeMap<String, Encomenda> mapEncomendas;

    public GestaoEncomendas() {
        this.mapEncomendas = new TreeMap<>();
    }

    public GestaoEncomendas(Map<String, Encomenda> mapEncomendas) {
        this.setMapEncomendas(mapEncomendas);
    }

    public GestaoEncomendas(GestaoEncomendas gestaoEncomendas) {
        this.setMapEncomendas(gestaoEncomendas.getMapEncomendas());
    }

    public Map<String, Encomenda> getMapEncomendas() {
        return this.mapEncomendas.entrySet()
                .stream()
                .collect(Collectors.toMap(e->e.getKey(), e->e.getValue().clone()));
    }

    public void setMapEncomendas(Map<String, Encomenda> arvoreEncomendas) {
        this.mapEncomendas = arvoreEncomendas.entrySet()
                .stream()
                .collect(Collectors.toMap(e->e.getKey(), e->e.getValue().clone(), (a,b) -> b, TreeMap::new));
    }

    public Set<String> todosCodigosEnc() {
        return this.mapEncomendas.keySet();
    }

    public void addEncomenda(Encomenda enc) {
        this.mapEncomendas.put(enc.getIdEnc(), enc);
    }

    public Encomenda getEncomenda(String codEnc) {
        return this.mapEncomendas.get(codEnc);
    }

    public void removeEncomenda(String codEnc) {
        this.mapEncomendas.remove(codEnc);
    }

    public String encomendaComMaisProdutos() {
        return this.mapEncomendas.entrySet()
                .stream()
                .max((e1, e2) -> e1.getValue().getEncomendas().size() - e2.getValue().getEncomendas().size())
                .get()
                .getKey();
    }

    public Set<String> encomendasComProduto(String codProd) {
        return this.mapEncomendas.entrySet()
                .stream()
                .filter(e -> e.getValue().getEncomendas().stream().anyMatch(prod -> prod.getReferencia() == codProd))
                .map(e -> e.getKey())
                .collect(Collectors.toSet());
    }

    public Set<String> encomendasAposData(LocalDate d) {
        return this.mapEncomendas.entrySet()
                .stream()
                .filter(e -> e.getValue().getData().compareTo(d) > 0)
                .map(e -> e.getKey())
                .collect(Collectors.toSet());
    }

    public List<Encomenda> encomendasValorDescrescente() {
        return this.mapEncomendas.values()
                .stream()
                .sorted((e1, e2) -> e2.getnEnc() - e1.getnEnc())
                .collect(Collectors.toList());
    }

    public Map<String, List<String>> encomendasDeProduto() {
        return this.mapEncomendas.values()
                .stream()
                .collect(Collectors.toMap(Encomenda::getIdEnc, e -> e.getEncomendas().stream().map(LinhaEncomenda::getReferencia).collect(Collectors.toList())))
                .entrySet()
                .stream()
                .flatMap(e -> e.getValue().stream().map(s -> new AbstractMap.SimpleEntry<>(e.getKey(), s)))
                .collect(Collectors.groupingBy(AbstractMap.SimpleEntry::getValue, Collectors.mapping(AbstractMap.SimpleEntry::getKey, Collectors.toList())));
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GestaoEncomendas that = (GestaoEncomendas) o;
        return this.mapEncomendas.equals(that.mapEncomendas);
    }

    public String toString() {
        final StringBuffer sb = new StringBuffer("Gestão de encomendas {\n");
        sb.append("\tMap de encomendas = ").append(mapEncomendas.toString()).append('\n');
        sb.append("\n}");
        return sb.toString();
    }

    public GestaoEncomendas clone() {
        return new GestaoEncomendas(this);
    }
}
