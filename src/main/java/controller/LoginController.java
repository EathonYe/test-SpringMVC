package controller;

import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    //添加一个日志器
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping({"/", "/index"})
    public String index() {
        //输出日志文件
        logger.info("The index page.");


        return "index";
    }

    @RequestMapping(value = "/login")
    @ResponseBody
    public JSONObject login() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", "success");
        return jsonObject;

//        return "login";
    }
}

