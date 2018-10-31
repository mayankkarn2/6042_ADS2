import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Class for bag.
 *
 * @param      <Item>  The item
 */
public class Bag<Item> implements Iterable<Item> {
    /**
     * N.
     */
    private int not;
    /**
     * First node.
     */
    private Node first;
    /**
     * Class for node.
     */
    private class Node {
        /**
         * Item.
         */
        private Item item;
        /**
         * Next node.
         */
        private Node next;
    }
    /**
     * Constructs the object.
     */
    public Bag() {
        first = null;
        not = 0;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return first == null;
    }
    /**
     * Size.
     *
     * @return     N.
     */
    public int size() {
        return not;
    }
    /**
     * Adds item to list.
     *
     * @param      item  The item.
     */
    public void add(final Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        not++;
    }
    /**
     * Iterator for Bag class.
     *
     * @return     A List.
     */
    public Iterator<Item> iterator()  {
        return new ListIterator();
    }
    /**
     * Class for list iterator.
     */
    private class ListIterator implements Iterator<Item> {
        /**
         * Node.
         */
        private Node current = first;
        /**
         * Determines if it has next.
         *
         * @return     True if has next, False otherwise.
         */
        public boolean hasNext() {
            return current != null;
        }
        /**
         * Removes the item from list.
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
        /**
         * Next item in the list.
         *
         * @return     Next item in the list.
         */
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
