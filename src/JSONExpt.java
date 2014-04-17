import java.io.PrintWriter;

/*
 * Here are a few experiments that I made to see how the JSON decoder was working.
 */
public class JSONExpt
{

  public static void
    main (String[] args)
  {
    PrintWriter pen = new PrintWriter (System.out, true);

    String json = "{\n\"person\":\n{\"first\" :\n \"Clark\" , \"last\" : \"Kent\","
                  + "\"age\":23,\"class year\":2014, \"male\":true,"
                  + "\"friends\": [ \"Sam\" , \"Joe\", \"Lilly\" ] , \"gpa\": 3.92, \"hasCat?\": true, \"crimes\": 0 }}";

    JSONDecoder decoder = new JSONDecoder (json);

    JSONObject obj = (JSONObject) decoder.jsonDecode ();
    pen.println (obj.toString ());

    JSONObject person = (JSONObject) obj.get ("person");

    // Print out names
    pen.println ("First name is " + person.get ("first"));
    pen.println ("Last name is " + person.get ("last"));
    // Print out age
    pen.println ("Age is " + person.get ("age"));
    // Perform arithmetic on age
    int age = ((JSONNumber) person.get ("age")).getInteger ();
    pen.println ("Double age is " + age * 2);
    // Print out class year
    int classyear = ((JSONNumber) person.get ("class year")).getInteger ();
    pen.println ("Class year is " + classyear);
    // Do arithmetic on class year
    pen.println ("Age + class year is " + (age + classyear));
    // Print out booleans: is male and has cat
    pen.println ("Is male? " + person.get ("male"));
    pen.println ("Has a cat? " + person.get ("hasCat?"));
    // Friends?
    JSONArray friends = (JSONArray) person.get ("friends");
    int numFriends = friends.size ();
    pen.println ("Number of friends: " + numFriends);
    pen.println ("First listed friend: " + friends.get (0).toString ());
    pen.println ("Last listed friend: "
                 + friends.get (numFriends - 1).toString ());
    
  } // main (String [])
}
