package com.fxz.demo.config;

/**
 * Created by fuxiaozhi on 2018\8\27 0027.
 */
import java.util.HashMap;
import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.rabbitmq")
public class MQPropConfig {
    private String host;
    private int port;
    private String userName;
    private String password;
    private String virtualHost;
    private Boolean publisherConfirms;
    private int cacheSize;
    private String exDefault;
    private String exDelay;
    private Integer delayTimeDefault;

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(this.host, this.port);
        connectionFactory.setUsername(this.userName);
        connectionFactory.setPassword(this.password);
        connectionFactory.setVirtualHost(this.virtualHost);
        connectionFactory.setChannelCacheSize(this.cacheSize);
        connectionFactory.setPublisherConfirms(this.publisherConfirms.booleanValue());
        return connectionFactory;
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(this.connectionFactory());
        return rabbitTemplate;
    }

    @Bean
    public DirectExchange defaultExchange() {
        return new DirectExchange(this.exDefault, true, false);
    }

    @Bean
    public CustomExchange delayExchange() {
        HashMap args = new HashMap();
        args.put("x-delayed-type", "direct");
        return new CustomExchange("test_exchange", "x-delayed-message", true, false, args);
    }

    public MQPropConfig() {
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        return this.port;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }

    public String getVirtualHost() {
        return this.virtualHost;
    }

    public Boolean getPublisherConfirms() {
        return this.publisherConfirms;
    }

    public int getCacheSize() {
        return this.cacheSize;
    }

    public String getExDefault() {
        return this.exDefault;
    }

    public String getExDelay() {
        return this.exDelay;
    }

    public Integer getDelayTimeDefault() {
        return this.delayTimeDefault;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setVirtualHost(String virtualHost) {
        this.virtualHost = virtualHost;
    }

    public void setPublisherConfirms(Boolean publisherConfirms) {
        this.publisherConfirms = publisherConfirms;
    }

    public void setCacheSize(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    public void setExDefault(String exDefault) {
        this.exDefault = exDefault;
    }

    public void setExDelay(String exDelay) {
        this.exDelay = exDelay;
    }

    public void setDelayTimeDefault(Integer delayTimeDefault) {
        this.delayTimeDefault = delayTimeDefault;
    }

    public boolean equals(Object o) {
        if(o == this) {
            return true;
        } else if(!(o instanceof MQPropConfig)) {
            return false;
        } else {
            MQPropConfig other = (MQPropConfig)o;
            if(!other.canEqual(this)) {
                return false;
            } else {
                String this$host = this.getHost();
                String other$host = other.getHost();
                if(this$host == null) {
                    if(other$host != null) {
                        return false;
                    }
                } else if(!this$host.equals(other$host)) {
                    return false;
                }

                if(this.getPort() != other.getPort()) {
                    return false;
                } else {
                    String this$userName = this.getUserName();
                    String other$userName = other.getUserName();
                    if(this$userName == null) {
                        if(other$userName != null) {
                            return false;
                        }
                    } else if(!this$userName.equals(other$userName)) {
                        return false;
                    }

                    String this$password = this.getPassword();
                    String other$password = other.getPassword();
                    if(this$password == null) {
                        if(other$password != null) {
                            return false;
                        }
                    } else if(!this$password.equals(other$password)) {
                        return false;
                    }

                    label93: {
                        String this$virtualHost = this.getVirtualHost();
                        String other$virtualHost = other.getVirtualHost();
                        if(this$virtualHost == null) {
                            if(other$virtualHost == null) {
                                break label93;
                            }
                        } else if(this$virtualHost.equals(other$virtualHost)) {
                            break label93;
                        }

                        return false;
                    }

                    label86: {
                        Boolean this$publisherConfirm = this.getPublisherConfirms();
                        Boolean other$publisherConfirm = other.getPublisherConfirms();
                        if(this$publisherConfirm == null) {
                            if(other$publisherConfirm == null) {
                                break label86;
                            }
                        } else if(this$publisherConfirm.equals(other$publisherConfirm)) {
                            break label86;
                        }

                        return false;
                    }

                    if(this.getCacheSize() != other.getCacheSize()) {
                        return false;
                    } else {
                        String this$exDefault = this.getExDefault();
                        String other$exDefault = other.getExDefault();
                        if(this$exDefault == null) {
                            if(other$exDefault != null) {
                                return false;
                            }
                        } else if(!this$exDefault.equals(other$exDefault)) {
                            return false;
                        }

                        label71: {
                            String this$exDelay = this.getExDelay();
                            String other$exDelay = other.getExDelay();
                            if(this$exDelay == null) {
                                if(other$exDelay == null) {
                                    break label71;
                                }
                            } else if(this$exDelay.equals(other$exDelay)) {
                                break label71;
                            }

                            return false;
                        }

                        Integer this$delayTimeDefault = this.getDelayTimeDefault();
                        Integer other$delayTimeDefault = other.getDelayTimeDefault();
                        if(this$delayTimeDefault == null) {
                            if(other$delayTimeDefault != null) {
                                return false;
                            }
                        } else if(!this$delayTimeDefault.equals(other$delayTimeDefault)) {
                            return false;
                        }

                        return true;
                    }
                }
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof MQPropConfig;
    }

    public int hashCode() {
        boolean PRIME = true;
        byte result = 1;
        String $host = this.getHost();
        int result1 = result * 59 + ($host == null?43:$host.hashCode());
        result1 = result1 * 59 + this.getPort();
        String $userName = this.getUserName();
        result1 = result1 * 59 + ($userName == null?43:$userName.hashCode());
        String $password = this.getPassword();
        result1 = result1 * 59 + ($password == null?43:$password.hashCode());
        String $virtualHost = this.getVirtualHost();
        result1 = result1 * 59 + ($virtualHost == null?43:$virtualHost.hashCode());
        Boolean $publisherConfirm = this.getPublisherConfirms();
        result1 = result1 * 59 + ($publisherConfirm == null?43:$publisherConfirm.hashCode());
        result1 = result1 * 59 + this.getCacheSize();
        String $exDefault = this.getExDefault();
        result1 = result1 * 59 + ($exDefault == null?43:$exDefault.hashCode());
        String $exDelay = this.getExDelay();
        result1 = result1 * 59 + ($exDelay == null?43:$exDelay.hashCode());
        Integer $delayTimeDefault = this.getDelayTimeDefault();
        result1 = result1 * 59 + ($delayTimeDefault == null?43:$delayTimeDefault.hashCode());
        return result1;
    }

    public String toString() {
        return "MQPropConfig(host=" + this.getHost() + ", port=" + this.getPort() + ", userName=" + this.getUserName() + ", password=" + this.getPassword() + ", virtualHost=" + this.getVirtualHost() + ", publisherConfirm=" + this.getPublisherConfirms() + ", cacheSize=" + this.getCacheSize() + ", exDefault=" + this.getExDefault() + ", exDelay=" + this.getExDelay() + ", delayTimeDefault=" + this.getDelayTimeDefault() + ")";
    }
}
