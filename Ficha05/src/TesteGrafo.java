public class TesteGrafo {
    public static void main(String[] args) {
        Grafo g = new Grafo();

        g.addArco(1,2);
        g.addArco(1,3);
        g.addArco(1,4);
        g.addArco(2,6);
        g.addArco(2,7);
        g.addArco(3,5);
        g.addArco(4,3);
        g.addArco(5,7);
        g.addArco(6,4);

        System.out.println("Tamanho do grafo (7 + 9 = 16): " + g.size());
        System.out.println("Teste isSink: " + (g.isSink(7) && !g.isSink(1) ? "passou" : "não passou"));
        System.out.println("Teste isSource: " + (g.isSource(1) && !g.isSource(7) ? "passou" : "não passou"));
        System.out.println("Teste haCaminho: " + (g.haCaminho(2,3) && !g.haCaminho(6, 1) ? "passou" : "não passou"));
        System.out.println("Caminho de 2 a 3 (2 -> 6 -> 4 -> 3): " + g.getCaminho(2, 3));
        System.out.println("Fan out de 1 (1-2, 1-3, 1-4): " + g.fanOut(1));
        System.out.println("Fan out de 7 (): " + g.fanOut(7));
        System.out.println("Fan in de 4 (1-4, 6-4): " + g.fanIn(4));
        System.out.println("Fan in de 1 (): " + g.fanIn(1));

        Grafo subg = new Grafo();
        g.addArco(1,2);
        g.addArco(2,7);
        g.addArco(3,5);
        g.addArco(5,7);

        System.out.println("Teste subGrafo: " + (subg.subGrafo(g) ? "passou" : "não passou"));
    }

}
