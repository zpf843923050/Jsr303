package org.zpf.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    public static final Log logger= LogFactory.getLog(HelloController.class);
    @RequestMapping(value = "test")
    public String test(){
        logger.info("测试");
        return "test.jsp";
    }
}
