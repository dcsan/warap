# ComWrap


# what it is
Basic native android webview + wrapper for meteor apps.
If you're fed up with phonegap performance, flaky compile process, this is a pure native app that you can use to wrap your web apps. It doesn't do anything much other than opening a webview though!

It's set for android 4.4+ so you get a chrome webview. If you need compatability with older Android OS versions, you could set for older os compatability or help me add crosswalk into this wrapper.


# How to use
in res/values/strings.xml edit

    <string name="app_name">YOUR APP NAME HERE</string>
    <string name="app_url">http://YOURURL.com</string>

In AndroidManifest.xml

    package="com.yourapp.name.here"

Use android studio to build the app. 

Also replace your app icons inside `res/mipmap`
you can use various web tools to download a directory of images in the right format.


# Roadmap:

- add loading screen from local filesystem

- add native android navigation menu
popover drawer to navigate between webapp features

- add a native -> JS bridge
so that native android navigation buttons could open a different view on the web content.

- add JS -> native bridge
so JS methods in the webapp can call native code. 
eg: to open up some native android navigation components
or when the web app is loaded call native code to hide a native local loading screen


