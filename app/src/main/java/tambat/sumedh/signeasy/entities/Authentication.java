package tambat.sumedh.signeasy.entities;

/**
 * @author sumedh tambat
 */
public class Authentication {
  private String id;
  private String access_token;
  private String error_code;
  private String message;

  public String getId ()
  {
    return id;
  }

  public void setId (String id)
  {
    this.id = id;
  }

  public String getAccess_token ()
  {
    return access_token;
  }

  public void setAccess_token (String access_token)
  {
    this.access_token = access_token;
  }

  public String getError_code() {
    return error_code;
  }

  public void setError_code(String error_code) {
    this.error_code = error_code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public String toString()
  {
    return "ClassPojo [id = "+id+", access_token = "+access_token+"]";
  }
}
