import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class PatientTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void patient_instantiatesCorrectly_true() {
    Patient testPatient = new Patient("Bob");
    assertEquals(true, testPatient instanceof Patient);
  }

  @Test
  public void patient_instantiatesWithName_bob() {
    Patient testPatient = new Patient("Bob");
    assertEquals("Bob", testPatient.getName());
  }


}
