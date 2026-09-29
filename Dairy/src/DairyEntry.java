import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DairyEntry {
    private int entryId = 0;
    private String text = "";
    private String timeStamp = "";

    public void addEntry(String entry) {
        canLogEntry();
        text += entry;
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        timeStamp = time.format(timeFormat);
        entryId++;
    }

    private void canLogEntry(){ if(!text.isEmpty()) throw new IllegalArgumentException("Entry is Logged"); }
    public String getEntry() { return text;}

    public String getTimeStamp() { return timeStamp; }

    public int getEntryId() { return entryId;}
}
