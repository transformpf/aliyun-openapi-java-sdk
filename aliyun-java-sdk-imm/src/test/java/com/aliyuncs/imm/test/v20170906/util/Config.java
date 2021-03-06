/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.aliyuncs.imm.test.v20170906.util;

import java.io.File;
import java.util.Properties;

/**
 * Created by guangchun.luo on 15/4/16.
 */
public class Config {
    Properties prop = new Properties();
    private Config() {

        String homestr = System.getProperty("user.home");

        String[] arr = new String[]{
                homestr + File.separator + ".aliyun-java-sdk-imm-test.properties",
                "resources/config_test.properties",
                "resources/config.properties"
        };

        prop = FileLoader.loadProperties(arr);

        regionId = (String) prop.get("regionId");
        accessKeyId = (String) prop.get("accessKeyId");
        accessKeySecret = (String) prop.get("accessKeySecret");
    }

    private static Config config;

    public static Config getInstance() {
        if (null == config) {
            config = new Config();
        }
        return config;
    }

    public String getRegionId() {
        return regionId;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }


    public String get(String key) {
        return (String) prop.get(key);
    }

    private String regionId;
    private String accessKeyId;
    private String accessKeySecret;

}
