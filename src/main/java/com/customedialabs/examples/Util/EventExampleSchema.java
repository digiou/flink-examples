package com.customedialabs.examples.Util;

import com.customedialabs.examples.events.EventExample;
import org.apache.flink.annotation.PublicEvolving;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.streaming.util.serialization.DeserializationSchema;
import org.apache.flink.streaming.util.serialization.SerializationSchema;

import java.io.IOException;

/**
 * Created by digiou on 26/10/2016.
 */
@PublicEvolving
public class EventSchema implements DeserializationSchema<EventExample>, SerializationSchema<EventExample> {

    private static final long serialVersionUID = 1L;

    @Override
    public EventExample deserialize(byte[] message) throws IOException {
        return null;
    }

    @Override
    public boolean isEndOfStream(EventExample nextElement) {
        return false;
    }

    @Override
    public TypeInformation<EventExample> getProducedType() {
        return null;
    }

    @Override
    public byte[] serialize(EventExample element) {
        return new byte[0];
    }
}
