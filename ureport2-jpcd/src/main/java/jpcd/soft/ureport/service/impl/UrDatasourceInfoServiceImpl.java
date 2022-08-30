package jpcd.soft.ureport.service.impl;

import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jpcd.soft.ureport.core.datasource.DatasourceParam;
import jpcd.soft.ureport.core.datasource.DynamicDatasourceManager;
import jpcd.soft.ureport.entity.UrDatasourceInfo;
import jpcd.soft.ureport.mapper.UrDatasourceInfoMapper;
import jpcd.soft.ureport.service.IUrDatasourceInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

/**
 * <p>
 * 动态数据源信息 服务实现类
 * </p>
 *
 * @author wang_yw
 * @since 2022-08-26
 */
@Service
public class UrDatasourceInfoServiceImpl extends ServiceImpl<UrDatasourceInfoMapper, UrDatasourceInfo> implements IUrDatasourceInfoService {

    @Autowired
    private DynamicDatasourceManager dynamicDatasourceManager;
    @Autowired
    private DataSource dataSource;

    /**
     * description: 新增数据源
     * date: 2022/8/19 14:37
     * author: wang_yw
     */
    public boolean addDatasourceInfo(UrDatasourceInfo urDatasourceInfo) {
        DatasourceParam datasourceParam = new DatasourceParam();
        BeanUtils.copyProperties(urDatasourceInfo, datasourceParam);
        dynamicDatasourceManager.addDatasource(datasourceParam);
        return this.save(urDatasourceInfo);
    }

    /**
     * description: 新增数据源-根据datasourceKey
     * version: 1.0
     * date: 2022/8/21 16:01
     * author: wang_yw
     */
    public void addDatasourceInfo(String datasourceKey) {
        QueryWrapper<UrDatasourceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(UrDatasourceInfo::getDatasourceKey, datasourceKey);
        UrDatasourceInfo urDatasourceInfo = this.getOne(queryWrapper);
        DatasourceParam datasourceParam = new DatasourceParam();
        BeanUtils.copyProperties(urDatasourceInfo, datasourceParam);
        dynamicDatasourceManager.addDatasource(datasourceParam);
    }

    /**
     * description: 是否存在指定数据源
     * version: 1.0
     * date: 2022/8/21 15:58
     * author: wang_yw
     */
    public boolean containsDatasource(String datasourceKey) {
        DynamicRoutingDataSource routingDataSource = (DynamicRoutingDataSource) dataSource;
        return routingDataSource.getDataSources().containsKey(datasourceKey);
    }
}
