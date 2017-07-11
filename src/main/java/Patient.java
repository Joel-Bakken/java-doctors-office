import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class Patient {
  private String name;
  private int dob;
  private int id;

  public Patient(String name, int dob, int id) {
    this.name = name;
    this.dob = dob;
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public int getDOB() {
    return dob;
  }

  public int getId() {
    return id;
  }

  public void save() {
  try(Connection con = DB.sql2o.open()) {
    String sql = "INSERT INTO patients(name) VALUES (:name);";
    this.id = (int) con.createQuery(sql, true)
      .addParameter("name", this.name)
      .executeUpdate()
      .getKey();
    }
  }

  public static List<Patient> all() {
    String sql = "SELECT id, name FROM patients";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Patient.class);
    }
  }
}
