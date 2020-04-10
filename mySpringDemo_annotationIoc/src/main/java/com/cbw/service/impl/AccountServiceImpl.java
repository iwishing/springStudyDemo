package com.cbw.service.impl;

import com.cbw.dao.IAccountDao;
import com.cbw.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 *
 * xml配置：
 *    <bean id="accountService" class="com.cbw.service.impl.AccountServiceImpl" scope="" init-method="" destroy-method="">
 *          <property name="" value=""  ref=""></property>
 *    </bean>
 *
 *注解配置：
 *      一.用于创建对象的
 *          他们的作用就和在xml配置文件中编写一个<bean>标签实现的功能是一样的
 *          1.@Component：用于把当前类对象存入spring容器
 *              属性：
 *                  value：用于指定bean的id，当我们不写时，默认值是当前类名，且首字母变小写
 *          ------------------
 *          2.@Controller ---------一般用在表现层
 *          3.@Service  -----------一般用在业务层
 *          4.@Repository  --------一般用在持久层
 *          以上三个注解他们的作用和属性和Component是一模一样，他们三个是spring框架为我们提供明确的三层使用的注解，使我们的三层更加清晰
 *
 *      二.用于注入数据的
 *          他们的作用就和在xml配置文件中的bean标签中写一个property标签的作用是一样的
 *          1.@Autowired：自动按照类型注入，只要容器中有唯一的一个bean对象类型和要注入的变量类型匹配，就可以注入成功
 *              例子：
 *                                  @Repository("accountDaoImpl")
 *                                  public class AccountDaoImpl implements IAccountDao {
 *                        ---------------------------------------------
 *                                  @Autowired
 *                                  private IAccountDao iAccountDao;
 *                        IoC容器是一个Map类型，注解时的id是key，bean的类名是value，这里就是id=accountDaoImpl，value=AccountDaoImpl（implement IAccountDao也能记录）
 *                        自动注入：
 *                        1.根据数据类型寻找value是一样的bean
 *                        2.如果IoC容器中，一个匹配的bean类型都没有，注入就会失败报错（如果是接口，那么他的实现类也能匹配）
 *                        3.如果IoC容器中，有bean匹配的时候:
 *                               1.有一个匹配的时候
 *                                      直接注入
 *                               2.有多个匹配的时候
 *                                      根据变量类型，圈定出所有匹配的bean
 *                                      根据变量名称，逐个比对圈定的bean的id值，如果有相同的，那么就匹配这个
 *                                      如果几个都一样，或者一个都没有，就会报错
 *               出现位置：
 *                  变量，方法
 *              细节：
 *                  在使用注解注入时，set方法就不是必须的
 *            2.@Qalifier：在按照类中注入的基础上再按照名称注入。它在给类成员注入时不能单独使用，必须和@Autowired同时使用。但是在给方法参数注入时可以
 *                属性：
 *                          value：用于指定注入bean的id
 *                例子：
 *                                 @Autowired
 *                                 @Qualifier("accountDaoImpl")
 *                                 private IAccountDao accountDaoImpl;
 *            3.@Resource：直接按照bean的id注入，可以单独使用
 *                 属性：
 *                       name：用于指定bean的id
 *                 例子：
 *                                 @Resource(name = "accountDaoImpl")
 *                                 private IAccountDao accountDaoImpl;
 *            以上三个注解，只能注入其他bean类型的数据，而基本类型和String类型的无法注入
 *            注：
 *              集合类型的注入只能通过xml来实现
 *            -------------------------------------------------------------------------------
 *            4.@Value：用于注入基本类型和String类型的数据
 *                 属性：
 *                      value：用于指定数据的值。它可以使用spring中的SpEL（也就是spring中的el表达式）
 *                              SpEl写法：${表达式}
 *                              注意：el表达式在哪里，就是谁的el表达式，如果出现在jsp里面，就是jsp的el表达式，如果写在spring的配置文件中就是spring的el表达式，如果写在
 *                                   mybatis的配置文件中，那么就是mybatis的配置文件中
 *      三.用于改变作用范围的
 *          他们的作用就和在bean标签中使用scope属性实现的功能是一样的
 *          @Scope：用于指定bean的作用范围
 *              属性：
 *                  value：指定范围的取值。取值和xml中bean标签中的scope属性一样，常用取值为singleton prototype，默认值是singleton
 *      四.生命周期相关的
 *          他们的作用就和在bean标签中使用init-method和destroy-method的作用是一样的
 *          1.@PreDestroy：用于指定销毁方法
 *          2.@PostConstruct：用于指定初始化方法
 *          用法：在bean类中，定义init()方法，用PostConstruct注解，定义destory()方法，用ProDestroy注解，bean对象在创建时候会执行init()方法，在销毁时会执行destroy()方法
 * 账户的业务层实现类
 */
@Component("accountService")
public class AccountServiceImpl implements IAccountService {

/*    @Autowired
    @Qualifier("accountDaoImpl")*/
    @Resource(name = "accountDaoImpl")
    private IAccountDao accountDaoImpl;

    public void saveAccount() {
        accountDaoImpl.saveAccount();


    }

}
