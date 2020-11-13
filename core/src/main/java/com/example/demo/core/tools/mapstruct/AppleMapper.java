package com.example.demo.core.tools.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(config = MapperConfig.class)
public interface AppleMapper {

    AppleMapper INSTANCE = Mappers.getMapper(AppleMapper.class);

    @Mappings({
            @Mapping(target = "id", source = "appleId"),
//            @Mapping(target = "weight", source = "weight", numberFormat = "#.00"),
    })
    Apple toApple(AppleDTO appleDTO);
}
