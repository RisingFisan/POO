public class TesteStackStr {
    public static void main(String[] args) {
        StackStr aMinhaStack = new StackStr();

        aMinhaStack.push("teste ");
        aMinhaStack.push("da ");
        aMinhaStack.push("stack");

        System.out.println(aMinhaStack.toString());
    }
}
