package org.dromara.omind.mq.api.producer;

import org.dromara.omind.baseplat.api.domain.entity.PlatConnectorRealtimeData;
import org.dromara.omind.mq.api.contants.TopicKeys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class RealtimeDataProducer {

    @Autowired
    private StreamBridge streamBridge;

    public void sendMsg(PlatConnectorRealtimeData platConnectorRealtimeData)
    {
        streamBridge.send(TopicKeys.PileRealtimeData, MessageBuilder.withPayload(platConnectorRealtimeData).build());
    }

}
