package com.sparrow.upload.controller;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class UploadController {

    @CrossOrigin
    @PostMapping("upload")
    public String upload(@RequestParam("files") MultipartFile[] files) throws IOException {
        byte[] bytes = files[0].getBytes();
        String fileName = files[0].getName();
        FileCopyUtils.copy(bytes, new File("d://temp/" + fileName));
        return "File Upload Success";
    }
}
