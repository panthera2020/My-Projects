import java.util.ArrayList;
import java.util.List;

public class Diary {
    private List<DairyEntry> diaryEntries = new ArrayList<>();

    public void logEntry(String text) {
        DairyEntry entry = new DairyEntry();
        entry.addEntry(text);
        diaryEntries.add(entry);
    }

    public String viewEntry(int id) {
        validate(id);
        return findEntry(id);
    }
    public void deleteEntry(int id) {
        validate(id);
        diaryEntries.remove(getEntry(id));
    }

    private String findEntry(int id) {
        validate(id);
        return getEntry(id).getTimeStamp() + "\n" + getEntry(id).getEntry();
    }

    private DairyEntry getEntry(int id) {
        for (DairyEntry userEntry : diaryEntries) { if (userEntry.getEntryId() == id) { return userEntry;}}
        return null;
    }

    private boolean doesEntryContain(int id) {
        for (DairyEntry userEntries : diaryEntries) { if (userEntries.getEntryId() == id) { return true; } }
        return false;
    }

    private void validate(int id) {
        if(!doesEntryContain(id)) throw new IllegalArgumentException("Entry Not Found");
    }
}
