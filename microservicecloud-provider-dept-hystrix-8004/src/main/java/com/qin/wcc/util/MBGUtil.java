package com.qin.wcc.util;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Description: mybatis逆向工程生成
 * @author: Qin YunFei
 * @date: 2017年10月22日 下午12:27:13
 * @version V1.0
 */
public class MBGUtil {


    public static void main(String[] args) throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config =
                cp.parseConfiguration(Thread.currentThread().getContextClassLoader().getResourceAsStream("mybatis/generatorConfig.xml"));
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);

        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);

        for(String warning : warnings) {
            System.out.println(warning);
        }

    }

}
