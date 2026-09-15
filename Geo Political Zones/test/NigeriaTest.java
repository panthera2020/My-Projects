import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NigeriaTest {

    @Test
    public void testThatWhenICollectAnInput_IGetGeoPoliticalZones() {
        Nigeria nigeria = new Nigeria();
        assertEquals("NORTHCENTRAL",nigeria.getGeoPoliticalZone("Benue"));
    }

    @Test
    public void testThatWhenICollectAnInput_AndStateDoesNotExist_ErrorIsThrown() {
        Nigeria nigeria = new Nigeria();
        assertThrows(IllegalArgumentException.class, () -> nigeria.getGeoPoliticalZone("BENDEL"));
    }
}
