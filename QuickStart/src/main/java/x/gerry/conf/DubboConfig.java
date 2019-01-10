package x.gerry.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author:Gerry
 * @description:读取额外的配置文件的配置信息
 * @date: Created in 2019/1/10
 */
@Configuration
@PropertySource("classpath:dubbo.properties")
public class DubboConfig {
    @Value("${dubbo.resAddress}")
    private String resAddress;

    @Value("${dubbo.appName}")
    private String appName;

    @Value("${dubbo.resUsername}")
    private String resUsername;

    @Value("${dubbo.resPassowrd}")
    private String resPassowrd;

    @Value("${dubbo.protocol}")
    private String protocol;

    @Value("${dubbo.port}")
    private int port;

    @Value("${dubbo.accepts}")
    private int accepts;

    @Value("${dubbo.connections}")
    private int connections;

    @Override
    public String toString() {
        return "DubboConfig [resAddress=" + resAddress + ", appName=" + appName + ", resUsername=" + resUsername + ", resPassowrd=" + resPassowrd + ", protocol=" + protocol + ", port=" + port + ", accepts=" + accepts + ", connections=" + connections + "]";
    }
}
