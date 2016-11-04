import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class AListTest extends TestCase {
  
  
  public void testAddOne() {
    AList l = new AList();
    l.add("Shampoo");
    assertEquals("added one item", "Shampoo", l.get(0));
  }
  
  public void testAddTwo() {
    AList l = new AList();
    l.add("Shampoo");
    l.add("Soap");
    assertEquals("added two items and first was Shampoo", "Shampoo", l.get(0));
    assertEquals("added two items and second was Soap", "Soap", l.get(1));
  }
  
  public void testAddBetween() {
    AList l = new AList();
    l.add("Shampoo");
    l.add("Soap");
    l.add(1, "Deodorant");
    assertEquals("added two items and first was Shampoo", "Shampoo", l.get(0));
    assertEquals("added two items and second was Deodorant", "Deodorant", l.get(1));
    assertEquals("added two items and third was Soap", "Soap", l.get(2));
  }
  
  public void testAddAtTheStart() {
    AList l = new AList();
    l.add("Shampoo");
    l.add("Soap");
    l.add(0, "Deodorant");
    assertEquals("added first was Deodorant", "Deodorant", l.get(0));
    assertEquals("second was Shampoo", "Shampoo", l.get(1));
    assertEquals("third was Soap", "Soap", l.get(2));
  }
  
  public void testAddAtTheEnd() {
    AList l = new AList();
    l.add("Shampoo");
    l.add("Soap");
    l.add(2, "Deodorant");
    assertEquals("first was Shampoo", "Shampoo", l.get(0));
    assertEquals("second was Soap", "Soap", l.get(1));
    assertEquals("third was Deodorant", "Deodorant", l.get(2));
  }
  
  public void testAddOffTheEnd() {
    AList l = new AList();
    l.add("Shampoo");
    l.add("Soap");
    l.add("Deodorant");
    l.add(3, "Lotion");
    assertEquals("added two items and first was Shampoo", "Shampoo", l.get(0));
    assertEquals("added two items and second was Soap", "Soap", l.get(1));
    assertEquals("added two items and third was Deodorant", "Deodorant", l.get(2));
    assertEquals("added two items and fourth was Lotion", "Lotion", l.get(3));
  }
  
  public void testGetOutOfBoundsWhenEmpty() {
    AList l = new AList();
    try {
      l.get(0);
      fail("Should have thrown an exception!");
    } catch (IndexOutOfBoundsException e) {  
      // expected!
    }
  }
  
  
  public void testGetOutOfBounds() {
    AList l = new AList();
    l.add("Shampoo");
    try {
      l.get(1);
      fail("Should have thrown an exception!");
    } catch (IndexOutOfBoundsException e) {  
      // expected!
    }
  }
  
  public void testRemoveLast() {
    AList l = new AList();
    l.add("Shampoo");
    l.add("Deodorant");
    l.add("Soap");
    l.remove(2);
    try {
      l.get(2);
      fail("Should have thrown an exception!");
    } catch (IndexOutOfBoundsException e) {  
      assertEquals("added two items and first was Shampoo", "Shampoo", l.get(0));
      assertEquals("added two items and second was Deodorant", "Deodorant", l.get(1));
    }
  }
  
  
  public void testRemoveMid() {
    AList l = new AList();
    l.add("Shampoo");
    l.add("Deodorant");
    l.add("Soap");
    l.remove(1);
    try {
      l.get(2);
      fail("Should have thrown an exception!");
    } catch (IndexOutOfBoundsException e) {  
      assertEquals("added two items and first was Shampoo", "Shampoo", l.get(0));
      assertEquals("added two items and second was Soap", "Soap", l.get(1));
    }
  }
  
  
  public void testSet() {
    AList l = new AList();
    l.add("Shampoo");
    l.set(0, "Deodorant");
    assertEquals("added two items and first was Deodorant", "Deodorant", l.get(0));
  }
  
  public void testRemoveString(){
    AList l = new AList();
    l.add("Shampoo");
    l.add("Deodorant");
    l.add("Soap");
    l.remove("Deodorant");
    try {
      l.get(2);
      fail("Should have thrown an exception!");
    } catch (IndexOutOfBoundsException e) {  
      assertEquals("added two items and first was Shampoo", "Shampoo", l.get(0));
      assertEquals("added two items and second was Soap", "Soap", l.get(1));
    }
  }
}
