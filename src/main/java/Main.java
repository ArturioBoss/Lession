import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,4,4,4,1,1};
        System.out.println(Arrays.toString(getArrayLast4(arr)));
        System.out.println(check1to4Array(arr));

    }

    public static int[] getArrayLast4(int[] in){
        for (int i = in.length-1; i >=0 ; i--) {
            if (in[i] == 4){
                return Arrays.copyOfRange(in, i+1, in.length);
            }
        }
        throw new RuntimeException("В данном массиве нет 4");
    }

    public static boolean check1to4Array(int[] in){
        boolean has1 = false, has4 = false;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == 1){
                has1 = true;
            }else if (in[i] == 4){
                has4 = true;
            }else {
                return false;
            }
            
        }
        return has1 & has4;
    }
}
