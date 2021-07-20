package chags.io.ds;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {

    public static void main(String[] args) {
        GenerateParanthesis generateParanthesis = new GenerateParanthesis();

        generateParanthesis.generateParenthesis(2);
        //.forEach(System.out::println);
    }

    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            System.out.println(current);
            if (valid(current)) {
                result.add(new String(current));
            }
        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }

    public boolean valid(char[] current) {
        int balance = 0;
        for (char c : current) {
            balance = c == '(' ? balance + 1 : balance - 1;
            if (balance < 0) {
                return false;
            }
        }
        return (balance == 0);
    }
}
