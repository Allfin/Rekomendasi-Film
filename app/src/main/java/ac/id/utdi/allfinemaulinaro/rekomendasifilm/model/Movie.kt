package ac.id.utdi.allfinemaulinaro.rekomendasifilm.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Movie(
    @StringRes val nameMovie: Int,
    @StringRes val releaseMovie: Int,
    @DrawableRes val imageRes: Int
)

