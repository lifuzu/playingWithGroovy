//http://www.tomasmalmsten.com/2010/02/how-to-modify-the-versoin-code-and-version-name-in-the-androidmanifest-using-gmaven/
def ns = new groovy.xml.Namespace('http://schemas.android.com/apk/res/android', 'ns')
def rootNode = new groovy.util.XmlParser(false, true).parseText("""
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.nook.lib.hellolib1a.main"
    android:versionCode="3" >

    <application
        android:allowBackup="true"
        android:icon="@drawable/ic_launcher"
        android:label="@string/app_name" >
        <activity
            android:name="com.nook.lib.hellolib1a.main.MainActivity"
            android:label="@string/app_name" >
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
""")
def attributes = rootNode.attributes()
def versionNumber = attributes[ns.versionCode]

println versionNumber
