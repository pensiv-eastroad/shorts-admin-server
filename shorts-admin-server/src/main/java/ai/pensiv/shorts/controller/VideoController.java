package ai.pensiv.shorts.controller;

import ai.pensiv.shorts.model.FileInfo;
import ai.pensiv.shorts.service.AccountService;
import ai.pensiv.shorts.service.VideoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VideoController {
    @Autowired VideoService videoService;

    @ApiOperation(value = "Get Video Files")
    @GetMapping(value = {"/api/v1/video/files/{yyyyMMdd}"}, produces = "application/json;charset=UTF-8")
    public ResponseEntity<Object> getVideoFiles(@PathVariable String yyyyMMdd) {
        return ResponseEntity.ok(videoService.readAll(yyyyMMdd));
    }

    @ApiOperation(value = "Post Video File Inference")
    @PostMapping(value = {"/api/v1/video/file"}, produces = "application/json;charset=UTF-8")
    public ResponseEntity<Object> inferenceVideo(@RequestBody FileInfo file) {
        videoService.inferenceVideo(file);
        return ResponseEntity.noContent().build();
    }
}
