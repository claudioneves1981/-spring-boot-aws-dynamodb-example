package com.claudioneves.dynamodb.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.claudioneves.dynamodb.repository.MusicRepository;
import lombok.Data;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig.TableNameOverride.withTableNameReplacement;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.claudioneves.dynamodb.repository",dynamoDBMapperConfigRef = "dynamoDBMapperConfig")
public class DynamoDBConfig {

    @Value("${aws.dynamodb.endpoint}")
    private String awsEndpoint;

    @Value("${aws.accesskey}")
    private String awsAccessKey;

    @Value("${aws.secretkey}")
    private String awsSecretKey;

    @Value("${aws.region}")
    private String awsRegion;


    @Bean
    public DynamoDBMapperConfig dynamoDBMapperConfig() {
        return
                DynamoDBMapperConfig.builder()
                        .withTableNameOverride(withTableNameReplacement("Music"))
                        .build();
    }

    @Bean
    public AmazonDynamoDB amazonDynamoDB(){

        return AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(awsEndpoint, awsRegion))
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsAccessKey,awsSecretKey)))
                .build();

    }
}
