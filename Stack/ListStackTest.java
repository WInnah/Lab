import junit.framework.TestCase;
import java.util.*;

public class ListStackTest extends TestCase {
  
  public void testAddOne() {
    ListStack<String> l = new ListStack<String>();
    l.push("Deodorant");
    assertEquals("added one item and first was Deodorant", "Deodorant", l.peek());
  }
  
  public void testAddTwo() {
    ListStack<String> l = new ListStack<String>();
    l.push("Deodorant");
    l.push("Shampoo");
    assertEquals("added one item and first was Shampoo", "Shampoo", l.peek());
  }
  
  public void testEmpty() {
    ListStack<String> l = new ListStack<String>();
    assertEquals("added none", true, l.isEmpty());
  }
  
   public void testPop() {
    ListStack<String> l = new ListStack<String>();
    l.push("Deodorant");
    l.push("Shampoo");
    l.pop();
    assertEquals("added one item and first was Deodorant", "Deodorant", l.peek());
  }
   
   public void testPoper() {
    ListStack<String> l = new ListStack<String>();
    l.push("MM");
    l.push("Winnah");
    l.push("Mary");
    l.push("Dan");
    l.push("Ruffa");
    l.pop();
    l.pop();
    assertEquals("added one item and first was Mary", "Mary", l.peek());
  }
   
   public void testPopEmpty() {
    ListStack<String> l = new ListStack<String>();
    try{
      l.pop();
    }catch(EmptyStackException e){
      //expected
    }
  }
   
   public void testPeekEmpty() {
    ListStack<String> l = new ListStack<String>();
    try{
      l.peek();
    }catch(EmptyStackException e){
      //expected
    }
  }
    
   public void testPoop() {
    ListStack<String> l = new ListStack<String>();
    l.push("MM");
    l.push("Winnah");
    l.push("Mary");
    l.push("Dan");
    l.push("Ruffa");
    l.pop();
    l.pop();
    l.pop();
    l.pop();
    l.pop();
    try{
      l.pop();
      fail("Should have thrown an exception");
    }catch(EmptyStackException e){
      //expected
    }
  }
  
}
