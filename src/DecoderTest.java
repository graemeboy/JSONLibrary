import static org.junit.Assert.*;

import org.junit.Test;

/**
 * A set of simple unit tests for JSONDecode
 */
public class DecoderTest
{

  JSONDecoder decoder = new JSONDecoder ("");
  static JSONBoolean t = new JSONBoolean ('t');
  static JSONBoolean f = new JSONBoolean ('f');

  @Test
  public void
    testTrue ()
      throws Exception
  {
    String goodDay = "{\"good day?\": true}";
    JSONDecoder decoder = new JSONDecoder (goodDay);
    JSONObject obj = (JSONObject) decoder.jsonDecode ();

    assertEquals ("testing true", true, obj.get ("good day?").get ());
  }// testTrue

  @Test
  public void
    testFalse ()
      throws Exception
  {
    String eatingGrapes = "{\"eating grapes?\": false}";
    JSONDecoder decoder = new JSONDecoder (eatingGrapes);
    JSONObject obj = (JSONObject) decoder.jsonDecode ();

    assertEquals ("testing false", false, obj.get ("eating grapes?").get ());
  }// testFasle

  @Test
  public void
    testNull ()
      throws Exception
  {
    String catsName = "{\"cat's name\": null}";
    JSONDecoder decoder = new JSONDecoder (catsName);
    JSONObject obj = (JSONObject) decoder.jsonDecode ();

    assertEquals ("testing false", null, obj.get ("cat's name").get ());

  }// testNull

  @Test
  public void
    testNumber ()
      throws Exception
  {
    String idealScore = "{\"ideal exam score\": 100}";
    JSONDecoder decoder = new JSONDecoder (idealScore);
    JSONObject obj = (JSONObject) decoder.jsonDecode ();

    assertEquals ("testing false", 100,
                  ((JSONNumber) obj.get ("ideal exam score")).getInteger ());
  }// testNumber
}
