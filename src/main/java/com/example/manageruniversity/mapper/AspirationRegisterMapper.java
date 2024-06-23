package com.example.manageruniversity.mapper;

import com.example.manageruniversity.dto.AspirationRegisterDTO;
import com.example.manageruniversity.entity.AspirationRegister;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AspirationRegisterMapper {
    AspirationRegisterMapper mapper = Mappers.getMapper(AspirationRegisterMapper.class);

    AspirationRegisterDTO mapToDto(AspirationRegister aspirationRegister);

}
