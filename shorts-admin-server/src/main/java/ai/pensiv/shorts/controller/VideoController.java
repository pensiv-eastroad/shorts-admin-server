package shorts.controller;

import ai.pensiv.shorts.service.AccountService;
import ai.pensiv.shorts.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VideoController {
    @Autowired VideoService videoService;
}
