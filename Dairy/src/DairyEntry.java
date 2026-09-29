import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DairyEntry {
    private String text = "";
    private String timeStamp = "";

    public void addEntry(String entry) {
        if(text.isEmpty()) {
            text += entry;
            LocalDateTime time = LocalDateTime.now();
            DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            timeStamp = time.format(timeFormat);
        }

    }
    public String getEntry() {
        return text;
    }

    public String getTimeStamp() {
        return timeStamp;
    }
}
