# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# signingConfig.enableV1Signing, signingConfig.enableV2Signing, and
# signingConfig.enableSourceStamp fields in the defaultConfig block of the
# build.gradle file as well as can be overridden on a per-product flavor
# basis in productFlavors blocks.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

# Keep Room entities
-keep class androidx.room.** { *; }
-keep @interface androidx.room.** { *; }

# Keep Hilt annotations
-keep class dagger.hilt.** { *; }
-keep @interface dagger.hilt.** { *; }

# Keep Compose classes
-keep class androidx.compose.** { *; }
-keep @interface androidx.compose.** { *; }

# Keep Kotlin serialization
-keepclassmembers class kotlinx.serialization.** {
    *** Companion;
}
