package exercises;

import edu.touro.mcon264.apps.collections.LinkedCollection;
import edu.touro.mcon264.support.LLNode;

public class ExtendedLinkedCollection<T> extends LinkedCollection<T> {
    @Override
    public String toString() {
        /**
         * Returns a string representation of the collection.
         * The string representation consists of a list of the collection's elements
         * in the order they are stored, enclosed in square brackets ("[]").
         * Adjacent elements are separated by a comma and space.
         * Elements are converted to strings as by String.valueOf(Object).
         *
         * @return a string representation of this collection
         */

            StringBuilder sb = new StringBuilder();
            sb.append("[");

            LLNode<T> current = head;
            while (current != null) {
                sb.append(String.valueOf(current.getInfo()));
                if (current.getLink() != null) {
                    sb.append(", ");
              }
              current = current.getLink();
          }
      
          sb.append("]");
          return sb.toString();
      }
    /**
     * Counts the number of times the specified target element
     * appears in this linked collection.
     *
     * @param target the element to count
     * @return the number of occurrences of target in the collection
     */




    public int count(T target) {
      //ТОDO: implement this method. Count the number of times target appears in the collection. Create Javadoc.
        LLNode<T> current = head;
        int count = 0;
        while (current != null) {
            if (current.getInfo().equals(target)) {
                count++;
            }
            current = current.getLink();
        }
        return count;

    }
    /**
     * Removes all occurrences of the specified target element
     * from this linked collection.
     *
     * @param target the element to remove
     * @return the number of elements removed
     */

    public void removeAll(T target) {
      //ТОDO: implement this method. Remove all occurrences of target from the collection and return the number of elements removed. Create Javadoc.
        LLNode<T> current = head;
        int count = 0;
        while (current != null) {
            if (current.getInfo().equals(target)) {
                remove(current.getInfo());
                count++;
            }
            current = current.getLink();
        }
    }
}
