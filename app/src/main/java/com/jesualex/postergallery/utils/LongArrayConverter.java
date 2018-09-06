package com.jesualex.postergallery.utils;

import android.text.TextUtils;

import java.io.IOException;
import java.util.Arrays;

import io.objectbox.converter.PropertyConverter;
import okio.Buffer;
import okio.ByteString;


/**
 * Created by jesualex
 * Date: 05-09-18
 */

public class LongArrayConverter implements PropertyConverter<long[], String> {
    @Override
    public long[] convertToEntityProperty(String s) {
        if (TextUtils.isEmpty(s))
            return null;
        else{
            String[] stringArray = s.split(",");
            long[] longArray = new long[stringArray.length];

            for (int i = 0; i < stringArray.length; i++) {
                longArray[i] = Long.parseLong(stringArray[i]);
            }

            return longArray;
        }
    }

    @Override
    public String convertToDatabaseValue(long[] array) {
        if (array != null && array.length > 0) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < array.length; i++) {
                if (i > 0) builder.append(",");
                builder.append(array[i]);
            }
            return builder.toString();
        }
        return null;
    }
}
