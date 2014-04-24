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

  public int
    size ()
  {
    return this.array.size ();
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
   * Function where, returns and array list of all of the objects within this
   * JSONArray that match the key and value specified
   * 
   * @param key
   * @param val
   * @return
   */
  public <T>
    ArrayList
    where (String key, T val)
  {
    ArrayList<JSONObject> results = new ArrayList ();
    JSONObject tempObj;
    // Needs to be an array of objects
    for (int i = 0; i < this.size (); i++)
      {
        // For each object
        if (this.array.get (i).type ().compareTo ("Object") == 0)
          {
            if ((tempObj = ((JSONObject) this.array.get (i))).get (key)
                                                             .compareTo (val))
              {
                // The object has a key-value pair that matches
                results.add (tempObj);
              } // if
          } // if
      } // for
    return results;
  } // where
  
  public <T>
  ArrayList
  whereLess (String key, int maxCompare)
{
  ArrayList<JSONObject> results = new ArrayList ();
  // I will make this more readable than where, by using more fields.
  JSONObject tempObj;
  JSONNumber tempNum;
  // Needs to be an array of objects
  for (int i = 0; i < this.size (); i++)
    {
      // For each object
      if (this.array.get (i).type ().compareTo ("Object") == 0)
        {
          // This object has the correct key
          tempObj = (JSONObject) this.array.get (i);
          tempNum = (JSONNumber) tempObj.get (key);
          if (tempNum.lessThan(maxCompare))
            {
              // The object has a key-value pair that matches
              results.add (tempObj);
            } // if
        } // if
    } // for
  return results;
} // where

  /**
   * function whereGreater
   * @param key
   * @param maxCompare
   * @return
   */
  public <T>
  ArrayList
  whereGreater (String key, int maxCompare)
{
  // This could be abstrated to work with whereLess
  ArrayList<JSONObject> results = new ArrayList ();
  // I will make this more readable than where, by using more fields.
  JSONObject tempObj;
  JSONNumber tempNum;
  // Needs to be an array of objects
  for (int i = 0; i < this.size (); i++)
    {
      // For each object
      if (this.array.get (i).type ().compareTo ("Object") == 0)
        {
          // This object has the correct key
          tempObj = (JSONObject) this.array.get (i);
          tempNum = (JSONNumber) tempObj.get (key);
          if (tempNum.greaterThan(maxCompare))
            {
              // The object has a key-value pair that matches
              results.add (tempObj);
            } // if
        } // if
    } // for
  return results;
} // where
  
  
  /**
   * Returns the element at i
   * 
   * @param i
   * @return
   */
  public JSONVal
    get (int i)
  {
    return this.array.get (i);
  }

  public String
    type ()
  {
    return "Array";
  } // type()

  public <T>
    boolean
    compareTo (T val)
  {
    return (this.array.toString ().compareTo (val.toString ()) == 0);
  } // compareTo()
}
