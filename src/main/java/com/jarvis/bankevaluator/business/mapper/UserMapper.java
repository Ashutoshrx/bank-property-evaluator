package com.jarvis.bankevaluator.business.mapper;

import com.jarvis.bankevaluator.data.entity.BusinessUnit;
import com.jarvis.bankevaluator.data.entity.User;
import com.jarvis.bankevaluator.dto.RegistrationRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

  @Mapping(target = "initiatorName", source = "initiatorName")
  @Mapping(target = "contactNumber", source = "contactNumber")
  @Mapping(target = "enabled", expression = "java(true)")
  @Mapping(target = "businessUnit", source = "businessUnit", qualifiedByName = "mapBusinessUnit")
  User mapToUser(RegistrationRequestDTO registrationRequest);

  @Named("mapBusinessUnit")
  BusinessUnit mapBusinessUnit(String businessUnit);
}
