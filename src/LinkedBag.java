/** % java LinkedBag.java < tobe.txt
 Vsego v sumke = 14
 is
 -
 -
 -
 that
 -
 -
 be
 -
 to
 not
 or
 be
 to

 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class LinkedBag<Item> implements Iterable<Item>{

    private Node first = null;
    private int N = 0;

    private class Node{
        Item item;
        Node next;
    }

    public void add(Item item){
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public int size() { return N; }

    public Iterator<Item> iterator() { return new ListIterator(); }

    private class ListIterator implements Iterator<Item>{
        private Node current = first;

        public boolean hasNext() { return current!= null; }
        public void remove() { throw new UnsupportedOperationException();}
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }


    public static void main(String[] args) {
	LinkedBag<String> bag = new LinkedBag<>();
	while (!StdIn.isEmpty()){
	    String b = StdIn.readString();
	    bag.add(b);
    }
        StdOut.println("Vsego v sumke = " + bag.size());
	for (String b : bag )
	    StdOut.println(b);
    }
}
