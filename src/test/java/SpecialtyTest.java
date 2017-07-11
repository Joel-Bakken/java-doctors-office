import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class SpecialtyTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void specialty_instantiatesCorrectly_true() {
    Specialty testSpecialty = new Specialty(1, "");
    assertEquals(true, testSpecialty instanceof Specialty);
  }
  @Test
  public void getSpecialty_instantiatesWithSpecialty_cardio() {
    Specialty testSpecialty = new Specialty(1,"cardio");
    assertEquals("cardio", testSpecialty.getSpecialty());
  }

  @Test
  public void getId_instantiatesWithId_1() {
    Specialty testSpecialty = new Specialty(1, "cardio");
    testSpecialty.save();
    assertTrue(testSpecialty.getId() > 0);
  }

}
