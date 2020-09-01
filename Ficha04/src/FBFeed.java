import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class FBFeed {
    private
    ArrayList<FBPost> posts;

    public FBFeed() {
        this.posts = new ArrayList<>();
    }

    public FBFeed(List<FBPost> posts) {
        setPosts(posts);
    }

    public FBFeed(FBFeed feed) {
        setPosts(feed.getPosts());
    }

    public List<FBPost> getPosts() {
        return this.posts.stream()
                .map(FBPost::clone)
                .collect(Collectors.toList());
    }

    public void setPosts(List<FBPost> posts) {
        this.posts = posts.stream()
                .map(FBPost::clone)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public void addPost(FBPost post) {
        this.posts.add(post);
    }

    public int nrPosts(String user) {
        return this.postsOf(user).size();
    }

    public List<FBPost> postsOf(String user) {
        return this.posts.stream()
                .filter(post -> (post.getUserName().equals(user)))
                .collect(Collectors.toList());
    }

    public List<FBPost> postsOf(String user, LocalDateTime inicio, LocalDateTime fim) {
        return this.posts.stream()
                .filter(post -> (post.getUserName().equals(user)
                        && post.getInstantCreated().compareTo(inicio) > 0
                        && post.getInstantCreated().compareTo(fim) < 0))
                .collect(Collectors.toList());
    }

    public FBPost getPost(int ID) {
        for(FBPost post : this.posts)
            if(post.getID() == ID)
                return post;
        return null;
    }

    public void comment(FBPost post, String comentario) {
        post.getComments().add(comentario);
    }

    public void comment(int postid, String comentario) {
        comment(getPost(postid), comentario);
    }

    public void like(FBPost post) {
        post.setLikes(post.getLikes() + 1);
    }

    public void like(int postid) {
        like(getPost(postid));
    }

    public List<Integer> top5CommentsExt() {
        ArrayList<FBPost> copy = new ArrayList<>(this.posts);
        List<Integer> top5 = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            FBPost mostCommented = null;
            for(FBPost post : copy)
                if(mostCommented == null || mostCommented.getComments().size() < post.getComments().size())
                    mostCommented = post;
            top5.add(mostCommented.getID());
            copy.remove(mostCommented);
        }
        return top5;
    }

    public List<Integer> top5CommentsInt() {
        return this.posts.stream()
                .sorted((Comparator<FBPost>) (p1,p2) -> p2.getComments().size() - p1.getComments().size())
                .limit(5)
                .map(FBPost::getID)
                .collect(Collectors.toList());
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        FBFeed fbFeed = (FBFeed) o;
        return this.posts.equals(fbFeed.posts);
    }

    public int hashCode() {
        return Objects.hash(posts);
    }

    public String toString() {
        final StringBuffer sb = new StringBuffer("FBFeed {\n");
        sb.append(posts).append('\n');
        sb.append("\n}");
        return sb.toString();
    }

    public FBFeed clone() {
        return new FBFeed(this);
    }
}
