package net.demoproject.venetian.mapper;

import net.demoproject.venetian.domain.Video;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class VideoMapper {

    private static Map<Integer, Video> videoMap = new HashMap<>();

    static {

        videoMap.put(1,new Video(1,"Venetian_Vedio_1"));
        videoMap.put(2,new Video(2,"Venetian_Vedio_2"));
        videoMap.put(3,new Video(3,"Venetian_Vedio_3"));
        videoMap.put(4,new Video(4,"Venetian_Vedio_4"));
        videoMap.put(5,new Video(5,"小Venetian_Vedio_5"));

    }



    public List<Video> listVideo(){

        List<Video> list = new ArrayList<>();
        list.addAll(videoMap.values());

        return  list;
    }









}
