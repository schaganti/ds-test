package chags.io.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class ReOrderLogs {
    public static void main(String[] args) {

        System.out.println("r 527".matches(".*\\s\\d+\\s*.*"));
        String[] input = new String[]{
                "1 n u", "r 527", "j 893", "6 14", "6 82"};
        ReOrderLogs reOrderLogs = new ReOrderLogs();
        reOrderLogs.reorderLogFiles(input);
    }

    public String[] reorderLogFiles(String[] logs) {

        List<String> stringLogs = new ArrayList<String>();
        List<String> numLogs = new ArrayList<String>();

        for (int i = 0; i < logs.length; i++) {
            String entry = logs[i];
            if (entry.matches(".*\\s\\d+\\s*.*")) {
                numLogs.add(entry);
            } else {
                System.out.println(entry);
                stringLogs.add(entry);
            }
        }

        Collections.sort(stringLogs, (v1, v2) -> {
            String v1Text = v1.substring(v1.indexOf(" ") + 1);
            String v2Text = v2.substring(v2.indexOf(" ") + 1);
            int result = v1Text.compareTo(v2Text);
            return result != 0 ? result : v1.compareTo(v2);
        });
        stringLogs.addAll(numLogs);
        System.out.print(stringLogs);
        return stringLogs.toArray(new String[0]);
    }

    private boolean isNumLog(String entry) {
        String[] words = entry.split(" ");
        return words[1].matches("\\d+");
    }

}
