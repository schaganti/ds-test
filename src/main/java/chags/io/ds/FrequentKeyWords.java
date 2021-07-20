package chags.io.ds;

import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FrequentKeyWords {
    public static void main(String[] args) {

        FrequentKeyWords frequentKeyWords = new FrequentKeyWords();
        List<String> keyWords = Arrays.asList("Anacell", "betacellular", "cetracular", "deltacellular", "eurocell");
        List<String> reviews = Arrays.asList("I love anacell Best services; Best services provided by anacell",
                "Betacellular has great services",
                "deltacellular provides much better services than betacellular",
                "cetracular is worse than anacell",
                "betacellular is better than deltacellular.");

        List<String> freqWords = frequentKeyWords.findFrequenttKeyWords(reviews, keyWords, 2);
        System.out.println(freqWords);
    }


    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> wordCountMap = new HashMap<>();

        Stream.of(words).forEach(word -> wordCountMap.compute(word, (w, c) -> c == null ? 1 : c+1));

        PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>((e1, e2) -> {
            return e2.getValue() == e1.getValue() ? e1.getKey().compareTo(e2.getKey()) : e2.getValue() - e1.getValue();
        });

        wordCountMap.entrySet().stream().forEach(e -> priorityQueue.offer(e));

        List<String> topFrequentWords = new ArrayList<>();
        IntStream.range(0, k).forEach(i -> topFrequentWords.add(0,priorityQueue.poll().getKey()));

        return topFrequentWords;
    }



    List<String> findFrequenttKeyWords(List<String> reviews, List<String> keyWords, int k) {

        Set<String> keyWordsSet = keyWords.stream().map(String::toUpperCase).collect(Collectors.toSet());
        Map<String, Integer> wordMap = new HashMap<>();

        reviews.stream().flatMap(review -> Stream.of(review.split(" "))).forEach(word -> {
            if (keyWordsSet.contains(word.toUpperCase())) {
                wordMap.merge(word, 1, Integer::sum);
            }
        });

        PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>(k, (v1, v2) -> {
            if (v1.getValue() == v2.getValue()) {
                return 0;
            } else if (v1.getValue() > v2.getValue()) {
                return 1;
            } else {
                return -1;
            }
        });

        int counter = 0;

        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            if (counter < k) {
                priorityQueue.add(entry);
            } else {
                Map.Entry<String, Integer> topElement = priorityQueue.peek();
                if (entry.getValue() > topElement.getValue()) {
                    priorityQueue.remove(topElement);
                    priorityQueue.add(entry);
                }
            }
            counter++;
        }
        List<String> topKeyWords = priorityQueue.stream().map(e -> e.getKey()).collect(Collectors.toList());
        Collections.sort(topKeyWords);
        return topKeyWords;

    }
}
