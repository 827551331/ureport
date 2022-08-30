package jpcd.soft.ureport.core.datasource;

import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.baomidou.dynamic.datasource.creator.DefaultDataSourceCreator;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Map;

/**
 * description: 动态数据源管理类
 * date: 2022/8/18 13:42
 * author: wang_yw
 */
@Slf4j
@Component
public class DynamicDatasourceManager {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private DefaultDataSourceCreator defaultDataSourceCreator;

    /**
     * description: 新增数据源
     * date: 2022/8/18 14:33
     * author: wang_yw
     *
     * @param datasourceParam : 数据源参数
     */
    public void addDatasource(DatasourceParam datasourceParam) {
        log.info("#新增数据源：{}", datasourceParam.toString());
        DataSourceProperty dataSourceProperty = new DataSourceProperty();
        dataSourceProperty.setUrl(datasourceParam.getUrl());
        dataSourceProperty.setUsername(datasourceParam.getUserName());
        dataSourceProperty.setPassword(datasourceParam.getPassWord());
        dataSourceProperty.setDriverClassName(datasourceParam.getDriverClass());
        dataSourceProperty.setLazy(datasourceParam.getLazy() != 0);
        dataSourceProperty.setPoolName(datasourceParam.getDatasourceKey());

        DynamicRoutingDataSource ds = (DynamicRoutingDataSource) dataSource;
        DataSource dataSource = defaultDataSourceCreator.createDataSource(dataSourceProperty);
        ds.addDataSource(datasourceParam.getDatasourceKey(), dataSource);
    }

    /**
     * description: 删除数据源
     * date: 2022/8/18 15:06
     * author: wang_yw
     */
    public void removeDatasource(String datasourceKey) {
        log.info("#删除数据源，key：{}", datasourceKey);
        DynamicRoutingDataSource ds = (DynamicRoutingDataSource) dataSource;
        ds.removeDataSource(datasourceKey);
    }

    /**
     * description: 获取所有的数据源
     * date: 2022/8/18 15:10
     * author: wang_yw
     */
    public Map<String, DataSource> getAllDatasource() {
        log.info("#获取所有的数据源");
        DynamicRoutingDataSource ds = (DynamicRoutingDataSource) dataSource;
        return ds.getDataSources();
    }
}
