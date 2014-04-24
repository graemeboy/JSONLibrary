interface JSONVal
{

  // return the type
  public String
    toString ();

  public Object
    get ();
  
  public String
  type (); // is this necessary?

  public <T> boolean compareTo(T valIn);

}
