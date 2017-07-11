import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class Specialty {
  private int id;
  private String specialty;
  private int providersId;

  public Specialty(int id, String specialty) {
//    this.id = id;
    this.specialty = specialty;
    this.providersId = providersId;
  }
  public String getSpecialty() {
    return specialty;
  }
  public int getId() {
    return id;
  }

  public void save() {
  try(Connection con = DB.sql2o.open()) {
    String sql = "INSERT INTO specialty(specialty) VALUES (:specialty);";
    this.id = (int) con.createQuery(sql, true)
      .addParameter("specialty", this.specialty)
      .executeUpdate()
      .getKey();
    }
  }

}
