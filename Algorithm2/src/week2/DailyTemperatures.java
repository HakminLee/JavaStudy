package week2;

import java.util.Stack;

public class DailyTemperatures {
    public int[] DailyTemperatures(int[] temps){
    int[] ans = new int[temps.length];
    Stack<Integer> stack = new Stack<>();
    for(int day = 0; day<temps.length; day++){
        while (!stack.isEmpty()&&temps[stack.peek()]<temps[day]){
            int prevday = stack.pop();
            ans[prevday] = day - prevday;
        }
        stack.push(day);
    }
    return ans;
    }
}



