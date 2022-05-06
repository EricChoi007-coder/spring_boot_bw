package net.demoproject.venetian;

import junit.framework.TestCase;
import net.demoproject.venetian.controller.UserController;
import net.demoproject.venetian.domain.User;
import net.demoproject.venetian.domain.Video;
import net.demoproject.venetian.service.VideoService;
import net.demoproject.venetian.utils.JsonData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.Charset;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={DemoProjectApplication.class})
@AutoConfigureMockMvc
public class VideoTest {

    //Controller level test
    @Autowired
    private UserController userController;
    //login test
    @Test
    public void loginTest(){
        User user = new User();
        user.setUsername("jack");
        user.setPwd("123");
        JsonData jsonData  = userController.login(user);
        System.out.println(jsonData.toString());
        TestCase.assertEquals(0,jsonData.getCode());
    }

    //service layer test
    //video test
    @Autowired
    private VideoService videoService;
    @Test
    public void testVideoList(){
        List<Video> videoList = videoService.listVideo();
        TestCase.assertTrue(videoList.size()>0);
    }

    //Test URL
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testVideoListApi()throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/pub/video/list"))
                        .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        int status = mvcResult.getResponse().getStatus();
        System.out.println(status);
        String result =
                mvcResult.getResponse().getContentAsString(Charset.forName("utf-8"));
        System.out.println(result);
    }
}
