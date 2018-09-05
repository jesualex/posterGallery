package com.jesualex.postergallery.utils;

import java.io.IOException;

import io.objectbox.converter.PropertyConverter;
import okio.Buffer;
import okio.ByteString;

/**
 * Created by jesualex
 * Date: 05-09-18
 */

public class LongArrayConverter implements PropertyConverter<long[], String> {
    private static final ByteString SEMICOLON = ByteString.decodeBase64(";");

    public long[] add(long id, long[] values) {
        long[] anotherArray = new long[values.length + 1];
        System.arraycopy(values, 0, anotherArray, 0, values.length);
        anotherArray[values.length] = id;
        return anotherArray;
    }

    @Override public long[] convertToEntityProperty(String databaseValue) {
        if (databaseValue == null) {
            return new long[0];
        }
        try {
            long[] ids = new long[0];
            Buffer buffer = new Buffer();
            buffer.writeUtf8(databaseValue);
            long index;
            while ((index = buffer.indexOf(SEMICOLON)) != -1) {
                ids = add(Long.parseLong(buffer.readUtf8(index - 1)), ids);
            }
            return ids;
        } catch (IOException io) {
            io.printStackTrace();
            return new long[0];
        }
    }

    @Override public String convertToDatabaseValue(long[] entityProperty) {
        Buffer buffer = new Buffer();
        for (long value : entityProperty) {
            buffer.write(SEMICOLON);
            buffer.writeUtf8(String.valueOf(value));
        }
        return buffer.toString();
    }
}
