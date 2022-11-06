package com.kodluyoruz.eticaret.Beans;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sevgidemir
 */

@Configuration
public class Configurations {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
