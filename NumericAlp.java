package mastermind;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

enum NumericAlp {
    ONE(1, "ONE"), TWO(2, "TWP"), THREE(3, "THREE"),
    FOUR(4, "FOUR"), FIVE(5, "FIVE"), SIX(6, "SIX"),
    SEVEN(7, "SEVEN"), EIGHT(8, "EIGHT"), NIGHT(9, "NIGHT");

    private final int key;
    private final String value;

    // Constructor
    private NumericAlp(int key, String name) {
        this.key = key;
        this.value = name;
    }

    private static final Map<Integer, NumericAlp> BY_KEY = Arrays.stream(values())
            .collect(Collectors.toMap(c -> c.key, c -> c));

    public static NumericAlp of(int key) {
        return BY_KEY.get(key);
    }

    public String getNumerAlp() {
        return this.value;
    }
}