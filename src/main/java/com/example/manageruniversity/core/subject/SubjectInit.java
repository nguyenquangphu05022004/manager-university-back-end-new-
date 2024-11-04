package com.example.manageruniversity.core.subject;

import com.example.manageruniversity.common.collection.CollectionUtils;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class SubjectInit {
    private final SubjectRepository subjectRepository;
    @PostConstruct
    public void init() {
        if(CollectionUtils.isEmpty(subjectRepository.findAll())) {
            List<Subject> subjects = List.of(
                    new Subject("BAS1001", "Triết học Mác Lênin", 2),
                    new Subject("INT1001", "Lập trình C++", 3),
                    new Subject("BAS1002", "Lịch sử đảng cộng sản việt nam", 2)
            );
            subjects.forEach(s -> this.subjectRepository.save(s));
        }
    }
}
