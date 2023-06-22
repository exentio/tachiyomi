package eu.kanade.domain.source.service

import eu.kanade.domain.source.interactor.SetMigrateSorting
import eu.kanade.tachiyomi.util.system.LocaleHelper
import tachiyomi.core.preference.PreferenceStore
import tachiyomi.core.preference.getEnum
import tachiyomi.domain.library.model.LibraryDisplayMode

class SourcePreferences(
    private val preferenceStore: PreferenceStore,
) {

    fun sourceDisplayMode() = preferenceStore.getObject("pref_display_mode_catalogue", LibraryDisplayMode.default, LibraryDisplayMode.Serializer::serialize, LibraryDisplayMode.Serializer::deserialize)

    fun enabledLanguages() = preferenceStore.getStringSet("source_languages", LocaleHelper.getDefaultEnabledLanguages())

    fun disabledSources() = preferenceStore.getStringSet("hidden_catalogues", emptySet())

    fun pinnedSources() = preferenceStore.getStringSet("pinned_catalogues", emptySet())

    fun lastUsedSource() = preferenceStore.getLong("last_catalogue_source", -1)

    fun showNsfwSource() = preferenceStore.getBoolean("show_nsfw_source", true)

    fun migrationSortingMode() = preferenceStore.getEnum("pref_migration_sorting", SetMigrateSorting.Mode.ALPHABETICAL)

    fun migrationSortingDirection() = preferenceStore.getEnum("pref_migration_direction", SetMigrateSorting.Direction.ASCENDING)

    fun extensionUpdatesCount() = preferenceStore.getInt("ext_updates_count", 0)

    fun trustedSignatures() = preferenceStore.getStringSet("trusted_signatures", emptySet())

    fun searchPinnedSourcesOnly() = preferenceStore.getBoolean("search_pinned_sources_only", false)
}
