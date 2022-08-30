package jpcd.soft.ureport.core.datasource;

import lombok.Data;

/**
 * description: 数据源参数
 * date: 2022/8/18 14:17
 * author: wang_yw
 */
@Data
public class DatasourceParam {
    private String url;
    private String userName;
    private String passWord;
    private String driverClass;
    private Integer lazy;
    private String datasourceKey;
}
