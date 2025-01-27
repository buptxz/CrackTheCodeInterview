/**
 * Created by xiong on 10/17/2016.
 */
package Q3_01_Three_in_One;

import CtCILibrary.AssortedMethods;
import java.util.Stack;
import java.lang.Integer;
import java.util.Arrays;

public class ZhengQuestion {
    public static void printStacks(ZhengFixedMultiStack<Integer> stacks) {
        System.out.println(AssortedMethods.arrayToString(stacks.getValues()));
    }

    public static void main(String [] args) throws Exception  {
        ZhengFixedMultiStack<Integer> stacks = new ZhengFixedMultiStack<>(4);
        printStacks(stacks);
        stacks.push(0, 10);
        printStacks(stacks);
        stacks.push(1, 20);
        printStacks(stacks);
        stacks.push(2, 30);
        printStacks(stacks);

        stacks.push(1, 21);
        printStacks(stacks);
        stacks.push(0, 11);
        printStacks(stacks);
        stacks.push(0, 12);
        printStacks(stacks);

        stacks.pop(0);
        printStacks(stacks);

        stacks.push(2, 31);
        printStacks(stacks);

        stacks.push(0, 13);
        printStacks(stacks);
        stacks.push(1, 22);
        printStacks(stacks);

        stacks.push(2, 31);
        printStacks(stacks);
        stacks.push(2, 32);
        printStacks(stacks);
    }
}
