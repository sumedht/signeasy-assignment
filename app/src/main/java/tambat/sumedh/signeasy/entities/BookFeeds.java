package tambat.sumedh.signeasy.entities;

/**
 * @author sumedh tambat
 */
public class BookFeeds {

  private Draft draft;
  private String count;
  private Signed signed;
  private Pending pending;
  private Original original;

  public Draft getDraft ()
  {
    return draft;
  }
  public void setDraft (Draft draft)
  {
    this.draft = draft;
  }

  public String getCount ()
  {
    return count;
  }
  public void setCount (String count)
  {
    this.count = count;
  }

  public Signed getSigned ()
  {
    return signed;
  }
  public void setSigned (Signed signed)
  {
    this.signed = signed;
  }

  public Pending getPending ()
  {
    return pending;
  }
  public void setPending (Pending pending)
  {
    this.pending = pending;
  }

  public Original getOriginal ()
  {
    return original;
  }
  public void setOriginal (Original original)
  {
    this.original = original;
  }

  @Override
  public String toString()
  {
    return "ClassPojo [draft = "+draft+", count = "+count+", signed = "+signed+", pending = "+pending+", original = "+original+"]";
  }
}
