package com.zhanghao.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 *  使用Java运行 MyBatis Generator
 * http://www.mybatis.org/generator/running/runningWithJava.html
 */
public class MybatisGen {

    public static void main(String[] args) throws Exception {
    	Class.forName("com.mysql.jdbc.Driver");
        String fileName = "E:\\developer\\github\\codeRepository\\exam\\exam-auto\\src\\main\\resources\\generatorConfig.xml";
        File configFile = new File(fileName);
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
        System.out.println("ok");
    }
}

