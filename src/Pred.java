import java.util.Comparator;

/**
 * Helpers for working with predicates. From Exam 2 Problem 2 by Vasilisa
 * Bashlovkina and Samuel A. Rebelsky
 */
public class Pred
{
  // +-----------+-------------------------------------------------------
  // | Constants |
  // +-----------+

  /**
   * A method that accepts any parameter.
   */
  public static Predicate<Object> ACCEPT = new Predicate<Object>()
    {
      public boolean test(Object val)
      {
        return true;
      }
    }; // new Predicate<Object>()

  /**
   * A method that rejects any parameter.
   */
  public static Predicate<Object> REJECT = new Predicate<Object>()
    {
      public boolean test(Object val)
      {
        return false;
      } // test(Object)
    }; // new Predicate<Object>

  // +----------------+--------------------------------------------------
  // | Static Methods |
  // +----------------+

  /**
   * Create a new predicate that holds when both of two predicates hold.
   * 
   * @return pred a predicate
   * @pre none
   * @post pred.test(val) holds if and only if left.test(val) holds and
   *       right.test(val) holds.
   */
  public static <T> Predicate<T> and(final Predicate<? super T> left,
                                     final Predicate<? super T> right)
  {
    return new Predicate<T>()
      {
        public boolean test(T val)
        {
          return left.test(val) && right.test(val);
        }// test(T)
      }; // new Predicate<T>
  } // and(Predicate<T>, Predicate<T>)

  /**
   * Create a new predicate that holds when another predicate does not hold, and
   * vice versa.
   * 
   * @return pred a predicate
   * @pre none
   * @post pred.test(val) holds if and only if derp.test(val) does not hold.
   */
  public static <T> Predicate<T> not(final Predicate<T> derp)
  {
    return new Predicate<T>()
      {
        public boolean test(T val)
        {
          return !derp.test(val);
        }// test(T)
      }; // new Predicate<T>
  } // not(Predicate<T>)

  /**
   * Create a new predicate that holds when either or both of two predicates
   * hold.
   * 
   * @return pred a predicate
   * @pre none
   * @post pred.test(val) holds if and only if left.test(val) holds or
   *       right.test(val) holds.
   */
  public static <T> Predicate<T> or(final Predicate<? super T> left,
                                    final Predicate<? super T> right)
  {
    return new Predicate<T>()
      {
        public boolean test(T val)
        {
          return left.test(val) || right.test(val);
        }// test(T)
      }; // new Predicate<T>
  } // or(Predicate<T>, Predicate<T>)

  /**
   * 
   * Return a predicate that holds if the two objects are equal
   * 
   * @param obj1
   * @param obj2
   * @pre obj1 and obj have the same type
   * @return
   */
  public static <T> Predicate<T> equal(final T obj1, final T obj2)
  {
    return new Predicate<T>()
      {
        @Override
        public boolean test(T val)
        {
          return obj1.equals(obj2);
        }
      };
  }// equal(T,T);

  /**
   * Returns a predicate that holds if val is equal to otherVal
   * 
   * @param otherVal
   * @pre otherVal and val have the same type
   */
  public static <T> Predicate<T> equal(final T obj1)
  {
    return new Predicate<T>()
      {
        @Override
        public boolean test(T val)
        {
          return obj1.equals(val);
        }// test
      };// new Predicate(T)
  }// equal(T,T);

  /**
   * Greater
   */
  public static <T> Predicate<T> greater(final T obj, final Comparator<T> order)
  {
    return new Predicate<T>()
      {
        @Override
        public boolean test(T val)
        {
          return order.compare(val, obj) > 0;
        }// test
      };// new Predicate(T)
  }// greater(T, Comparator<T>)
  /**
   * Greater
   */
  public static <T> Predicate<T> smaller(final T obj, final Comparator<T> order)
  {
    return new Predicate<T>()
      {
        @Override
        public boolean test(T val)
        {
          return order.compare(val, obj) < 0;
        }// test
      };// new Predicate(T)
  }// smaller(T, Comparator<T>);
  /**
   * Convert a predicate that works on a superclass to a predicate that works on
   * a subclass.
   */
  public static <T> Predicate<T> munge(final Predicate<? super T> pred)
  {
    return new Predicate<T>()
      {
        public boolean test(T val)
        {
          return pred.test(val);
        } // test(T)
      }; // new Predicate<T>
  } // munge(Predicate)
} // class Pred
