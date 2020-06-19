import Builder.impl.AbstractStringBuilderImpl;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        AbstractStringBuilderImpl abstractStringBuilder = new AbstractStringBuilderImpl();
        abstractStringBuilder.build();
        String string = abstractStringBuilder.getString();

        System.out.println("Одинаковые буквы: ");
        Map<Character, Integer> chars = StringLib.countSymbols(string);
        chars.entrySet().stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .forEach(System.out::println);


        System.out.println("\nОдинаковые слова: ");
        Map<String, Integer> words = StringLib.countEqualWords(string);
        words.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(System.out::println);


        System.out.println("\nИсходный текст: ");
        System.out.println(abstractStringBuilder.getString());
        System.out.println("\nРеверс: ");
        System.out.println(StringLib.reverseString(abstractStringBuilder.getString()));

    }
}
