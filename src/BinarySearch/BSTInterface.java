package BinarySearch;

public interface BSTInterface<T> {
    void insert (T element);
    void delete(T element);
    int size();
    int height();
    boolean search(T element);
}
