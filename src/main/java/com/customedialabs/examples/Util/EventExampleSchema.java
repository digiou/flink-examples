package com.customedialabs.examples.Util;

import java.io.IOException;

import com.customedialabs.examples.events.EventExample;
import com.google.gson.*;
import org.apache.flink.annotation.PublicEvolving;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.streaming.util.serialization.DeserializationSchema;
import org.apache.flink.streaming.util.serialization.SerializationSchema;

/**
 * Created by digiou on 26/10/2016.
 */
@PublicEvolving
public class EventExampleSchema implements DeserializationSchema<EventExample>, SerializationSchema<EventExample> {

    private static final long serialVersionUID = 1L;

    @Override
    public EventExample deserialize(byte[] message) throws IOException {
        String messageStr = new String(message);

        Gson gsonObj = new GsonBuilder()
                .create();

        return gsonObj.fromJson(messageStr, EventExample.class);
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
        Gson gsonObj = new GsonBuilder()
                .create();

        return gsonObj.toJson(element).getBytes();
    }
}
