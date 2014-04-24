public class JSONBoolean
    implements
      JSONVal
{

  boolean isTrue = false;

  public JSONBoolean(char specialIn)
  {
    if (specialIn == 't')
      {
        isTrue = true;
      } // if
  } // JSONBoolean

  public Object get()
  {
    return this.isTrue;
  }//get()

  public String toString()
  {
    return String.valueOf(this.isTrue);
  }//toString()

  public boolean equals(JSONBoolean other)
  {
    return (this.isTrue && other.isTrue) || (!this.isTrue && !other.isTrue);
  }//equals(JSONBoolean)
  
  public String type ()
  {
    return "Boolean";
  } // type()
  
  public <T> boolean compareTo(T val)
  {
    return ((val instanceof Boolean) && (val == this.get()));
  } // compareTo
} // class JSONSpecial
