import java.util.ArrayList;
import java.util.List;

public class Diary {
    private List<DairyEntry> diaryEntries = new ArrayList<>();


    public void logEntry(String text) {
        DairyEntry entry = new DairyEntry();
        entry.addEntry(text);
        diaryEntries.add(entry);
    }


    public String viewEntry(String timeStamp) {
        for (DairyEntry entry : diaryEntries) {
            if (entry.getTimeStamp().equals(timeStamp)) {
                return entry.getEntry();
            }
        }
        return null;
    }

    public void deleteEntry(String timeStamp) {
        if(!isEntryInDiary(timeStamp)) throw new IllegalArgumentException("Entry Not Found");
        for (DairyEntry entry : diaryEntries) {
            if (entry.getTimeStamp().equals(timeStamp)) {
                diaryEntries.remove(entry);
                break;
            }
        }
    }

    private boolean isEntryInDiary(String timeStamp) {
        for (DairyEntry entry : diaryEntries) { if (entry.getTimeStamp().equals(timeStamp)) { return true; } }
        return false;
    }
}
