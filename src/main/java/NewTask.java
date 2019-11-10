import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

public class NewTask {



    public static void main(String[] args) throws Exception {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try {
            Connection connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel();
            channel.exchangeDeclare("logs", "fanout");

            String message = String.join ("", args);
            channel.basicPublish ("logs", "", null, message.getBytes ());
            System.out.println ("[x] Enviado '" + message + "'");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}


