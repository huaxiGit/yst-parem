package com.yst.pojo;


import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class TbOrderDefective extends BaseRowModel implements Serializable {


  @ExcelProperty(value = {"缺陷单编号"}, index = 0)
  private String defectiveNumber;  //都是字符串
  @ExcelProperty(value = {"缺陷单主题"}, index = 1)
  private String defectiveTheme;  //都是字符串
  /**
   *  转工单状态 名称 0 拟制中 1 待确认 3 已转
   */
  @ExcelProperty(value = {"缺陷类型"}, index = 2)
  @TableField(exist = false)
  private String orderStatusName;  //excel 字符串  //数据库int

  //所属机构
  @ExcelProperty(value = {"所属机构"}, index = 3)
  private String  organizationDeptId;  // 数据库 int  要根据表查 id
  //缺陷等级
  @ExcelProperty(value = {"缺陷等级"}, index = 4)
  private String qexceptionId;   //数据库 int
    //缺陷填报人
    @ExcelProperty(value = {"缺陷填报人"}, index = 5)
    private String defectiveName;    //都是字符串

    //填报时间
    @ExcelProperty(value = {"填报时间"}, index = 6)
    private Date createTime;   //时间

    //转工单状态
    @ExcelProperty(value = {"转工单状态"}, index = 7)
  private String ZhuanOrderStatus;  //0 拟制中 1 待确认 2 已转

  //工单操作人
  @ExcelProperty(value = {"工单操作人"}, index = 8)
 private String orderConfirmer;   //
  //工单确认时间
  @ExcelProperty(value = {"工单确认时间"}, index = 9)
  private Date confirmedTime;  //

  //所属机构 存
  private Integer  DeptId;

  //转工单状态  存 //0 拟制中 1 待确认 2 已转
  private Integer orderStatus;    // == orderStatusName
  //缺陷等级 存
  private Integer exceptionId;




}
