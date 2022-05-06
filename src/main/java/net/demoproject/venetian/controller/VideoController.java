package net.demoproject.venetian.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import net.demoproject.venetian.domain.Video;
import net.demoproject.venetian.service.VideoService;
import net.demoproject.venetian.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Video Controller
 * */


@RestController
@RequestMapping("/api/v1/pub/video")
public class VideoController {
    @Autowired
    private VideoService videoService;

    protected Logger log = LoggerFactory.getLogger(VideoController.class);

    //@RequestMapping(value = "list",method = RequestMethod.GET)
    @GetMapping("list")
    public JsonData list() throws JsonProcessingException {

        //log test

        log.warn("test warn level log");
        log.error("test error level log");

        List<Video> list =  videoService.listVideo();
        return JsonData.buildSuccess(list);
    }



    @PostMapping("save_video_chapter")
    public JsonData saveVideoChapter(@RequestBody Video video){

        System.out.println(video.toString());
        return JsonData.buildSuccess(video);
    }





}
