package by.javaguru.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.nio.file.Path;

@Service
@RequiredArgsConstructor
public class ImageService {

    @Value("app.image.bucket:E:\\AAA\\JavaGuru\\JavaEnterprise\\Projects\\spring-starter-template\\images")
    private final String bucket;

    public void upload(String imagePath, InputStream content) {
        Path fullImagePath = Path.of(bucket, imagePath);

    }
}
