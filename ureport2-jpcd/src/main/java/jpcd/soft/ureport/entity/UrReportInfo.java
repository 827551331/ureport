package jpcd.soft.ureport.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 报表文件信息
 * </p>
 *
 * @author wang_yw
 * @since 2022-08-29
 */
@TableName("ur_report_info")
@ApiModel(value = "UrReportInfo对象", description = "动态数据源信息")
public class UrReportInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("自增ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("租户信息")
    @NotBlank(message = "租户信息不能为空")
    private String hireCode;

    @ApiModelProperty("创建时间")
    private LocalDateTime createDate;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateDate;

    @ApiModelProperty("报表名称")
    @NotBlank(message = "报表名称不能为空")
    private String reportName;

    @ApiModelProperty("创建人员")
    @NotBlank(message = "创建人员不能为空")
    private String createPer;

    @ApiModelProperty("报表文件")
    @NotBlank(message = "报表文件不能为空")
    private String reportFile;

    @ApiModelProperty("报表类型")
    private String reportType;

    @ApiModelProperty("已授权人员")
    private String authorizedPerson;

    @ApiModelProperty("已授权部门")
    private String authorizedDepartment;

    @ApiModelProperty("已授权角色")
    private String authorizedRole;

    @ApiModelProperty("报表状态 0：禁用；1：启用")
    private Integer status;

    @ApiModelProperty("备注")
    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHireCode() {
        return hireCode;
    }

    public void setHireCode(String hireCode) {
        this.hireCode = hireCode;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getCreatePer() {
        return createPer;
    }

    public void setCreatePer(String createPer) {
        this.createPer = createPer;
    }

    public String getReportFile() {
        return reportFile;
    }

    public void setReportFile(String reportFile) {
        this.reportFile = reportFile;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getAuthorizedPerson() {
        return authorizedPerson;
    }

    public void setAuthorizedPerson(String authorizedPerson) {
        this.authorizedPerson = authorizedPerson;
    }

    public String getAuthorizedDepartment() {
        return authorizedDepartment;
    }

    public void setAuthorizedDepartment(String authorizedDepartment) {
        this.authorizedDepartment = authorizedDepartment;
    }

    public String getAuthorizedRole() {
        return authorizedRole;
    }

    public void setAuthorizedRole(String authorizedRole) {
        this.authorizedRole = authorizedRole;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "UrReportInfo{" +
                "id=" + id +
                ", hireCode=" + hireCode +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", reportName=" + reportName +
                ", createPer=" + createPer +
                ", reportFile=" + reportFile +
                ", reportType=" + reportType +
                ", authorizedPerson=" + authorizedPerson +
                ", authorizedDepartment=" + authorizedDepartment +
                ", authorizedRole=" + authorizedRole +
                ", status=" + status +
                ", remark=" + remark +
                "}";
    }
}
