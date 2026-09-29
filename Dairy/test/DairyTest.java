import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DairyTest {
    private Diary diary;

    @BeforeEach
    public void setUp() {
        diary = new Diary();
    }

    @Test
    public void testThatNewDairyCreatedCanAddEntry() {
        String text = "I went to school today";
        diary.logEntry(text);
        assertEquals("I went to school today", diary.viewEntry("29/09/2026 14:09"));
    }

    @Test
    public void testThatWhenOneEntryIsAddedAndIDeleteEntryIsDeleted_WhenIViewWithTimeStampNotInDiaryErrorEntryNotFoundIsThrown() {
        String text = "I went to school today";
        diary.logEntry(text);
        assertEquals("I went to school today", diary.viewEntry("29/09/2026 14:34"));
        diary.deleteEntry("29/09/2026 14:34");
        try {
            diary.viewEntry("29/09/2026 14:34");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Entry not found");
        }
    }

    @Test
    public void testThatWhenIViewEntryNotInDiaryErrorEntryNotFoundIsThrown() {
        try {
            diary.viewEntry("29/09/2026 14:34");
        }catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Entry not found");
        }
    }

}
