package org.jilse.project.data.remote.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import org.jilse.project.data.remote.ApiService
import org.jilse.project.domain.models.CharacterModel

class CharacterPagingSource(private val api: ApiService): PagingSource<Int, CharacterModel>() {
    override fun getRefreshKey(state: PagingState<Int, CharacterModel>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterModel> {
        return try {
            val page = params.key?: 1
            val response = api.getCharacters(page)

            val characters = response.results.map { it.toDomain() }
            val prev = if (page == 1) null else page - 1
            val next = if (response.info.next != null) page + 1 else null

            LoadResult.Page(
                data = characters,
                prevKey = prev,
                nextKey = next
            )

        }catch (e: Exception){
            LoadResult.Error(e)
        }
    }

}