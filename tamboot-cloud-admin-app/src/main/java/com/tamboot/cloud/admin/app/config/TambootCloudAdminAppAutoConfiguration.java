package com.tamboot.cloud.admin.app.config;

import com.tamboot.cloud.admin.app.api.AppSystemSvcApi;
import com.tamboot.cloud.admin.app.core.CloudAppContextHolder;
import com.tamboot.cloud.admin.app.core.DatabaseUserDetailsService;
import com.tamboot.cloud.client.config.TambootCloudClientAutoConfiguration;
import com.tamboot.cloud.client.core.CloudSecurityApiRequestInterceptor;
import feign.Client;
import feign.Contract;
import feign.Feign;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@AutoConfigureAfter(TambootCloudClientAutoConfiguration.class)
public class TambootCloudAdminAppAutoConfiguration {
    @Bean
    public CloudAppContextHolder cloudAppContextHolder() {
        return new CloudAppContextHolder();
    }

    @Bean
    public DatabaseUserDetailsService databaseUserDetailsService() {
        return new DatabaseUserDetailsService();
    }

    @Configuration
    @Import(FeignClientsConfiguration.class)
    public static class AppFeignClientsConfiguration {
        private static final String SYSTEM_SVC_URL = "http://SYSTEM-SVC";

        @Bean
        public AppSystemSvcApi appSystemSvcApi(Decoder decoder, Encoder encoder, Client client, Contract contract, ObjectProvider<CloudSecurityApiRequestInterceptor> cloudSecurityApiRequestInterceptor) {
            Feign.Builder builder = Feign.builder()
                    .decoder(decoder)
                    .encoder(encoder)
                    .client(client)
                    .contract(contract);

            CloudSecurityApiRequestInterceptor interceptor = cloudSecurityApiRequestInterceptor.getIfAvailable();
            if (interceptor != null) {
                builder.requestInterceptor(interceptor);
            }

            return builder.target(AppSystemSvcApi.class, SYSTEM_SVC_URL);
        }
    }
}
