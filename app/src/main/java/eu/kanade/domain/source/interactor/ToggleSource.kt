package eu.kanade.domain.source.interactor

import eu.kanade.domain.source.model.Source
import eu.kanade.domain.source.service.SourcePreferences
import eu.kanade.tachiyomi.core.preference.getAndSet

class ToggleSource(
    private val preferences: SourcePreferences,
) {

    fun await(source: Source, enable: Boolean = isEnabled(source.id)) {
        await(source.id, enable)
    }

    fun await(sourceId: Long, enable: Boolean = isEnabled(sourceId)) {
        preferences.disabledSources().getAndSet { disabled ->
            if (enable) disabled.minus("$sourceId") else disabled.plus("$sourceId")
        }
    }

    private fun isEnabled(sourceId: Long): Boolean {
        return sourceId.toString() in preferences.disabledSources().get()
    }
}
