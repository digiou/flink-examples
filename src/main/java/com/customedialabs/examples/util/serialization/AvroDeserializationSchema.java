package com.customedialabs.examples.util.serialization;

import com.customedialabs.examples.events.EventExample;
import org.apache.avro.Schema;
import org.apache.avro.io.*;
import org.apache.avro.reflect.ReflectData;
import org.apache.avro.reflect.ReflectDatumReader;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.typeutils.TypeExtractor;
import org.apache.flink.streaming.util.serialization.DeserializationSchema;

import java.io.IOException;

/**
 * Created by digiou on 27/10/2016.
 */
public class AvroDeserializationSchema<T> implements DeserializationSchema<T> {

    private final Class<T> avroType;

    private transient DatumReader<T> reader;
    private transient JsonDecoder decoder;

    public AvroDeserializationSchema(Class<T> avroType) {
        this.avroType = avroType;
    }

    @Override
    public T deserialize(byte[] message) throws IOException {
        ensureInitialized();

        Schema schema = ReflectData.get().getSchema(EventExample.class);
        decoder = DecoderFactory.get().jsonDecoder(schema, new String(message));
        return reader.read(null, decoder);
    }

    @Override
    public boolean isEndOfStream(T nextElement) {
        return false;
    }

    @Override
    public TypeInformation<T> getProducedType() {
        return TypeExtractor.getForClass(avroType);
    }

    private void ensureInitialized() {
        if (reader == null) {
            if (org.apache.avro.specific.SpecificRecordBase.class.isAssignableFrom(avroType)) {
                reader = new SpecificDatumReader<T>(avroType);
            } else {
                reader = new ReflectDatumReader<T>(avroType);
            }
        }
    }
}
