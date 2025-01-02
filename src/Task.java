import java.time.LocalDateTime;

public class Task {
    private static int counter = 0;
    private int id;
    private String description;
    private Status status;
    private LocalDateTime timeCreatedAt;
    private LocalDateTime updatedAt;

    public Task(String description, Status status) {
        this.id = ++counter;
        this.description = description;
        this.status = status;
        this.timeCreatedAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        this.updatedAt = LocalDateTime.now();
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
        this.updatedAt = LocalDateTime.now();
    }

    public LocalDateTime getTimeCreatedAt() {
        return timeCreatedAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Description: %s, Status: %s, Created At: %s, Updated At: %s",
                id, description, status, timeCreatedAt, updatedAt);
    }
}
