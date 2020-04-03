/**
 * Created by masha on 4/25/2017.
 */
 interface PBT <E> {
    static <X> PBT<X> create(X value){
            return new BinaryTree<>(value);
        }

    int numberOfNodes();

    void add(E value);

    void remove(E value);

    void printSideways();

    void printSidewaysParent();

 }

