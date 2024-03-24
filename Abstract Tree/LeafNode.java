import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/*
LeafNode is a generic class and child of AbstractTreeNode.
This node allows for a single data element.
*/
public class LeafNode<T> extends AbstractTreeNode<T> {

    /**
     * constructor
     *
     * @param data data of node
     */
    public LeafNode(T data) {
        super(data);
    }

    /**
     * Add the child to this node
     *
     * @param identifier identifier to verify if it is the child of this node
     * @param child a child
     * @return new Node by adding child to group or create new group node if it is the leaf
     */
    @Override
    public TreeNode<T> addChild(Predicate<T> identifier, TreeNode<T> child) {

        //this leaf is changed to group node
        if (identifier.test(data)){
            GroupNode<T> groupNode = new GroupNode<>(data);
            groupNode.addChild(b->true, child);
            return groupNode;
        }
        return this;
    }

    /**
     * return the list of data of nodes (this node and of children if it is group node)
     * @return list of data
     */
    @Override
    public List<T> toList() {
        List<T> result = new ArrayList<>();
        result.add(data);
        return result;
    }

    /**
     * map by using the transform method to map the data T to R
     * @param transform transform method
     * @param <R> parameter
     * @return TreeNode object of R data
     */
    @Override
    public <R> TreeNode<R> map(Function<T, R> transform) {
        return new LeafNode<R>(transform.apply(data));
    }

    /**
     * reduce the node by using combiner method
     * that accept 2 T objects, calculate the T result
     * @param initialValue initial value
     * @param combiner combiner method (T,T)->T
     * @return the T result
     */
    @Override
    public T reduce(T initialValue, BiFunction<T, T, T> combiner) {
        return combiner.apply(initialValue, data);
    }

    /**
     * print this node (and its children if it is group node)
     */
    @Override
    public void print() {
        System.out.println(data);
    }
}
