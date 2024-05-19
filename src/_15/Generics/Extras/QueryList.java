package _15.Generics.Extras;

import java.util.ArrayList;
import java.util.List;

interface QueryItem {

    boolean matchFieldValue(String fieldName, String value);
}
public class QueryList <T extends Student & QueryItem>{
    //Type that use this class must be a Student or its subtype and also implements QueryItem interface
    //Generic type parameter (T) can extend 1 class but many interfaces
    private List<T> items;

    public QueryList(List<T> items) {
        this.items = items;
    }

    public static <T extends QueryItem> List<T> getMatches(List<T> items, String field, String value) {
    //T declared here is a different type than the type declared in the class
        List<T> matches = new ArrayList<>();
        for (var item : items) {
            if (item.matchFieldValue(field, value)) {
                matches.add(item);
            }
        }
        return matches;
    }

    public List<T> getMatches(String field, String value) {

        List<T> matches = new ArrayList<>();
        for (var item : items) {
            if (item.matchFieldValue(field, value)) {
                matches.add(item);
            }
        }
        return matches;
    }
}
