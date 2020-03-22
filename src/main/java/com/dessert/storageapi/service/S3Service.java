package com.dessert.storageapi.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.Bucket;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class S3Service {
    //    @Autowired
//    AmazonS3Client s3Client;
    @Autowired
    AmazonS3 s3;


    public List<Bucket> getBucket() {

        return s3.listBuckets();
    }

    public Bucket getBucket(String bucketName) {

        List<Bucket> bucketList = s3.listBuckets();
        return bucketList.stream().filter(r -> r.getName().equals(bucketName)).findFirst().get();
    }
    // create buck by bucket name
    public Bucket createBucket(String buckedName) {
        Bucket b;
        if (s3.doesBucketExistV2(buckedName)) {
            log.info("Bucket {} already exists.", buckedName);
            b = getBucket(buckedName);
        } else {
            try {
                b = s3.createBucket(buckedName);
            } catch (AmazonS3Exception e) {
                log.error(e.getErrorMessage());
                b = null;
            }
        }
        return b;
    }

    //分片上传

    //分片下载
    public
}
