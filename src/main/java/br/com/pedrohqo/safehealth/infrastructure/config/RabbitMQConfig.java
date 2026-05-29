package br.com.pedrohqo.safehealth.infrastructure.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_NOTIFICATION = "notification.consultation.queue";
    public static final String EXCHANGE_NOTIFICATION = "notification.exchange";
    public static final String ROUTING_KEY_NOTIFICATION = "notification.routing.key";

    @Bean
    public Queue notificationQueue(){
        return new Queue(QUEUE_NOTIFICATION, true);
    }

    @Bean
    public DirectExchange notificationExchange(){
        return new DirectExchange(EXCHANGE_NOTIFICATION);
    }

    @Bean
    public Binding notificationBinding(Queue notificationQueue, DirectExchange notificationExchange){
        return BindingBuilder.bind(notificationQueue).to(notificationExchange).with(ROUTING_KEY_NOTIFICATION);
    }

    @Bean
    @SuppressWarnings("removal")
    public MessageConverter jsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
