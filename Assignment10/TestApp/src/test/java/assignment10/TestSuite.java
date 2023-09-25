package assignment10;


import assignment10.question1.ArrayFlattenerService;
import assignment10.question2.ArrayReversor;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TestSuite {

    @InjectMocks
    ArrayReversor arrayReversor;

    @Mock
    ArrayFlattenerService arrayFlattenerService;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testFlattenArray() {
        Mockito.when(arrayFlattenerService.flattenArray(Mockito.any())).thenReturn(new int[]{1, 3, 0, 4, 5, 9});
        int[][] arr = {{1, 3}, {0}, {4, 5, 9}};
        int[] expected = {1, 3, 0, 4, 5, 9};
        int[] result = arrayFlattenerService.flattenArray(arr);
        assert(Arrays.equals(expected, result));
    }

    @Test
    public void testFlattenArrayNull() {
        Mockito.when(arrayFlattenerService.flattenArray(Mockito.any())).thenReturn(null);
        int[] result = arrayFlattenerService.flattenArray(null);
        assert(result == null);
    }

    @Test
    public void testReverseArray() {
        Mockito.when(arrayFlattenerService.flattenArray(Mockito.any())).thenReturn(new int[]{1, 3, 0, 4, 5, 9});
        int[][] arr = {{1, 3}, {0}, {4, 5, 9}};
        int [] expected = {9, 5, 4, 0, 3, 1};
        int[] result = arrayReversor.reverseArray(arr);
        assertNotNull(result);
        assert(Arrays.equals(expected, result));
    }
    @Test
    public void testReverseArrayNull() {
        Mockito.when(arrayFlattenerService.flattenArray(Mockito.any())).thenReturn(null);
        int[][] arr = {{1, 3}, {0}, {4, 5, 9}};
        int [] expected = null;
        int[] result = arrayReversor.reverseArray(arr);
        assert(Arrays.equals(expected, result));
    }

}
