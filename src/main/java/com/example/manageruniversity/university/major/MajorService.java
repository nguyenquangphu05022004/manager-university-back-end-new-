package com.example.manageruniversity.university.major;

import java.util.List;

public interface MajorService {
    Major update(MajorRequest majorDto);
    List<Major> getAll();
    Major getById(String majorId);

}
