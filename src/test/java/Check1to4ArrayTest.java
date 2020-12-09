import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Check1to4ArrayTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
            {new  int[] {1,1,1,1}, false},
                {new  int[] {1,4,1}, true},
                {new  int[] {1,4,4,4,4}, true},
                {new  int[] {1,4,2,4,4,4}, false}
        });
    }

    private int[] array;
    private boolean res;

    public Check1to4ArrayTest(int[] array, boolean res) {
        this.array = array;
        this.res = res;
    }

    @Test
    public void testCheck1to4(){
        Assert.assertEquals(res, Main.check1to4Array(array));
    }
}
