// name: Rayyan K  date:
public class DLL_Driver
{
   public static void main(String args[])
   {
      DLL list = new DLL();	
   
      list.addLast("Apple");
      list.addLast("Banana");
      list.addLast("Cucumber");
      list.add("Durian");
      list.add("Eggplant");
      
      System.out.println("The list is " + list);
      System.out.println("Size: " + list.size());
      Object obj = list.remove(2);
      System.out.println("Remove index 2: "+ obj);
      System.out.println("The list is " + list);
      System.out.println("Size: " + list.size());
   
      list.add(2,"Carrot");
      System.out.println("Add Carrot at index 2:   " + list);
      
      try
      {
         list.add(16,"Kiwi");    //out-of-bounds
      }
      catch(IndexOutOfBoundsException e)
      {
         System.out.println(e);
      }
       
       
      System.out.println("Get values at index 0 and First: " + list.get(0)+" and " + list.getFirst());
      System.out.println("No change in list: " +list);
         
      list.removeFirst();
      System.out.println( "Remove the First:  " + list); 
       
      list.addFirst("Artichoke");
      System.out.println("Add First:  " + list);
      System.out.println("Size: " + list.size());
       
      list.set(1, "Broccoli");
      System.out.println("Set value at index 1:  " + list);
   }
}

//////////////////////////////////////////////////////////
    
class DLL        //DoubleLinkedList
{
   private int size;
   private DLNode head = new DLNode(); //dummy node--very useful--simplifies the code
   
   public int size()
   {
      return size;
   }
   
  /* appends obj to end of list; increases size;
   	  @return true  */
   public boolean add(Object obj)
   {
      addLast(obj);
      return true;   
   }
   
   /* inserts obj at position index.  increments size. 
   	*/
   public void add(int index, Object obj) throws IndexOutOfBoundsException  //this the way the real LinkedList is coded
   {
      if(index > size || index < 0)
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      /* enter your code below  */
      DLNode n = new DLNode(obj,null, null);
      DLNode copy = head;
      for(int k = 0; k<index; k++)
      {
         copy = copy.getNext();
      }
      n.setNext(copy);
      n.setPrev(copy.getPrev());
      copy.getPrev().setNext(n);
      copy.setPrev(n);
      
      size++;
   }
   
   /* return obj at position index.  
   	*/
   public Object get(int index)
   {
      DLNode d = head;
      for(int n = 0; n<index; n++)
      {
         d = d.getNext();
      }
      return d;
   }
   
   /* replaces obj at position index.  
   		*/
   public void set(int index, Object obj)
   {
      DLNode d = head;
      for(int n = 0; n<index; n++)
      {
         if(d.getNext() != null)
            d = d.getNext();
      }
      d.setValue(obj);
   }
   
   /*  removes the node from position index.  decrements size.
   	  @return the object at position index.
   	 */
   public Object remove(int index)
   {
     DLNode d = head;
     if(index == 1)
     {
        head = head.getNext();
        return null;
     }
     for(int n = 0; n<index-1; n++)
     {
        if(d.getNext() != null)
           d = d.getNext();
        else
         return null;
     }
     d.getNext().getNext().setPrev(d);
     d.setNext(d.getNext().getNext());
     for(int b = 0; b<index-1; b++)
     {
         d = d.getPrev();
     }
     size--;
     return d;
   }
   
  /* inserts obj at front of list; increases size;
     */
   public void addFirst(Object obj)
   {
      add(0, obj);
   }
   
   /* appends obj to end of list; increases size;
       */
   public void addLast(Object obj)
   {
      add(size, obj);
   }
   
   public Object getFirst()
   {
      return head;
   }
   
   public Object getLast()
   {
      DLNode d = head;
      while(d.getNext() != null)
      {
         d = d.getNext();
      }
      return d;
   }
   
   public Object removeFirst()
   {
      remove(1);
      return head;
   }
   
   public Object removeLast()
   {
      remove(size);
      return head;
   }
   
   public String toString()
   {
      String s = new String("");
      DLNode copy = head.getNext();
      for(int n = 0; n<size; n++)
      {
         if(n == size-1)
         {
            s+=copy.getValue();
         }
         else if(copy == null)
         {
            copy = copy.getNext();
         }
         else if(copy.getValue() == null)
         {
            s += "";
         }
         else
         {
            s += copy.getValue() + ", ";
            copy = copy.getNext();
         }
      }
      return s;
   }
}
	
//////////////////////////////////////

class DLNode 
{
   private Object value;
   private DLNode prev;
   private DLNode next;
   public DLNode(Object arg, DLNode p, DLNode n)
   {
      value=arg;
      prev=p;
      next=n;
   }
   public DLNode()
   {
      value=null;
      next=this;
      prev=this;
   }
   public void setValue(Object arg)
   {
      value=arg;
   }
   public void setNext(DLNode arg)
   {
      next=arg;
   }
   public void setPrev(DLNode arg)
   {
      prev=arg;
   }
   public DLNode getNext()
   {
      return next;
   }
   public DLNode getPrev()
   {
      return prev;
   }
   public Object getValue()
   {
      return value;
   }
}
