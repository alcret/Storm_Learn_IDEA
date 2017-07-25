package four;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import kafka.javaapi.producer.Producer;
import kafka.producer.ProducerConfig;
import org.slf4j.helpers.MessageFormatter;

import java.util.Properties;

/**
 * Created by zc on 17-7-25.
 */
public class KafkaAppender extends AppenderBase<ILoggingEvent>{
    private String topic;
    private String zookeeperHost;
    private Producer<String,String> producer;
    private MessageFormatter formatter;

    public String getTopic() {
        return topic;
    }

    public String getZookeeperHost() {
        return zookeeperHost;
    }

    public MessageFormatter getFormatter() {
        return formatter;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setZookeeperHost(String zookeeperHost) {
        this.zookeeperHost = zookeeperHost;
    }

    public void setFormatter(MessageFormatter formatter) {
        this.formatter = formatter;
    }


    @Override
    public void start() {
        if(this.formatter == null) {
            this.formatter = new MessageFormatter();
        }
        super.start();
        Properties props = new Properties();
        props.put("zk.connect",this.zookeeperHost);
        props.put("serializer.class","kafka.serializer.StringEcoder");
        ProducerConfig config = new ProducerConfig(props);
        this.producer = new Producer<String, String>(config);
    }
    @Override
    public void stop() {
        super.stop();
        this.producer.close();
    }


    @Override
    protected void append(ILoggingEvent iLoggingEvent) {

    }
}
