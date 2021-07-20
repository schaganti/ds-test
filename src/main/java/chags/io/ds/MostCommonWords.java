package chags.io.ds;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MostCommonWords {
    public static void main(String[] args) {

        MostCommonWords mostCommonWords = new MostCommonWords();
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        System.out.println(paragraph.replaceAll("([a-zA-Z0-9])*", "$1"));

        String mostCommon = mostCommonWords.mostCommonWord(paragraph, new String[]{"hit"});
        System.out.println(mostCommon);

    }

    public String mostCommonWord(String paragraph, String[] banned) {

        if(paragraph == null) {
            return null;
        }

        List<String> bannedWords = Arrays.asList(banned);


        paragraph = paragraph.replaceAll("[^a-zA-Z]", " ");

        List<String> words = Stream.of(paragraph.split("\\s+")).map(String::toLowerCase)
                .filter(w -> !bannedWords.contains(w))
                .collect(Collectors.toList());



        HashMap<String, Integer> wordCount = new HashMap<>();

        words.forEach(w -> wordCount.merge(w, 1, (v1, v2) -> v1+v2));

        AtomicReference<Map.Entry<String, Integer>> mostPopularEntry = new AtomicReference<>();

        wordCount.entrySet().forEach(e -> {
            mostPopularEntry.set((mostPopularEntry.get() != null && mostPopularEntry.get().getValue() > e.getValue() ? mostPopularEntry.get() : e));
        });


        return mostPopularEntry.get().getKey();
    }
}
