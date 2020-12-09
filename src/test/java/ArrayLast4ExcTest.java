import org.junit.Test;

public class ArrayLast4ExcTest {

    @Test(expected = RuntimeException.class)
    public void testArrayLast4Exception(){
        int[] arr = {1,1,2,2,3,3,5};
        Main.getArrayLast4(arr);
    }
}
