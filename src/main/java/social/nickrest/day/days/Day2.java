package social.nickrest.day.days;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import social.nickrest.day.Day;
import social.nickrest.day.data.DayInfo;
import social.nickrest.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

@DayInfo(day = 2)
public class Day2 extends Day {

    private final List<Game> games = new ArrayList<>();

    public Day2() {
        super();

        for(String line : this.content.split("\n")) {
            String[] split = line.split(": ");
            String id = split[0].replace("Game", "").trim();

            Game game = new Game();
            game.id = Integer.parseInt(id);

            String[] sets = split[1].split(";");

            for(String s : sets) {
                String[] setNotFormatted = StringUtil.strip(s.split(", "));

                Game.Set set = new Game.Set();
                for(String s1 : setNotFormatted) {
                    int value = Integer.parseInt(s1.split(" ")[0]);
                    String color = s1.split(" ")[1];

                    switch (color) {
                        case "blue" -> set.blue = value;
                        case "green" -> set.green = value;
                        case "red" -> set.red = value;
                    }
                }
                game.sets.add(set);
            }

            games.add(game);
        }
    }

    @Override
    public void part1() {
        int sum = 0;

        for(Game game : games) {
            boolean invalid = false;

            for(Game.Set set : game.sets) {
                if(set.red > 12 || set.green > 13 || set.blue > 14) {
                    invalid = true;
                    break;
                }
            }

            if(!invalid) {
                sum += game.id;
            }
        }

        System.out.println(sum);
    }

    @Override
    public void part2() {
        int sum = 0;

        for(Game game : games) {

            int maxRed = 0, maxGreen = 0, maxBlue = 0;

            for(Game.Set sets : game.sets) {

                if(sets.red > maxRed) maxRed = sets.red;
                if(sets.green > maxGreen) maxGreen = sets.green;
                if(sets.blue > maxBlue) maxBlue = sets.blue;

            }

            sum += (maxRed * maxGreen * maxBlue);
        }

        System.out.println(sum);
    }

    @Data
    @Getter @Setter
    private static class Game {
        List<Set> sets = new ArrayList<>();
        int id;

        @Data
        private static class Set {
            int blue, green, red;
        }
    }
}
