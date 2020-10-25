package com.example.demo.RestController;

import com.example.demo.Service.AmazonClient;
import com.example.demo.configuration.S3Config;
import com.example.demo.repository.S3Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/crack")
public class BucketController {
    private AmazonClient amazonClient;
    S3Services s3Services;

    @Autowired
    BucketController(AmazonClient amazonClient) {
        this.amazonClient = amazonClient;
    }

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        System.out.println("upload bucket file");
        String s= this.amazonClient.uploadFile(file);
        System.out.println(s);
        return s;
    }

    @DeleteMapping("/deleteFile")
    public String deleteFile(@RequestPart(value = "url") String fileUrl) {
        return this.amazonClient.deleteFileFromS3Bucket(fileUrl);
    }

}
