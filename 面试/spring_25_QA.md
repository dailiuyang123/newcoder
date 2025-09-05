* 1、什么是Spring框架?Spring框架有哪些主要模块?

Spring框架是一个开源的Java应用程序框架，主要用于构建企业级Java应用程序。它是一个分层的、面向切面的一站式轻量级解决方案，核心是控制反转（IoC）和面向切面编程（AOP），旨在简化Java企业级应用的开发难度和开发周期。以下是其详细介绍：
- **方便解耦，简化开发**：通过IoC容器，可将对象间依赖关系交由Spring控制，避免硬编码造成的过度耦合，开发者能更专注于上层应用。
- **支持AOP编程**：借助Spring的AOP功能，可方便地进行面向切面编程，轻松实现传统OOP难以完成的功能，如事务管理、日志记录等。
- **声明式事务支持**：通过配置文件或`@Transactional`注解，可将开发者从繁琐的事务管理代码中解脱出来，以声明式方式灵活管理事务。
- **方便程序测试**：可采用非容器依赖的编程方式进行测试，降低测试成本，使测试更便捷。
- **方便集成各种优秀框架**：Spring能降低各种框架的使用难度，可直接支持Struts、Hibernate等多种优秀框架。
- **降低JavaEE API的使用难度**：Spring对JDBC、JavaMail等JavaEE API进行了封装，使其使用难度大幅降低。

Spring框架由多个模块组成，主要包括以下几类：
- **核心容器模块**：包括`spring-core`、`spring-beans`、`spring-context`等。提供IoC容器，管理Bean的生命周期和依赖注入。其中`spring-core`是基础工具类与依赖注入支持；`spring-beans`用于Bean工厂与Bean的定义；`spring-context`扩展了`BeanFactory`，支持国际化、事件传播等。
- **数据访问与集成模块**：包含`spring-jdbc`、`spring-orm`、`spring-jms`等。用于简化数据库操作和事务管理，集成ORM框架，支持对象-XML映射和消息传递等。例如`spring-jdbc`是JDBC抽象层，`spring-orm`可集成Hibernate等ORM框架，`spring-jms`提供Java消息服务支持。
- **Web模块**：有`spring-web`、`spring-webmvc`、`spring-webflux`等。为Web应用开发提供支持，`spring-web`提供HTTP客户端等基础功能，`spring-webmvc`是基于Servlet的MVC框架，`spring-webflux`是非阻塞响应式Web框架。
- **AOP与Instrumentation模块**：主要有`spring-aop`、`spring-aspects`等。提供面向切面编程支持，`spring-aop`实现了AOP功能，`spring-aspects`集成了AspectJ的切面库。
- **测试模块**：主要是`spring-test`，集成JUnit或TestNG，支持Spring上下文测试和Mock对象，方便对Spring应用进行单元测试和集成测试。
- **其他模块**：如`spring-security`、`spring-batch`等。`spring-security`用于身份验证和授权，`spring-batch`用于处理大量数据任务，`spring-integration`提供企业集成模式支持。


* 2、使用Spring框架能带来哪些好处?

* 3、什么是控制反转(IOC)?什么是依赖注入?
  控制反转（Inversion of Control，IOC）是一种设计原则，旨在通过将程序控制权交给框架或容器，实现模块之间的松耦合。以下是具体介绍：
- **核心思想**：将对象的创建和依赖关系的管理交给容器，而非由代码自行管理，把控制权从对象内部反转到外部容器。
- **作用**：实现模块松耦合，提高代码的可维护性与应用的灵活性。例如在传统开发中，Controller 需要显式实例化 Service，耦合度高；使用 IOC 后，Service 的实例由容器注入，Controller 不再关心 Service 的具体实现，降低了两者的耦合度。
- **与依赖注入的关系**：依赖注入（Dependency Injection，DI）是实现 IOC 的主要手段。

依赖注入是一种设计模式，用于实现对象之间的依赖关系解耦，是控制反转的一种具体实现方式。以下是详细说明：
- **核心思想**：将对象的依赖（即它所需要的其他对象或服务）从外部注入，而不是由对象自己去创建或查找这些依赖。
- **三个核心角色**：依赖是被注入的对象或服务；消费者是需要依赖的类；注入者是负责将依赖注入到消费者的实体，通常是一个 IOC 容器或手动编写的代码。
- **实现方式**：主要有构造器注入、Setter 注入和接口注入三种。构造器注入通过类的构造函数将依赖传递进来，依赖不可变；Setter 注入通过 Setter 方法注入依赖，依赖可在对象创建后动态改变；接口注入则通过定义接口，消费者实现该接口，注入者通过接口方法注入依赖，较少使用。
- **优点**：可以解耦合，使消费者与依赖的具体实现分离；提高可测试性，通过注入 mock 对象，方便进行单元测试；提升可维护性，修改依赖实现时无需更改消费者代码；还能提高可重用性，依赖可被多个消费者共享。
- **缺点**：手动实现可能导致代码量增加，需要额外的配置或框架支持，理解该概念也需要一定时间，且如果依赖未正确注入，可能在运行时才暴露问题。

* 4、请解释下Spring框架中的IoC?


* 5.BeanFactory和ApplicationContext有什么区别?
* 6、Spring有几种配置方式?
> 答案：Spring主要有4种配置方式，分别是基于XML的配置、基于注解的配置、基于Java类的配置和基于Groovy DSL的配置，且允许各种配置方式复合共存。具体如下：
- **基于XML的配置**：在XML文件中通过<bean>元素定义Bean，通过<property>子元素或p命名空间进行属性注入。还可通过<bean>的scope属性指定作用范围，lazy-init属性指定延迟初始化，init-method和destory-method属性指定生命周期方法。适用于Bean实现类来源于第三方类库，无法在类中标注注解的情况，也常用于命名空间的配置，如aop、context等。
- **基于注解的配置**：在Bean实现类处通过标注@Component或衍型类@Repository、@Service及@Controller定义Bean。通过在成员变量或方法入参处标注@Autowired，按类型匹配自动注入，可配合@Qualifier按名称匹配注入。通过@Scope指定作用范围，@Lazy指定延迟初始化，@PostConstruct和@PreDestroy指定生命周期方法。适用于Bean的实现类是当前项目开发的情况，可直接在Java类中使用。
- **基于Java类的配置**：在标注了@Configuration的Java类中，通过在类方法上标注@Bean定义一个Bean。方法必须提供Bean的实例化逻辑。注入方式比较灵活，可通过在方法处通过@Autowired方法入参绑定Bean，也可通过调用配置类的@Bean方法进行注入。同样通过@Scope、@Lazy等注解指定作用范围、延迟初始化等相关配置。适合实例化Bean的逻辑比较复杂的情况，可通过代码方式控制Bean初始化的整体逻辑。
- **基于Groovy DSL的配置**：在Groovy文件中通过DSL定义Bean的名称，如userDao(UserDao)。可在方法处通过ref()方法进行注入。通过bean->bean.scope="prototype"指定作用范围，bean->bean.lazyInit=true指定延迟初始化，bean->bean.initMehtod或bean.destoryMethod指定生命周期方法。优势在于可以通过Groovy脚本灵活控制Bean初始化的过程。
* 7、如何用基于XML配置的方式配置Spring?
* 8.如何用基于Java配置的方式配置Spring?
* 9、怎样用注解的方式配置Spring?
* 10.请解释Spring Bean的生命周期?
> 答案：
Spring Bean的生命周期是指从Bean的定义开始，经过实例化、属性填充、初始化，直到最终销毁的整个过程。具体如下：
1. **Bean定义加载与解析**：Spring容器启动时，会扫描所有配置源，如XML、注解、Java配置等，将Bean的定义信息解析为BeanDefinition对象，该对象包含了类名、作用域、延迟加载等属性，然后通过BeanDefinitionRegistry将其注册到容器中。
2. **实例化**：Spring通过反射机制调用构造方法完成Bean对象创建。若有唯一构造方法，直接使用；若有多个构造方法，优先选择带@Autowired注解的；若无@Autowired则选择无参构造，若无则报错。为解决循环依赖，Spring在实例化后会立即将原始对象包装成ObjectFactory放入三级缓存（singletonFactories）。
3. **属性填充**：此阶段是Spring实现依赖注入（DI）的核心，主要有字段注入、Setter注入和构造器注入三种方式。Spring会将当前Bean依赖的其他Bean注入到其中，例如通过@Autowired注解自动装配依赖对象。循环依赖问题在该阶段通过三级缓存机制解决。
4. **Aware接口回调**：在属性注入后，Spring会检查Bean是否实现了特定的Aware接口，如BeanNameAware、BeanFactoryAware、ApplicationContextAware等，并通过回调方法注入相应的容器基础设施。
5. **初始化**：
  - **初始化前处理**：调用所有BeanPostProcessor.postProcessBeforeInitialization()方法，这是AOP代理等高级特性的入口点。
  - **初始化方法执行**：Spring按固定顺序执行三种初始化方法，分别是@PostConstruct注解方法、InitializingBean.afterPropertiesSet()方法和自定义init-method方法。
6. **使用**：经过前面的阶段后，Bean就可以在应用程序中被使用了，例如在Web应用中，Bean可以被控制器调用，以处理相关的业务逻辑。
7. **销毁**：当应用程序关闭或者Bean不再需要时，Spring会销毁Bean。如果Bean实现了DisposableBean接口，会调用接口的destroy方法。也可以通过@PreDestroy注解标记销毁前执行的方法，或者在Bean的配置中指定自定义的销毁方法，以释放资源，如关闭数据库连接等。

此外，单例Bean和原型Bean的生命周期管理存在差异，单例Bean在容器启动时创建，与容器生命周期一致，容器关闭时销毁；原型Bean则在每次请求时创建，容器不管理其销毁，由垃圾回收器回收。

* 11.Spring Bean的作用域之间有什么区别?
> 答案：Spring Bean常见的作用域有singleton、prototype、request、session、application等，它们之间的区别主要体现在实例创建方式、生命周期、适用场景等方面。具体如下：
- **singleton（单例）**：Spring默认作用域，容器启动时创建一个实例并存储在单例池中，整个容器生命周期内只有这一个实例，无论何时请求该Bean，都会返回同一个实例。适用于无状态的服务类，如日志服务、邮件发送服务，以及全局配置类等，可节省内存开销，但在多线程环境下若Bean有可变状态，需注意线程安全问题。
- **prototype（原型）**：每次请求（如通过`getBean()`方法或依赖注入）时，Spring容器都会创建一个新的实例，容器不管理其销毁，需开发者手动释放相关资源。适合有状态的Bean，如用户会话相关Bean，或临时对象，如表单数据绑定对象，能避免多个请求间的数据干扰，但频繁创建实例可能消耗较多内存。
- **request（请求）**：仅在Web环境中有效，每次HTTP请求都会创建一个新的Bean实例，请求结束后该实例被销毁。常用于处理HTTP请求级数据，如封装表单参数、跟踪请求信息等，可针对每个请求提供独立的处理逻辑。
- **session（会话）**：同样用于Web环境，每个HTTP会话会创建一个Bean实例，该实例在当前会话内共享，会话过期或结束后销毁。适合存储用户登录状态、购物车信息、用户偏好设置等，可在一个会话周期内保持数据的一致性。
- **application（应用）**：基于Web环境，在整个ServletContext生命周期内，Spring IoC容器仅创建一个Bean实例，与整个应用的生命周期绑定，类似于单例，但作用域是ServletContext而非Spring容器。适用于全局配置信息、应用级缓存、共享资源管理等，可在整个Web应用中共享数据。
- **websocket（WebSocket）**：是Spring 4.0引入的，针对WebSocket环境，每个WebSocket会话会创建一个新的Bean实例，会话结束后销毁。适用于需要绑定到WebSocket会话的场景，如实时通信中的聊天室消息推送、WebSocket连接的用户信息管理等。
- **globalSession（全局会话）**：主要用于Portlet环境，为每个全局会话创建一个新的Bean实例，与全局会话绑定，用于跨Portlet共享数据，如用户身份信息、全局配置等。在标准Web应用框架中通常不存在，是Portlet应用特有的作用域。

* 12.什么是Springinnerbeans?
* 13.Spring框架中的单例Beans是线程安全的么?
> 答案： Spring框架中的单例Beans本身并不保证线程安全性，其是否线程安全取决于Bean的设计和使用方式。具体如下：
- **无状态单例Beans通常是线程安全的**：如果单例Bean只包含不可变的状态，或者其成员变量在初始化后不再改变，没有可被修改的成员变量，那么多个线程同时访问时不会出现数据不一致等问题，这种情况下它是线程安全的。例如，一些只包含只读操作或静态方法的工具类Bean，以及大多数DAO类，通常属于无状态的单例Bean，是线程安全的。
- **有状态单例Beans可能是线程不安全的**：如果单例Bean包含可变状态，并且这些状态可能会被多个线程并发访问和修改，就可能出现线程安全问题。例如，单例Bean中包含一个计数器成员变量，多个线程同时调用方法对计数器进行累加操作，若没有同步控制，就会导致计数器的值不准确。此外，如果单例Bean依赖于外部的非线程安全资源，如非线程安全的数据库连接池，在多线程环境下也可能引发问题。

为了确保有状态单例Beans的线程安全，可以采取一些措施，如使用同步方法或同步块、选择线程安全的数据结构、将状态设计为不可变，或者将单例Bean的作用域改为prototype（每次请求都会创建新的实例）等。

* 14、请举例说明如何在Spring中注入一个Java Collection?


* 15.如何向SpringBean中注入一个Java.util.Properties?
* 16、请解释Spring Bean的自动装配?
* 17、请解释自动装配模式的区别?
* 18、如何开启基于注解的自动装配?
* 19、请举例解释@Required注解?
* 20、请举例解释@Autowired注解?
* 22、构造方法注入和设值注入有什么区别?
* 23、Spring框架中有哪些不同类型的事件?
* 24.FileSystemResource和ClassPathResource有何区别? 
* 25、Spring框架中都用到了哪些设计模式?
 >答案： Spring框架中用到了多种设计模式，常见的有工厂模式、单例模式、代理模式、观察者模式等，具体如下：
1. **工厂模式**：包括简单工厂模式和工厂方法模式。BeanFactory是简单工厂模式的体现，它根据指定的类名或ID创建Bean对象。FactoryBean接口则实现了工厂方法模式，允许用户自定义Bean的创建逻辑，可用于创建复杂的Bean实例。
2. **单例模式**：Spring默认将Bean配置为单例，确保在容器中只有一个共享的实例，有助于节省资源和提高性能，如数据库连接池、线程池等通常以单例Bean形式存在。
3. **适配器模式**：SpringMVC中的HandlerAdapter是适配器模式的应用，它允许不同类型的处理器适配到处理器接口，以实现统一的处理器调用。在Spring AOP中，AdvisorAdapter接口的实现子类将Advice适配成MethodInterceptor对象，也体现了适配器模式。
4. **装饰器模式**：BeanWrapper允许在不修改原始Bean类的情况下添加额外的功能，是装饰器模式的实际应用。另外，一些类名中含有Wrapper或Decorator的类，通常也是基于装饰器模式设计的。
5. **代理模式**：Spring的AOP（面向切面编程）底层通过代理模式来实现切面功能，包括JdkDynamicAopProxy和Cglib2AopProxy两种动态代理方式，能够在方法执行前后添加额外的逻辑，如事务管理、日志记录等。
6. **观察者模式**：Spring的事件监听机制是观察者模式的应用，通过ApplicationEventPublisher发布事件，由ApplicationListener监听事件，实现了对象间的松耦合，当一个对象的状态发生改变时，可通知其他依赖它的对象。
7. **策略模式**：Spring允许使用策略模式来定义包扫描时的过滤策略，如在@ComponentScan注解中使用的excludeFilters和includeFilters。另外，HandlerInterceptor和HandlerExecutionChain也使用了策略模式，允许开发者自定义处理器拦截器并按一定顺序执行。
8. **模板方法模式**：Spring中的JdbcTemplate、HibernateTemplate等都使用了模板方法模式，将一些固定的流程封装在父类中，子类只需实现一些抽象方法，便可完成特定的数据库操作等功能。
9. **责任链模式**：Spring AOP通过责任链模式实现通知（Advice）的调用，确保通知按顺序执行。此外，Spring中的过滤器和拦截器也采用了责任链模式，多个过滤器和拦截器按照一定顺序执行，可对请求或响应进行拦截和处理。

## Spring Boot 面试题

1、什么是 Spring Boot？
> 答案：Spring Boot是一个基于Java的开源框架，旨在简化Spring应用程序的配置和引导过程，使开发者能够更快捷地构建独立运行的应用程序。

spring.io网站对其官方定义为：“Spring Boot让创建独立的、生产级的基于Spring的应用程序变得容易，并且可以直接运行”。它具有以下核心特点：
- **自动配置**：Spring Boot能根据类路径中的依赖和环境，自动配置Spring应用程序，减少开发者手动配置的工作量。
- **独立运行**：应用可以打包成JAR文件并独立运行，内置了如Tomcat、Jetty等服务器，无需依赖外部应用服务器。
- **生产就绪**：具备内置的监控、健康检查及外部配置等功能，使应用能够在生产环境中平稳运行。
- **简化依赖管理**：通过Spring Boot Starter简化依赖管理和版本控制，开发者只需引入相关的Starter，即可自动包含所需的依赖项。


2、Spring Boot 有哪些优点？
> 答案:Spring Boot具有诸多优点，主要包括简化配置、快速开发、支持微服务等，具体如下：
1. **简化配置**：Spring Boot会根据项目中的依赖自动配置数据源、日志、Web容器等，无需开发者进行繁琐的手动配置。同时，使用`application.properties`或`application.yml`作为默认配置文件，开发者可按需定制，减少了XML配置的使用。
2. **独立运行**：支持多种嵌入式服务器，如Tomcat、Jetty等。应用程序可打包成可执行的JAR文件，直接通过`java -jar myapp.jar`命令运行，无需外部部署环境，且可在任何支持Java的平台上运行，可移植性强。
3. **开箱即用**：提供一系列的Starter POMs，一键引入常用的Spring模块和其他第三方库，无需手动添加多个依赖。还提供如Spring Initializr等快速启动模板，可快速生成项目结构和基本配置。
4. **生产就绪**：Actuator模块提供多种生产就绪功能，可通过HTTP请求访问`/health`、`/metrics`等端点，获取应用程序的健康状态、性能指标等。同时支持外部化配置，可将配置信息存储在外部文件、环境变量或云配置中心中，便于在不同环境使用不同配置。
5. **易于测试**：Spring Boot Test模块提供了许多便捷的注解和工具，如`@SpringBootTest`注解可启动完整的Spring应用上下文用于集成测试，`@MockBean`和`@Autowired`注解可帮助模拟和注入依赖对象，方便进行单元测试和集成测试。
6. **社区支持和生态系统丰富**：拥有庞大的开发者社区和丰富的文档资源，遇到问题易找到解决方案。与Spring框架和Spring Cloud项目深度集成，可轻松集成各种Spring模块和其他第三方库，构建复杂应用程序。
7. **性能优化**：通过优化类加载和依赖管理，应用程序启动速度快。且通常内存占用小、CPU使用率低，适合在资源受限环境中运行，可有效降低运行成本。
8. **云原生支持**：与AWS、Google Cloud等多种云平台深度集成，支持云原生开发和部署。结合Spring Cloud项目，可实现服务发现、配置管理等功能，助力构建高度可扩展和弹性的微服务架构。
9. **微服务支持良好**：集成了Spring Cloud生态系统，提供了诸如服务注册与发现、负载均衡、断路器等微服务相关功能的支持，简化了微服务的开发和部署。
10. **支持热部署**：支持热部署功能，开发者修改代码后无需重新启动应用即可立即生效，提高了开发效率。


3、什么是 JavaConfig？

4、如何重新加载 Spring Boot 上的更改，而无需重新启动服务器？

5、Spring Boot 中的监视器是什么？

6、如何在 Spring Boot 中禁用 Actuator 端点安全性？

7、如何在自定义端口上运行 Spring Boot 应用程序？

8、什么是 YAML？

9、如何实现 Spring Boot 应用程序的安全性？

10、如何集成 Spring Boot 和 ActiveMQ？

11、如何使用 Spring Boot 实现分页和排序？

12、什么是 Swagger？你用 Spring Boot 实现了它吗？

13、什么是 Spring Profiles？

14、什么是 Spring Batch？

15、什么是 FreeMarker 模板？

16、如何使用 Spring Boot 实现异常处理？
> 答案:在Spring Boot中可通过全局异常处理和局部异常处理两种方式实现异常处理，具体如下：
- **全局异常处理**：通常使用`@ControllerAdvice`注解来实现，该注解能使类成为全局异常处理器，捕获并处理整个应用程序中的异常。配合`@ExceptionHandler`注解可定义特定异常的处理逻辑。示例代码如下：
```java
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    // 处理所有未捕获的异常
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // 处理自定义异常
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handleCustomException(CustomException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // 处理参数校验异常
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        String errors = ex.getBindingResult()
               .getFieldErrors()
               .stream()
               .map(fieldError -> fieldError.getDefaultMessage())
               .collect(Collectors.joining("；"));
        return new ResponseEntity<>("参数校验失败：" + errors, HttpStatus.BAD_REQUEST);
    }
}
```
- **局部异常处理**：在控制器（Controller）中使用`@ExceptionHandler`注解实现，可定义处理特定于该控制器异常的方法。示例代码如下：
```java
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {
    @GetMapping("/test")
    public String testMethod() {
        throw new CustomException("Something went wrong");
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handleCustomException(CustomException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
```

此外，还可以自定义错误响应类，将异常信息封装成统一格式返回给客户端，提高接口的规范性和可读性。例如：
```java
import org.springframework.http.HttpStatus;

public class ApiError {
    private HttpStatus status;
    private String message;
    private long timestamp;

    public ApiError(HttpStatus status, String message, long timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }

    // 省略getter和setter方法
}
```
然后在全局异常处理器中返回该类的实例：
```java
@ExceptionHandler(Exception.class)
public ResponseEntity<ApiError> handleException(Exception e) {
    ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), System.currentTimeMillis());
    return new ResponseEntity<>(apiError, apiError.getStatus());
}
```

17、您使用了哪些 starter maven 依赖项？
> 答案：Spring 有许多常用的 Starter Maven 依赖项，以下是一些常见的介绍：
- **spring - boot - starter - parent**：Spring Boot 的父级依赖，用于提供相关的 Maven 默认依赖，使用它之后，常用的包依赖可以省去 version 标签，还能统一管理项目的一些默认配置，如默认使用 Java 8、UTF - 8编码等。
- **spring - boot - starter**：Spring Boot 的核心启动器，包含了自动配置支持、日志和 YAML 相关功能，是 Spring Boot 项目的基础依赖。
- **spring - boot - starter - web**：用于快速开发 Web 应用，引入后，运行 `mvn spring - boot:run` 可直接启用一个嵌套了 Tomcat 的 Web 应用，也可配合其他 Web 容器如 Jetty 或 Undertow 使用。
- **spring - boot - starter - jdbc**：提供数据访问功能，默认情况下，若未配置数据源，Spring Boot 会自动配置一个，还会自动配置 JdbcTemplate、DataSourceTransactionManager 等，方便进行数据库操作。
- **spring - boot - starter - data - jpa**：基于 JPA（Java Persistence API）的数据库访问依赖，结合 Hibernate 等实现，可通过定义 Repository 接口方便地进行数据库操作，如增删改查。
- **spring - boot - starter - security**：用于实现应用的安全功能，如认证和授权。添加该依赖后，Spring Boot 会自动配置一个基于表单的登录页面，并提供默认的用户名和密码。
- **spring - boot - starter - test**：主要用于项目测试，包含了 JUnit、Hamcrest、Mockito 以及 spring - test 模块等，方便编写单元测试和集成测试。
- **spring - boot - starter - quartz**：若项目需要定时任务功能，可添加此依赖，用于整合 Quartz 定时任务框架，方便定义和管理定时任务。
- **spring - boot - starter - mail**：支持 `javax.mail` 模块，可便捷地发送邮件，常用于实现系统的邮件通知等功能。
- **mybatis - spring - boot - starter**：如果项目使用 MyBatis 作为持久层框架，可添加该依赖，用于整合 MyBatis 和 Spring Boot，方便配置和使用 MyBatis。

18、什么是 CSRF 攻击？
> 答案：CSRF，全称“跨站请求伪造（Cross - site request forgery）”，是一种挟制用户在当前已登录的Web应用程序上执行非本意操作的攻击方法。以下是具体介绍：
- **攻击原理**：攻击者诱导用户打开第三方网站，利用用户在目标网站的已登录状态发起跨站请求。由于浏览器会在同源请求中自动携带用户的登录凭证（如Cookie），目标网站服务器收到请求后，会误认为是用户本人的操作，从而执行相应的恶意操作。
- **攻击步骤**：
  - 用户登录受信任网站A，服务器将登录信息Cookie写入浏览器。
  - 用户在同一浏览器中，未登出网站A的情况下，访问危险网站B。
  - 网站B中存在恶意代码，会诱导用户调用网站A中的接口，浏览器会携带网站A的Cookie向网站A的服务器发送请求。
  - 网站A的服务器以为是用户的正常操作，执行相应业务，如转账等，导致用户遭受损失。
- **攻击类型**：
  - **GET类型**：攻击者可在网站中的`img`标签里构建一个GET请求，当用户打开这个网站的时候就会自动发起提交。例如银行转账接口若支持GET方式，黑客可将转账请求隐藏在图片链接中，用户访问含该图片的页面时，就会触发转账。
  - **POST类型**：攻击者构建一个隐藏的表单，当用户进入页面时，自动提交这个表单。如黑客在页面中创建一个指向银行转账接口的隐藏表单，用户访问页面时就会自动向银行服务器发送转账POST请求。
  - **链接类型**：攻击者在`a`标签的`href`属性里构建一个请求，然后诱导用户去点击。比如以“美图图片下载”“股市内幕”等诱饵，诱使用户点击链接，实则执行恶意请求。
- **攻击特点**：
  - 攻击一般发起在第三方网站，被攻击的网站无法直接防止攻击发生。
  - 攻击利用受害者在被攻击网站的登录凭证，冒充受害者提交操作，而不是直接窃取数据，整个过程攻击者并不能获取到受害者的登录凭证，仅仅是“冒用”。
- **攻击条件**：
  - 目标站点存在CSRF漏洞。
  - 用户登录过目标站点，并且在浏览器上保持有该站点的登录状态。
  - 用户打开一个第三方站点，如黑客站点或某些论坛。

19、什么是 WebSockets？

20、什么是 AOP？

21、如何理解 Spring boot 中的 starter？
> 答案：Spring Boot 的 Starter 是一个依赖管理工具，用于简化 Spring Boot 项目的依赖管理。Starter 模块会自动导入依赖，并配置相应的启动类、配置文件、资源文件等。以下是一些常见的 Starter 模块：
- **spring - boot - starter - parent**：Spring Boot 的父级依赖，用于提供相关的 Maven 默认依赖，使用它之后，常用的包依赖可以省去 version 标签，还能统一管理项目的一些默认配置，如默认使用 Java 8、UTF - 8编码等。
- **spring - boot - starter**：Spring Boot 的核心启动器，包含了自动配置支持、日志和 YAML 相关功能，是 Spring Boot 项目的基础依赖。
- **spring - boot - starter - web**：用于快速开发 Web 应用，引入后，运行 `mvn spring - boot:run` 可直接启用一个嵌套了 Tomcat 的 Web 应用，也可配合其他 Web 容器如 Jetty 或 Undertow 使用。
- **spring - boot - starter - jdbc**：提供数据访问功能，默认情况下，若未配置数据源，Spring Boot 会自动配置一个，还会自动配置 JdbcTemplate、DataSourceTransactionManager 等，方便进行数据库操作。
- **spring - boot - starter - data - jpa**：基于 JPA（Java Persistence API）的数据库访问依赖，结合 Hibernate 等实现，可通过定义 Repository 接口方便地进行数据库操作，如增删改查。
- **spring - boot - starter - security**：用于实现应用的安全功能，如认证和授权。添加该依赖后，Spring Boot 会自动配置一个基于表单的登录页面，并提供默认的用户名和密码。
- **spring - boot - starter - test**：主要用于项目测试，包含了 JUnit、Hamcrest、Mockito 以及 spring - test 模块等，方便编写单元测试和集成测试。
- **spring - boot - starter - quartz**：若项目需要定时任务功能，可添加此依赖，用于整合 Quartz 定时任务框架，方便定义和管理定时任务。
- **spring - boot - starter - mail**：支持 `javax.mail` 模块，可便捷地发送邮件，常用于实现系统的邮件通知等功能。
- **mybatis - spring - boot - starter**：如果项目使用 MyBatis 作为持久层框架，可添加该依赖，用于整合 MyBatis 和 Spring Boot，方便配置和使用 MyBatis。

22、如何自定义实现一个starter？
> 答案：自定义实现一个Spring Boot Starter通常可按以下步骤进行：
1. **创建Maven项目**：创建一个新的Maven项目，作为Starter的载体。项目命名可遵循`<项目名>-spring-boot-starter`的格式，以便与官方Starter区分。
2. **添加依赖**：在`pom.xml`文件中添加必要的依赖。通常需要继承`spring - boot - starter - parent`，并添加`spring - boot - starter`依赖，例如：
```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.7.5</version>
    <relativePath/> <!-- lookup parent from repository -->
</parent>
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter</artifactId>
    </dependency>
    <!-- 其他所需的依赖 -->
</dependencies>
```
3. **定义配置属性**：创建一个Java类，使用`@ConfigurationProperties`注解来定义Starter可使用的配置属性。例如：
```java
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "my.starter")
public class MyStarterProperties {
    private String property1;
    private boolean property2;
    // getters and setters
}
```
4. **创建自动配置类**：创建一个自动配置类，该类用`@Configuration`注解标注，并结合`@ConditionalOnClass`等条件注解，确保只有在满足某些条件时才应用配置。同时，通过`@EnableConfigurationProperties`引入之前定义的配置属性类，例如：
```java
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(MyStarterProperties.class)
@ConditionalOnClass(MyService.class)
public class MyStarterAutoConfiguration {
    private final MyStarterProperties properties;

    public MyStarterAutoConfiguration(MyStarterProperties properties) {
        this.properties = properties;
    }

    @Bean
    @ConditionalOnMissingBean
    public MyService myService() {
        return new MyServiceImpl(properties);
    }
}
```
5. **注册自动配置类**：为让Spring Boot能发现自动配置类，需在`src/main/resources/META-INF/spring.factories`文件中添加记录，内容如下：
```properties
org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
com.example.my.starter.MyStarterAutoConfiguration
```
6. **打包和发布**：将Starter打包成JAR文件，可使用`mvn clean package`命令。若需供其他项目使用，可将其发布到私有仓库或Maven中央仓库。
7. **使用自定义Starter**：其他Spring Boot项目可通过添加Maven依赖来使用自定义Starter，例如：
```xml
<dependency>
    <groupId>com.example</groupId>
    <artifactId>my - starter</artifactId>
    <version>1.0.0</version>
</dependency>
```
同时，可在`application.properties`或`application.yml`中配置相应属性，如：
```properties
my.starter.property1=value1
my.starter.property2=true
```



#### spring 与 spring boot 的区别
> 答案:Spring 和 Spring Boot 并非对立关系，Spring Boot 是基于 Spring 框架的扩展和简化，两者的核心区别主要体现在设计目标、使用方式和功能定位上，具体如下：


### 1. **设计目标不同**
- **Spring**：是一个全面的企业级开发框架，核心是 IoC（控制反转）和 AOP（面向切面编程），提供了丰富的模块（如 Spring Core、Spring MVC、Spring JDBC 等），旨在解决企业级应用开发中的复杂性（如依赖管理、事务控制等）。但其配置繁琐，需要手动整合各种模块和第三方库。
- **Spring Boot**：目标是“简化 Spring 应用开发”，通过“自动配置”“ Starter 依赖”等机制，消除 Spring 应用中重复的手动配置，让开发者能够快速搭建和运行 Spring 应用，专注于业务逻辑而非框架配置。


### 2. **配置方式不同**
- **Spring**：依赖大量 XML 配置或注解 + XML 混合配置，例如：
  - 定义 Bean 需要在 XML 中编写 `<bean>` 标签；
  - 整合 Spring MVC 需配置 `DispatcherServlet`、视图解析器等；
  - 数据源、事务管理等均需手动配置。
- **Spring Boot**：采用“约定优于配置”原则，默认零 XML 配置，主要通过以下方式简化配置：
  - **自动配置**：根据类路径中的依赖（如引入 `spring-boot-starter-web` 会自动配置 Tomcat、Spring MVC 等）；
  - **注解驱动**：使用 `@SpringBootApplication` 一键开启自动配置和包扫描；
  - **外部化配置**：通过 `application.properties` 或 `application.yml` 集中管理配置（如端口、数据源等）。


### 3. **依赖管理不同**
- **Spring**：需要手动引入各个模块的依赖，并严格控制版本兼容性（例如 Spring Core、Spring MVC、Spring JDBC 需保持版本一致），否则可能出现冲突。
- **Spring Boot**：通过 **Starter 依赖** 简化依赖管理，例如：
  - 引入 `spring-boot-starter-web` 会自动包含 Spring MVC、Tomcat、Jackson 等相关依赖；
  - 基于 `spring-boot-starter-parent` 统一管理依赖版本，无需手动指定版本号，避免版本冲突。


### 4. **部署方式不同**
- **Spring**：传统 Spring 应用需打包为 WAR 文件，部署到外部 Web 容器（如 Tomcat、Jetty）中运行。
- **Spring Boot**：默认支持 **嵌入式服务器**（Tomcat、Jetty 等），应用可打包为可执行 JAR 文件，直接通过 `java -jar` 命令运行，无需外部容器，简化部署流程。


### 5. **功能定位不同**
- **Spring**：是基础框架，提供了核心的 IoC、AOP 等功能，以及丰富的扩展模块（如 Spring Security、Spring Data 等），适用于构建复杂的企业级应用，但需要手动整合各模块。
- **Spring Boot**：不是对 Spring 功能的增强，而是对 Spring 开发流程的“简化工具”，内置了 Spring 的核心功能，并提供了自动配置、生产就绪特性（如监控、健康检查）等，更适合快速开发独立运行的应用（尤其是微服务）。


### 总结
- **Spring 是基础**：提供核心功能，是 Spring Boot 的底层依赖。
- **Spring Boot 是简化工具**：基于 Spring，通过自动配置和 Starter 依赖减少开发工作量，让 Spring 应用更易于创建和运行。

简单来说：**使用 Spring 开发需要“手动搭骨架”，而 Spring Boot 则是“自动搭好骨架，开发者只需填肉”**。