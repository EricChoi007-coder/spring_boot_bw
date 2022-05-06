package net.demoproject.venetian.service.impl;

import net.demoproject.venetian.domain.Video;
import net.demoproject.venetian.mapper.VideoMapper;
import net.demoproject.venetian.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VideoServiceImpl implements VideoService {


    @Autowired
    private VideoMapper videoMapper;


    @Override
    public List<Video> listVideo() {
        return videoMapper.listVideo();
    }
}
