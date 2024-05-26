package com.sailheader.testng.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PackingMaterialDTO {
    Long id;
    String sequenceNumber;
    BigDecimal quantity;
    BigDecimal packSpec;
}
