package com.faina.utils.sort.external.comparator;

import com.faina.utils.sort.external.MyRecord;

import java.util.Comparator;

public class ComparatorFactory {

    private static final String NAME = "name";

    public static Comparator<MyRecord> compare(String field)    {

        if (field.equalsIgnoreCase(NAME))   {
            return new ByNameComparator();
        }

        //TODO: implement more comparators

        //TODO: ???
        throw new IllegalArgumentException();
    }
}
