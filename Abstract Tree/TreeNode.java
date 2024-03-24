import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/*
Basic tree node interface
*/
public interface TreeNode<T> {

    /**
     * Add the child to this node
     *
     * @param identifier identifier to verify if it is the child of this node
     * @param child a child
     * @return new Node by adding child to group or create new group node if it is the leaf
     */
    TreeNode<T> addChild(Predicate<T> identifier, TreeNode<T> child);

    /**
     * return the list of data of nodes (this node and of children if it is group node)
     * @return list of data
     */
    List<T> toList();

    /**
     * map by using the transform method to map the data T to R
     * @param transform transform method
     * @param <R> parameter
     * @return TreeNode object of R data
     */
    <R> TreeNode<R> map(Function<T, R> transform);

    /**
     * reduce the node by using combiner method
     * that accept 2 T objects, calculate the T result
     * @param initialValue initial value
     * @param combiner combiner method (T,T)->T
     * @return the T result
     */
    T reduce(T initialValue, BiFunction<T, T, T> combiner);

    /**
     * print this node (and its children if it is group node)
     */
    public void print();
}
 
 