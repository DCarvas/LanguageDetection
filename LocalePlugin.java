package com.outsystems.plugins;

import org.apache.cordova.*;
import org.json.JSONArray;
import android.os.LocaleList;
import android.content.Context;
import android.app.LocaleManager;
import java.util.Locale;
import android.os.Build;

public class LocalePlugin extends CordovaPlugin {

  @Override
  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
    if (action.equals("getSystemLocale")) {
      try {
        Context context = this.cordova.getActivity().getApplicationContext();

        // Check if the device's Android version is API level 24 or higher
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
          LocaleList locales = context.getSystemService(LocaleManager.class).getSystemLocales();
          Locale locale = locales.get(0); // Get the first locale in the list
          String localeString = locale.toLanguageTag(); // e.g. "en-US"
          callbackContext.success(localeString);
        } else {
          // Fallback for older Android versions
          Locale locale = Locale.getDefault();
          String localeString = locale.toLanguageTag(); // e.g. "en-US"
          callbackContext.success(localeString);
        }
        return true;

      } catch (Exception e) {
        // Handle exceptions and send error callback
        callbackContext.error("Error detecting locale: " + e.getMessage());
        return false;
      }
    }
    return false;
  }
}
