import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class PatientTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void patient_instantiatesCorrectly_true() {
    Patient testPatient = new Patient("", 1, 2);
    assertEquals(true, testPatient instanceof Patient);
  }

  @Test
  public void getName_instantiatesWithName_joel() {
    Patient testPatient = new Patient("Joel", 1, 2);
    assertEquals("Joel", testPatient.getName());
  }

  @Test
  public void patient_instantiatesWithDOB_1_1_17() {
    Patient testPatient = new Patient("Joel", 1, 2);
    assertEquals(1, testPatient.getDOB());
  }

  @Test
  public void save_assignsIdToObject() {
    Patient testPatient = new Patient("", 1, 2);
    testPatient.save();
    Patient savedPatient = Patient.all().get(0);
    assertEquals(testPatient.getId(), savedPatient.getId());
  }

}
