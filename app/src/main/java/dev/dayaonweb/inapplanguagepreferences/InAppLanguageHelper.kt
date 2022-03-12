package dev.dayaonweb.inapplanguagepreferences

import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat

object InAppLanguageHelper {

    fun getCurrentPreferredLanguage(): String {
        val currentAppLocale = AppCompatDelegate.getApplicationLocales()
        if (currentAppLocale == LocaleListCompat.getEmptyLocaleList())
            return ""
        return currentAppLocale.toLanguageTags()
    }

    fun setAppLanguage(languageTag: String) {
        AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags(languageTag))
    }
}