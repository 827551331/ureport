package com.bstek.ureport.provider.report.file;

import com.bstek.ureport.provider.report.ReportFile;
import com.bstek.ureport.provider.report.ReportProvider;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.io.InputStream;
import java.util.List;

/**
 * description: 数据库存储实现类
 * date: 2022/8/29 15:42
 * version: 1.0
 *
 * @author wang_yw
 */
public class DbReportProvider implements ReportProvider, ApplicationContextAware {

    /**
     * 根据报表名加载报表文件
     *
     * @param file 报表名称
     * @return 返回的InputStream
     */
    @Override
    public InputStream loadReport(String file) {
        return null;
    }

    /**
     * 根据报表名，删除指定的报表文件
     *
     * @param file 报表名称
     */
    @Override
    public void deleteReport(String file) {

    }

    /**
     * 获取所有的报表文件
     *
     * @return 返回报表文件列表
     */
    @Override
    public List<ReportFile> getReportFiles() {
        return null;
    }

    /**
     * 保存报表文件
     *
     * @param file    报表名称
     * @param content 报表的XML内容
     */
    @Override
    public void saveReport(String file, String content) {

    }

    /**
     * @return 返回存储器名称
     */
    @Override
    public String getName() {
        return null;
    }

    /**
     * @return 返回是否禁用
     */
    @Override
    public boolean disabled() {
        return false;
    }

    /**
     * @return 返回报表文件名前缀
     */
    @Override
    public String getPrefix() {
        return null;
    }

    /**
     * Set the ApplicationContext that this object runs in.
     * Normally this call will be used to initialize the object.
     * <p>Invoked after population of normal bean properties but before an init callback such
     * as {@link InitializingBean#afterPropertiesSet()}
     * or a custom init-method. Invoked after {@link ResourceLoaderAware#setResourceLoader},
     * {@link ApplicationEventPublisherAware#setApplicationEventPublisher} and
     * {@link MessageSourceAware}, if applicable.
     *
     * @param applicationContext the ApplicationContext object to be used by this object
     * @throws ApplicationContextException in case of context initialization errors
     * @throws BeansException              if thrown by application context methods
     * @see BeanInitializationException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}
