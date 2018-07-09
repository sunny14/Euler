package com.faina.utils.sort.external.comparator;

import com.faina.utils.sort.external.MyRecord;

import java.util.Comparator;

public class ByNameComparator implements Comparator<MyRecord> {

    @Override
    public int compare(MyRecord record, MyRecord otherRecord) {
        return record.getName().compareTo(otherRecord.getName());
    }
}
