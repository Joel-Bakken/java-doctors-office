import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class Provider {
  private String name;
  private String specialty;
  private int id;


  public Provider(String name, String specialty, int id) {
      this.name = name;
      this.specialty = specialty;
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
  public String getSpecialty() {
    return specialty;
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
  public static List<Provider> specialty() {
    String sql = "SELECT specialty, name FROM providers";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Provider.class);
    }
  }


}
