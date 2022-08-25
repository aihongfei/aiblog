const blog = {
  content: "# Spring Boot开发小而美的个人博客\n" +
    "\n" +
    ">  作者：李仁密\n" +
    "\n" +
    "\n" +
    "\n" +
    "**个人博客功能：**\n" +
    "\n" +
    "**技术组合：**\n" +
    "\n" +
    "*  后端：Spring Boot + JPA + thymeleaf模板\n" +
    "*  数据库：MySQL\n" +
    "*  前端UI：Semantic UI框架\n" +
    "\n" +
    "**工具与环境：**\n" +
    "\n" +
    "*  IDEA\n" +
    "*  Maven 3\n" +
    "*  JDK 8\n" +
    "*  Axure RP 8\n" +
    "\n" +
    "**课程内容模块：**\n" +
    "\n" +
    "*  需求分析与功能规划\n" +
    "*  页面设计与开发\n" +
    "*  技术框架搭建\n" +
    "*  后端管理功能实现\n" +
    "*  前端管理功能实现\n" +
    "\n" +
    "**你能学得什么？**\n" +
    "\n" +
    "*  基于Spring Boot的完整全栈式的开发套路\n" +
    "*  Semantic UI框架的使用\n" +
    "*  一套博客系统的源代码与设计\n" +
    "\n" +
    "## 1、需求与功能\n" +
    "\n" +
    "### 1.1 用户故事\n" +
    "\n" +
    "用户故事是敏捷框架中的一种开发方法。可以帮助开发者转换视角，以用户的角度更好的把握需求，从而实现具有商业价值的功能。\n" +
    "\n" +
    ">  用户故事最好是用户团队编写\n" +
    "\n" +
    "**用户故事模板**：\n" +
    "\n" +
    "-  As a (role of user), I want (some feature) so that (some business value).\n" +
    "-  作为一个(某个角色) 使用者，我可以做(某个功能) 事情，如此可以有(某个商业价值) 的好处\n" +
    "\n" +
    "**关键点**：角色、功能、商业价值\n" +
    "\n" +
    "**举例**：\n" +
    "\n" +
    "-  作为一个招聘网站**注册用户**，我想**查看最近3天发布的招聘信息**，以便于**了解最新的招聘信息**。\n" +
    "-  作为公司，可以张贴新工作。\n" +
    "\n" +
    "\n" +
    "\n" +
    "个人博客系统的用户故事：\n" +
    "\n" +
    "角色：**普通访客**，**管理员（我）**\n" +
    "\n" +
    "*  访客，可以分页查看所有的博客\n" +
    "*  访客，可以快速查看博客数最多的6个分类\n" +
    "*  访客，可以查看所有的分类\n" +
    "*  访客，可以查看某个分类下的博客列表\n" +
    "*  访客，可以快速查看标记博客最多的10个标签\n" +
    "*  访客，可以查看所有的标签\n" +
    "*  访客，可以查看某个标签下的博客列表\n" +
    "*  访客，可以根据年度时间线查看博客列表\n" +
    "*  访客，可以快速查看最新的推荐博客\n" +
    "*  访客，可以用关键字全局搜索博客\n" +
    "*  访客，可以查看单个博客内容\n" +
    "*  访客，可以对博客内容进行评论\n" +
    "*  访客，可以赞赏博客内容\n" +
    "*  访客，可以微信扫码阅读博客内容\n" +
    "*  访客，可以在首页扫描公众号二维码关注我\n" +
    "*  我，可以用户名和密码登录后台管理\n" +
    "*  我，可以管理博客\n" +
    "   *  我，可以发布新博客\n" +
    "   *  我，可以对博客进行分类\n" +
    "   *  我，可以对博客打标签\n" +
    "   *  我，可以修改博客\n" +
    "   *  我，可以删除博客\n" +
    "   *  我，可以根据标题，分类，标签查询博客\n" +
    "*  我，可以管理博客分类\n" +
    "   *  我，可以新增一个分类\n" +
    "   *  我，可以修改一个分类\n" +
    "   *  我，可以删除一个分类\n" +
    "   *  我，可以根据分类名称查询分类\n" +
    "*  我，可以管理标签\n" +
    "   *  我，可以新增一个标签\n" +
    "   *  我，可以修改一个标签\n" +
    "   *  我，可以删除一个标签\n" +
    "   *  我，可以根据名称查询标签\n" +
    "\n" +
    "### 1.2 功能规划\n" +
    "\n" +
    "\n" +
    "## 2、页面设计与开发\n" +
    "\n" +
    "### 2.1 设计\n" +
    "\n" +
    "**页面规划：**\n" +
    "\n" +
    "前端展示：首页、详情页、分类、标签、归档、关于我\n" +
    "\n" +
    "后台管理：模板页\n" +
    "\n" +
    "### 2.2 页面开发\n" +
    "\n" +
    "\n" +
    "\n" +
    "[Semantic UI官网](https://semantic-ui.com/)\n" +
    "\n" +
    "[Semantic UI中文官网](http://www.semantic-ui.cn/)\n" +
    "\n" +
    "[WebStorm下载与破解](https://imcoding.me/blogs/5)\n" +
    "\n" +
    "[背景图片资源](https://www.toptal.com/designers/subtlepatterns/)\n" +
    "\n" +
    "### 2.3 插件集成\n" +
    "\n" +
    "\n" +
    "\n" +
    "[编辑器 Markdown](https://pandao.github.io/editor.md/)\n" +
    "\n" +
    "[内容排版 typo.css](https://github.com/sofish/typo.css)\n" +
    "\n" +
    "[动画 animate.css](https://daneden.github.io/animate.css/)\n" +
    "\n" +
    "[代码高亮 prism](https://github.com/PrismJS/prism)\n" +
    "\n" +
    "[目录生成 Tocbot](https://tscanlin.github.io/tocbot/)\n" +
    "\n" +
    "[滚动侦测 waypoints](http://imakewebthings.com/waypoints/)\n" +
    "\n" +
    "[平滑滚动 jquery.scrollTo](https://github.com/flesler/jquery.scrollTo)\n" +
    "\n" +
    "[二维码生成 qrcode.js](https://davidshimjs.github.io/qrcodejs/)\n" +
    "\n" +
    "## 3、框架搭建\n" +
    "\n" +
    ">  [IDEA下载 https://www.jetbrains.com/idea/](https://www.jetbrains.com/idea/)\n" +
    "\n" +
    "### 3.1 构建与配置\n" +
    "\n" +
    "**1、引入Spring Boot模块：**\n" +
    "\n" +
    "*  web\n" +
    "*  Thymeleaf\n" +
    "*  JPA\n" +
    "*  MySQL\n" +
    "*  Aspects\n" +
    "*  DevTools\n" +
    "\n" +
    "**2、application.yml配置**\n" +
    "\n" +
    "*  使用 thymeleaf 3\n" +
    "\n" +
    "   pom.xml:\n" +
    "\n" +
    "```xml\n" +
    "<thymeleaf.version>3.0.2.RELEASE</thymeleaf.version>\n" +
    "<thymeleaf-layout-dialect.version>2.1.1</thymeleaf-layout-dialect.version>\n" +
    "```\n" +
    "\n" +
    "\n" +
    "  \tapplication.yml:\n" +
    "\n" +
    "```yaml\n" +
    "spring:\n" +
    "  thymeleaf:\n" +
    "    mode: HTML\n" +
    "```\n" +
    "\n" +
    "*  数据库连接配置\n" +
    "\n" +
    "```yaml\n" +
    "spring:\n" +
    "  datasource:\n" +
    "    driver-class-name: com.mysql.jdbc.Driver\n" +
    "    url: jdbc:mysql://localhost:3306/blog?useUnicode=true&characterEncoding=utf-8\n" +
    "    username: root\n" +
    "    password: root\n" +
    "  jpa:\n" +
    "    hibernate:\n" +
    "      ddl-auto: update\n" +
    "    show-sql: true\n" +
    "```\n" +
    "\n" +
    "*  日志配置\n" +
    "\n" +
    "   application.yml:\n" +
    "\n" +
    "```yaml\n" +
    "logging:\n" +
    "  level:\n" +
    "    root: info\n" +
    "    com.imcoding: debug\n" +
    "  file: log/imcoding.log\n" +
    "```\n" +
    "\n" +
    "​\tlogback-spring.xml：\n" +
    "\n" +
    "```xml\n" +
    "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
    "<configuration>\n" +
    "    <!--包含Spring boot对logback日志的默认配置-->\n" +
    "    <include resource=\"org/springframework/boot/logging/logback/defaults.xml\" />\n" +
    "    <property name=\"LOG_FILE\" value=\"${LOG_FILE:-${LOG_PATH:-${LOG_TEMP:-${java.io.tmpdir:-/tmp}}}/spring.log}\"/>\n" +
    "    <include resource=\"org/springframework/boot/logging/logback/console-appender.xml\" />\n" +
    "\n" +
    "    <!--重写了Spring Boot框架 org/springframework/boot/logging/logback/file-appender.xml 配置-->\n" +
    "    <appender name=\"TIME_FILE\"\n" +
    "              class=\"ch.qos.logback.core.rolling.RollingFileAppender\">\n" +
    "        <encoder>\n" +
    "            <pattern>${FILE_LOG_PATTERN}</pattern>\n" +
    "        </encoder>\n" +
    "        <file>${LOG_FILE}</file>\n" +
    "        <rollingPolicy class=\"ch.qos.logback.core.rolling.TimeBasedRollingPolicy\">\n" +
    "            <fileNamePattern>${LOG_FILE}.%d{yyyy-MM-dd}.%i</fileNamePattern>\n" +
    "            <!--保留历史日志一个月的时间-->\n" +
    "            <maxHistory>30</maxHistory>\n" +
    "            <!--\n" +
    "            Spring Boot默认情况下，日志文件10M时，会切分日志文件,这样设置日志文件会在100M时切分日志\n" +
    "            -->\n" +
    "            <timeBasedFileNamingAndTriggeringPolicy class=\"ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP\">\n" +
    "                <maxFileSize>10MB</maxFileSize>\n" +
    "            </timeBasedFileNamingAndTriggeringPolicy>\n" +
    "\n" +
    "        </rollingPolicy>\n" +
    "    </appender>\n" +
    "\n" +
    "    <root level=\"INFO\">\n" +
    "        <appender-ref ref=\"CONSOLE\" />\n" +
    "        <appender-ref ref=\"TIME_FILE\" />\n" +
    "    </root>\n" +
    "\n" +
    "</configuration>\n" +
    "<!--\n" +
    "    1、继承Spring boot logback设置（可以在appliaction.yml或者application.properties设置logging.*属性）\n" +
    "    2、重写了默认配置，设置日志文件大小在100MB时，按日期切分日志，切分后目录：\n" +
    "\n" +
    "        my.2017-08-01.0   80MB\n" +
    "        my.2017-08-01.1   10MB\n" +
    "        my.2017-08-02.0   56MB\n" +
    "        my.2017-08-03.0   53MB\n" +
    "        ......\n" +
    "-->\n" +
    "```\n" +
    "\n" +
    "*  生产环境与开发环境配置\n" +
    "   *  application-dev.yml\n" +
    "   *  application-pro.yml\n" +
    "\n" +
    "### 3.2 异常处理\n" +
    "\n" +
    "**1、定义错误页面**\n" +
    "\n" +
    "*  404\n" +
    "*  500\n" +
    "*  error\n" +
    "\n" +
    "**2、全局处理异常**\n" +
    "\n" +
    "统一处理异常：\n" +
    "\n" +
    "```java\n" +
    "@ControllerAdvice\n" +
    "public class ControllerExceptionHandler {\n" +
    "\n" +
    "    private final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);\n" +
    "    /**\n" +
    "     * 异常处理\n" +
    "     * @param request\n" +
    "     * @param e\n" +
    "     * @return\n" +
    "     */\n" +
    "    @ExceptionHandler({Exception.class})\n" +
    "    public ModelAndView handleException(HttpServletRequest request, Exception e) throws Exception {\n" +
    "\n" +
    "        logger.error(\"Request URL : {} , Exception : {}\", request.getRequestURL(), e);\n" +
    "\n" +
    "        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {\n" +
    "            throw e;\n" +
    "        }\n" +
    "        ModelAndView mav = new ModelAndView();\n" +
    "        mav.addObject(\"url\", request.getRequestURL());\n" +
    "        mav.addObject(\"exception\", e);\n" +
    "        mav.setViewName(\"error/error\");\n" +
    "\n" +
    "        return mav;\n" +
    "    }\n" +
    "}\n" +
    "```\n" +
    "\n" +
    "\n" +
    "\n" +
    "错误页面异常信息显示处理：\n" +
    "\n" +
    "```html\n" +
    "<div>\n" +
    "    <div th:utext=\"'&lt;!--'\" th:remove=\"tag\"></div>\n" +
    "    <div th:utext=\"'Failed Request URL : ' + ${url}\" th:remove=\"tag\"></div>\n" +
    "    <div th:utext=\"'Exception message : ' + ${exception.message}\" th:remove=\"tag\"></div>\n" +
    "    <ul th:remove=\"tag\">\n" +
    "        <li th:each=\"st : ${exception.stackTrace}\" th:remove=\"tag\"><span th:utext=\"${st}\" th:remove=\"tag\"></span></li>\n" +
    "    </ul>\n" +
    "    <div th:utext=\"'--&gt;'\" th:remove=\"tag\"></div>\n" +
    "</div>\n" +
    "```\n" +
    "\n" +
    "\n" +
    "\n" +
    "**3、资源找不到异常**\n" +
    "\n" +
    "```java\n" +
    "@ResponseStatus(HttpStatus.NOT_FOUND)\n" +
    "public class NotFoundExcepiton extends RuntimeException {\n" +
    "\n" +
    "    public NotFoundExcepiton() {\n" +
    "    }\n" +
    "\n" +
    "    public NotFoundExcepiton(String message) {\n" +
    "        super(message);\n" +
    "    }\n" +
    "\n" +
    "    public NotFoundExcepiton(String message, Throwable cause) {\n" +
    "        super(message, cause);\n" +
    "    }\n" +
    "}\n" +
    "```\n" +
    "\n" +
    "\n" +
    "\n" +
    "### 3.3 日志处理\n" +
    "\n" +
    "**1、记录日志内容**\n" +
    "\n" +
    "*  请求 url\n" +
    "*  访问者 ip\n" +
    "*  调用方法 classMethod\n" +
    "*  参数 args\n" +
    "*  返回内容\n" +
    "\n" +
    "**2、记录日志类：**\n" +
    "\n" +
    "```java\n" +
    "@Aspect\n" +
    "@Component\n" +
    "public class LogAspect {\n" +
    "\n" +
    "    private final Logger logger = LoggerFactory.getLogger(this.getClass());\n" +
    "\n" +
    "    /**\n" +
    "     * 定义切面\n" +
    "     */\n" +
    "    @Pointcut(\"execution(* com.imcoding.web.*.*(..))\")\n" +
    "    public void log() {\n" +
    "    }\n" +
    "\n" +
    "    @Before(\"log()\")\n" +
    "    public void doBefore(JoinPoint joinPoint) {\n" +
    "        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();\n" +
    "        HttpServletRequest request = attributes.getRequest();\n" +
    "        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + \".\" + joinPoint.getSignature().getName();\n" +
    "        ReqeustLog reqeustLog = new ReqeustLog(\n" +
    "                request.getRequestURL().toString(),\n" +
    "                request.getRemoteAddr(),\n" +
    "                classMethod,\n" +
    "                joinPoint.getArgs()\n" +
    "        );\n" +
    "        logger.info(\"Rquest  ----- {}\",reqeustLog);\n" +
    "    }\n" +
    "\n" +
    "    @After(\"log()\")\n" +
    "    public void doAfter() {\n" +
    "        //logger.info(\"---------- doAfter 2 ----------\");\n" +
    "    }\n" +
    "\n" +
    "    @AfterReturning(returning = \"result\",pointcut = \"log()\")\n" +
    "    public void doAtfertRturning(Object result) {\n" +
    "        logger.info(\"Return ------ {}\",result );\n" +
    "    }\n" +
    "\n" +
    "\n" +
    "    private class ReqeustLog {\n" +
    "        private String url;\n" +
    "        private String ip;\n" +
    "        private String classMethod;\n" +
    "        private Object[] args;\n" +
    "\n" +
    "        public ReqeustLog(String url, String ip, String classMethod, Object[] args) {\n" +
    "            this.url = url;\n" +
    "            this.ip = ip;\n" +
    "            this.classMethod = classMethod;\n" +
    "            this.args = args;\n" +
    "        }\n" +
    "\n" +
    "        @Override\n" +
    "        public String toString() {\n" +
    "            return \"ReqeustLog{\" +\n" +
    "                    \"url='\" + url + '\\'' +\n" +
    "                    \", ip='\" + ip + '\\'' +\n" +
    "                    \", classMethod='\" + classMethod + '\\'' +\n" +
    "                    \", args=\" + Arrays.toString(args) +\n" +
    "                    '}';\n" +
    "        }\n" +
    "    }\n" +
    "\n" +
    "}\n" +
    "```\n" +
    "\n" +
    "\n" +
    "\n" +
    "### 3.4 页面处理\n" +
    "\n" +
    "\n" +
    "\n" +
    "**1、静态页面导入project**\n" +
    "\n" +
    "**2、thymeleaf布局**\n" +
    "\n" +
    "*  定义fragment\n" +
    "*  使用fragment布局\n" +
    "\n" +
    "**3、错误页面美化**\n" +
    "\n" +
    "4、设计与规范\n" +
    "\n" +
    "### 4.1 实体设计\n" +
    "\n" +
    "**实体类：**\n" +
    "\n" +
    "*  博客 Blog\n" +
    "*  博客分类 Type\n" +
    "*  博客标签 Tag\n" +
    "*  博客评论 Comment\n" +
    "*  用户 User\n" +
    "\n" +
    "\n" +
    "\n" +
    "**实体关系：**\n" +
    "\n" +
    "**评论类自关联关系：**\n" +
    "\n" +
    "**Blog类：**\n" +
    "\n" +
    "**Type类：**\n" +
    "\n" +
    "**Tag类：**\n" +
    "\n" +
    "**Comment类：**\n" +
    "\n" +
    "**User类：**\n" +
    "\n" +
    "### 4.2 应用分层\n" +
    "\n" +
    "### 4.3 命名约定\n" +
    "\n" +
    "**Service/DAO层命名约定：**\n" +
    "\n" +
    "*  获取单个对象的方法用get做前缀。\n" +
    "*  获取多个对象的方法用list做前缀。\n" +
    "*  获取统计值的方法用count做前缀。\n" +
    "*  插入的方法用save(推荐)或insert做前缀。\n" +
    "*  删除的方法用remove(推荐)或delete做前缀。\n" +
    "*  修改的方法用update做前缀。\n" +
    "\n" +
    "\n" +
    "\n" +
    "## 5、后台管理功能实现\n" +
    "\n" +
    "### 5.1 登录\n" +
    "\n" +
    "\n" +
    "\n" +
    "**1、构建登录页面和后台管理首页**\n" +
    "\n" +
    "**2、UserService和UserRepository**\n" +
    "\n" +
    "**3、LoginController实现登录**\n" +
    "\n" +
    "**4、MD5加密**\n" +
    "\n" +
    "**5、登录拦截器**\n" +
    "\n" +
    "### 5.2 分类管理\n" +
    "\n" +
    "\n" +
    "\n" +
    "**1、分类管理页面**\n" +
    "\n" +
    "**2、分类列表分页**\n" +
    "\n" +
    "````javascript\n" +
    "{\n" +
    "  \"content\":[\n" +
    "    {\"id\":123,\"title\":\"blog122\",\"content\":\"this is blog content\"},\n" +
    "    {\"id\":122,\"title\":\"blog121\",\"content\":\"this is blog content\"},\n" +
    "    {\"id\":121,\"title\":\"blog120\",\"content\":\"this is blog content\"},\n" +
    "    {\"id\":120,\"title\":\"blog119\",\"content\":\"this is blog content\"},\n" +
    "    {\"id\":119,\"title\":\"blog118\",\"content\":\"this is blog content\"},\n" +
    "    {\"id\":118,\"title\":\"blog117\",\"content\":\"this is blog content\"},\n" +
    "    {\"id\":117,\"title\":\"blog116\",\"content\":\"this is blog content\"},\n" +
    "    {\"id\":116,\"title\":\"blog115\",\"content\":\"this is blog content\"},\n" +
    "    {\"id\":115,\"title\":\"blog114\",\"content\":\"this is blog content\"},\n" +
    "    {\"id\":114,\"title\":\"blog113\",\"content\":\"this is blog content\"},\n" +
    "    {\"id\":113,\"title\":\"blog112\",\"content\":\"this is blog content\"},\n" +
    "    {\"id\":112,\"title\":\"blog111\",\"content\":\"this is blog content\"},\n" +
    "    {\"id\":111,\"title\":\"blog110\",\"content\":\"this is blog content\"},\n" +
    "    {\"id\":110,\"title\":\"blog109\",\"content\":\"this is blog content\"},\n" +
    "    {\"id\":109,\"title\":\"blog108\",\"content\":\"this is blog content\"}],\n" +
    "  \"last\":false,\n" +
    "  \"totalPages\":9,\n" +
    "  \"totalElements\":123,\n" +
    "  \"size\":15,\n" +
    "  \"number\":0,\n" +
    "  \"first\":true,\n" +
    "  \"sort\":[{\n" +
    "    \"direction\":\"DESC\",\n" +
    "    \"property\":\"id\",\n" +
    "    \"ignoreCase\":false,\n" +
    "    \"nullHandling\":\"NATIVE\",\n" +
    "    \"ascending\":false\n" +
    "  }],\n" +
    "  \"numberOfElements\":15\n" +
    "}\n" +
    "````\n" +
    "\n" +
    "\n" +
    "\n" +
    "**3、分类新增、修改、删除**\n" +
    "\n" +
    "### 5.3 标签管理\n" +
    "\n" +
    "### 5.4 博客管理\n" +
    "\n" +
    "\n" +
    "\n" +
    "**1、博客分页查询**\n" +
    "\n" +
    "**2、博客新增**\n" +
    "\n" +
    "**3、博客修改**\n" +
    "\n" +
    "**4、博客删除**\n" +
    "\n" +
    "## 6、前端展示功能实现\n" +
    "\n" +
    "### 6.1 首页展示\n" +
    "\n" +
    "\n" +
    "\n" +
    "**1、博客列表**\n" +
    "\n" +
    "**2、top分类**\n" +
    "\n" +
    "**3、top标签**\n" +
    "\n" +
    "**4、最新博客推荐**\n" +
    "\n" +
    "**5、博客详情**\n" +
    "\n" +
    "**1、Markdown 转换 HTML**\n" +
    "\n" +
    "*  [commonmark-java  https://github.com/atlassian/commonmark-java](https://github.com/atlassian/commonmark-java)\n" +
    "*  pom.xml引用commonmark和扩展插件\n" +
    "\n" +
    "```xml\n" +
    "<dependency>\n" +
    "   <groupId>com.atlassian.commonmark</groupId>\n" +
    "   <artifactId>commonmark</artifactId>\n" +
    "   <version>0.10.0</version>\n" +
    "</dependency>\n" +
    "<dependency>\n" +
    "   <groupId>com.atlassian.commonmark</groupId>\n" +
    "   <artifactId>commonmark-ext-heading-anchor</artifactId>\n" +
    "   <version>0.10.0</version>\n" +
    "</dependency>\n" +
    "<dependency>\n" +
    "   <groupId>com.atlassian.commonmark</groupId>\n" +
    "   <artifactId>commonmark-ext-gfm-tables</artifactId>\n" +
    "   <version>0.10.0</version>\n" +
    "</dependency>\n" +
    "```\n" +
    "\n" +
    "\n" +
    "\n" +
    "**2、评论功能**\n" +
    "\n" +
    "\n" +
    "\n" +
    "*  评论信息提交与回复功能\n" +
    "*  评论信息列表展示功能\n" +
    "*  管理员回复评论功能\n" +
    "\n" +
    "\n" +
    "### 6.2 分类页\n" +
    "\n" +
    "### 6.3 标签页\n" +
    "\n" +
    "### 6.4 归档页\n" +
    "\n" +
    "### 6.5 关于我\n" +
    "\n" +
    "\n" +
    "\n" +
    "\n" +
    "\n"
}

const comment = [{
  id: 1,
  nick: "繁华落幕1",
  content: "测试一下啊 哈哈哈哈哈哈哈啊哈",
  replyId: 2,
  replyBtn: true
},
  {
    id: 2,
    nick: "繁华落幕2",
    content: "测试一下啊 哈哈哈哈哈哈哈啊哈\n" +
      "测试一下啊 哈哈哈哈哈哈哈啊哈\n" +
      "测试一下啊 哈哈哈哈哈哈哈啊哈\n" +
      "测试一下啊 哈哈哈哈哈哈哈啊哈",
    replyId: null,
    replyBtn: true
  }, {
    id: 3,
    nick: "繁华落幕3",
    content: "测试一下啊 哈哈哈哈哈哈哈啊哈",
    replyId: 1,
    replyBtn: true
  }, {
    id: 4,
    nick: "繁华落幕4",
    content: "测试一下啊 哈哈哈哈哈哈哈啊哈",
    replyId: 3,
    replyBtn: true
  }]
export {
  blog, comment
}
