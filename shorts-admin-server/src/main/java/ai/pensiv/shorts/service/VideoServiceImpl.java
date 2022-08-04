package ai.pensiv.shorts.service;

import ai.pensiv.shorts.config.DirectoryConfig;
import ai.pensiv.shorts.config.PerformanceMonitor;
import ai.pensiv.shorts.model.FileInfo;
import ai.pensiv.shorts.util.FileUtils;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    private Logger log = LoggerFactory.getLogger(VideoServiceImpl.class);
//    @Autowired
//    DirectoryConfig directoryConfig;
    @Override
    public List<FileInfo> readAll(String date) {
//        System.out.println(directoryConfig.getInputs());
//        File[] files = FileUtils.listFiles(dirConfig.getMODEL_SHORTS_INPUTS(), ".*");
        String path = "/Users/eastroad/data/models/shorts/inputs/video/" +
                date.substring(0,4) + "/" +
                date.substring(4,6) + "/" +
                date.substring(6,8);
        System.out.println(path);
        ArrayList<FileInfo> fileInfos = new ArrayList<>();
        File[] files = FileUtils.listFiles(path, ".*");
        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            FileInfo fileInfo = FileInfo.builder(date, file.getName(), file.getPath(), FileUtils.convertFileSizeIntoString(file.length())).build();
            fileInfos.add(fileInfo);
        }
        return fileInfos;
    }

    @Override
    public void inferenceVideo(FileInfo file) {

    }
}
