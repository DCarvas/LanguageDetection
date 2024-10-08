package com.outsystems.plugins;

import org.apache.cordova.*;
import org.json.JSONArray;
import android.os.LocaleList;
import android.content.Context;
import android.app.LocaleManager;
import java.util.Locale;

public class LocalePlugin extends CordovaPlugin {
  @Override
  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
    if (action.equals("getSystemLocale")) {
      Context context = this.cordova.getActivity().getApplicationContext();
      LocaleList locales = context.getSystemService(LocaleManager.class).getSystemLocales();
      Locale locale = locales.get(0);
      String localeString = locale.toLanguageTag(); // e.g. "en-US"
      callbackContext.success(localeString);
      return true;
    }
    return false;
  }
}
