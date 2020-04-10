package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 配置类，作用和applicationContext.xml一样
 * spring中的新注解
 * @Configuration：指定当前类是一个配置类
 *      细节：当配置类作为AnnotationConfigApplicationContext对象创建的参数时，该注释可以不写
 * @ComponentScan：用于通过注释指定spring在创建容器时要扫描的包
 *      属性：
 *           basePackage：用于指定创建容器时要扫描的包
 *           value：它和basePackages的作用一样
 *              注意：1.这两个都是数组类型的，一个类的时候，直接写，多个类要用{}隔开
 *                    @ComponentScan(basePackages = {"com.cbw","com.cbw.domain"})
 *                    2.basePackage和value也可以不写，直接写字符串
 *                    @ComponentScan("com.cbw")
 *      我们使用此注解就等同于在xml文件中配置了：
 *      <context:component-scan base-package="com.cbw"></context:component-scan>
 * @Bean：用于把当前方法的返回值作为bean对象存入spring的IoC容器中
 *      属性：
 *          name：用于指定bean的id，当不写时，默认值是当前方法的名称
 *
 *细节：当我们使用注解配置方法时，如果方法有参数，spring框架会去容器中查找有没有可用的bean对象
 *      查找方式和@AutoWired注解是一样的
 *
 */
@Configuration
@PropertySource("classpath:jdbcConfig.properties")
@ComponentScan("com.cbw")
public class SpringConfiguration {

    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    /**
     * 用于创建一个QueryRuanner对象，并且存入springIoC容器中
     * @param dataSource
     * @return
     */
    @Bean("runner")
    public QueryRunner createQueryRunner(DataSource dataSource){
        return new QueryRunner(dataSource);
    }

    /**
     * 用于创建一个数据源对象，并且存入springIoC容器中
     * @return
     */
    @Bean("dataSource")
    public DataSource createDataSource(){
        ComboPooledDataSource ds = new ComboPooledDataSource();
        try {
            ds.setDriverClass(driver);
            ds.setJdbcUrl(url);
            ds.setUser(username);
            ds.setPassword(password);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return ds;
    }
}


