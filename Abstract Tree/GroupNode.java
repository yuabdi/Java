import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/*
GroupNode is a generic class and child of AbstractTreeNode.
This node basically take the place of a supervisor.
It allows for a single data element along with an array list of other elements.
*/
public class GroupNode<T> extends AbstractTreeNode<T> {

    /**
     * children of this node
     */
    private List<TreeNode> children;

    /**
     * constructor
     *
     * @param data data of node
     */
    public GroupNode(T data) {
        super(data);
        children = new LinkedList<>();
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

        if (identifier.test(this.data)){
            children.add(child);
            return this;
        }

        //note: the child can be converted from leaf node to group node.
        for (int i = 0; i < children.size(); i++){
            children.set(i, children.get(i).addChild(identifier, child));
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
        result.add(this.data);
        for (TreeNode e : children) {
            result.addAll(e.toList());
        }
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

        GroupNode newGroup = new GroupNode<>(transform.apply(this.data));

        for (TreeNode e : children) {
            newGroup.addChild(b->true, e.map(transform));
        }

        return newGroup;
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

        T result = combiner.apply(initialValue, this.data);

        for (TreeNode e : children) {
            result = (T) e.reduce(result, combiner);
        }

        return result;
    }

    /**
     * print this node (and its children if it is group node)
     */
    @Override
    public void print() {
        System.out.println(this.data);
        for (TreeNode e : children) {
            e.print();
        }
    }
}