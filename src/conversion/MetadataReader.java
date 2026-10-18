package conversion;

import java.util.Locale;

public class MetadataReader {
    public String readFormat(String fileName) {
        if (fileName == null || fileName.isBlank()) {
            throw new IllegalArgumentException("File name is required");
        }

        int dot = fileName.lastIndexOf('.');
        if (dot < 0 || dot == fileName.length() - 1) {
            throw new IllegalArgumentException("File name must include an extension");
        }

        return fileName.substring(dot + 1).toLowerCase(Locale.ROOT);
    }
}