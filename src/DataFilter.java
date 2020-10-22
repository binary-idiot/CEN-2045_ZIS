import java.util.Map;

@FunctionalInterface
public interface DataFilter {
    boolean filter(Map.Entry<String, Map<String, String>> map);
}
