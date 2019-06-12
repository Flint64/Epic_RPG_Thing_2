package chimera.epic_rpg_thing;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class GenerateDefenseTest {
    @Test
  public void generateDefenseTest() {
      int d = 50;
      int fence = 20;
      int defense = d + fence;
      assertEquals(defense,70);
  }
}