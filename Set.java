import org.pojomatic.Pojomatic;

public class Bose<T> {

    private T arrayElement[] = (T[]) new Object[1000];
    int size = 0;

    public Bose() {
        this.arrayElement = null;
    }

    public Bose(T[] element) {
        arrayElement = element;
        size = arrayElement.length;
    }

    boolean isEmpty() {
        if (arrayElement != null) {
            return false;
        }
        return true;
    }

    boolean add(T[] element) {

        if (contains((T) element)) {
            return false;
        }

        incrementArray();
        arrayElement[size++] = (T) element;

        return true;

    }

    public boolean contains(T elem) {

        if (elem == null) {
            return true;
        } else {
            for (int i = 0; i < arrayElement.length; i++) {
                if (elem.equals(arrayElement[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    private void incrementArray() {
        T[] temparray = arrayElement;

        int tempsize = size + 5;
        arrayElement = (T[]) new Object[tempsize];

        System.arraycopy(temparray, 0, arrayElement, 0, size);
    }

    @Override
    public boolean equals(Object o) {
        return Pojomatic.equals(this, o);
    }

    @Override
    public int hashCode() {
        return Pojomatic.hashCode(this);
    }
}