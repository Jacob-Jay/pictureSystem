package work.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import work.service.PictureService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiangqing
 * @version 1.0
 * @since 2019-08-08 16:05
 */
@RequestMapping("upload")
@Controller
public class UpLoad {

    @Autowired
    private PictureService pictureService;

    @RequestMapping()
    public String upload() {
        return "uploadPicture";
    }

    @RequestMapping("/do")
    public String doUpload(HttpServletRequest request,@RequestParam("picture") MultipartFile picture, @RequestParam("picture2") MultipartFile picture2) {
        try {
            List<MultipartFile> files = new ArrayList<>();
            files.add(picture);
            files.add(picture2);
            pictureService.deal(files,request);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }

        return "success";
    }
}
