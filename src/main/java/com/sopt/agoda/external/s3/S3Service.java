package com.sopt.agoda.external.s3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class S3Service {
    private final String bucketName;
    private final AwsConfig awsConfig;
    private final AmazonS3 s3Client;
    private static final List<String> IMAGE_EXTENSIONS = Arrays.asList("image/jpeg", "image/png", "image/jpg", "image/webp");

    public S3Service(@Value("${aws-property.s3-bucket-name}") final String bucketName, AwsConfig awsConfig) {
        this.bucketName = bucketName;
        this.awsConfig = awsConfig;
        this.s3Client = awsConfig.s3Client();
    }

    public List<String> getImageUrls(final String folderName) {
        List<String> imageUrls = new ArrayList<>();

        // 해당 폴더의 객체 리스트 가져오기
        ObjectListing objects = s3Client.listObjects(bucketName, folderName);
        do {
            // 현재 batch의 객체들을 순회
            for (S3ObjectSummary objectSummary : objects.getObjectSummaries()) {
                String objectKey = objectSummary.getKey();
                // 파일 크기가 0이 아닌 경우에만 추가(경로도 객체여서 응답에 보임)
                if (objectSummary.getSize() > 0) {
                    String imageUrl = s3Client.getUrl(bucketName, objectKey).toString();
                    imageUrls.add(imageUrl);
                }
            }
            // 다음 batch 가져오기
            objects = s3Client.listNextBatchOfObjects(objects);
        } while (objects.isTruncated());

        return imageUrls;
    }

}
