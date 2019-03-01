package com.example.springcloudconfigclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CREATED BY L.C.Y on 2019-3-1
 */
@RefreshScope
@RestController
@RequestMapping
public class ConfigClientController {
    @Value("${config-1}")
    private String config1;

    @GetMapping("/config")
    public String getConfigFromRemote() {
        return config1;
    }
}
