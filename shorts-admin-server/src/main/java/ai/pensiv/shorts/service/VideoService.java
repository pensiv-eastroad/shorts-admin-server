package ai.pensiv.shorts.service;

import ai.pensiv.shorts.model.FileInfo;

import java.util.List;

public interface VideoService {
    public List<FileInfo> readAll(String date);
    public void inferenceVideo(FileInfo file);
}
