package jpcd.soft.ureport.entity.vo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "Result", description = "结果返回")
public class Result<R, RS, P> {

    //单个结果
    private R result;
    //结果集
    private List<RS> results;
    //分页信息
    private IPage<P> pageInfo;
    //返回结果代码
    private String resultCode;
    //返回结果内容
    private String resultMsg;

    public Result() {
    }

    public void setSuccess() {
        resultCode = CommonEnums.SUCCESS.getValue();
        resultMsg = "操作成功";
    }

    public void setFail() {
        resultCode = CommonEnums.FAIL.getValue();
        resultMsg = "操作失败";
    }

    public Result<R, RS, P> fail(String resultMsg) {
        resultCode = CommonEnums.FAIL.getValue();
        this.resultMsg = resultMsg;
        return this;
    }

    public Result<R, RS, P> success(String resultMsg) {
        resultCode = CommonEnums.SUCCESS.getValue();
        this.resultMsg = resultMsg;
        return this;
    }

    public Result<R, RS, P> success() {
        resultCode = CommonEnums.SUCCESS.getValue();
        this.resultMsg = CommonEnums.SUCCESS.getMessage();
        return this;
    }

    public boolean isSuccess() {
        return CommonEnums.SUCCESS.getValue().equals(resultCode);
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }
}
