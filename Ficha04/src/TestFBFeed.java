import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

public class TestFBFeed {
    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.of(2018, Month.AUGUST, 31, 16, 32);
        FBPost post1 = new FBPost(1, "Sofia", "Boa tarde!",10, new ArrayList<>(), dateTime);
        FBPost post2 = new FBPost(2, "Diogo", "Estou a estudar.\nzzz");
        FBPost post3 = new FBPost(3, "Pedro", "Adoro Java!", 0);
        FBPost post4 = new FBPost(4, "Ana", "Detestei o final de Game of Thrones!", 104);
        FBPost post5 = new FBPost(5, "Sofia", "Lavem as mãos e fiquem em casa!", 2994, new ArrayList<>(), LocalDateTime.of(2020, 2, 29, 10, 56));
        FBPost post6 = new FBPost(6, "Rita", "Acabei de pedir uma pizza!",26);
        FBPost post7 = new FBPost(7, "Luís", "Acho que estou doente... :(", 2);

        ArrayList<FBPost> posts = new ArrayList<>();
        posts.add(post1);
        posts.add(post2);
        posts.add(post3);
        posts.add(post4);
        posts.add(post5);
        posts.add(post6);
        posts.add(post7);

        FBFeed feed = new FBFeed(posts);

        feed.comment(5, "Absolutamente de acordo!");
        feed.comment(7, "As melhoras!");
        feed.comment(3, "Prefiro Python.");
        feed.comment(3, "Eu gosto mais de Rust.");
        feed.comment(3, "Haskell é a melhor linguagem de programação!");
        feed.comment(6, "Não queres partilhar um bocadinho? :p");
        feed.comment(1, "Boa tarde!");
        feed.comment(7, "Não saias de casa!!!");

        feed.like(1);

        System.out.println("Teste função nrPosts: " + (feed.nrPosts("Sofia") == 2
                && feed.nrPosts("Rita") == 1
                && feed.nrPosts("Tiago") == 0 ? "Passou" : "Não passou"));
        System.out.println("Teste função postsOf: " + feed.postsOf("Sofia"));

        System.out.println("Teste função postsOf em 2020: " + feed.postsOf("Sofia", LocalDateTime.of(2020,1,1,0,0), LocalDateTime.now()));

        System.out.println("Teste função top 5 ext: " + feed.top5CommentsExt());
        System.out.println("Teste função top 5 int: " + feed.top5CommentsInt());
    }
}
