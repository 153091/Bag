/** % java ResizingBag.java < tobe.txt
 Note: ResizingBag.java uses unchecked or unsafe operations.
 Note: Recompile with -Xlint:unchecked for details.
 Vsego v sumke = 14
 to
 be
 or
 not
 to
 -
 be
 -
 -
 that
 -
 -
 -
 is

 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingBag<Item> implements Iterable<Item> {
    private Item[] b;
    private int N = 0;

    public ResizingBag() {
        b = (Item[]) new Object[1];
    }
    public boolean isEmpty () { return N>0;}
    public void add(Item item) {
        if (N==b.length) resize(b.length*2);
        b[N++]= item;
    }


    public void resize(int capacity){
        Item[] copy = (Item[]) new Object[capacity];
        for (int i=0; i<N ; i++)
            copy[i] = b[i];
        b=copy;
    }

    public int size() { return N;}

    public Iterator<Item> iterator() {return new ArrayIterator();}

    private class ArrayIterator implements Iterator<Item> {
        private int i = 0;
        public boolean hasNext() {return i<N ; }
        public void remove() {throw new UnsupportedOperationException();}
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return b[i++];
        }
    }


    public static void main(String[] args){
        ResizingBag<String> bag = new ResizingBag<>();
        while (!StdIn.isEmpty()) {
            String b = StdIn.readString();
            bag.add(b);
        }
        StdOut.println("Vsego v sumke = " +bag.size());
        for (String b : bag)
        StdOut.println(b);
    }
}
