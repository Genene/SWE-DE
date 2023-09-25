package assignment10.question1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArrayFlattenerService {

    ArrayFlattener arrayFlattener;

    public int[] flattenArray(int[][] arr){
        return arrayFlattener.flattenArray(arr);
    }

    @Autowired
    public void setArrayFlattener(ArrayFlattener arrayFlattener){
        this.arrayFlattener = arrayFlattener;
    }
}
