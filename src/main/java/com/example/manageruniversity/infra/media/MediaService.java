package com.example.manageruniversity.infra.media;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MediaService {
    Media upload(MultipartFile multipartFile);
    List<Media> upload(List<MultipartFile> files);
    Resource load(String path);
    void delete(Long id);
}
