package utils.files;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Files {

    public static List<File> getAllFiles(File file) {
        return Arrays.asList(file.listFiles());
    }

    public static List<File> getAllFilesWithout(File file, List<File> files) {
        return getAllFiles(file).stream().
                filter(currentFile -> !files.stream().
                        map(File::getAbsoluteFile).toList().contains(currentFile.getAbsoluteFile()))
                .toList();
    }
}
