package social.nickrest.day.days;

import social.nickrest.day.Day;
import social.nickrest.day.data.DayInfo;
import social.nickrest.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@DayInfo(day = 1)
public class Day1 extends Day {

    @Override
    public void part1() {
        String[] input = StringUtil.strip(this.content.split("\n"), "[^0-9]");

        int sum = 0;
        for(String s : input) {
            if(s.length() == 0) continue;

            int firstDigit = Integer.parseInt(s.substring(0, 1));
            int lastDigit = Integer.parseInt(s.substring(s.length() - 1));

            sum += Integer.parseInt(String.format("%s%s", firstDigit, lastDigit));
        }

        System.out.println(sum);
    }

    @Override
    public void part2() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);

        int sum = 0;
        for(String s : this.content.split("\n")) {
            StringBuilder buffer = new StringBuilder();
            List<Integer> numbers = new ArrayList<>();

            for(char c : s.toCharArray()) {
                if(isNumber(String.valueOf(c))) {
                    numbers.add(Integer.parseInt(String.valueOf(c)));
                    continue;
                }

                buffer.append(c);

                for(String key : map.keySet()) {
                    if(buffer.toString().contains(key)) {
                        numbers.add(map.get(key));
                        buffer.delete(0, buffer.indexOf(key) + key.length() - 1);
                    }
                }
            }

            if(numbers.size() == 0) continue;

            int firstNumber = Integer.parseInt(String.valueOf(numbers.get(0)));
            int lastNumber = Integer.parseInt(String.valueOf(numbers.get(numbers.size() - 1)));

            sum += Integer.parseInt(String.format("%s%s", firstNumber, lastNumber));
        }

        System.out.println(sum);
    }

    private boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }

}
