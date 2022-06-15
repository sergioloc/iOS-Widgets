package com.slc.ios

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.*
import android.widget.RemoteViews

/**
 * Implementation of Clock Widget functionality.
 */
class ClockWidget : AppWidgetProvider() {

    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        for (appWidgetId in appWidgetIds) {
            updateClockWidget(context, appWidgetManager, appWidgetId)
        }
    }
}

internal fun updateClockWidget(context: Context, appWidgetManager: AppWidgetManager, appWidgetId: Int) {
    val views = RemoteViews(context.packageName, R.layout.widget_clock)
    appWidgetManager.updateAppWidget(appWidgetId, views)
}