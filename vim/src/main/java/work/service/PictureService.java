package work.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Jiangqing
 * @version 1.0
 * @since 2019-08-08 16:43
 */
@Service
public class PictureService {

    public void deal(List<MultipartFile> files, HttpServletRequest request) {
        ServletContext servletContext = request.getServletContext();
//        String contextPath = servletContext.getContextPath();
        String contextPath = servletContext.getRealPath("static");
        String rootPath = contextPath + File.separator + "image";

        File dir = new File(rootPath);
        if (!dir.exists()) {
            dir.mkdir();
        }
        for (MultipartFile file : files) {
            String fileName = file.getOriginalFilename();
            File picture = new File(rootPath+File.separator+fileName);
            try {
                file.transferTo(picture);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
