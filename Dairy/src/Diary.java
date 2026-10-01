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

    public String getUserName() { return userName; }

    public boolean isLocked() { return locked; }

    private int generateId(){ return diaryEntries.size() + 1; }

    public void createEntry(String title, String body) {
        checkLock();
        DairyEntry newEntry = new DairyEntry(generateId(),title,body);
        diaryEntries.add(newEntry);
    }

    public DairyEntry findEntry(int id) {
        checkLock();
        validate(id);
        for (DairyEntry userEntry : diaryEntries) { if (userEntry.getEntryId() == id) { return userEntry; }}
        return null;
    }

    public void deleteEntry(int id) {
        checkLock();
        validate(id);
        for (DairyEntry userEntry : diaryEntries) {if (userEntry.getEntryId() == id) { diaryEntries.remove(userEntry); }}
    }

    public void lockDiary() { locked = true; }

    public void unlockDiary(String password) {
        validate(password);
        locked = false;
    }

    public void update(int id,String title, String body) {
        checkLock();
        validate(id);
        findEntry(id).update(title);
        findEntry(id).updateText(body);
    }

    private boolean doesEntryContain(int id) {
        for (DairyEntry userEntries : diaryEntries) { if (userEntries.getEntryId() == id) { return true; } }
        return false;
    }

    private void validate(int id) { if(!doesEntryContain(id)) throw new IllegalArgumentException("Entry Not Found"); }

    private void validate(String password) { if(!password.equals(this.password)) throw new IllegalArgumentException("Passwords do not match");}

    private void checkLock(){if(locked) throw new IllegalArgumentException("Diary has been locked"); }

}
