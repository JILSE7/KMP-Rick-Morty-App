package org.jilse.project.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import org.jilse.project.data.database.RickMortyDatabase
import org.jilse.project.data.remote.ApiService
import org.jilse.project.data.remote.paging.CharacterPagingSource
import org.jilse.project.data.remote.paging.EpisodesPagingSource
import org.jilse.project.domain.IRepository
import org.jilse.project.domain.models.CharacterModel
import org.jilse.project.domain.models.CharacterOfTheDayModel
import org.jilse.project.domain.models.EpisodeModel

class RepositoryImp(
    private val api: ApiService,
    private val characterPagingSource: CharacterPagingSource,
    private val episodePagingSource: EpisodesPagingSource,
    private val rickMortyDatabase: RickMortyDatabase,
): IRepository {
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

    override fun getAllEpisodes(): Flow<PagingData<EpisodeModel>> {
        return Pager(
            config = PagingConfig(pageSize = MAX_ITEMS, prefetchDistance = PREFETCH_DISTANCE),
            pagingSourceFactory = { episodePagingSource }
        ).flow
    }

    override suspend fun getCharacterOfTheDayDB(): CharacterOfTheDayModel? {
        return rickMortyDatabase.getPreferencesDao().getCharacterOfTheDay()?.toDomain()
    }

    override suspend fun saveCharacterOfTheDay(character: CharacterOfTheDayModel) {
        return rickMortyDatabase.getPreferencesDao().saveCharacterOfTheDay(character.toEntity())
    }

}