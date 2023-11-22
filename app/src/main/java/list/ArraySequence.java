package list;

/**
 * This class implements Arraylist using position.
 * @param <E>
 * @author Yeabsira Bizualem 
 */
public class ArraySequence<E> implements Sequence<E> {
    private final ArrayBackedList<SequenceNode<E>> items;

    public ArraySequence(){
        items = new ArrayBackedList<>();
    }

    /**
     * Returns the number of elements in the list.
     * @return number of elements in the list
     */
    @Override
    public int size() {
        return items.size();
    }

    /**
     * changes the type f the element ot string
     * @return the string representation os of array sequence
     */
    @Override
    public String toString() {
        StringBuilder temp = new StringBuilder("{");
        for (int i = 0; i < items.size(); i++) {
            temp.append("(").append(i).append(",").append(items.get(i).getElement()).append(")");
            if (i < items.size() - 1) {
                temp.append(",");
            }
        }
        temp.append("}");
        return temp.toString();
    }


    /**
     * Tests whether the list is empty. tester 1
     *
     * @return true If the list is empty and false otherwise.
     */

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    /**
     * Returns the first Position in the list.
     *
     * @return the first Position in the list (or null, if empty).
     */
    @Override
    public Position<E> first() {
        if(items.isEmpty()){
            return null;
        }
        return items.get(0);
    }

    /**
     * Returns the last Position in the list.
     *
     * @return the last Position in the list (or null, if empty).
     */
    @Override
    public Position<E> last() {
        if(items.isEmpty()) {
            return null;
        }
        return items.get(items.size()-1);
    }

    /**
     * Returns the Position immediately before the given position.
     *
     * @param position A Position of the list.
     * @return The Position of the preceding element (or null, if p is first).
     * @throws IllegalArgumentException if p is not a valid position for this list.
     *
     */
    @Override
    public Position<E> before(Position<E> position) throws IllegalArgumentException {
        int indexOfPosition = indexOf(position);
        if(indexOfPosition < 0){
            throw new IllegalArgumentException("position is not valid") ;
        }
        if (position == items.get(0)){
            return null;
    }
        return  items.get(indexOfPosition-1);
    }

    /**
     * Returns the Position immediately after Position p.
     *
     * @param position A Position of the list.
     * @return The Position of the following element (or null, if p is last)
     * @throws IllegalArgumentException If position is not a valid position for this
     *                                  list.
     */
    @Override
    public Position<E> after(Position<E> position) throws IllegalArgumentException {
        int indexOfPosition = indexOf(position);
        if(indexOfPosition < 0 ){
            throw new IllegalArgumentException("Position is not valid");
        }
        if(position == items.get(items.size()-1)) {
            return null;
        }
        return  items.get(indexOfPosition+1);
    }

    /**
     * Inserts an element at the front of the list.
     *
     * @param element the new element.
     * @return The Position representing the location of the new element.
     */
    @Override
    public Position<E> addFirst(E element) {
        items.add(0,new SequenceNode<>(element));
        return atIndex(0);
    }
    /**
     * Inserts an element at the back of the list.
     *
     * @param element The new element.
     * @return The Position representing the location of the new element.
     */
    @Override
    public Position<E> addLast(E element) {
        int lastIndex = items.size();
        items.add(lastIndex, new SequenceNode<>(element));
        return atIndex(lastIndex);
    }

    /**
     * Inserts an element immediately before the given Position.
     *
     * @param position The Position before which the insertion takes place.
     * @param element  The new element.
     * @return The Position representing the location of the new element.
     * @throws IllegalArgumentException if p is not a valid position for this
     *                                  list.
     */
    @Override
    public Position<E> addBefore(Position<E> position, E element) throws IllegalArgumentException {
        int indexOfPosition = indexOf(position);
        if(indexOfPosition < 0) {
            throw new IllegalArgumentException("position is not valid");
        }
        items.add(indexOfPosition-1,new SequenceNode<>(element));
        return items.get(indexOfPosition);
    }

    /**
     * Inserts an element immediately after the given Position.
     *
     * @param position The Position after which the insertion takes place.
     * @param element  The new element.
     * @return the Position representing the location of the new element
     * @throws IllegalArgumentException If position is not a valid position for this
     *                                  list.
     */
    @Override
    public Position<E> addAfter(Position<E> position, E element) throws IllegalArgumentException {
        int indexOfPosition = indexOf(position);
        if(indexOfPosition < 0) {
            throw new IllegalArgumentException("position is not valid");
        }
         items.add(indexOfPosition + 1, new SequenceNode<>(element));
        return items.get(indexOfPosition);
    }

    /**
     * Replaces the element stored at the given Position and returns the
     * replaced element.
     *
     * @param position The Position of the element to be replaced.
     * @param element  The new element.
     * @return The replaced element.
     * @throws IllegalArgumentException If position is not a valid position for this
     *                                  list.
     */
    @Override
    public E set(Position<E> position, E element) throws IllegalArgumentException {
        int index = indexOf(position);
        if(index < 0) {
            throw new IllegalArgumentException("position is not valid");
        }
        SequenceNode<E> prevElement = items.set(index, new SequenceNode<>(element));
        return prevElement.getElement();
    }

    /**
     * Removes the element stored at the given Position and returns it.
     * The given position is invalidated as a result.
     *
     * @param position The Position of the element to be removed.
     * @return The removed element.
     * @throws IllegalArgumentException If position is not a valid position for this
     *                                  list.
     */
    @Override
    public E remove(Position<E> position) throws IllegalArgumentException {
       int index = indexOf(position);
        if(index < 0){
          throw new IllegalArgumentException("position is not valid");
        }
        SequenceNode<E> ele = items.get(index);
         items.remove(index);
        return ele.getElement();
    }

    /**
     * Returns (but does not remove) the element at index i.
     *
     * @param index The index of the element to return.
     * @return The element at the specified index.
     * @throws IndexOutOfBoundsException If the index is negative or greater
     *                                   than size()-1.
     */
    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if(index < 0 || index > items.size()-1) {
            throw new IndexOutOfBoundsException("Index out of bound");
        }
        SequenceNode<E> element = items.get(index);
        return element.getElement();
    }

    /**
     * Replaces the element at the specified index, and returns the element
     * previously stored.
     *
     * @param index   The index of the element to replace.
     * @param element the new element to be stored.
     * @return the previously stored element.
     * @throws IndexOutOfBoundsException If the index is negative or greater
     *                                   than size()-1.
     */
    @Override
    public E set(int index, E element) throws IndexOutOfBoundsException {
        if(index < 0 || index >= items.size()) {
            throw new IndexOutOfBoundsException("Index out of bound");
        }
        SequenceNode<E> prev = items.set(index,new SequenceNode<>(element));
      //  items.set(index,new SequenceNode<>(element));
        return prev.getElement();
    }

    /**
     * Inserts the given element at the specified index of the list, shifting
     * all subsequent elements in the list one position further to make room.
     *
     * @param index   The index at which the new element should be stored.
     * @param element The new element to be stored.
     * @throws IndexOutOfBoundsException If the index is negative or greater
     *                                   than size().
     */
    @Override
    public void add(int index, E element) throws IndexOutOfBoundsException {
        if(index < 0|| index > items.size()) {
            throw new IndexOutOfBoundsException("Index out of bound");
        }
       // items.expand(items.size()+1);
        items.add(index,new SequenceNode<>(element));
    }

    /**
     * Removes and returns the element at the given index, shifting all
     * subsequent elements in the list one position closer to the front.
     *
     * @param index The index of the element to be removed.
     * @return The element that had be stored at the given index.
     * @throws IndexOutOfBoundsException If the index is negative or greater
     *                                   than size()-1.
     */
    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if(index < 0 || index > items.size()-1) {
            throw new IndexOutOfBoundsException("Index out of bound");
        }
        Position<E> prev = atIndex(index);
        items.remove(index);
        return prev.getElement();
    }

    /**
     * Returns the position containing the element at the given index.
     *
     * @param index The index of the element.
     * @return The position of the element at the specified index.
     * @throws IndexOutOfBoundsException if the index is negative or greater
     *                                   than size()-1
     */
    @Override
    public Position<E> atIndex(int index) throws IndexOutOfBoundsException {
        if(index < 0 || index >= items.size()) {
            throw new IndexOutOfBoundsException("Index out of bound");
        }
        return items.get(index);
    }

    /**
     * Returns the index of the element stored at the given Position.
     *
     * @param position The Position of the element.
     * @return The index of the element at the specified Position.
     * @throws IllegalArgumentException if position is not a valid position for this
     *                                  list.
     */
    @Override
    public int indexOf(Position<E> position) throws IllegalArgumentException {
     //   int indexOfPosition = 0;
        for(int i = 0; i < items.size() ;i++) {
            if (items.get(i) == position) {
                return i;
            }
        }throw new IllegalArgumentException("Position is not valid");
    }

    public static class SequenceNode<E> implements Position<E>{
       private final E element;
       public SequenceNode(E element){
           this.element = element;
       }
        /**
         * Returns the element stored at this position.
         *
         * @return The stored element.
         * @throws IllegalStateException if position no longer valid
         */
        @Override
        public E getElement() throws IllegalStateException {
            return element;
        }
    }
}


