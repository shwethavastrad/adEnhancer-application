package com.svastrad.adEnhancer.config;

import com.maxmind.db.CHMCache;
import com.maxmind.geoip2.DatabaseReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;

@Configuration
@EnableWebSecurity(debug = true)
@ImportResource({"classpath:spring-security-config.xml"})
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public DatabaseReader databaseReader() throws IOException {
        File database = new File("/Users/shwethavastrad/Downloads/adEnhancer/src/main/resources/GeoLite2-Country.mmdb");

        // This creates the DatabaseReader object. To improve performance, reuse
        // the object across lookups. The object is thread-safe.
        return new DatabaseReader.Builder(database).withCache(new CHMCache()).build();
    }

}