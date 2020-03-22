package com.dessert.storageapi.config;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.*;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import org.springframework.beans.factory.annotation.Value;
import com.amazonaws.auth.BasicAWSCredentials;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class S3Config {
    @Value("${aws.access_key_id}")
    private String accessKey;
    @Value("${aws.secret_access_key}")
    private String secretKey;
    @Value("${aws.s3.region}")
    private String region;
    @Value("${aws.s3.endpoint}")
    private String endpoint;
    /**
     * aws s3 client
     */
/*    AmazonS3 s3 = null;

    @PostConstruct
    public void init() {
        ClientConfiguration config = new ClientConfiguration();
        config.setMaxConnections(500);
        config.setSocketTimeout(100 * 1000);
        config.setConnectionTimeout(5000);
        config.setProtocol(Protocol.HTTP);

        AwsClientBuilder.EndpointConfiguration endpointConfig = new AwsClientBuilder.EndpointConfiguration(endpoint, region);
        AWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
        AWSCredentialsProvider awsCredentialsProvider = new AWSStaticCredentialsProvider(awsCredentials);
        s3 = AmazonS3Client.builder()
                .withEndpointConfiguration(endpointConfig)
                .withClientConfiguration(config)
                .withCredentials(awsCredentialsProvider)
                .disableChunkedEncoding()
                .withPathStyleAccessEnabled(true)
                .build();
    }*/

    @Bean
    public AmazonS3 amazonS3Client() {
        ClientConfiguration config = new ClientConfiguration();
        config.setMaxConnections(500);
        config.setSocketTimeout(100 * 1000);
        config.setConnectionTimeout(5000);
        config.setProtocol(Protocol.HTTP);

        AwsClientBuilder.EndpointConfiguration endpointConfig = new AwsClientBuilder.EndpointConfiguration(endpoint, region);
        AWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
        AWSCredentialsProvider awsCredentialsProvider = new AWSStaticCredentialsProvider(awsCredentials);
        return AmazonS3Client.builder()
                .withEndpointConfiguration(endpointConfig)
                .withClientConfiguration(config)
                .withCredentials(awsCredentialsProvider)
                .disableChunkedEncoding()
                .withPathStyleAccessEnabled(true)
                .build();
    }




   /* @Bean
    public BasicAWSCredentials basicAWSCredentials() {
        return new BasicAWSCredentials(accessKey, secretKey);
    }

    @Bean
    public AmazonS3Client amazonS3Client(AWSCredentials awsCredentials) {
        AmazonS3Client amazonS3Client = new AmazonS3Client(awsCredentials);
        amazonS3Client.setRegion(Region.getRegion(Regions.fromName(region)));
        return amazonS3Client;
    }*/

}
