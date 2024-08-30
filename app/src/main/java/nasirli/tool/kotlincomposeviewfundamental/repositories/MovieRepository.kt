package nasirli.tool.kotlincomposeviewfundamental.repositories

import nasirli.tool.kotlincomposeviewfundamental.screens.movie_app.domain.RetrofitInstance
import nasirli.tool.kotlincomposeviewfundamental.screens.movie_app.model.Details
import nasirli.tool.kotlincomposeviewfundamental.screens.movie_app.model.MoviesList
import retrofit2.Response

class MovieRepository {
    suspend fun getMovieList(page: Int): Response<MoviesList> {
        return RetrofitInstance.api.getMovies(page)
    }
    suspend fun getDetailsById(id:Int): Response<Details>{
        return RetrofitInstance.api.getDetailsById(id = id)
    }
}