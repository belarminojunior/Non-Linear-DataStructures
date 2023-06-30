package interfaces;

public interface BSTInterface<T> {
    void insert (T element);
    void delete(T element);
    void preOrder();
    void inOrder();
    void  postOrder();
    boolean search(T element);
}
