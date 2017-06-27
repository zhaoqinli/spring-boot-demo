package com.example.container;

import java.io.File;
import java.nio.charset.Charset;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * tomcat配置
 * 通过addAdditionalTomcatConnectors方法添加多个监听连接;此时可以通过http 8010端口，https 8443端口。
 */
//@Configuration
public class TomcatConfig {
	@Bean
	public EmbeddedServletContainerFactory servletContainer(){
		TomcatEmbeddedServletContainerFactory tomcat=new TomcatEmbeddedServletContainerFactory();
		tomcat.setUriEncoding(Charset.forName("UTF-8"));
		tomcat.addAdditionalTomcatConnectors(createSslConnector());
		return tomcat;
	}
	private Connector createSslConnector(){
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
        try {
            File truststore = new File("D:/users/server.keystore");
            connector.setScheme("https");
            protocol.setSSLEnabled(true);
            connector.setSecure(true);
            connector.setPort(8443);
            protocol.setKeystoreFile(truststore.getAbsolutePath());
            protocol.setKeystorePass("123456");
            protocol.setKeyAlias("springboot");
            return connector;
        } catch (Exception ex) {
            throw new IllegalStateException("cant access keystore: [" + "keystore" + "]  ", ex);
        }
	}
}
