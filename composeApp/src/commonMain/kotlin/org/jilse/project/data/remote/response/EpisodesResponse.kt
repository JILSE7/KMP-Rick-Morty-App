package org.jilse.project.data.remote.response

import kotlinx.serialization.Serializable
import org.jilse.project.domain.models.EpisodeModel
import org.jilse.project.domain.models.SeasonEpisode

@Serializable
data class EpisodesResponse(
    val info: InfoResponse,
    val results: List<EpisodeResponse>
)

@Serializable
data class EpisodeResponse(
    val id: Int,
    val name: String,
    val episode: String,
    val characters: List<String>
) {
    fun toDomain(): EpisodeModel {
        val season = getSeasonFromEpisode(episode)
        return EpisodeModel(
            id = id,
            name = name,
            episode = episode,
            characters = characters.map { it -> it.substringAfter("/") },
            videoURL = getSeasonUrlFromEpisode(season),
            season = season
        )
    }

    private fun getSeasonFromEpisode(episode: String): SeasonEpisode {
        return when {
            episode.startsWith("S01") -> SeasonEpisode.SEASON_1
            episode.startsWith("S02") -> SeasonEpisode.SEASON_2
            episode.startsWith("S03") -> SeasonEpisode.SEASON_3
            episode.startsWith("S04") -> SeasonEpisode.SEASON_4
            episode.startsWith("S05") -> SeasonEpisode.SEASON_5
            episode.startsWith("S06") -> SeasonEpisode.SEASON_6
            episode.startsWith("S07") -> SeasonEpisode.SEASON_7
            else -> SeasonEpisode.UNKNOWN
        }
    }

    private fun getSeasonUrlFromEpisode(season: SeasonEpisode): String {
        val episode = "https://firebasestorage.googleapis.com/v0/b/snapshot-android.appspot.com/o/videos%2FRoy_%20A%20Life%20Well%20Lived%20_%20Rick%20and%20Morty%20_%20Adult%20Swim.mp4?alt=media&token=af650caf-61ad-4c76-a12d-a36a264649f1"
     return when(season) {
         SeasonEpisode.SEASON_1 -> episode
         SeasonEpisode.SEASON_2 -> episode
         SeasonEpisode.SEASON_3 -> episode
         SeasonEpisode.SEASON_4 -> episode
         SeasonEpisode.SEASON_5 -> episode
         SeasonEpisode.SEASON_6 -> episode
         SeasonEpisode.SEASON_7 -> episode
         SeasonEpisode.UNKNOWN -> episode
     }
    }
}