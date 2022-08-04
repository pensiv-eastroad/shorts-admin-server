package ai.pensiv.shorts.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FilenameFilter;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;

public class FileUtils {

    private static final Logger log = LoggerFactory.getLogger(FileUtils.class);

    public static File[] listFiles(String dir_path, String filename_pattern) {
        File   dir   = new File(dir_path);
        File[] files = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String filename) {
                return (filename_pattern == null ?  true : filename.matches(filename_pattern));
            }
        });
        return files;
    }

    public static void sortFiles(File[] filterResult){
        Arrays.sort(filterResult, new Comparator() {
            public int compare(Object arg0, Object arg1) {
                File file1 = (File)arg0;
                File file2 = (File)arg1;
                return file1.getName().compareToIgnoreCase(file2.getName());
            }
        });
    }

    public static String recentDirectoryPath(String path) {
        File file = new File(path);
        String[] directoryList = file.list();
        String recentDays = null;
        Double compareDate = Double.NEGATIVE_INFINITY;
        if (directoryList!=null) {
            for (String dateString : directoryList) {
                if (dateString.matches("^\\d{1,12}")) {
                    Double dd = Double.parseDouble(dateString);
                    if (compareDate < dd) {
                        compareDate = dd;
                        recentDays = dateString;
                    }
                }
            }
        }
        return recentDays;
    }

    public static String convertFileSizeIntoString(long size) {

        DecimalFormat df = new DecimalFormat("0.00");

        float sizeKb = 1024.0f;
        float sizeMb = sizeKb * sizeKb;
        float sizeGb = sizeMb * sizeKb;
        float sizeTerra = sizeGb * sizeKb;

        if(size < sizeMb)
            return df.format(size / sizeKb)+ " Kb";
        else if(size < sizeGb)
            return df.format(size / sizeMb) + " Mb";
        else if(size < sizeTerra)
            return df.format(size / sizeGb) + " Gb";

        return "";
    }

}
