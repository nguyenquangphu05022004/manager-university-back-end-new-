package com.example.manageruniversity.core.media;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class MediaServiceImpl implements MediaService{
    @Override
    public Media upload(MultipartFile multipartFile) {
        return null;
    }

    @Override
    public List<Media> upload(List<MultipartFile> files) {
        return null;
    }

    @Override
    public Resource load(String path) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
