package jpcd.soft.ureport.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 动态数据源信息
 * </p>
 *
 * @author wang_yw
 * @since 2022-08-26
 */
@Data
@TableName("ur_datasource_info")
@ApiModel(value = "UrDatasourceInfo对象", description = "动态数据源信息")
public class UrDatasourceInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("自增ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("租户信息")
    private String hireCode;

    @ApiModelProperty("创建时间")
    private String createDate;

    @ApiModelProperty("更新时间")
    private String updateDate;

    @ApiModelProperty("数据源URL")
    private String url;

    @ApiModelProperty("数据源账号")
    private String userName;

    @ApiModelProperty("数据源密码")
    private String passWord;

    @ApiModelProperty("数据源驱动类")
    private String driverClass;

    @ApiModelProperty("是否立即初始化  0：否，1：立即初始化")
    private Integer lazy;

    @ApiModelProperty("数据源唯一key")
    private String datasourceKey;

}
