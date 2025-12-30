package model;

public class Card {
    private int id;
    private String title;
    private String content;
    private boolean isLearned;
    private int userId;


    public Card(String title, String content, int userId) {
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.isLearned = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isLearned() {
        return isLearned;
    }

    public void setLearned(boolean learned) {
        isLearned = learned;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
