package social.nickrest.util;

import lombok.experimental.UtilityClass;

import java.util.Arrays;

@UtilityClass
public class StringUtil {

    public String[] strip(String[] input) {
        return Arrays.stream(input).map(String::strip).toArray(String[]::new);
    }

    public String[] strip(String[] input, String regex) {
        return Arrays.stream(input)
                .map(s -> s.replaceAll(regex, ""))
                .toArray(String[]::new);
    }

}
