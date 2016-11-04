import java.util.*;

public class LList<E> implements MyList<E>{
  private MyNode head;
  private MyNode tail;
  private int size;
  
  public LList(){
    head = new MyNode();
    tail = new MyNode();
    size = 0;
  }

  public void check(int i) {
    if (size == 0 || i >= size) {
      throw new IndexOutOfBoundsException();
    }
  }
  
  public void add(E item){
    add(size, item);
  }
  
  public void add(int i, E item){
    MyNode newNode = new MyNode(item, null);
    int count = 0;
     if (i > size){
      throw new IndexOutOfBoundsException();
     }else{
       if (size == 0 && i == 0){
         head = newNode;
         tail = newNode;
       }else if(size > 0 && i == 0){
         newNode.setNext(head);
         head = newNode;
       }else{
         MyNode cursor = head;
         while(--i > 0){
           cursor = cursor.getNext();
         }
         newNode.setNext(cursor.getNext());
         cursor.setNext(newNode);
         if (i == size - 1){
           tail = newNode;
         }
       }
       size++;
     }
  }
  
  public E get(){
    return get(size);
  }
  public E get(int i){
    check(i);
    MyNode cursor = head;
     while(i-- > 0){
       cursor = cursor.getNext();
     }
     return cursor.getData(); 
  }
  
  public void remove(int i){
    check(i);
    MyNode newNode = new MyNode(null, null);
    int count = 0;
    MyNode cursor = head;
    if(i == 0 && size == 1){
      head = null;
      tail = null;
      size--;
    }else if (i == 0){
      head.setData(null);
      head = cursor.getNext();
      size--;
    }
    else {
      while(count <= i){
        if (count + 1 == i && i == size-1){
           tail = cursor.getNext().getNext();
           newNode.setNext(cursor.getNext().getNext());
           cursor.setNext(newNode);
        }else if(count + 1 == i && i != size-1){
          cursor.setNext(cursor.getNext().getNext());
        }
        cursor = cursor.getNext();
        count++;
      }
      size--;
    }
  }
  
  public void remove(E item){
    int count = 0;
    MyNode newNode = new MyNode(null, null);
    MyNode cursor = head;
    if(head.getData().equals(item) && size == 1){
      head = null;
      tail = null;
      size--;
    }
    if (head.getData().equals(item)){
      head.setData(null);
      head = cursor.getNext();
      size--;
    }else{
      while(cursor.getNext() != null){
        if(count + 1 == size - 1 && cursor.getNext().getData().equals(item)){
           tail = cursor.getNext().getNext();
           newNode.setNext(cursor.getNext().getNext());
           cursor.setNext(newNode);
        }else if (count < size - 1 && cursor.getNext().getData().equals(item)){
          cursor.setNext(cursor.getNext().getNext());
        }
        cursor = cursor.getNext();
        count++;
      }
      size--;
    }
  }
  
  public void set(int i, E item){
    check(i);
    int count = 0;
    MyNode cursor = head;
    while(count <= i){
      if(count == i){
        cursor.setData(item);
      }
      cursor = cursor.getNext();
      count++;
    }
  }
  
  public class MyNode{
    private E data;
    private MyNode next;
    private int size;
    
    public MyNode(){
      this.data = null;
      this.next = null;
      size = 0;
    }
    
     public MyNode(E data, MyNode next){
      this.data = data;
      this.next = next;
    }
     
     public MyNode getNext(){
       return this.next;
     }
    
     public void setNext(MyNode next){
       this.next = next;
     }
     
     public E getData(){
       return this.data;
     }
     
     public void setData(E data){
       this.data = data;
     }
  }
  
  public Iterator iterator() {
    return new LListIterator(head);
  }
  
  private class LListIterator implements Iterator {
    
    private MyNode prev;
    private MyNode last;
    private MyNode next;
    private int count;
    
    public LListIterator(MyNode head) {
      prev = null;
      last = null;
      next = head;
      count = 0;
    }
    
    public E next() {
      if (next == null) {
        throw new NoSuchElementException();
      }
      E data = next.getData();
        prev = last;
        last = next;
        next = next.getNext();
      return data;
    }
    
    public boolean hasNext() {
      return (next.getNext() != null)? true : false;
    }
    
    public void remove(){
      if (last == null){
        throw new IllegalStateException();
      }else{
        count++;
        if (count > 1){
          throw new IllegalStateException();
        }else{
          if (last == head){
            prev = null;
            last = null;
            head = next;
            next = next.getNext();
          }else{
            prev = prev;
            last = null;
            prev.setNext(next);
            next = next.getNext();
          }
        }
      }
    }
  }
}
