import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DairyTest {
    private final String userName = "Ronke";
    private final String password = "Ronke1234";
    private Diary diary;
    private String title = "Monday";
    private String body = "I went to work";
    private int id = 1;

    @BeforeEach
    public void setUp() {
        diary = new Diary(userName, password);
    }

    @Test
    public void testThatWhenDiaryIsCreated_DairyIsUnlocked() {
        assertFalse(diary.isLocked());
    }

    @Test
    public void testThatWhenDiaryIsCreated_UserNameIsSet() {
        assertEquals(userName, diary.getUserName());
    }

    @Test
    public void testThatWhenDiaryIsCreated_UserCanAddDiaryEntry() {
        diary.createEntry(title,body);
        DairyEntry result = diary.findEntry(id);
        assertEquals(title.toUpperCase(),result.getTitle());
        assertEquals(body,result.getBody());
    }

    @Test
    public void testThatUserCanDeleteEntry() {
        diary.createEntry(title,body);
        String newTitle = "Tuesday";
        String newBody = "I went to the club";
        diary.createEntry(newTitle, newBody);
        diary.deleteEntry(id);
        assertThrows(IllegalArgumentException.class, () -> diary.findEntry(id));
    }

    @Test
    public void testThatUserCanLockDiaryEntry() {
        diary.lockDiary();
        assertTrue(diary.isLocked());
    }

    @Test
    public void testThatUserCanUnlockDiaryEntryAfterDiaryIsLockedWithPassword() {
        diary.lockDiary();
        assertTrue(diary.isLocked());
        diary.unlockDiary(password);
        assertFalse(diary.isLocked());
    }

    @Test
    public void testThatUserCanUpdateEntry() {
        diary.createEntry(title,body);
        String newTitle = "Tuesday";
        String newBody = "I went to the club";
        diary.update(id,newTitle,newBody);
        DairyEntry result = diary.findEntry(id);
        assertEquals(newTitle.toUpperCase(),result.getTitle());
        assertEquals(newBody,result.getBody());
    }

    @Test
    public void testThatWhenDiaryIsLocked_UserCannotCreateDiaryEntry_ErrorIsThrown() {
        diary.lockDiary();
        assertThrows(IllegalArgumentException.class, () -> diary.createEntry(title,body));
    }

    @Test
    public void testThatWhenDiaryIsLocked_UserCannotDeleteDiaryEntry_ErrorIsThrown() {
        diary.createEntry(title,body);
        diary.lockDiary();
        assertThrows(IllegalArgumentException.class, () -> diary.deleteEntry(id));
    }

    @Test
    public void testThatWhenDiaryIsLocked_UserCannotFindEntry_ErrorIsThrown() {
        diary.createEntry(title,body);
        diary.lockDiary();
        assertThrows(IllegalArgumentException.class, () -> diary.findEntry(id));
    }

    @Test
    public void testThatWHenDiaryIsLocked_UserCannotUpdateDiaryEntry_ErrorIsThrown() {
        diary.createEntry(title,body);
        diary.lockDiary();
        String newTitle = "Tuesday";
        String newBody = "I went to the club";
        assertThrows(IllegalArgumentException.class, ()-> diary.update(id,newTitle,newBody));
    }

    @Test
    public void testThatWhenIFindEntryOfUnknownId_ErrorIsThrown() {
        assertThrows(IllegalArgumentException.class, ()-> diary.findEntry(id));
        diary.createEntry(title,body);
        assertThrows(IllegalArgumentException.class, ()-> diary.findEntry(2));
    }

    @Test
    public void testThatWhenUserEntersWrongPassword_ErrorIsThrown() {
        diary.lockDiary();
        assertThrows(IllegalArgumentException.class, () -> diary.unlockDiary("wrongPassword"));
    }

    @Test
    public void testThatWhenIDeleteEntry_CorrectEntryIsDeleted() {
        diary.createEntry(title, body);
        diary.createEntry("Tuesday", "I went to the club");
        diary.deleteEntry(id);
        assertThrows(IllegalArgumentException.class, () -> diary.findEntry(id));
        assertNotNull(diary.findEntry(2)); // second entry still exists
    }
}
