import java.math.BigDecimal;
import java.math.BigInteger;

public class JSONNumber
    implements
      JSONVal
{
  // Started saving number as a string for convenience.
  // Now I think it's a good idea, actually. Parse on get?
  // We probably ought to do them all as strings. Except arrays...
  String number;
  boolean isDecimal;

  public JSONNumber (String number, boolean decimal)
  {
    this.number = number;
    this.isDecimal = decimal;

  } // JSONNumber

  public BigDecimal
    get ()
  {
    return new BigDecimal (this.number);
  }

  public BigInteger
    getBigInteger ()
  {
    return new BigInteger (this.number);
  }

  public int
    getInteger ()
  {
    return Integer.parseInt (this.number);
  }

  public boolean
    isDecimal ()
  {
    return isDecimal;
  }

  public String
    toString ()
  {
    return number;
  }//toString()
  
}//JSONNumber class
