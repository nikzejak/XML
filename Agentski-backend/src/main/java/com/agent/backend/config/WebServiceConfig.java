package com.agent.backend.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/ws/*");
    }

    @Bean(name = "ourAds")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema adsSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("AdsPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://ftn.uns.ac.rs.tim13");
        wsdl11Definition.setSchema(adsSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema adsSchema() {

        return new SimpleXsdSchema(new ClassPathResource("ad.xsd"));
    }

    @Bean(name = "ourComments")
    public DefaultWsdl11Definition defaultWsdl11Definition2(XsdSchema commentsSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("CommentsPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://ftn.uns.ac.rs.tim13");
        wsdl11Definition.setSchema(commentsSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema commentsSchema() {

        return new SimpleXsdSchema(new ClassPathResource("comment.xsd"));
    }

    @Bean(name = "ourCarBrands")
    public DefaultWsdl11Definition defaultWsdl11Definition3(XsdSchema carBrandsSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("CarBrandsPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://ftn.uns.ac.rs.tim13");
        wsdl11Definition.setSchema(carBrandsSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema carBrandsSchema() {

        return new SimpleXsdSchema(new ClassPathResource("carbrands.xsd"));
    }

    @Bean(name = "ourMessages")
    public DefaultWsdl11Definition defaultWsdl11Definition4(XsdSchema messagesSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("MessagesPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://ftn.uns.ac.rs.tim13");
        wsdl11Definition.setSchema(messagesSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema messagesSchema() {

        return new SimpleXsdSchema(new ClassPathResource("message.xsd"));
    }
}
