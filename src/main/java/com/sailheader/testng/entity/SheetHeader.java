
package com.sailheader.testng.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

/**
 * 单据表
 * @author porsche
 * @since 2022-04-14
 */
@Data
@TableName("wh_sheet_header")
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SheetHeader{
	/**
	 * 主键
	 */
	Long id;
	/**
	 * 租户
	 */
	String tenantId;
	/**
	 * 站点
	 */
	Long siteId;
	/**
	* 单据类型，	采购单：PO，领料单：（RO），发货单：（DO），生产入库单（FO）	原料入库单：MO;
	*/
    String sheetType;
	/**
	* 具体单据的子类型，比如采购单包含：委外采购单，普通采购单，研发采购单等；
	*/
    String sheetSubType;
	/**
	* 单据单号
	*/
    String sheetNo;
	/**
	* 来源类型
	*/
    String sourceType;
	/**
	* 来源类型对应的来源ID或NO
	*/
    String sourceNo;

}
