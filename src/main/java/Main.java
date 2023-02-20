import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<String> strings = new ArrayList<>();

    public static void main(String[] args) {

        Path path = Paths.get("src/main/resources/new_21.txt");

        try {
            strings = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(getPairsOfNumbers(strings));
        //System.out.println(getSequenceOfNumbers(strings));

    }

    public static List<List<Integer>> getPairsOfNumbers(List<String> strings) {
        List<List<Integer>> collect = strings.stream()
                .map(Main::parseNumbers)
                .toList();
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> indexes = new ArrayList<>();
        int size = collect.size();
        for (int i = 0; i < size; i++) {
            indexes.add(i, 0);
        }
        while (true) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Integer integer = collect.get(i).get(indexes.get(i));
                result.add(integer);
            }
            list.add(result);

            int next = size - 1;
            while (next >= 0 &&
                    (indexes.get(next) + 1 >=
                            collect.get(next).size()))
                next--;

            if (next < 0)
                break;

            indexes.set(next, indexes.get(next) + 1);

            for (int i = next + 1; i < size; i++) {
                indexes.set(i, 0);
            }

        }
        return list;
    }

    private static List<Integer> parseNumbers(String numbers) {
        String[] strings = numbers.split(",");
        List<Integer> integers = new ArrayList<>();
        for (String s : strings) {
            if (s.contains("-")) {
                String[] numberSeq = s.split("-");
                int firstNumber = Integer.parseInt(numberSeq[0]);
                int lastNumber = Integer.parseInt(numberSeq[1]);
                integers.add(firstNumber);
                while (firstNumber != lastNumber) {
                    integers.add(++firstNumber);
                }
            } else {
                integers.add(Integer.parseInt(s));
            }
        }
        return integers;
    }

    public static List<List<Integer>> getSequenceOfNumbers(List<String> strings) {
        return strings.stream().map(Main::parseNumbers)
                .toList();
    }


}