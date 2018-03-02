Miwok App
===================================

This app displays lists of vocabulary words for the user to learn the Miwok language.
Used in a Udacity course in the Beginning Android Nanodegree.

Pre-requisites
--------------

- Android SDK v23
- Android Build Tools v23.0.2
- Android Support Repository v23.3.0

Getting Started
---------------

This sample uses the Gradle build system. To build this project, use the
"gradlew build" command or use "Import Project" in Android Studio.

Support
-------

- Google+ Community: https://plus.google.com/communities/105153134372062985968
- Stack Overflow: http://stackoverflow.com/questions/tagged/android

Patches are encouraged, and may be submitted by forking this project and
submitting a pull request through GitHub. Please see CONTRIBUTING.md for more details.

License
-------

Copyright 2016 The Android Open Source Project, Inc.

Licensed to the Apache Software Foundation (ASF) under one or more contributor
license agreements.  See the NOTICE file distributed with this work for
additional information regarding copyright ownership.  The ASF licenses this
file to you under the Apache License, Version 2.0 (the "License"); you may not
use this file except in compliance with the License.  You may obtain a copy of
the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
License for the specific language governing permissions and limitations under
the License.


----------------------

### Added by: doct0rX 👾

> Tongue Twister: When you click on something that is clickable that was previously set its OnClickListener, then the OnClick method of the OnClickListener will react quick. So what you wanna click?
* More on Click Listeners:
    * [Button Click Listeners in Android](https://stackoverflow.com/questions/8977212/button-click-listeners-in-android)
    * [Android button example](http://www.mkyong.com/android/android-button-example/)

#### OnClickListener vs onClick

You might be wondering why we're going through all the trouble of creating an anonymous subclass of OnClickListener and attaching it to a view, when we already know how to use the onClick XML attribute from from back in Android Basics: User Input. Why write something terrifying like:

```java
// In onCreate() in the Activity
Button button = (Button) findViewById(R.id.ze_button);
button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        doSomeStuff();
    }
});
```

When we could do something much cleaner like:

```java
android:onClick="myListener" // This is in the XML layout

public void myListener(View view){ // This is back in the Activity file
    doSomeStuff();
}
```

There are a couple reasons why you might want to programmatically set an OnClickListener. The first is if you ever want to change the behavior of your button while your app is running. You can point your button at another method entirely, or just disable the button by setting an OnClickListener that doesn't do anything.

When you define a listener using the onClick attribute, the view looks for a method with that name only in its host activity. Programmatically setting an OnClickListener allows you to control a button's behavior from somewhere other than its host activity. This will become very relevant when we learn about Fragments, which are basically mini activities, allowing you to build reusable collections of views with their own lifecycle, which can then be assembled into activities. Fragments always need to use OnClickListeners to control their buttons, since they're not Activities, and won't be searched for listeners defined in onClick.

For more commentary on the decision to use an OnClickListener vs onClick, check out [this question](https://stackoverflow.com/questions/8977212/button-click-listeners-in-android) on Stack Overflow.