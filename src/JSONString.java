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
}
