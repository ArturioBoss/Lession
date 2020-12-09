import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class GetArrayLast4Test {
    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {new  int[] {1,1,4,1}, new int[]{1}},
                {new  int[] {1,4,4}, new int[0]},
                {new  int[] {1,4,4,2,2,5,7}, new int[]{2,2,5,7}}
        });
    }

    private int[] arrayIn;
    private int[] arrayOut;

    public GetArrayLast4Test(int[] arrayIn, int[] arrayOut) {
        this.arrayIn = arrayIn;
        this.arrayOut = arrayOut;
    }

    @Test
    public void testArrayLast4(){
        Assert.assertArrayEquals(arrayOut, Main.getArrayLast4(arrayIn));
    }
}
