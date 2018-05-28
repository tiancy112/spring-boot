package com.samsundot.invoice.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
@Component
@ConfigurationProperties(prefix = "azureblob") 
@PropertySource("classpath:azureblob.properties")
public class StorageConfig {  
    private String defaultEndpointsProtocol;  
    private String blobEndpoint;  
    private String queueEndpoint;  
    private String tableEndpoint;  
    private String accountName;  
    private String accountKey;  
    public String getDefaultEndpointsProtocol() {  
        return defaultEndpointsProtocol;  
    }  
    public void setDefaultEndpointsProtocol(String defaultEndpointsProtocol) {  
        this.defaultEndpointsProtocol = defaultEndpointsProtocol;  
    }  
    public String getBlobEndpoint() {  
        return blobEndpoint;  
    }  
    public void setBlobEndpoint(String blobEndpoint) {  
        this.blobEndpoint = blobEndpoint;  
    }  
    public String getQueueEndpoint() {  
        return queueEndpoint;  
    }  
    public void setQueueEndpoint(String queueEndpoint) {  
        this.queueEndpoint = queueEndpoint;  
    }  
    public String getTableEndpoint() {  
        return tableEndpoint;  
    }  
    public void setTableEndpoint(String tableEndpoint) {  
        this.tableEndpoint = tableEndpoint;  
    }  
    public String getAccountName() {  
        return accountName;  
    }  
    public void setAccountName(String accountName) {  
        this.accountName = accountName;  
    }  
    public String getAccountKey() {  
        return accountKey;  
    }  
    public void setAccountKey(String accountKey) {  
        this.accountKey = accountKey;  
    }  
}  
