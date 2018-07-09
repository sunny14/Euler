package com.faina.utils.sort.external;

import java.io.IOException;
import java.io.Writer;
import java.util.Collection;

public class SimpleCSVparser {

    //TODO: char?
    private static final String DEFAULT_SEPARATOR = ",";
    private static String title;

    public static void setTitle(String titleFromFile)   {
        title = titleFromFile;
    }

    public static MyRecord parseLine(String s, String separator) {
        if (s == null)  {
            return null;
        }
        String s2 = s.trim();
        if ( s2.isEmpty())  {
            return null;
        }
        String[] splittedLine = s.split(separator);
        return new MyRecord(splittedLine[0], splittedLine[1], splittedLine[2]);

    }


    public static MyRecord parseLine(String s) {
        return parseLine(s, DEFAULT_SEPARATOR);
    }

    public static void writeRecord(MyRecord record, Writer writer, String separator) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(record.getName())
                .append(separator)
                .append(record.getAge())
                .append(separator)
                .append(record.getWork())
                .append("\n");
        writer.write(sb.toString());
    }

    public static void writeRecord(MyRecord record, Writer writer) throws IOException {
        writeRecord(record, writer, DEFAULT_SEPARATOR);
    }


    public static void writeAll(Collection <MyRecord> collection, Writer writer) throws IOException {
        writer.write(title+"\n");
        for (MyRecord record: collection)   {
            writeRecord(record, writer);
        }
    }
}
