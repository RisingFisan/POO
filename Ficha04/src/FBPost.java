import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.time.temporal.ChronoUnit.DAYS;

public class FBPost {
    private int ID;
    private String userName;
    private LocalDateTime instantCreated;
    private String content;
    private int likes;
    private ArrayList<String> comments;

    public FBPost(int ID, String userName, String content) {
        this.ID = ID;
        this.userName = userName;
        this.content = content;
        this.instantCreated = LocalDateTime.now();
        this.likes = 0;
        this.comments = new ArrayList<>();
    }

    public FBPost(int ID, String userName, String content, int likes) {
        this.ID = ID;
        this.userName = userName;
        this.content = content;
        this.instantCreated = LocalDateTime.now();
        this.likes = likes;
        this.comments = new ArrayList<>();
    }

    public FBPost(int ID, String userName, String content, int likes, List<String> comments) {
        this.ID = ID;
        this.userName = userName;
        this.content = content;
        this.instantCreated = LocalDateTime.now();
        this.likes = likes;
        this.comments = new ArrayList<>(comments);
    }

    public FBPost(int ID, String userName, String content, int likes, List<String> comments, LocalDateTime dateTime) {
        this.ID = ID;
        this.userName = userName;
        this.content = content;
        this.instantCreated = dateTime;
        this.likes = likes;
        this.comments = new ArrayList<>(comments);
    }

    public FBPost(FBPost post) {
        this.ID = post.getID();
        this.userName = post.getUserName();
        this.content = post.getContent();
        this.instantCreated = post.getInstantCreated();
        this.likes = post.getLikes();
        this.comments = new ArrayList<>(post.getComments());
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDateTime getInstantCreated() {
        return this.instantCreated;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLikes() {
        return this.likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public ArrayList<String> getComments() {
        return this.comments;
    }

    public void setComments(ArrayList<String> comments) {
        this.comments = new ArrayList<>(comments);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        FBPost fbPost = (FBPost) o;
        return this.ID == fbPost.ID &&
                this.likes == fbPost.likes &&
                this.userName.equals(fbPost.userName) &&
                this.instantCreated.equals(fbPost.instantCreated) &&
                this.content.equals(fbPost.content) &&
                this.comments.equals(fbPost.comments);
    }

    public String toString() {
        final StringBuffer sb = new StringBuffer("FBPost {\n");
        sb.append("\tID = ").append(ID).append('\n');
        sb.append("\tUsername = '").append(userName).append("'\n");
        sb.append("\tCreated = ").append(instantCreated).append('\n');
        sb.append("\tContent = '").append(content).append("'\n");
        sb.append("\tLikes = ").append(likes).append('\n');
        sb.append("\tComments = ").append(comments).append('\n');
        sb.append('}');
        return sb.toString();
    }

    public FBPost clone() {
        return new FBPost(this);
    }
}
