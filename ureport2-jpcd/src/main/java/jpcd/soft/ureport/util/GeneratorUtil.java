package jpcd.soft.ureport.util;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * description: GeneratorUtil
 * date: 2022/8/17 13:03
 * author: wang_yw
 * version: 1.0
 */
public class GeneratorUtil {


    /**
     * 执行 run
     */
    public static void main(String[] args) {

        String dbUrl = "jdbc:mysql://121.4.190.111:7706/jpcd_soft_ureport";
        String db_username = "root";
        String db_password = "XfFJfUlWtZHs7u2IrBHE";

        FastAutoGenerator.create(dbUrl, db_username, db_password)
                .globalConfig(builder -> {
                    builder.author("wang_yw") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("/Users/wdssdream/workspace/github/ureport/ureport2-jpcd/src/main/java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("jpcd.soft") // 设置父包名
                            .moduleName("ureport") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml,
                                    "/Users/wdssdream/workspace/github/ureport/ureport2-jpcd/src/main/resources/mybatis")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("ur_report_info") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_")// 设置过滤表前缀
                            .mapperBuilder()
                            .enableMapperAnnotation();
                })
                .templateConfig(builder -> builder.build())
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }
}
