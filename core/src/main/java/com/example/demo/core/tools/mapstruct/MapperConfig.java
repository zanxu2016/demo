package com.example.demo.core.tools.mapstruct;

import org.mapstruct.ReportingPolicy;

@org.mapstruct.MapperConfig(
        implementationPackage = "com.example.demo.tools.mapstruct",
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public class MapperConfig {
}


