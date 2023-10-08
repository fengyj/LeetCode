package me.fengyj.algorithms.sorter;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SorterTest {

    private Integer[] getTestData() {
        return new Integer[] { 6, 4, 3, 1, 10, 20, 5, 2, 14, 11, 15, 13, 12, 8, 17, 19, 18, 9 };
    }
    
    private Integer[] getTestDataInOrder() {
        return new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
    }
    
    private Integer[] getTestDataInReverseOrder() {
        return new Integer[] { 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
    }
    
    private Integer[] getTestDataWithDuplicated() {
        return new Integer[] { 6, 6, 4, 3, 1, 10, 20, 5, 2, 12, 14, 11, 15, 13, 3, 12, 8, 17, 19, 18, 9, 9, 9 };
    }
    
    @Test
    public void test_Selection() {

        Integer[] data = getTestData();

        Sorter.SHOW_STEPS = true;

        new Selection<Integer>().sort(data);

        assertTrue(Sorter.isSorted(data));
    }
    
    @Test
    public void test_Selection_With_Order_Data() {

        Integer[] data = getTestDataInOrder();

        Sorter.SHOW_STEPS = true;

        new Selection<Integer>().sort(data);

        assertTrue(Sorter.isSorted(data));
    }
    
    @Test
    public void test_Selection_With_Reverse_Order_Data() {

        Integer[] data = getTestDataInReverseOrder();

        Sorter.SHOW_STEPS = true;

        new Selection<Integer>().sort(data);

        assertTrue(Sorter.isSorted(data));
    }
    
    @Test
    public void test_Selection_With_Duplicated_Data() {

        Integer[] data = getTestDataWithDuplicated();

        Sorter.SHOW_STEPS = true;

        new Selection<Integer>().sort(data);

        assertTrue(Sorter.isSorted(data));
    }

    @Test
    public void test_Insection() {

        Integer[] data = getTestData();

        Sorter.SHOW_STEPS = true;

        new Insection<Integer>().sort(data);

        assertTrue(Sorter.isSorted(data));
    }
    
    @Test
    public void test_Insection_With_Order_Data() {

        Integer[] data = getTestDataInOrder();

        Sorter.SHOW_STEPS = true;

        new Insection<Integer>().sort(data);

        assertTrue(Sorter.isSorted(data));
    }
    
    @Test
    public void test_Insection_With_Reverse_Order_Data() {

        Integer[] data = getTestDataInReverseOrder();

        Sorter.SHOW_STEPS = true;

        new Insection<Integer>().sort(data);

        assertTrue(Sorter.isSorted(data));
    }

    @Test
    public void test_Insection_With_Duplicated_Data() {

        Integer[] data = getTestDataWithDuplicated();

        Sorter.SHOW_STEPS = true;

        new Insection<Integer>().sort(data);

        assertTrue(Sorter.isSorted(data));
    }

    @Test
    public void test_Shell() {

        Integer[] data = getTestData();

        Sorter.SHOW_STEPS = true;

        new Shell<Integer>().sort(data);

        assertTrue(Sorter.isSorted(data));
    }
    
    @Test
    public void test_Shell_With_Order_Data() {

        Integer[] data = getTestDataInOrder();

        Sorter.SHOW_STEPS = true;

        new Shell<Integer>().sort(data);

        assertTrue(Sorter.isSorted(data));
    }
    
    @Test
    public void test_Shell_With_Reverse_Order_Data() {

        Integer[] data = getTestDataInReverseOrder();

        Sorter.SHOW_STEPS = true;

        new Shell<Integer>().sort(data);

        assertTrue(Sorter.isSorted(data));
    }

    @Test
    public void test_Shell_With_Duplicated_Data() {

        Integer[] data = getTestDataWithDuplicated();

        Sorter.SHOW_STEPS = true;

        new Shell<Integer>().sort(data);

        assertTrue(Sorter.isSorted(data));
    }

    @Test
    public void test_Merge() {

        Integer[] data = getTestData();

        Sorter.SHOW_STEPS = true;

        new Merge<Integer>().sort(data);

        assertTrue(Sorter.isSorted(data));
    }
    
    @Test
    public void test_Merge_With_Order_Data() {

        Integer[] data = getTestDataInOrder();

        Sorter.SHOW_STEPS = true;

        new Merge<Integer>().sort(data);

        assertTrue(Sorter.isSorted(data));
    }
    
    @Test
    public void test_Merge_With_Reverse_Order_Data() {

        Integer[] data = getTestDataInReverseOrder();

        Sorter.SHOW_STEPS = true;

        new Merge<Integer>().sort(data);

        assertTrue(Sorter.isSorted(data));
    }

    @Test
    public void test_Merge_With_Duplicated_Data() {

        Integer[] data = getTestDataWithDuplicated();

        Sorter.SHOW_STEPS = true;

        new Merge<Integer>().sort(data);

        assertTrue(Sorter.isSorted(data));
    }

    @Test
    public void test_Quick() {

        Integer[] data = getTestData();

        Sorter.SHOW_STEPS = true;

        new Quick<Integer>().sort(data);

        assertTrue(Sorter.isSorted(data));
    }
    
    @Test
    public void test_Quick_With_Order_Data() {

        Integer[] data = getTestDataInOrder();

        Sorter.SHOW_STEPS = true;

        new Quick<Integer>().sort(data);

        assertTrue(Sorter.isSorted(data));
    }
    
    @Test
    public void test_Quick_With_Reverse_Order_Data() {

        Integer[] data = getTestDataInReverseOrder();

        Sorter.SHOW_STEPS = true;

        new Quick<Integer>().sort(data);

        assertTrue(Sorter.isSorted(data));
    }
    
    @Test
    public void test_Quick_With_Duplicated_Data() {

        Integer[] data = getTestDataWithDuplicated();

        Sorter.SHOW_STEPS = true;

        new Quick<Integer>().sort(data);

        assertTrue(Sorter.isSorted(data));
    }

    @Test
    public void test_Heap() {

        Integer[] data = getTestData();

        Sorter.SHOW_STEPS = true;

        new Heap<Integer>().sort(data);

        assertTrue(Sorter.isSorted(data));
    }

    @Test
    public void test_Heap_With_Order_Data() {

        Integer[] data = getTestDataInOrder();

        Sorter.SHOW_STEPS = true;

        new Heap<Integer>().sort(data);

        assertTrue(Sorter.isSorted(data));
    }

    @Test
    public void test_Heap_With_Reverse_Order_Data() {

        Integer[] data = getTestDataInReverseOrder();

        Sorter.SHOW_STEPS = true;

        new Heap<Integer>().sort(data);

        assertTrue(Sorter.isSorted(data));
    }

    @Test
    public void test_Heap_With_Duplicated_Data() {

        Integer[] data = getTestDataWithDuplicated();

        Sorter.SHOW_STEPS = true;

        new Heap<Integer>().sort(data);

        assertTrue(Sorter.isSorted(data));
    }
}
