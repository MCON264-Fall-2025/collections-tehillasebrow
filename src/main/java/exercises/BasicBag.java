package exercises;

import edu.touro.mcon264.apps.collections.ArrayCollection;
import edu.touro.mcon264.apps.collections.BagInterface;

/**
 * BasicBag is a simple implementation of the BagInterface using an array
 * as the underlying data structure. It extends ArrayCollection<T> to reuse
 * array-based storage and provides Bag-specific operations such as grab,
 * count, removeAll, and clear.
 *
 * @param <T> the type of elements stored in the bag
 */

public class BasicBag<T> extends ArrayCollection<T> implements BagInterface<T> {
    @Override
    /**
     * Returns a random element from the bag without removing it.
     * If the bag is empty, returns null.
     *
     * @return a randomly selected element, or null if empty
     */

    public T grab() {
        if (numElements == 0) {
            return null;
        }
        int randomIndex = (int) (Math.random() * numElements);
        T grabbed = elements[randomIndex];

        // Shift elements left to fill the gap
        for (int i = randomIndex; i < numElements - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[numElements - 1] = null;
        numElements--;

        return grabbed;


    }

    /**
     * Counts how many times the target element appears in the bag.
     *
     * @param target the element to count
     * @return the number of occurrences of target
     */


    @Override
    public int count(T target) {
        int count = 0;
        for (int i = 0; i < numElements; i++) {
            if (elements[i].equals(target)) {
                count++;
            }
        }
        return count;
    }


    @Override
    public int removeAll(T target) {
        int removed = 0;
        for (int i = 0; i < numElements; ) {
            if (elements[i].equals(target)) {
                remove(elements[i]);
                removed++;
            } else {
                i++;
            }
        }
        return removed;
    }


    @Override
    public void clear() {
        for (int i = 0; i < numElements; i++) {
            elements[i] = null;
        }
        numElements = 0;
    }


    // TODO: implement the methods in the BagInterface using an array as the underlying data structure
    // consider extending ArrayCollection<T>
    // put in the JavaDoc comments as specified in the BagInterface.
    // Which SOLID principles is being applied here?
    public static void main(String[] args) {
        BasicBag<Integer> bag = new BasicBag<>();
        bag.add(1);
        bag.add(2);
        bag.add(2);
        bag.add(3);
        // Grab a random element
        Integer grabbed = bag.grab();
        System.out.println("Grabbed: " + grabbed);


        int count = bag.count(2);
        bag.removeAll(2);
        bag.clear();


    }

}
