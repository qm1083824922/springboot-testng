package com.sailheader.testng.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

/**
 * 创建单据传输对象
 * @author Porsche
 * @since 2024/10/20 16:28
 */
@Data
@Accessors(chain = true)
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@Schema(description = "创建单据传输对象")
public class SheetHeaderDTO {
    /**
     * 主键
     */
    @Schema(description = "主键",nullable = true,requiredMode = Schema.RequiredMode.REQUIRED)
    Long id;
    /**
     * 租户
     */
    @Schema(description = "租户",nullable = true,requiredMode = Schema.RequiredMode.REQUIRED)
    String tenantId;
    /**
     * 站点
     */
    @Schema(description = "站点",nullable = true,requiredMode = Schema.RequiredMode.REQUIRED)
    Long siteId;
    /**
     * 单据类型，	采购单：PO，领料单：（RO），发货单：（DO），生产入库单（FO）	原料入库单：MO;
     */
    @Schema(description = "单据类型",nullable = true,requiredMode = Schema.RequiredMode.REQUIRED)
    String sheetType;
    /**
     * 具体单据的子类型，比如采购单包含：委外采购单，普通采购单，研发采购单等；
     */
    @Schema(description = "具体单据的子类型",nullable = true,requiredMode = Schema.RequiredMode.REQUIRED)
    String sheetSubType;
    /**
     * 单据单号
     */
    @Schema(description = "单据单号",nullable = true,requiredMode = Schema.RequiredMode.REQUIRED)
    String sheetNo;
    /**
     * 来源类型
     */
    @Schema(description = "来源类型",nullable = true,requiredMode = Schema.RequiredMode.REQUIRED)
    String sourceType;
    /**
     * 来源类型对应的来源ID或NO
     */
    @Schema(description = "来源类型对应的来源ID或NO",nullable = true,requiredMode = Schema.RequiredMode.REQUIRED)
    String sourceNo;
}
