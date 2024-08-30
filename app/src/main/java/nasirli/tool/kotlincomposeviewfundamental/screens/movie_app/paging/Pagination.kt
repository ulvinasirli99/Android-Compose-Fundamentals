package nasirli.tool.kotlincomposeviewfundamental.screens.movie_app.paging

interface Pagination<Key, Item> {
    suspend fun loadNextPage()
    fun reset()
}