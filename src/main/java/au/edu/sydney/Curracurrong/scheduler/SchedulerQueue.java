package au.edu.sydney.Curracurrong.scheduler;

import java.util.Enumeration;
import java.util.Vector;

import au.edu.sydney.Curracurrong.runtime.StreamOperator;

/**
 *
 * @author Vasvi Kakkad, Bernhard Scholz
 * University of Sydney
 */
public class SchedulerQueue{
    private static final int DEFAULT_INTIAL_CAPACITY = 11;

    private final Vector <StreamOperator> heap;

    /**
     * Creates a SchedulerQueue with the specified initial capacity that
     * orders its elements according to their natural ordering (using
     * Comparable).
     *
     * @param initialCapacity the initial capacity for this queue.
     */
    public SchedulerQueue(int initialCapacity) {
        if (initialCapacity < 1)
                throw new IllegalArgumentException("The initial capacity must be > 1. Actual: " + initialCapacity + ".");
        heap = new Vector<StreamOperator>(initialCapacity);
    }

    
    public SchedulerQueue() {
        this(DEFAULT_INTIAL_CAPACITY);
    }

    /**
     * Returns the number of elements in this collection.
     *
     * @return the number of elements in this collection.
     */
    public synchronized int size() {
        return heap.size();
    }

    /**
     * Removes all elements from the queue. The queue will be empty
     * after this call returns.
     */
    public synchronized void clear() {
        heap.removeAllElements();
    }

    /**
     * Adds the specified element to this queue.
     *
     * @param c the element
     */
    public synchronized void add(StreamOperator c) {
        if (c == null)
            throw new NullPointerException("Cannot insert null object");
        heap.addElement(c);        
        notifyAll();
    }

    /**
     * Removes a single instance of the specified element from this queue, if it
     * is present.
     *
     * @param o element to be removed from this collection, if present.
     * @return true if the collection contained the specified element.
     */
    public synchronized boolean remove(StreamOperator o) {
        int i = heap.indexOf(o);
        if (i == -1)
                return false;
        heap.removeElementAt(i);
        return true;
    }

    /**
     * Retrieves, but does not remove, the head of this queue, returning null if
     * this queue is empty. Does not block.
     *
     * @return the head of this queue, or null if this queue is empty.
     */
    public synchronized StreamOperator peek() {
        return isEmpty() ? null : (StreamOperator) heap.firstElement();
    }

    /**
     * Retrieves, but does not remove, the head of this queue. If the queue is
     * empty, this method blocks until a root becomes available.
     *
     * @return the head of this queue.
     */
    public synchronized StreamOperator peekBlocking() {
        while (isEmpty()) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        return (StreamOperator) heap.firstElement();
    }

    /**
     * Retrieves and removes the head of this queue, or null if this queue is
     * empty. Does not block.
     *
     * @return the head of this queue, or null if this queue is empty.
     */
    public synchronized StreamOperator poll() {
        if (isEmpty())
                return null;

        StreamOperator ret = (StreamOperator) heap.elementAt(0); // The root element to return

        heap.removeElementAt(0);

        return ret;
    }

    /**
     * Retrieves and removes the head of this queue. If the queue is empty, this
     * method blocks until a root becomes available.
     *
     * @return the head of this queue.
     */
    public synchronized StreamOperator pollBlocking() {
        while (isEmpty()) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        StreamOperator res = (StreamOperator) heap.firstElement();
        heap.removeElementAt(0);
        return res;
    }

    /**
     * Returns true if this collection contains no elements.
     *
     * @return true if this collection contains no elements.
     */
    public synchronized boolean isEmpty() {
        return heap.isEmpty();
    }

    /**
     * This method converts the queue contents into string
     * @return queue contents in string format
     */
    @Override
    public synchronized String toString() {
        StringBuffer s = new StringBuffer('{');
        for (int i = 0; i < heap.size(); i++) {
                s.append(heap.elementAt(i));
                if (i + 1 < heap.size())
                        s.append(',');
        }
        s.append('}');
        return s.toString();
    }

    /**
     * Returns an Enumeration over the elements in this queue. The Enumeration
     * does not return the elements in any particular order.
     *
     * @return an Enumeration over the elements in this queue.
     */
    public synchronized Enumeration<StreamOperator> elements() {
        return heap.elements();
    }

    /**
     * This method checks for the availability of a stream operator in scheduler queue
     * @param so stream operator
     * @return true if available, false otherwise
     */
    public synchronized boolean contains(StreamOperator so){
        if(heap.contains(so)) {
            return true;
        } else {
            return false;
        }
    }
}
