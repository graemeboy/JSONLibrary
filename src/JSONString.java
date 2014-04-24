public class JSONString
    implements
      JSONVal
{
  String string;

  // Constructors
  public JSONString (String stringIn)
  {
    this.string = stringIn;
  } // JSONString

  public String
    toString ()
  {
    return this.string;
  }

  @Override
  public String
    get ()
  {
    return this.string;
  }
  
  public String type ()
  {
    return "String";
  } // type()
  
  public <T> boolean compareTo(T val)
  {
    return ((val instanceof String) && this.string.compareTo ((String) val) == 0);
  } // compareTo
}
