import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class BinarySearchTreeTest 
{
    @Test
    public void testBSTConstructor()
    {
        BinarySearchTree<String> bst = new BinarySearchTree<>();

        Assertions.assertEquals(0, bst.size());
        Assertions.assertEquals(0, bst.height());

        Assertions.assertTrue(bst.isEmpty());
    } 
    
    @Test
    public void testBSTInsert()
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(10);

        Assertions.assertEquals(10, bst.findMin());
        Assertions.assertEquals(10, bst.findMax());

        bst.insert(5);
        bst.insert(15);

        Assertions.assertEquals(3, bst.size());
        Assertions.assertEquals(2, bst.height());
        Assertions.assertEquals(5, bst.findMin());
        Assertions.assertEquals(15, bst.findMax());

        bst.insert(2);
        bst.insert(7);

        Assertions.assertEquals(5, bst.size());
        Assertions.assertEquals(3, bst.height());
        Assertions.assertEquals(2, bst.findMin());
        Assertions.assertEquals(15, bst.findMax());

        bst.insert(1);
        bst.insert(3);
        bst.insert(20);

        Assertions.assertEquals(8, bst.size());
        Assertions.assertEquals(4, bst.height());
        Assertions.assertEquals(1, bst.findMin());
        Assertions.assertEquals(20, bst.findMax());
    }

    @Test
    public void testBSTContains()
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(2);
        bst.insert(7);
        bst.insert(1);
        bst.insert(3);
        bst.insert(20);
        boolean inserted = bst.insert(20);

        Assertions.assertTrue(bst.contains(10));
        Assertions.assertFalse(bst.contains(25));
        Assertions.assertTrue(bst.contains(1));
        Assertions.assertFalse(bst.contains(4));
        Assertions.assertFalse(inserted);
    }
}
