public interface MyList<E> extends Iterable<E>{
  
  public void add(E item);
  
  public void add(int i, E item);
  
  public E get(int i);
  
  public void remove(int i);
  
  public void remove(E item);
  
  public void set(int i, E item);
}