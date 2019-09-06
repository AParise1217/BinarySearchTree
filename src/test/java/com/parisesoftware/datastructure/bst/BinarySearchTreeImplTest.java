package com.parisesoftware.datastructure.bst;

import com.parisesoftware.datastructure.model.BSTNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeImplTest {

    @Test
    public void isEmptyShouldReturnTrueWhenNoNodes() {
        // Method invocation
        BinarySearchTreeImpl testBST = new BinarySearchTreeImpl();

        //Verify
        assertTrue(testBST.isEmpty());
    }

    @Test
    public void isEmptyShouldReturnFalseWhenThereAreNodes() {

        // Method invocation
        BinarySearchTreeImpl<String> testBST = new BinarySearchTreeImpl<>();
        testBST.insert("Some Test Data");
        testBST.insert("Some More Test Data");

        //Verify
        assertFalse(testBST.isEmpty());
    }

    @Test
    public void insertShouldAddDataToBSTAsRoot() {
        //Setup test data
        String testString = "This is a test.";

        // Method invocation
        BinarySearchTreeImpl<String> testBST = new BinarySearchTreeImpl<>();
        testBST.insert(testString);

        //Verify
        assertNotEquals(null, testBST.getRoot());
        assertEquals(testString, testBST.getRoot().getData());
    }

    @Test
    public void insertShouldAddKeepInitialDataSetAsRoot() {
        //Setup test data
        String testString1 = "Lore";
        String testString2 = "Data";

        // Method invocation
        BinarySearchTreeImpl<String> testBST = new BinarySearchTreeImpl<>();
        testBST.insert(testString1);
        testBST.insert(testString2);

        //Verify
        assertNotEquals(null, testBST.getRoot());
        assertEquals(testString1, testBST.getRoot().getData());
    }

    @Test
    public void removeNodeShouldUpdateRoot() {
        //Setup test data
        String testString1 = "Warf";
        String testString2 = "Yarr";

        BinarySearchTreeImpl<String> testBST = new BinarySearchTreeImpl<>();
        testBST.insert(testString1);
        testBST.insert(testString2);

        // Method invocation
        testBST.removeNode(testString1);

        //Verify
        assertNotEquals(null, testBST.getRoot());
        assertEquals(testString2, testBST.getRoot().getData());
    }

    @Test
    public void setRootShouldUpdateRoot() {
        //Setup test data
        String testString1 = "TOS";
        String testString2 = "TNG";

        BinarySearchTreeImpl<String> testBST = new BinarySearchTreeImpl<>();
        testBST.insert(testString1);

        // Method invocation
        testBST.setRoot(new BSTNode<>(testString2));

        //Verify
        assertNotEquals(null, testBST.getRoot());
        assertEquals(testString2, testBST.getRoot().getData());
    }

    @Test
    public void removeNodeShouldRemoveRootWithOnlyOneNode() {
        //Setup test data
        String testString1 = "Picard";

        BinarySearchTreeImpl<String> testBST = new BinarySearchTreeImpl<>();
        testBST.insert(testString1);

        // Method invocation
        testBST.removeNode(testString1);

        //Verify
        assertNull(testBST.getRoot());
    }

    @Test
    public void constructorShouldSetRootAsNull() {
        // Method invocation
        BinarySearchTreeImpl testBST = new BinarySearchTreeImpl();

        //Verify
        assertNull(testBST.getRoot());
    }

}
