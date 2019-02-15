//package com.netcracker.edu.backend.config;
//
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.MapperFeature;
//import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//
//
//@Configuration
//public class LazyLoadingConfiguration {
//    @Bean
//    public MappingJackson2HttpMessageConverter jackson2HttpMessageConverter() {
//        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//        converter.setObjectMapper(this.jacksonBuilder().build());
//
//        return converter;
//    }
//
//    public Jackson2ObjectMapperBuilder jacksonBuilder() {
//        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
//
//        Hibernate5Module hibernateModule = new Hibernate5Module();
//
//        hibernateModule.configure(Hibernate5Module.Feature.FORCE_LAZY_LOADING, false);
//
//        builder.modules(hibernateModule);
//
//        // Spring MVC default Objectmapper config
//        builder.featuresToDisable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//        builder.featuresToDisable(MapperFeature.DEFAULT_VIEW_INCLUSION);
//
//        return builder;
//    }
//}
