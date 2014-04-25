import java.util.ArrayList;


public class JSONObject
    implements
      JSONVal
{
  // Fields
  // Keys are only strings.
  ArrayList<String> keys;
  // A JSONVal can contain objects, numbers, strings, etc.
  ArrayList<JSONVal> vals;
  int i;

  // Constructors
  public JSONObject()
  {
    keys = new ArrayList<String>();
    vals = new ArrayList<JSONVal>();
  } // JSONObject

  // Methods

  // Add a key to the key list
  public void addKey(String keyIn)
  {
    this.keys.add(keyIn);
  } // addKey (String)

  public void addVal(JSONVal val)
  {
    vals.add(val);
  } // addVal (JSONVal)

  /**
   * returns the value associated to the given key. Eff. is O(n), n = number of
   * keys
   * 
   * @param key
   * @return
   */
  public JSONVal get(String keyIn)
  {
    for (int i = 0; i < this.keys.size(); i++)
      {
        if (this.keys.get(i).compareTo(keyIn) == 0)
          {
            return this.vals.get(i);
          } // if
      } // for
    return null; // no such key was found.
  } // get()
/**
 * Get the corresponding value if the predicate holds
 * @param <T>
 */
  public <T> JSONArray get(Predicate<String> pred)
  {
    JSONArray result = new JSONArray();
    for (int i = 0; i < this.keys.size(); i++)
      {
        if (pred.test(this.keys.get(i)))
          {
            result.add(this.vals.get(i));
          } // if pred holds
      } // for
    return result;
  }// get(Predicate<T>)
  
  public String toString()
  {

    String output = "{\n";
    JSONVal val;
    int keysLen = this.keys.size();
    String tab = "    ";
    for (int i = 0; i < keysLen; i++)
      {
        val = this.vals.get(i);
        if (val == null)
          {
            return "null";
          } // if

        if (val instanceof JSONObject)
          {
            // This is awfully hacky, and only actually
            // looks good with json objects nested once
            tab = "  ";
          } // if

        output += tab + "\"" + this.keys.get(i) + "\": " + val.toString();

        if (i < keysLen - 1)
          {
            output += ",";
          }
        output += "\n";

      } // for
    output += tab + "}";
    return output;
  } // toString()

  @Override
  public Object get()
  {
    return "[Object]";
  }

  public String type()
  {
    return "Object";
  } // type()

  public <T> boolean compareTo(T val)
  {
    return (this.toString().compareTo(val.toString()) == 0);
  }//compareTo
  
  /**
   * Return a predicate that holds if the current key 
   * is equal to str 
   * 
   * @return new Predicate
   */
  public Predicate<String> equalKey(final String str, final int index)
  {
    return new Predicate<String>()
        {
          @Override
          public boolean test(String val)
          {
            return str.equals(JSONObject.this.keys.get(index));
          }// test
        };// new Predicate
  }//equalKey(String, index);
}// JSONObject class