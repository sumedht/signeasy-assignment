package tambat.sumedh.signeasy.entities;

/**
 * @author sumedh tambat
 */
public class Files {
  private String id;
  private String file_size;
  private String last_modified_time;
  private String name;
  private String type;
  private String created_time;

  public String getId ()
  {
    return id;
  }
  public void setId (String id)
  {
    this.id = id;
  }

  public String getFile_size ()
  {
    return file_size;
  }
  public void setFile_size (String file_size)
  {
    this.file_size = file_size;
  }

  public String getLast_modified_time ()
  {
    return last_modified_time;
  }
  public void setLast_modified_time (String last_modified_time)
  {
    this.last_modified_time = last_modified_time;
  }

  public String getName ()
  {
    return name;
  }
  public void setName (String name)
  {
    this.name = name;
  }

  public String getType ()
  {
    return type;
  }
  public void setType (String type)
  {
    this.type = type;
  }

  public String getCreated_time ()
  {
    return created_time;
  }
  public void setCreated_time (String created_time)
  {
    this.created_time = created_time;
  }

  @Override
  public String toString()
  {
    return "ClassPojo [id = "+id+", file_size = "+file_size+", last_modified_time = "+last_modified_time+", name = "+name+", type = "+type+", created_time = "+created_time+"]";
  }
}
