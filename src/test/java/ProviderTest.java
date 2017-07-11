import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;

public class ProviderTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void provider_instantiatesCorrectly_true() {
    Provider testProvider = new Provider("Kinsella", "", 1);
    assertEquals(true, testProvider instanceof Provider);
  }

  @Test
    public void getName_providerInstantiatesWithName_kinsella() {
    Provider testProvider = new Provider("Kinsella", "", 1);
      assertEquals("Kinsella", testProvider.getName());
    }

  @Test
    public void getSpecialty_providerHasASpecialty_rheumatology() {
    Provider testProvider = new Provider("", "Rheumatology", 1);
    assertEquals("Rheumatology", testProvider.getSpecialty());
    }

  @Test
  public void save_assignsIdToObject() {
    Provider testProvider = new Provider("","", 1);
    testProvider.save();
    Provider savedProvider = Provider.all().get(0);
    assertEquals(testProvider.getId(), savedProvider.getId());
  }
}
