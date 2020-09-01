import jdk.jfr.Unsigned;

import java.util.Scanner;

public class TestePrograma {
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        System.out.println("Introduz o número da pergunta: ");
        int question = inputReader.nextInt();
        switch (question) {
            case 1:
                Circle circle1 = new Circle();
                System.out.println("Círculo predefinido, valores devem ser x = 0.0, y = 0.0 e raio = 1.0.");
                System.out.println(circle1.toString() + "\n");

                double x = 3.1;
                double y = -6.9;
                double radius = 5;
                Circle circle2 = new Circle(x, y, radius);
                System.out.printf("Círculo com valores iniciais x = %f, y = %f e raio = %f.\n", x, y, radius);
                System.out.println(circle2.toString() + "\n");

                Circle circle3 = new Circle(circle2);
                System.out.println("Círculo obtido por cópia do círculo anterior");
                System.out.println(circle3.toString() + "\n");

                circle3.setX(-4.2);
                circle3.setY(1);
                circle2.setRadius(0.1);
                circle1.changeCenter(2,3);
                System.out.println("Alteração dos valores x e y do círculo 3 para -4.2 e 1, respetivamente.");
                System.out.println(circle3.toString());
                System.out.println("Alteração do raio do círculo 2 para 0.1.");
                System.out.println(circle2.toString());
                System.out.println("Alteração do centro do círculo 1 para x = 2.0 e y = 3.0.");
                System.out.println(circle1.toString() + "\n");

                System.out.printf("Área do círculo 2 (deve dar cerca de 0.03): %f\n", circle2.area());
                System.out.printf("Perímetro do círculo 3 (deve dar cerca de 31.42): %f\n", circle3.perimeter());
                break;
            case 7:
                LinhaEncomenda linhaBlank = new LinhaEncomenda();
                System.out.println("Linha de encomenda predefinida, valores devem ser todos nulos.");
                System.out.println(linhaBlank.toString() + '\n');

                LinhaEncomenda linhaValores = new LinhaEncomenda("ABCD","Produto interessante!",29.90,4,23, 6);
                System.out.println("Linha de encomenda com valores iniciais (ref=\"ABCD\", desc=\"Produto interessante!\", precoSemTaxas=29.90, qtd=4, imposto=23%, descComercial=6%).");
                System.out.println(linhaValores.toString() + "\n");

                LinhaEncomenda linhaClone = new LinhaEncomenda(linhaValores);
                System.out.println("Linha de encomenda copiada da anterior, valores devem ser iguais.");
                System.out.println(linhaClone.toString() + "\n");

                linhaClone.setPrecoSemTaxas(25);
                System.out.println("Preço antes de impostos mudado para 25.");
                System.out.println(linhaClone.toString() + "\n");
                double valorLinhaEnc = linhaClone.calculaValorLinhaEnc();
                System.out.printf("O valor da venda já considerados os impostos e descontos é: %f\n",valorLinhaEnc);
                double valorDesconto = linhaClone.calculaValorDesconto();
                System.out.printf("O valor do desconto é: %f\n",valorDesconto);
                break;
            case 9:
                Ponto a = new Ponto(0,0);
                Ponto b = new Ponto(0,3);
                Ponto c = new Ponto(4,0);
                Triangulo triangulo1 = new Triangulo(a,b,c);
                a.setX(-5);
                System.out.println("Triângulo definido pelos pontos (0,0), (0,3) e (4,0).");
                System.out.println(triangulo1.toString() + "\n");
                System.out.println("Área do triângulo = " + triangulo1.calculaAreaTriangulo());
                System.out.println("Perímetro do triângulo = " + triangulo1.calculaPerimetroTriangulo());
                System.out.println("Altura do triângulo = " + triangulo1.calculaAltura());

                Triangulo triangulo2 = triangulo1.clone();
                if(!triangulo1.equals(triangulo2)) System.out.println("Something is wrong with the equals or the clone functions.");
                break;
        }
    }
}
