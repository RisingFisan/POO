import java.util.ArrayList;

public class StackStr {
    ArrayList<String> stack;

    public StackStr() {
        this.stack = new ArrayList<String>();
    }

    public void push(String s) {
        this.stack.add(s);
    }

    public String top() {
        if (!this.stack.isEmpty())
            return this.stack.get(this.stack.size() - 1);
        else
            return null; //Temos que futuramente validar se a stack está vazia. Caso esteja vazia não
                       //faz sentido executar este método.
    }

    public String pop() {
        if(!this.stack.isEmpty())
            return this.stack.remove(this.stack.size() - 1);
        else
            return null;
    }

    public boolean empty() {
        return this.stack.isEmpty();
    }

    public int length() {
        return this.stack.size();
    }

    public String toString() {
        final StringBuffer sb = new StringBuffer("Stack de Strings\n");
        sb.append("Stack: " + this.stack.toString());
        return sb.toString();
    }
}
