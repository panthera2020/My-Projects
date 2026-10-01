import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiariesTest {
    private  Diaries diaries;
    private String name = "Ronke";
    private String password = "Ronke1234";

    @BeforeEach
    public void setUp(){
        diaries = new Diaries();
    }

    @Test
    public void testThatDiariesCanAddDiary(){
        diaries.add(name,password);
        Diary result = diaries.findByUserName(name);
        assertEquals("Ronke", result.getUserName());
    }

    @Test
    public void testThatWhenDairyIsAddedAndDeletedAndIFindDeletedDiary_ErrorIsThrown(){
        diaries.add(name,password);
        diaries.delete(name,password);
        assertThrows(IllegalArgumentException.class, () -> diaries.findByUserName(name));
    }

    @Test void testThatWhenIDeleteDiaryNotInDiary_ErrorIsThrown(){
        assertThrows(IllegalArgumentException.class, () -> diaries.delete(name,password));
    }

    @Test
    public void testThatWhenIWantToDeleteFromDiaryAndPasswordIsNotCorrect_ErrorIsThrown(){
        assertThrows(IllegalArgumentException.class, () -> diaries.delete(name,"balablue"));
    }

    @Test
    public void testThatWhenIFindDiaryThatDoesNotExist_ErrorIsThrown(){
        assertThrows(IllegalArgumentException.class, () -> diaries.findByUserName(name));
    }

    @Test
    public void testThatWhenIAddTwoDiaries_ICanFindEachByUserName(){
        diaries.add(name, password);
        diaries.add("Tola", "Tola1234");
        Diary userDiaryOne = diaries.findByUserName(name);
        Diary userDiaryTwo = diaries.findByUserName("Tola");
        assertEquals(name, userDiaryOne.getUserName());
        assertEquals("Tola", userDiaryTwo.getUserName());
    }

}
