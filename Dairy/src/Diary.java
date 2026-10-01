import java.util.ArrayList;
import java.util.List;

public class Diary {
    private final String userName;
    private final String password;
    private boolean locked;
    private List<DairyEntry> diaryEntries = new ArrayList<>();

    public Diary(String userName, String password){
        this.userName = userName;
        this.password = password;
        this.locked = false;
    }

    public boolean isLocked() {
        return locked;
    }

    private int generateId(){
        return diaryEntries.size() + 1;
    }

    public void createEntry(String title, String body) {
        DairyEntry newEntry = new DairyEntry(generateId(),title,body);
        diaryEntries.add(newEntry);
    }

    public DairyEntry findEntry(int id) {
        validate(id);
        for (DairyEntry userEntry : diaryEntries) { if (userEntry.getEntryId() == id) { return userEntry; }}
        return null;
    }

    public void deleteEntry(int id) {
        validate(id);
        for (DairyEntry userEntry : diaryEntries) {if (userEntry.getEntryId() == id) { diaryEntries.remove(userEntry); }}
    }

    public void lockDiary() { locked = true; }

    public void unlockDiary() { locked = false; }

    private boolean doesEntryContain(int id) {
        for (DairyEntry userEntries : diaryEntries) { if (userEntries.getEntryId() == id) { return true; } }
        return false;
    }

    private void validate(int id) {
        if(!doesEntryContain(id)) throw new IllegalArgumentException("Entry Not Found");
    }



}
