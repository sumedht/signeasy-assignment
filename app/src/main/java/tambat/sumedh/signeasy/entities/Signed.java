package tambat.sumedh.signeasy.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sumedh tambat
 */
public class Signed {
  private List<Files> files;

  private String count;

  public List<Files> getFiles ()
  {
    return files;
  }
  public void setFiles (List<Files> files)
  {
    this.files = new ArrayList<>();
    this.files = files;
  }

  public String getCount ()
  {
    return count;
  }
  public void setCount (String count)
  {
    this.count = count;
  }

  @Override
  public String toString()
  {
    return "ClassPojo [files = "+files+", count = "+count+"]";
  }
}
