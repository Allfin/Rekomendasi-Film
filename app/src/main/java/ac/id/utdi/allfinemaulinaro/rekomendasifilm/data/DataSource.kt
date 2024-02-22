package ac.id.utdi.allfinemaulinaro.rekomendasifilm.data

import ac.id.utdi.allfinemaulinaro.rekomendasifilm.R
import ac.id.utdi.allfinemaulinaro.rekomendasifilm.model.Genres
import ac.id.utdi.allfinemaulinaro.rekomendasifilm.model.Movie

object DataSource {
    // Data Genders Movie
    val genres = listOf(
        Genres(R.string.action),
        Genres(R.string.comedy),
        Genres(R.string.horror),
    )

    // Data untuk action
    val actions = listOf(
        Movie(R.string.dune, R.string.dune_release, R.drawable.dune),
        Movie(R.string.end_game, R.string.end_game_release, R.drawable.end_game),
        Movie(R.string.silent_night, R.string.silent_night_release, R.drawable.silent_night),
        Movie(R.string.the_family_plan, R.string.the_family_plan_release, R.drawable.the_family_plan),
        Movie(R.string.john_wick_chapter_4, R.string.john_wick_hapter_4_release, R.drawable.john_wick_chapter_4),
        Movie(R.string.godzilla_x_kong_the_new_empire, R.string.godzilla_x_kong_the_new_empire_release, R.drawable.godzilla_x_kong_the_new_empire)
    )

    // List data horror
    val horrors = listOf(
        Movie(R.string.the_return, R.string.the_return_release, R.drawable.the_return),
        Movie(R.string.skal, R.string.skal_release, R.drawable.skal),
        Movie(R.string.the_farm, R.string.the_farm_release, R.drawable.the_farm),
        Movie(R.string.while_we_sleep, R.string.while_we_sleep_release, R.drawable.while_we_sleep),
        Movie(R.string.no_way_up, R.string.no_way_up_release, R.drawable.no_way_up),
        Movie(R.string.meg_2_the_trench, R.string.meg_2_the_trench_relase, R.drawable.meg_2_the_trench),
    )

    // List data comedy
    val comedies = listOf(
        Movie(R.string.role_play, R.string.role_play_release, R.drawable.role_play),
        Movie(R.string.upgraded, R.string.upgraded_release, R.drawable.upgraded),
        Movie(R.string.barbie, R.string.barbie_release, R.drawable.barbie),
        Movie(R.string.migration, R.string.migration_release, R.drawable.migration),
        Movie(R.string.anyone_but_you, R.string.anyone_but_you_release, R.drawable.anyone_but_you),
        Movie(R.string.wonka, R.string.wonka_release, R.drawable.wonka)
    )

}