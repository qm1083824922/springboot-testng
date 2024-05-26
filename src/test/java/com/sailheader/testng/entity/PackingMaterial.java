package com.sailheader.testng.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class PackingMaterial {
    Long id;
    String sequenceNumber;
    BigDecimal quantity;
    BigDecimal packSpec;
}
