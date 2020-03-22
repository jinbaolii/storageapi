package com.dessert.storageapi.controller;

import com.dessert.storageapi.model.BucketVO;
import com.dessert.storageapi.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class FileController {
    @Autowired
    S3Service s3Service;

    @GetMapping("/bucket/bucketList")
    public ResponseEntity getBucketList() {
        return new ResponseEntity(s3Service.getBucket(), HttpStatus.OK);
    }

    @PostMapping("/bucket")
    public ResponseEntity postBucket(@RequestBody BucketVO bucketVO) {
        return new ResponseEntity(s3Service.createBucket(bucketVO.getBucketName()), HttpStatus.OK);
    }
}
