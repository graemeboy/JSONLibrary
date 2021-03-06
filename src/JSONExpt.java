import java.io.PrintWriter;

/*
 * Here are a few experiments that I made to see how the JSON decoder was working.
 */
public class JSONExpt
{
  

  public static void main(String[] args)
  {
    PrintWriter pen = new PrintWriter(System.out, true);


    // Queries
    pen.println("** Experimenting with Query Language ** \n");
    String queryJSON =
        "{ \"schools\": [ { \"name\" : \"Grinnell College\", \"type\": \"Liberal Arts\", \"numStudents\": 1655 } ,"
            + "{ \"name\" : \"Carlton College\", \"type\": \"Liberal Arts\", \"numStudents\": 2018 }, "
            + "{ \"name\" : \"Vassar College\", \"type\": \"Liberal Arts\", \"numStudents\": 2477 }, "
            + "{ \"name\" : \"Middlebury College\", \"type\": \"Liberal Arts\", \"numStudents\": 2499 }, "
            + "{ \"name\" : \"Wesleyan University\", \"type\": \"Liberal Arts\", \"numStudents\": 3262 }, "
            + "{ \"name\" : \"Harvard University\", \"type\": \"University\", \"numStudents\": 28147 }, "
            + "{ \"name\" : \"Stanford University\", \"type\": \"University\", \"numStudents\": 15877 }, "
            + "{ \"name\" : \"University of Chicago\", \"type\": \"University\", \"numStudents\": 15245 }, "
            + "{ \"name\" : \"University of Iowa\", \"type\": \"University\", \"numStudents\": 31065 }, "
            + "{ \"name\": \"Cornell University\", \"type\": \"University\", \"numStudents\": 21000 } ] }";

    JSONDecoder queryDecoder = new JSONDecoder(queryJSON);
    JSONObject queryObj = queryDecoder.jsonDecode();
    
    
    
    String universities =
        ((JSONArray) queryObj.get("schools")).where("type", "University")
                                             .toString();
    String liberalArts =
        ((JSONArray) queryObj.get("schools")).where("type", "Liberal Arts")
                                             .toString();

    String small =
        ((JSONArray) queryObj.get("schools")).whereLess("numStudents", 2000)
                                             .toString();
    String big =
        ((JSONArray) queryObj.get("schools")).whereGreater("numStudents", 25000)
                                             .toString();

    pen.println("* Universities are: * \n" + universities);
    pen.println("* Liberal Arts Colleges are: * \n" + liberalArts);

    pen.println("* Small Colleges are: * \n" + small);
    pen.println("* Big Universities are: * \n" + big);

    pen.println("\n** Experimenting with Getting Values from Complex Objects ** \n");
    String json =
        "{\n\"person\":\n{\"first\" :\n \"Clark\" , \"last\" : \"Kent\","
            + "\"age\":23,\"class year\":2014, \"male\":true,"
            + "\"friends\": [ \"Sam\",\"Joe\", \"Lilly\" ] , \"gpa\": 3.92,\"hasCat\": true, \"crimes\": 0 }}";

    JSONDecoder decoder = new JSONDecoder(json);

    JSONObject obj = (JSONObject) decoder.jsonDecode();
    pen.println(obj.toString());

    JSONObject person = (JSONObject) obj.get("person");

    // Print out names
    pen.println("First name is " + person.get("first"));
    pen.println("Last name is " + person.get("last"));
    // Print out age
    pen.println("Age is " + person.get("age"));
    // Perform arithmetic on age
    int age = ((JSONNumber) person.get("age")).getInteger();
    pen.println("Double age is " + age * 2);
    // Print out class year
    int classyear = ((JSONNumber) person.get("class year")).getInteger();
    pen.println("Class year is " + classyear);
    // Do arithmetic on class year
    pen.println("Age + class year is " + (age + classyear));
    // Print out booleans: is male and has cat
    pen.println("Is male? " + person.get("male"));
    pen.println("Has a cat? " + person.get("hasCat?"));
    // Friends?
    JSONArray friends = (JSONArray) person.get("friends");
    int numFriends = friends.size();
    pen.println("Number of friends: " + numFriends);
    pen.println("First listed friend: " + friends.get(0).toString());
    pen.println("Last listed friend: " + friends.get(numFriends - 1).toString());

    System.out.println("Really poor experiment of get with predicates");
    String predTesting = "{ \"blah\": \"mlah\" , \"a\":\"b\", \"c\": 5}";
    JSONDecoder queryDecoder2 = new JSONDecoder(predTesting);
    JSONObject queryObj2 = queryDecoder2.jsonDecode();
    String testing = queryObj2.get(Pred.equal("a")).toString();
    System.out.println(testing);

  } // main (String [])
}
