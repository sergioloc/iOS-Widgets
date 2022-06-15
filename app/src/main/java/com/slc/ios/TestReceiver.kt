package com.slc.ios

import android.appwidget.AppWidgetManager
import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Intent

class TestReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action.equals(Intent.ACTION_SCREEN_OFF)) {
            //stuff
        } else if (intent.action.equals(Intent.ACTION_SCREEN_ON)) {

        }

        val widgetManager =
            AppWidgetManager.getInstance(context)
        val appWidgetIds = widgetManager.getAppWidgetIds(
            ComponentName(
                context,
                TestWidget::class.java
            )
        )

        val updateIntent = Intent(
            AppWidgetManager.ACTION_APPWIDGET_UPDATE,
            null,
            context,
            TestWidget::class.java
        )
        updateIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds)

        context.sendBroadcast(updateIntent)
    }
}