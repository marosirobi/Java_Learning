package model.genericsextra;

import model.util.QueryItem;

public record Employee(String name) implements QueryItem {

    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        return false;
    }
}
