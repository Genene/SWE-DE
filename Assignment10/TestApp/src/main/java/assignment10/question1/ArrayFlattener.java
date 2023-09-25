package assignment10.question1;


import org.springframework.stereotype.Component;

@Component
public class ArrayFlattener {

    public int[] flattenArray(int[][] arr){
        if(arr == null){
            return null;
        }
        int totalLength = 0;
        for (int[] ints : arr) {
            totalLength += ints.length;
        }
        int[] result = new int[totalLength];
        int index = 0;
        for (int[] ints : arr) {
            for (int anInt : ints) {
                result[index++] = anInt;
            }
        }
        return result;
    }



}
