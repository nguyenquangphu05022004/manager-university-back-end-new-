package com.example.manageruniversity.core.major;

import com.example.manageruniversity.common.collection.CollUtils;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class MajorInit {
    private final MajorRepository majorRepository;

    @PostConstruct
    public void init() {
        if(CollUtils.isEmpty(this.majorRepository.findAll())) {
            List<Major> majors = List.of(
                    new Major("CNTT", "Công nghệ thông tin"),
                    new Major("DTVT", "Điện tử viễn thông"),
                    new Major("KT", "Kế toán"),
                    new Major("MAR", "Marketing")
            );
            majors.forEach(s -> this.majorRepository.save(s));
        }
    }
}
