package com.taylor_johnson.realsocialnew.Api;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by desarrolladorjf on 08/03/2017.
 */

public interface RealsocialService {


    @GET("oficinas/1")
    Call<OfficeApiResponse> getPostList();
    @GET("convenios/1")
    Call<AgreementApiResponse> getAgreementList();
    @GET("noticias/1")
    Call<NoticeApiResponse> getNoticePostList();

    @GET("opciones/1")
    Call<OptionsApiResponse> getOptionList();
    @GET("redesSociales/1")
    Call<SocialApiResponse> getSociaList();


}
