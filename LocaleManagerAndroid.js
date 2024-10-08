cordova.exec(
  function success(result) {
    // Return the locale as a string
    console.log('Locale: ' + result);
  },
  function error(err) {
    console.error('Error getting locale: ' + err);
  },
  'LocalePlugin', // This is the name of the native plugin
  'getSystemLocale', // This is the action in the plugin that gets the locale
  []
);
