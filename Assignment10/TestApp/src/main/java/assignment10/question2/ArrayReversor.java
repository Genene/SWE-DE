package assignment10.question2;

import assignment10.question1.ArrayFlattener;
import assignment10.question1.ArrayFlattenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ArrayReversor {

    ArrayFlattenerService arrayFlattenerService;
    @Autowired
    public ArrayReversor(ArrayFlattenerService arrayFlattenerService){
        this.arrayFlattenerService = arrayFlattenerService;
    }

    public int[] reverseArray(int[][] arr){
        int[] flattenedArray = arrayFlattenerService.flattenArray(arr);
        if(flattenedArray == null){
            return null;
        }
        int[] reversedArray = new int[flattenedArray.length];
        int index = 0;
        for(int i = flattenedArray.length - 1; i >= 0; i--){
            reversedArray[index++] = flattenedArray[i];
        }
        return reversedArray;
    }

}
