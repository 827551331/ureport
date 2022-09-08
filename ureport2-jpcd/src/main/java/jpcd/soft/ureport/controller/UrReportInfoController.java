package jpcd.soft.ureport.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jpcd.soft.ureport.entity.UrReportInfo;
import jpcd.soft.ureport.entity.dto.UrReportInfoDTO;
import jpcd.soft.ureport.entity.vo.Result;
import jpcd.soft.ureport.service.impl.UrReportInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 * 报表文件信息 前端控制器
 * </p>
 *
 * @author wang_yw
 * @since 2022-08-29
 */
@Controller
@RequestMapping("/urReportInfo")
public class UrReportInfoController {

    @Autowired
    private UrReportInfoServiceImpl urReportInfoService;


    /**
     * description: 新增数据源
     * date: 2022/8/19 14:34
     * author: wang_yw
     */
    @PostMapping("/addReportInfo")
    public Result<Object, Object, Object> addDatasourceInfo(@Validated @RequestBody UrReportInfo urReportInfo) {
        Result<Object, Object, Object> result = new Result<>();
        if (urReportInfoService.save(urReportInfo)) {
            result.setSuccess();
        } else {
            result.setFail();
        }
        return result;
    }

    /**
     * description: 分页查询信息
     * version: 1.0
     * date: 2022/8/19 15:41
     * author: wang_yw
     */
    @PostMapping("/pageReportInfo")
    public Result<Object, Object, UrReportInfo> pageReportInfo(@RequestBody UrReportInfoDTO urReportInfoDTO) {
        Result<Object, Object, UrReportInfo> result = new Result<>();
        QueryWrapper<UrReportInfo> queryWrapper = new QueryWrapper<>();
        IPage<UrReportInfo> page = new Page<>();
        page.setCurrent(urReportInfoDTO.getCurrentPage());
        page.setSize(urReportInfoDTO.getPageSize());
        IPage<UrReportInfo> urReportInfoIPage = urReportInfoService.page(page, queryWrapper);
        result.setSuccess();
        result.setPageInfo(urReportInfoIPage);
        return result;
    }

}
