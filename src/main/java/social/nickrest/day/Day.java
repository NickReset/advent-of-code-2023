package social.nickrest.day;

import lombok.Getter;
import lombok.NonNull;
import social.nickrest.day.data.DayInfo;
import social.nickrest.util.FileUtil;

@Getter
public abstract class Day {

    private final DayInfo info = getClass().getAnnotation(DayInfo.class);

    protected final int day;
    protected String content;

    public Day() {
        if(info == null) {
            throw new RuntimeException("DayInfo annotation not found");
        }

        this.day = info.day();
        this.content = FileUtil.getContent(FileUtil.getInputStream(String.format("/days/%s.txt", info.day())));
    }

    public abstract void part1();
    public abstract void part2();
}
