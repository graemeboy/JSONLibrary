import java.util.ArrayList;

public class JSONArray
    implements
      JSONVal
{
  // Make an arraylist of JSONVals

  ArrayList<JSONVal> array;

  public JSONArray ()
  {
    this.array = new ArrayList<JSONVal> ();
  } // JSONArray(String)

  public void
    add (JSONVal valIn)
  {
    this.array.add (valIn);
  } // add()

  public ArrayList<JSONVal>
    get ()
  {
    return this.array;
  } // get()
  
  public int size()
  {
    return this.array.size();
  } // size ()
  
  public String
    toString ()
  {
    String output = "[";
    int arrayLen = this.array.size ();
    for (int i = 0; i < arrayLen; i++)
      {
        output += this.array.get (i).toString ();
        if (i < arrayLen - 1)
          {
            output += ", ";
          } // if
      } // for
    output += "]";
    return output;
  } // toString()

  /**
   * Returns the element at i
   * @param i
   * @return 
   */
  public JSONVal
    get (int i)
  {
    return this.array.get (i);
  }
}
