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
    public void testThatWhenDiaryIsCreated_UserCanAddDiaryEntry() {
        diary.createEntry(title,body);
        DairyEntry result = diary.findEntry(id);
        assertEquals(title.toUpperCase(),result.getTitle());
        assertEquals(body,result.getBody());
    }

    @Test
    public void testThatUserCanDeleteEntry() {
        diary.createEntry(title,body);
        String newTitle = "Monday";
        String newBody = "I went to work";
        int newId = 1;
        diary.createEntry(newTitle, newBody);
        diary.deleteEntry(newId);
        assertThrows(IllegalArgumentException.class, () -> diary.findEntry(newId));
    }

    @Test
    public void testThatUserCanLockDiaryEntry() {
        diary.lockDiary();
        assertTrue(diary.isLocked());
    }

    @Test
    public void testThatUserCanUnlockDiaryEntryAfterDiaryIsLocked() {
        diary.lockDiary();
        assertTrue(diary.isLocked());
        diary.unlockDiary();
        assertFalse(diary.isLocked());
    }
































//    private Diary diary;
//    private String text = "I went to school today";
//
//    @BeforeEach
//    public void setUp() {
//        diary = new Diary();
//    }
//
//    @Test
//    public void testThatNewDairyCreatedCanAddEntry() {
//        diary.logEntry(text);
//        String result = diary.viewEntry(1);
//        assertTrue(result.startsWith("30/09/2026"));
//        assertTrue(result.contains(text));
//    }
//
//    @Test
//    public void testThatWhenOneEntryIsAddedAndIDeleteEntryIsDeleted_WhenIViewWithDeletedEntryIdErrorEntryNotFoundIsThrown() {
//        diary.logEntry(text);
//        String result = diary.viewEntry(1);
//        assertTrue(result.contains(text));
//        diary.deleteEntry(1);
//        try {
//            diary.viewEntry(1);
//        } catch (IllegalArgumentException e) {
//            assertEquals(e.getMessage(), "Entry Not Found");
//        }
//    }
//
//    @Test
//    public void testThatWhenITryToViewEntryWithIdNotInDiary_ErrorIsThrown() {
//        diary.logEntry(text);
//        assertThrows(IllegalArgumentException.class, () -> diary.viewEntry(5));
//    }
//
//    @Test
//    public void testThatWhenITryToViewEmptyDiary_ErrorIsThrown() {
//        assertThrows(IllegalArgumentException.class, () -> diary.viewEntry(5));
//    }
//
//    @Test
//    public void testThatWhenITryToDeleteFromEmptyDiary_ErrorIsThrown() {
//        assertThrows(IllegalArgumentException.class, () -> diary.deleteEntry(1));
//    }
//
//    @Test
//    public void testThatWhenITryToDeleteFromDiaryWithIncorrectId_ErrorIsThrown() {
//        diary.logEntry(text);
//        assertThrows(IllegalArgumentException.class, () -> diary.deleteEntry(6));
//    }
//
//    @Test
//    public void testThatWhenIViewEntryNotInDiaryErrorEntryNotFoundIsThrown() {
//        try {
//            diary.viewEntry(1);
//        }catch (IllegalArgumentException e) {
//            assertEquals(e.getMessage(), "Entry Not Found");
//        }
//    }
//
//    @Test
//    public void testThatWhenIDeleteEntryNotInDiaryErrorEntryNotFoundIsThrown() {
//        assertThrows(IllegalArgumentException.class, () -> diary.deleteEntry(5));
//    }

}
