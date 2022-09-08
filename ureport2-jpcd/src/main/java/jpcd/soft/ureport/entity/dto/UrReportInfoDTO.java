package jpcd.soft.ureport.entity.dto;

import jpcd.soft.ureport.entity.UrReportInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * description: UrReportInfoDTO
 * date: 2022/8/30 11:47
 * author: wang_yw
 * version: 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UrReportInfoDTO extends UrReportInfo {
    private Integer currentPage;
    private Integer pageSize;
}
