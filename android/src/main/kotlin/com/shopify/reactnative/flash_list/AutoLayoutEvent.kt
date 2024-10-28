@file:Suppress("DEPRECATION") // We want to use RCTEventEmitter for interop purposes
package com.shopify.reactnative.flash_list

import com.facebook.react.bridge.Arguments
import com.facebook.react.bridge.WritableArray
import com.facebook.react.bridge.WritableMap
import com.facebook.react.uimanager.events.Event
import com.facebook.react.uimanager.events.RCTEventEmitter

class AutoLayoutEvent(
  surfaceId: Int,
  viewTag: Int,
  private val autoLayoutId: Int,
  private val layouts: WritableArray
): Event<AutoLayoutEvent>(surfaceId, viewTag) {
  override fun getEventName() = AutoLayoutEvent.EVENT_NAME

  override fun getEventData(): WritableMap = Arguments.createMap().apply {
    putInt("autoLayoutId", autoLayoutId)
    putArray("layouts", layouts)
  }

  override fun dispatch(rctEventEmitter: RCTEventEmitter) {
    rctEventEmitter.receiveEvent(viewTag, eventName, eventData)
  }

  companion object {
    const val EVENT_NAME: String = "onAutoLayout"
  }
}