package chags.io.ds;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class ProductSearch {
    public static void main(String[] args) {
        ProductSearch productSearch = new ProductSearch();

        List<List<String>> sug = productSearch.suggestedProducts(new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"}, "mouse");

        System.out.print(sug);

    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        List<String> productList = (List<String>) Arrays.asList(products);
        Collections.sort(productList);

        StringBuilder searchStrBuilder = new StringBuilder();
        List<List<String>> suggestions = new ArrayList<>();
        char[] searchChars = searchWord.toCharArray();

        for (char c : searchChars) {
            searchStrBuilder.append(c);
            final String prefix = searchStrBuilder.toString();
            List<String> filteredList = new ArrayList<>();
            for (String prod : productList) {
                if (prod.startsWith(prefix)) {
                    filteredList.add(prod);
                }
                if(filteredList.size() == 3) {
                    break;
                }
            }
            suggestions.add(filteredList);
        }


        return suggestions;
    }
}
