package org.jilse.project.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import org.jilse.project.data.remote.ApiService
import org.jilse.project.data.remote.paging.CharacterPagingSource
import org.jilse.project.domain.IRepository
import org.jilse.project.domain.models.CharacterModel

class RepositoryImp(private val api: ApiService, private val characterPagingSource: CharacterPagingSource): IRepository {
    companion object {
        const val MAX_ITEMS = 20
        const val PREFETCH_DISTANCE = 5
    }
    override suspend fun getSingleCharacter(id: String): CharacterModel {
        return api.getSingleCharacter(id).toDomain()
    }

    override fun getCharacters(): Flow<PagingData<CharacterModel>> {
        return Pager(
            config = PagingConfig(pageSize = MAX_ITEMS, prefetchDistance = PREFETCH_DISTANCE),
            pagingSourceFactory = { characterPagingSource }
        ).flow
    }

}