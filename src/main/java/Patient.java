import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class Patient {
  private String name;

  public Patient(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
