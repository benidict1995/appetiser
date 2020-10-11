plugins{
    `kotlin-dsl`
}

repositories{
    google()
    mavenCentral()
    jcenter()

}

dependencies{
    implementation (gradleApi())
    implementation (localGroovy())
    implementation ("com.android.tools.build:gradle:3.6.4")
    implementation ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.0")
}