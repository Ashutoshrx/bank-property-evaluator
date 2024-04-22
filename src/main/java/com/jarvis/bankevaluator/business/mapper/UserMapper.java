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
  @Mapping(target = "businessUnits", source = "businessUnit", qualifiedByName = "mapBusinessUnit")
  User mapToUser(RegistrationRequestDTO registrationRequest);

  @Named("mapBusinessUnit")
  default List<BusinessUnit> mapBusinessUnit(String businessUnitInput) {
    List<BusinessUnit> businessUnits = new ArrayList<>();
    BusinessUnit businessUnit = new BusinessUnit();
    businessUnit.setBusinessUnit(businessUnitInput);
    businessUnits.add(businessUnit);
    return businessUnits;

  }
}
