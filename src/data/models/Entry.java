package data.models;

import java.time.LocalDateTime;

public class Entry {
    private  int id;
    private String title;
    private String body;
    private LocalDateTime dateCreated;
    private int diaryId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getDiaryId() {
        return diaryId;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", dateCreated=" + dateCreated +
                ", diaryId=" + diaryId +
                '}';
    }

    public void setDiaryId(int diaryId) {
        this.diaryId = diaryId;
    }
}
