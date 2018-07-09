package com.faina.utils.sort.external;

import com.faina.utils.MyIOUtils;
import com.faina.utils.sort.external.comparator.ComparatorFactory;
import com.google.common.collect.MinMaxPriorityQueue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;

public class ExternalSort {

    private static final String DIR = "target"+File.separator+"sorted";
    private static Logger logger = LogManager.getLogger(ExternalSort.class.getName());

    //TODO: handle exceptions
    public static void main( String [] args ) throws IOException {

        int maxRecordsNum = 0;
        String key = null;

        //assign program arguments into local variables
        try {
            key = args[0];
            maxRecordsNum = Integer.parseInt(args[1]);

        }catch (Throwable th)   {
            logger.error("wrong arguments, please supply arguments as following:\nkey maximalNumberOfRecordsInMemory");
            System.exit(0);
        }

        int maxHeapSize = maxRecordsNum/2;


        splitFileIntoSortedFiles(key, maxHeapSize);


        //optional: order heaps by min/max

        File dir = new File(DIR);
        if (dir.list() == null) {
            logger.error("invalid path, exiting");
            System.exit(1);
        }
        else if (dir.list().length == 0)    {
            logger.info("no records to sort, exiting");
            System.exit(0);
        }

        //merge heaps into ordered heaps A1,A2, A3... until there are no two heaps A1, A2 where max(A1) > min (A2)
        int filesNum = dir.list().length;
        for (int i=1; i <= filesNum; i++) {



            //merge all files j > i with i, one by one
            for (int j=i+1; j<=filesNum; j++)   {

                MinMaxPriorityQueue<MyRecord> records = getRecordsFromFile(key, maxHeapSize, String.valueOf(i));
                MinMaxPriorityQueue<MyRecord> records2 = getRecordsFromFile(key, maxHeapSize, String.valueOf(j));

                Comparator comparator = records.comparator();
                while (comparator.compare(records.peekLast(), records2.peekFirst()) > 0 )   {
                    MyRecord smallerRecord = records2.pollFirst();
                    MyRecord biggerRecord = records.pollLast();

                    records.add(smallerRecord);
                    records2.add(biggerRecord);
                }

                writeToFile(i, records);
                writeToFile(j, records2);
            }



        }


        //write ordered sorted heaps to file


        //write ordered sorted heaps into database


    }

    private static MinMaxPriorityQueue<MyRecord> getRecordsFromFile(String key, int maxHeapSize, String filename ) throws FileNotFoundException {
        //upload file i to heap
        Scanner scanner = new Scanner(new File(DIR+File.separator+filename));
        //skip the first line
        if (scanner.hasNext()) {
            scanner.nextLine();
        }
        MinMaxPriorityQueue<MyRecord> records = getRecordsFromFileInternal(key, maxHeapSize, scanner);
        scanner.close();
        return records;
    }

    private static void splitFileIntoSortedFiles(String key, int maxHeapSize) throws IOException {
        File inputCSV = MyIOUtils.getFileFromResources("utils.sort.external");
        Scanner scanner = new Scanner(inputCSV);

        //skip the first line
        SimpleCSVparser.setTitle(scanner.nextLine());

        for (Integer heapcount=1; scanner.hasNext(); heapcount++) {

            //upload and parse maxHeapSize CSV records
            MinMaxPriorityQueue<MyRecord> records = getRecordsFromFileInternal(key, maxHeapSize, scanner);

            //TODO: keep map of min/max values

            writeToFile(heapcount, records);
        }

        scanner.close();
    }

    private static MinMaxPriorityQueue<MyRecord> getRecordsFromFileInternal(String key, int maxHeapSize, Scanner scanner) {
        MinMaxPriorityQueue<MyRecord> records = MinMaxPriorityQueue.orderedBy(ComparatorFactory.compare(key))
                .maximumSize(maxHeapSize)
                .create();

        for (int i = 0; i < maxHeapSize && scanner.hasNext(); i++) {
            MyRecord record = SimpleCSVparser.parseLine(scanner.nextLine());
            //add to the heap
            //TODO: use Optional
            if (record != null) {
                records.add(record);
            }
        }
        return records;
    }

    private static void writeToFile(Integer heapcount, MinMaxPriorityQueue<MyRecord> records) throws IOException {
        File outputFile = new File(DIR+File.separator+ heapcount.toString());
        boolean res = outputFile.getParentFile().delete();
        res = outputFile.getParentFile().mkdirs();
        FileWriter fw = new FileWriter(outputFile);
        SimpleCSVparser.writeAll(records, fw);
        fw.close();
    }
}
