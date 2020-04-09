import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BasicHashtable<K, V> {
    private Object[] values = new Object[101];

    public void put(K key, V value) {
        int index = calculatePossition(key);
        values[index] = value;
    }

    public V get(K key) {
        return (V) values[calculatePossition(key)];
    }

    protected int calculatePossition(K key) {
        int hashCode = key.hashCode();
        int index = hashCode % values.length;
        if (index < 0) {
            index += values.length;
        }
        return index;
    }

    @Override
    public String toString() {
        return Stream.of(values).filter(Objects::nonNull).map(Object::toString).collect(
                Collectors.joining(",", "{", "}"));
    }
}
