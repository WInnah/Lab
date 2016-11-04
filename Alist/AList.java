import java.util.*;

public class AList implements MyList{
  
  private Object[] items;
  private int count;
  
  public AList() {
    items = new Object[10];
    count = 0;
  }
  
  public void add(Object item) {
    items[count++] = item;
  }
  
  public void add(int i, Object item) {
    Object temp = "";
    Object[] newArray = Arrays.copyOf(items, items.length + 1);
    items = Arrays.copyOf(newArray, newArray.length);
    
      for (int j = 0; j < items.length; j++) { 
        if (j == i && i + 1 == items.length){
          items[j] = item;
        }
        if (j >= i) {
          temp = items[j];
          items[j] = item;
          item = temp;
        }
        else {
          items[j] = items[j];
        }
      }
    count++;
  }
  
  public Object get(int i) {
   check(i);
    return items[i];
  }
  
  public void remove(int i) {
    check(i);
    for (int j = i; j <= count; j++) {
      i = j;
      items[j] = items[i + 1];
    }
    count--;
  }
  
  public void remove(Object item) {
    for (int i = 0; i < items.length; i++) {
      if (items[i] == item) {
        for (int j = i; j <= count; j++) {
          i = j;
          items[j] = items[i + 1];
        }
      }
    }
     count--;
  }
  
  public void set(int i, Object item) {
    check(i);
    items[i] = item;
  }
  
  public void check(int i) {
    if (count == 0 || i >= count) {
      throw new IndexOutOfBoundsException();
    }
  }

}
