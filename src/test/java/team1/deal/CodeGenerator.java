package team1.deal;

        import com.baomidou.mybatisplus.annotation.IdType;
        import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
        import com.baomidou.mybatisplus.core.toolkit.StringUtils;
        import com.baomidou.mybatisplus.generator.AutoGenerator;
        import com.baomidou.mybatisplus.generator.config.*;
        import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
        import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

        import java.util.HashMap;
        import java.util.Map;
        import java.util.Scanner;

public class CodeGenerator {
    public static void main(String[] args) {
        //代码生成器
        AutoGenerator mpg =new AutoGenerator();

        //全局配置
        GlobalConfig globalConfig=new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        globalConfig.setOutputDir(projectPath + "/src/main/java");
        globalConfig
                .setAuthor("team1")              //开发人员
                .setSwagger2(true)              //生成api文档注解
                .setOpen(false)                 //是否打开输出目录
                .setFileOverride(false)         //是否覆盖已有文件，默认false
                .setIdType(IdType.AUTO)         //指定生成的主键ID类型,IdType,Auto为数据库ID自增
                .setBaseResultMap(true)         //不晓得啥子意思
                .setEntityName("%sPO")          //实体命名方式，例如：%sEntity 生成 UserEntity
                .setMapperName("%sMapper")      //mapper命名方式
                .setServiceName("%sService");   //service命名方式
        mpg.setGlobalConfig(globalConfig);

        //数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig
                .setUsername("chenli")
                .setPassword("190014")
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUrl("jdbc:mysql://localhost:3306/deal?useSSL=false&characterEncoding=utf8&serverTimezone=Asia/Shanghai");
        mpg.setDataSource(dataSourceConfig);

        //包名设置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig
                .setParent("team1.deal")      //父包名。如果为空，将下面子包名必须写全部， 否则就只需写子包名
                .setPathInfo(getPathInfo())         //路径配置信息,只有里面设置了的包名生效其他设置例如setController就不会生效
                .setEntity("model.po")
                .setMapper("mapper")
                .setXml("xml");
        mpg.setPackageInfo(packageConfig);

        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();  //数据库表配置，通过该配置，可指定需要生成哪些表或者排除哪些表
        strategyConfig
                .setNaming(NamingStrategy.underline_to_camel)       //数据库表映射到实体的命名策略
                .setEntitySerialVersionUID(false)                   //猜测为设置序列版本UID
                .setEntityLombokModel(true)                         //实体是否为lombok模型
                .setRestControllerStyle(true)                       //生成@RestController
                .setInclude(scanner("表名，多个英文逗号分割").split(","))//需要包含的表名
                .setControllerMappingHyphenStyle(true); //@RequestMapping("/managerUserActionHistory")---@RequestMapping("/manager-user-action-history")            //驼峰转连字符  不清楚是否正确 例：如 umps_user 变为 upms/user

        //模板配置(这里并没有用，使用的默认的，默认velocity模板引擎)
        TemplateConfig templateConfig = new TemplateConfig();

        mpg
                .setStrategy(strategyConfig)
                .setTemplate(templateConfig)
                .setTemplateEngine(new VelocityTemplateEngine())
                .execute();
    }

    /**
     * 读取控制台内容
     */
    private static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入" + tip + "：");
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }


    private static Map<String, String> getPathInfo() {
        Map<String, String> pathInfo = new HashMap<>();
        pathInfo.put(ConstVal.ENTITY_PATH, System.getProperty("user.dir") + "/src/main/java/team1/deal/model/po");        //System.getProperty("user.dir")用户当前工作目录
        pathInfo.put(ConstVal.MAPPER_PATH, System.getProperty("user.dir") + "/src/main/java/team1/deal/mapper");
        pathInfo.put(ConstVal.SERVICE_PATH, System.getProperty("user.dir") + "/src/main/java/team1/deal/service");
        pathInfo.put(ConstVal.SERVICE_IMPL_PATH, System.getProperty("user.dir") + "/src/main/java/team1/deal/service/impl");
        pathInfo.put(ConstVal.XML_PATH, System.getProperty("user.dir") + "/src/main/resources/mybatis/xml/mapper");
        return pathInfo;
    }
}
