package org.zpf.domain;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

public class UserSu implements Serializable {
    private String userName;
    private MultipartFile image;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
