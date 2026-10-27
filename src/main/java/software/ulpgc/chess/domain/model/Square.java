package software.ulpgc.chess.domain.model;

import java.util.Arrays;
import java.util.Locale;

public record Square(File file, Rank rank) {

    public static Square at(String value) {
        value = value.toLowerCase(Locale.ROOT);
        return new Square(fileIn(value), rankIn(value));
    }

    private static File fileIn(String value) {
        return fileIn(value.charAt(0));
    }

    private static File fileIn(char c) {
        return Arrays.stream(File.values())
                .filter(file -> file.getSymbol() == c)
                .findFirst()
                .get();
    }

    private static Rank rankIn(String value) {
        return rankIn(value.charAt(1));
    }

    private static Rank rankIn(char c) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.getValue() == c - '0')
                .findFirst()
                .get();
    }
}
