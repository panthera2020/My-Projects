import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DairyEntry {
    private int entryId;
    private String title;
    private String body;
    private final String timeStamp;

    public DairyEntry(int entryId, String title, String body) {
        this.entryId = entryId;
        this.title = title;
        this.body = body;
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        this.timeStamp = time.format(timeFormat);
    }

    public void update(String title) { this.title = title; }

    public String getTitle() { return title.toUpperCase();}

    public void updateText(String body) { this.body = body;}

    public String getBody() { return body;}

    public void updateId(int number){ entryId = number; }

    public String getEntry() { return getTitle() + "\n" + timeStamp + "\n" + getBody(); }

    public int getEntryId() { return entryId;}
}
