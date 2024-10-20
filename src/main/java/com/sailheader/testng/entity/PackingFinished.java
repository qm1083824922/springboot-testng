package com.sailheader.testng.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sailheader.testng.enums.PackingFinishedStatusEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * @author Porsche
 * @since 2024/10/19 23:33
 */
@Data
@TableName("wh_packing_finished")
@Accessors(chain = true)
public class PackingFinished {
    /**
     * 主键ID
     */
    Long id;
    /**
     * 租户ID
     */
    String tenantId;
    /**
     * 站点ID
     */
    Long siteId;

    /**
     * 成品： FINISHED，半成品：SEMIFINISHED
     */
     String type;
    /**
     * 包装条码，包装序列号
     */
     String sequenceNumber;
    /**
     * 父级包装ID
     */
     Long parentId;
    /**
     * 是否存在下级包装
     */
     Boolean isHasSubPack;
    /**
     * 产品ID
     */
     Long productPartId;
    /**
     * 产品编码
     */
     String productPartNo;
    /**
     * 产品名称
     */
     String productPartName;
    /**
     * 产品型号
     */
     String productPartModel;
    /**
     * 产品规格
     */
     String productPartSpec;
    /**
     * 包装数量（产品数量）
     */
     BigDecimal quantity;
    /**
     * 包规数量, 标准包装数量
     */
     BigDecimal packingSpecQty;
    /**
     * 批次，先进先出条件判断
     */
     String lotNo;
    /**
     * 批次生产日期
     */
     @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
     @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
     Date lotDate;
    /**
     * 层级
     */
     Integer level;
    /**
     * 是否尾箱
     */
     Boolean isTailBox;
    /**
     * 存储期限或有效期，喻指时长，单位为天
     */
     Integer storageDuration;
    /**
     * 超期日期，到期日期，根据生产日期和储存期限计算得出
     */
     @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
     @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
     Date expiryDate;
    /**
     * 入库时间，用于计算原材料库龄
     */
     @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
     @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
     Date inboundTime;
    /**
     * 生成包装的工单ID
     */
     Long workOrderId;
    /**
     * 工单号， mes_work_order
     */
     String workOrderNo;
    /**
     * 仓库ID
     */
     Long warehouseId;
    /**
     * 区域ID
     */
     Long areaId;
    /**
     * 储位ID
     */
     Long storageId;
    /**
     * 备注
     */
     String remark;
    /**
     * 扩展参数，json格式
     */
     String options;
    /**
     * 状态
     */
     Integer status;

    /**
     * 根据成品包装条码校验是否存在
     *
     * @param packingFinished 成品包装
     * @return 是否存在, true：存在，false：不存在
     */
    public static Boolean checkExist(PackingFinished packingFinished) {
        return Objects.nonNull(packingFinished);
    }

    /**
     * 检验成品包装状态是否已出库
     *
     * @param status 成品包装状态
     * @return 是否已出库，true：已出库，false：未出库
     */
    public static Boolean checkHasOutbound(Integer status) {
        return status.equals(PackingFinishedStatusEnum.OUTBOUND.getCode());
    }

    /**
     * 检查成品包装状态是否已锁定
     * @param status 成品包装状态
     * @return 是否已锁定，true：已锁定，false：未锁定
     */
    public static Boolean checkHasLocked(Integer status) {
        return status.equals(PackingFinishedStatusEnum.LOCKED.getCode());
    }

    /**
     * 检查是否存在父级包装
     * @param parentId 父级包装ID
     * @return 是否存在父级包装，true：存在，false：不存在
     */
    public static Boolean checkHasParentPacking(Long parentId) {
        return Objects.isNull(parentId);
    }
}
