import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class DBInterface {

    public static Map<String, Map<String, String>> select(String query){
        return ZooData.getZooData().get(query);
    }

    public static Map<String, Map<String, String>> filter(String query, DataFilter df){
        return select(query).entrySet()
                .stream()
                .filter(df::filter)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    static void update(String entry){

    }

    static void add(String entry){

    }

    static void delete(String entry){

    }
}
