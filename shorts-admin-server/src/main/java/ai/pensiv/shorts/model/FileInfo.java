package ai.pensiv.shorts.model;

import lombok.*;

@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class FileInfo {

    @Getter
    @Setter
    private String date;

    @Getter
    @Setter
    private String fileName;

    @Getter
    @Setter
    private String path;

    @Getter
    @Setter
    private String size;

    @Builder(builderMethodName = "of")
    public FileInfo(String date, String fileName, String path, String size) {
        this.date = date;
        this.fileName = fileName;
        this.path = path;
        this.size = size;
    }

    @Builder
    public static FileInfoBuilder builder(String date, String fileName, String path, String size) {
        return FileInfo.of().date(date).fileName(fileName).path(path).size(size);
    }
}