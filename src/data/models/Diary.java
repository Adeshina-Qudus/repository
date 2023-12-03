package data.models;

public class Diary{
    private int id;
    private String username;
    private String password;
    private boolean isLocked;
    private int entryId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLocked() {
        return isLocked;
    }

    @Override
    public String toString() {
        return "Diary{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isLocked=" + isLocked +
                '}';
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public void setEntryId(int entryId) {
        this.entryId = entryId;
    }
    public int getEntryId() {
        return entryId;
    }
}
