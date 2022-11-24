package eu.kanade.presentation.util

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import com.bluelinelabs.conductor.Router

/**
 * For interop with Conductor
 */
val LocalRouter: ProvidableCompositionLocal<Router?> = staticCompositionLocalOf { null }

/**
 * For invoking back press to the parent activity
 */
val LocalBackPress: ProvidableCompositionLocal<(() -> Unit)?> = staticCompositionLocalOf { null }
