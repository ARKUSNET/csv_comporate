import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

/**
 * Created by Айслу on 30.01.2018.
 */
public class CsvSortWriter {
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub

        final String csvfile2  = "C:\\TEMP\\student.csv";


        CSVReader reader = new CSVReader(new FileReader(csvfile2));
        String [] nextLine,sortedNextLine;
        List<String> columns = new ArrayList<String>();
        List<String> sortedColumns = new ArrayList<String>();
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        if ((nextLine = reader.readNext()) != null) {
            int i = nextLine.length;

            for(int j=0;j<i;j++){
                columns.add(nextLine[j]);
                sortedColumns.add(nextLine[j]);
            }

            Collections.sort(sortedColumns);
        }



        for(int i=0;i<columns.size();i++){
            String str = columns.get(i);
            map.put(i, sortedColumns.indexOf(str));
        }

        for(int i=0;i<map.size();i++){
            System.out.println(" key is :" + i + ", value is :" + map.get(i));
        }

        CSVWriter writer = new CSVWriter(new FileWriter("C:\\TEMP\\yourfile.csv"), ',',CSVWriter.NO_QUOTE_CHARACTER);

        sortedNextLine = new String[sortedColumns.size()];
        System.out.println(sortedNextLine.length);
        //System.out.println(sortedNextLine[0] + "-" + sortedNextLine[1]);

        for(int k = 0; k < sortedColumns.size(); k++){
            sortedNextLine[k] = sortedColumns.get(k);
            System.out.println(sortedNextLine[k]);
        }

        writer.writeNext(sortedNextLine);

        while ((nextLine = reader.readNext()) != null) {
            for(int count=0;count < nextLine.length ; count++){
                String str = nextLine[count];
                sortedNextLine[map.get(count)] = str;
            }
            writer.writeNext(sortedNextLine);
        }

        writer.close();
    }
}
