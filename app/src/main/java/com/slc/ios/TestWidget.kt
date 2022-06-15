package com.slc.ios

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.*
import android.content.Context.BATTERY_SERVICE
import android.os.BatteryManager
import android.widget.RemoteViews
import java.util.*


/**
 * Implementation of App Widget functionality.
 */
class TestWidget : AppWidgetProvider() {

    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }
}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {
    val bm = context.getSystemService(BATTERY_SERVICE) as BatteryManager
    val batLevel = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)

    val calendar = Calendar.getInstance()
    val seconds = calendar[Calendar.SECOND]

    // Construct the RemoteViews object
    val views = RemoteViews(context.packageName, R.layout.test_widget)
    views.setTextViewText(R.id.appwidget_text, seconds.toString())

    // Instruct the widget manager to update the widget
    appWidgetManager.updateAppWidget(appWidgetId, views)
}