import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        questions questions = new questions();

//        q1
        int[] nums = {0,1,0,3,12};
        int[] result = questions.moveZero(nums);
        System.out.println(Arrays.toString(result));

//        q2
        String s = "leetcode";
        int index = questions.noRepeatChar(s);
        System.out.println(index);
    }
}