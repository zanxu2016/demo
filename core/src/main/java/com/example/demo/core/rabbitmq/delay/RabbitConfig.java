package com.example.demo.core.rabbitmq.delay;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitConfig {
    //rabbitmq 连接工厂
    private final ConnectionFactory RAB_FACTORY = new ConnectionFactory();
    private Connection connection;

    public void init() throws Exception {
        //rabbitmq 服务器地址
        String SERVER_HOST = "127.0.0.1";
        RAB_FACTORY.setHost(SERVER_HOST);
        //端口号
        int PORT = 5672;
        RAB_FACTORY.setPort(PORT);
        //用户名
        String USER_NAME = "guest";
        RAB_FACTORY.setUsername(USER_NAME);
        //密码
        String PASSWORD = "guest";
        RAB_FACTORY.setPassword(PASSWORD);
        this.connection = RAB_FACTORY.newConnection();
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean isQUEUE_SAVE() {
        //队列是否持久化
        return true;
    }

    public String getMESSAGE_SAVE() {
        //消息持久化  1，0
        return "1";
    }
}
