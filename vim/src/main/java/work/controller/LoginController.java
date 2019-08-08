package work.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Jiangqing
 * @version 1.0
 * @since 2019-08-08 16:01
 */
@Controller
@RequestMapping("login")
public class LoginController {

    @RequestMapping()
    public String login() {
        return "login";
    }
}
