import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class MainTest {

  @Test
  public void test() {
    Assertions.assertEquals(0, Main.findFrequency(null, "test"));
    Assertions.assertEquals(0, Main.findFrequency(new HashMap<>(), "test"));
    Assertions.assertEquals(0, Main.findFrequency(new HashMap<>(), "dummy"));

    Map<String, Integer> frequencyTable = Main.buildFrequencyTable("Hello there dummy content Hello again    ");

    Assertions.assertEquals(0, Main.findFrequency(frequencyTable, "drums"));
    Assertions.assertEquals(1, Main.findFrequency(frequencyTable, "there"));
    Assertions.assertEquals(1, Main.findFrequency(frequencyTable, "dummy"));
    Assertions.assertEquals(1, Main.findFrequency(frequencyTable, "content"));
    Assertions.assertEquals(1, Main.findFrequency(frequencyTable, "CoNtEnt"));
    Assertions.assertEquals(2, Main.findFrequency(frequencyTable, "hello"));
    Assertions.assertEquals(2, Main.findFrequency(frequencyTable, "Hello"));
    Assertions.assertEquals(1, Main.findFrequency(frequencyTable, "again"));
    Assertions.assertEquals(1, Main.findFrequency(frequencyTable, "AGAIN"));
    Assertions.assertEquals(0, Main.findFrequency(frequencyTable, " "));
    Assertions.assertEquals(0, Main.findFrequency(frequencyTable, " "));

    frequencyTable = Main.buildFrequencyTable("Test test tEst TEsT again TEST hi there TEST");

    Assertions.assertEquals(6, Main.findFrequency(frequencyTable, "test"));
    Assertions.assertEquals(1, Main.findFrequency(frequencyTable, "again"));
    Assertions.assertEquals(1, Main.findFrequency(frequencyTable, "hi"));
    Assertions.assertEquals(1, Main.findFrequency(frequencyTable, "there"));
    Assertions.assertEquals(0, Main.findFrequency(frequencyTable, "unknown"));
  }
}
