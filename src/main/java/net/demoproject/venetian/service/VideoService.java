package net.demoproject.venetian.service;

import net.demoproject.venetian.domain.Video;
import org.springframework.stereotype.Component;

import java.util.List;

public interface VideoService {

    List<Video> listVideo();

    void scheduleJobTest() throws Exception;

}
