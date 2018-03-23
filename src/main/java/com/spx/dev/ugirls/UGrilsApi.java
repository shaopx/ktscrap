package com.spx.dev.ugirls;

import com.spx.dev.ugirls.domain.GetDownloadUrlResult;
import com.spx.dev.ugirls.domain.ProductListResult;
import com.spx.dev.ugirls.domain.ProductTagResult;
//import io.reactivex.Observable;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface UGrilsApi {

    @FormUrlEncoded
    @POST("CommonData/GetProductTag")
    Call<ProductTagResult> getProductTag(@FieldMap Map<String, String> params);
//    Observable<ProductTagResult> getProductTag(@FieldMap Map<String, String> params);


    @FormUrlEncoded
    @POST("CommonData/GetSpecialList/GetListByTagId")
    Call<ProductListResult> GetListByTagId(@FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST("Users/Common/DownLoad")
    Call<GetDownloadUrlResult> getDownloadUrl(@FieldMap Map<String, String> params);
}
