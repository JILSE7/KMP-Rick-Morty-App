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
     return when(season) {
         SeasonEpisode.SEASON_1 -> "https://www.youtube.com/watch?v=BbAWyGjqgo4"
         SeasonEpisode.SEASON_2 -> "https://www.youtube.com/watch?v=IUjxvRsMhKc"
         SeasonEpisode.SEASON_3 -> "https://www.youtube.com/watch?v=RSGCJVhjWnI"
         SeasonEpisode.SEASON_4 -> "https://www.youtube.com/watch?v=L1qqA2vvKNs"
         SeasonEpisode.SEASON_5 -> "https://www.youtube.com/watch?v=y2ozacj3xQU"
         SeasonEpisode.SEASON_6 -> "https://www.youtube.com/watch?v=9etNizOl8oE"
         SeasonEpisode.SEASON_7 -> "https://www.youtube.com/watch?v=Qr7ghf-SHxQ"
         SeasonEpisode.UNKNOWN -> "https://www.youtube.com/watch?v=b89CnP0Iq30"
     }
    }
}