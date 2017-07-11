import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class Provider {
  private String name;
  private String speciality;
  private int id;


  public Provider(String name, String speciality, int id) {
      this.name = name;
      this.speciality = speciality;
      this.id = id;
    }

  public String getName() {
    return name;
  }

  public static List<Provider> all() {
    String sql = "SELECT id, name FROM providers";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Provider.class);
    }
  }
  public String getSpeciality() {
    return speciality;
  }

  public int getId() {
    return id;
  }

  public void save() {
  try(Connection con = DB.sql2o.open()) {
    String sql = "INSERT INTO providers(name) VALUES (:name);";
    this.id = (int) con.createQuery(sql, true)
      .addParameter("name", this.name)
      .executeUpdate()
      .getKey();
    }
  }
}
