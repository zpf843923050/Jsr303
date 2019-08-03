package org.zpf.controller;

import com.sun.org.apache.regexp.internal.RE;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import org.apache.commons.io.FileUtils;
import org.hibernate.validator.constraints.Email;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.zpf.domain.UserSu;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Controller
public class FileUploadController2 {
    @RequestMapping(value = "/uploadUserImage")
    public String upload(
            HttpServletRequest request,
            @ModelAttribute UserSu userSu,
            Model model
    ) {
        System.out.println(userSu.getUserName());
        //如果文件不为空,写入上传路径
        if (!userSu.getImage().isEmpty()) {
            //写入文件路径
            String path = request.getServletContext().getRealPath("/images/");
            //上传文件名
            String fileName = userSu.getImage().getOriginalFilename();
            File filePath = new File(path, fileName);
            //判断路径是否存在
            if (!filePath.getParentFile().exists()) {
                //创建目录
                filePath.getParentFile().mkdirs();
            }

            //将上传文件保存到目标文件夹中
            try {
                userSu.getImage().transferTo(new File(path + File.separator + fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
            //将用户添加到Model中
            model.addAttribute("userSu", userSu);
            //跳转到下载页面
            return "userInfo";


        } else
            return "error";
    }


    @RequestMapping(value = "/download")
    public ResponseEntity<byte[]> download(
            HttpServletRequest request,
            @RequestParam("fileName") String fileName,
            Model model
    ) throws IOException {
        //下载文件路径
        String path = request.getServletContext().getRealPath("/images/");
        File file = new File(path, File.separator + fileName);
        HttpHeaders headers = new HttpHeaders();
        //下载显示的文件名,解决中文乱码问题
        String downloadFileName = new String(fileName.getBytes("utf-8"), "iso-8859-1");
        //通知浏览器以attachment下载方式打开图·片
        headers.setContentDispositionFormData("attachment", downloadFileName);
        //application/octet-stream:二进制流数据//最常见的文件下载
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        //201HttpStatus.CREATED
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }
}

