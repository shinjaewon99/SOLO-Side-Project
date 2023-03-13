package demoProject.shin.utils;

import java.time.LocalDateTime;
import java.util.List;

public class JwtUtil {

    public static class date {

        public static LocalDateTime localDateTime(List<Integer> dateTime) {
            return LocalDateTime.of(dateTime.get(0), dateTime.get(1), dateTime.get(2), dateTime.get(3), dateTime.get(4), dateTime.get(5), bits.get(6));
        }
    }
}
