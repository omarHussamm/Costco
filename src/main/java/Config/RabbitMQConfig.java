package Config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {

    @Value("UserOrderQueue")
    private String UserOrderQueue;
    @Value("TransactionOrderQueue")
    private String TransactionOrderQueue;
    @Value("ProductOrderQueue")
    private String ProductOrderQueue;
    @Value("OrderUserQueue")
    private String OrderUserQueue;
    @Value("TransactionUserQueue")
    private String TransactionUserQueue;
    @Value("ProductUserQueue")
    private String ProductUserQueue;
    @Value("OrderTransactionQueue")
    private String OrderTransactionQueue;
    @Value("UserTransactionQueue")
    private String UserTransactionQueue;
    @Value("ProductTransactionQueue")
    private String ProductTransactionQueue;
    @Value("UserProductQueue")
    private String UserProductQueue;
    @Value("TransactionProductQueue")
    private String TransactionProductQueue;
    @Value("OrderProductQueue")
    private String OrderProductQueue;


    private static final String exchange = "rabbit_mq_exchange";

    // spring bean for rabbitmq queue
    @Bean
    Queue UserOrderQueue() {
        return new Queue("UserOrderQueue", false);
    }
    @Bean
    Queue TransactionOrderQueue() {
        return new Queue("TransactionOrderQueue", false);
    }
    @Bean
    Queue ProductOrderQueue() {
        return new Queue("ProductOrderQueue", false);
    }

    @Bean
    Queue OrderUserQueue() {
        return new Queue("OrderUserQueue", false);
    }
    @Bean
    Queue TransactionUserQueue() {
        return new Queue("TransactionUserQueue", false);
    }
    @Bean
    Queue ProductUserQueue() {
        return new Queue("ProductUserQueue", false);
    }

    @Bean
    Queue UserTransactionQueue() {
        return new Queue("UserTransactionQueue", false);
    }
    @Bean
    Queue ProductTransactionQueue() {
        return new Queue("ProductTransactionQueue", false);
    }
    @Bean
    Queue OrderTransactionQueue() {
        return new Queue("OrderTransactionQueue", false);
    }
    @Bean
    Queue UserProductQueue() {
        return new Queue("UserProductQueue", false);
    }
    @Bean
    Queue TransactionProductQueue() {
        return new Queue("TransactionProductQueue", false);
    }
    @Bean
    Queue OrderProductQueue() {
        return new Queue("OrderProductQueue", false);
    }



    // spring bean for rabbitmq exchange
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(exchange);
    }

    @Bean
    public MessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Binding bindingUserOrder(TopicExchange topicExchange) {
        return BindingBuilder.bind(UserOrderQueue()).to(topicExchange).with("UserOrderQueue");
    }

    @Bean
    public Binding bindingOrderUser(TopicExchange topicExchange) {
        return BindingBuilder.bind(OrderUserQueue()).to(topicExchange).with("OrderUserQueue");
    }

    @Bean
    public Binding bindingTransactionUser(TopicExchange topicExchange) {
        return BindingBuilder.bind(TransactionUserQueue()).to(topicExchange).with("TransactionUserQueue");
    }
    @Bean
    public Binding bindingUserTransaction(TopicExchange topicExchange) {
        return BindingBuilder.bind(UserTransactionQueue()).to(topicExchange).with("UserTransactionQueue");
    }

    @Bean
    public Binding bindingProductUser(TopicExchange topicExchange) {
        return BindingBuilder.bind(ProductUserQueue()).to(topicExchange).with("ProductUserQueue");
    }
    @Bean
    public Binding bindingUserProduct(TopicExchange topicExchange) {
        return BindingBuilder.bind(UserProductQueue()).to(topicExchange).with("UserProductQueue");
    }

    @Bean
    public Binding bindingOrderTransaction(TopicExchange topicExchange) {
        return BindingBuilder.bind(OrderTransactionQueue()).to(topicExchange).with("OrderTransactionQueue");
    }
    @Bean
    public Binding bindingTransactionOrder(TopicExchange topicExchange) {
        return BindingBuilder.bind(TransactionOrderQueue()).to(topicExchange).with("TransactionOrderQueue");
    }
    @Bean
    public Binding bindingProductTransaction(TopicExchange topicExchange) {
        return BindingBuilder.bind(ProductTransactionQueue()).to(topicExchange).with("ProductTransactionQueue");
    }
    @Bean
    public Binding bindingTransactionProduct(TopicExchange direct) {
        return BindingBuilder.bind(TransactionProductQueue()).to(direct).with("TransactionProductQueue");
    }
    @Bean
    public Binding bindingProductOrder(TopicExchange topicExchange) {
        return BindingBuilder.bind(ProductOrderQueue()).to(topicExchange).with("ProductOrderQueue");
    }
    @Bean
    public Binding bindingOrderProduct(TopicExchange topicExchange) {
        return BindingBuilder.bind(OrderProductQueue()).to(topicExchange).with("OrderProductQueue");
    }
    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost("35.180.68.31");
        connectionFactory.setVirtualHost("cherry_broker");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("root");
        connectionFactory.setPassword("root");
        return connectionFactory;
    }

    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}