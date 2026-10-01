import java.util.ArrayList;
import java.util.List;

public class Diaries {
    private List<Diary> diaries = new ArrayList<>();

    public void add(String name, String password) {
        diaries.add(new Diary(name, password));
    }

    public Diary findByUserName(String userName) {
        check(userName);
        for (Diary diary : diaries) { if (diary.getUserName().equals(userName)) {return diary;}}
        return null;
    }

    public void delete(String name, String password) {
        validate(password,name);
        diaries.remove(findByUserName(name));
    }

    private boolean doesExist(String userName) {
        for (Diary diary : diaries) {if (diary.getUserName().equals(userName)) {return true;}}
        return false;
    }

    private void check(String username) {if (!doesExist(username)) throw new IllegalArgumentException("Username " + username + " does not exist");}

    private void validate(String password , String userName) {
        Diary foundUser = findByUserName(userName);
        boolean locked = foundUser.isLocked();
        foundUser.lockDiary();
        foundUser.unlockDiary(password);
        if(locked) foundUser.unlockDiary(password);
    }
}
