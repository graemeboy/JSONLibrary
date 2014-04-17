public class JSONConstant
    implements
      JSONVal
{

  boolean isTrue = false;
  boolean isNull = false;

  public JSONConstant (char specialIn)
  {
    if (specialIn == 't')
      {
        isTrue = true;
      } // if
    else if (specialIn == 'n')
      {
        isNull = true;
      } // else if
  } // JSONSpecial

  public Boolean
    get ()
  {
    if (isNull)
      {
        return null;
      } // if

    return this.isTrue;
  } // get ()

  public String
    toString ()
  {
    if (isNull)
      {
        return "null";
      } // if
    return String.valueOf (this.isTrue);
  } // toString ()

} // class JSONSpecial
