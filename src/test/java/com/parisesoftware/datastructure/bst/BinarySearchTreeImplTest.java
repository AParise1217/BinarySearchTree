package com.parisesoftware.datastructure.bst;

import com.google.acai.Acai;
import com.google.inject.Inject;
import com.parisesoftware.datastructure.bst.factory.IBinarySearchTreeFactory;
import com.parisesoftware.datastructure.model.BSTNode;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class BinarySearchTreeImplTest {

    @Rule
    public Acai acai = new Acai(StringBSTTestModule.class);

    @Inject
    private IBinarySearchTreeFactory<String> binarySearchTreeFactory;

    private BinarySearchTreeImpl<String> getBST() {
        return (BinarySearchTreeImpl<String>) this.binarySearchTreeFactory.createBST();
    }

    @Test
    public void isEmptyShouldReturnTrueWhenNoNodes() {
        // Method invocation
        BinarySearchTreeImpl testBST = getBST();

        //Verify
        assertTrue(testBST.isEmpty());
    }

    @Test
    public void isEmptyShouldReturnFalseWhenThereAreNodes() {

        // Method invocation
        BinarySearchTreeImpl<String> testBST = getBST();
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
        BinarySearchTreeImpl<String> testBST = getBST();
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
        BinarySearchTreeImpl<String> testBST = getBST();
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

        BinarySearchTreeImpl<String> testBST = getBST();
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

        BinarySearchTreeImpl<String> testBST = getBST();
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

        BinarySearchTreeImpl<String> testBST = getBST();
        testBST.insert(testString1);

        // Method invocation
        testBST.removeNode(testString1);

        //Verify
        assertNull(testBST.getRoot());
    }

    @Test
    public void constructorShouldSetRootAsNull() {
        // Method invocation
        BinarySearchTreeImpl testBST = getBST();

        //Verify
        assertNull(testBST.getRoot());
    }

}
