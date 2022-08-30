package jpcd.soft.ureport.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jpcd.soft.ureport.entity.UrDatasourceInfo;
import jpcd.soft.ureport.entity.vo.Result;
import jpcd.soft.ureport.service.impl.UrDatasourceInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 动态数据源信息 前端控制器
 * </p>
 *
 * @author wang_yw
 * @since 2022-08-26
 */
@RestController
@RequestMapping("/urDatasourceInfo")
public class UrDatasourceInfoController {

    @Autowired
    private UrDatasourceInfoServiceImpl urDatasourceInfoService;

    /**
     * description: 新增数据源
     * date: 2022/8/19 14:34
     * author: wang_yw
     */
    @PostMapping("/addDatasourceInfo")
    public Result<Object, Object, Object> addDatasourceInfo(@Validated @RequestBody UrDatasourceInfo urDatasourceInfo) {
        Result<Object, Object, Object> result = new Result<>();
        if (urDatasourceInfoService.addDatasourceInfo(urDatasourceInfo)) {
            result.setSuccess();
        } else {
            result.setFail();
        }
        return result;
    }

    /**
     * description: 分页查询数据源信息
     * version: 1.0
     * date: 2022/8/19 15:41
     * author: wang_yw
     */
    @PostMapping("/pageDatasourceInfo")
    public Result<Object, Object, UrDatasourceInfo> pageDatasourceInfo(@RequestBody UrDatasourceInfo urDatasourceInfo,
                                                                       int currentPage,
                                                                       int pageSize) {
        Result<Object, Object, UrDatasourceInfo> result = new Result<>();
        QueryWrapper<UrDatasourceInfo> queryWrapper = new QueryWrapper<>();
        IPage<UrDatasourceInfo> page = new Page<>();
        page.setCurrent(currentPage);
        page.setSize(pageSize);
        IPage<UrDatasourceInfo> urDatasourceInfoIPage = urDatasourceInfoService.page(page, queryWrapper);
        result.setSuccess();
        result.setPageInfo(urDatasourceInfoIPage);
        return result;
    }

}
