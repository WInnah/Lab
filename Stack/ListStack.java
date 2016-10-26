import java.util.*;
public class  ListStack<E> implements MyStack<E>{
  private LList list;
  private int size;
  
  public ListStack(){
    list = new LList <String>();
    size = 0;
  }
  
  public void push(E item){
    list.add(0, item);
    size++;
  }

  public E pop(){
    if (isEmpty()){
      throw new EmptyStackException();
    }else{
      E remover;
      remover = (E)list.get(0);
      list.remove(0);
      size--;
      return remover;
    }
  }

  public E peek(){
    if (isEmpty()){
      throw new EmptyStackException();
    }else{
      E peeked;
      peeked = (E)list.get(0);
      return peeked;
    }
  }

  public int size(){
    return size;
  }

  public boolean isEmpty(){
    return (size == 0)? true: false;
  }
}