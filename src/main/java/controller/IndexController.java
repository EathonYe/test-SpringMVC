package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    //添加一个日志器
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping(value = {"", "/", "/index"})
    public ModelAndView getIndexView(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView mav = new ModelAndView();

        HttpSession session = request.getSession();
        Boolean loginSuccess = (Boolean) session.getAttribute("loginSuccess");
        if (loginSuccess !=null && loginSuccess == true) {

            //输出日志文件
            logger.info("The index page.");

            mav.setViewName("index");
        } else {
            mav.setViewName("login");
        }

        return mav;
    }

}
