package id.ishom.movielist.core;

import java.io.IOException;
import java.lang.annotation.Annotation;

import id.ishom.movielist.model.ApiError;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

public class ErrorUtils {
    public static ApiError parseError(Response<?> response) {
        Converter<ResponseBody, ApiError> converter =
                ApiClient.INSTANCE.getRetrofit().responseBodyConverter(ApiError.class, new Annotation[0]);
        ApiError error;
        try {
            error = converter.convert(response.errorBody());
        } catch (IOException e) {
            return new ApiError("Invalid parse");
        }
        return error;
    }
}
