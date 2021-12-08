package org.oes.start.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author XuJian
 * @since 2021/12/03
 */
@Configuration
public class Config {

    @Value("${profile.env:unknown}")
    private String env;

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

}
