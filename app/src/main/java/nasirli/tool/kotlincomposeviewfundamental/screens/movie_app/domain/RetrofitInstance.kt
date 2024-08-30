package nasirli.tool.kotlincomposeviewfundamental.screens.movie_app.domain

import nasirli.tool.kotlincomposeviewfundamental.screens.utils.Util.MovieUrl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: ApiInterface by lazy {
        Retrofit.Builder()
            .baseUrl(MovieUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }
}