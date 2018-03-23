package com.spx.dev.ugirls;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
//import com.ugirls.social.common.utils.LogUtils;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Converter.Factory;
import retrofit2.Retrofit;

public class DecodeConverterFactory extends Factory {
    private final Gson gson;

    public class DecodeResponseBodyConverter<T> implements Converter<ResponseBody, T> {
        private final TypeAdapter<T> adapter;

        DecodeResponseBodyConverter(TypeAdapter<T> adapter) {
            this.adapter = adapter;
        }

        public T convert(ResponseBody value) throws IOException {
            String json = value.string().trim();
            System.out.println(json);
            try {
                json = EncrypterUtil.AESDecrypt(json);
                System.out.println(json);
            } catch (Exception e) {
            }
            return this.adapter.fromJson(json);

        }
    }

    public static DecodeConverterFactory create() {
        return create(new Gson());
    }

    public static DecodeConverterFactory create(Gson gson) {
        return new DecodeConverterFactory(gson);
    }

    private DecodeConverterFactory(Gson gson) {
        if (gson == null) {
            throw new NullPointerException("gson == null");
        }
        this.gson = gson;
    }

    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new DecodeResponseBodyConverter(this.gson.getAdapter(TypeToken.get(type)));
    }
}