package com.example.manageruniversity.university.location;

import com.example.manageruniversity.common.collection.ListUtils;
import com.example.manageruniversity.common.pojo.CommonResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/location-room")
@CrossOrigin("*")
public class RoomController {
    private final RoomService roomService;

    @GetMapping
    public CommonResult<List<RoomDto>> getList() {
        return CommonResult.success(ListUtils.convertToList(roomService.getList(), RoomDto::new));
    }
}
