package com.benidict.master_details.plugin

import org.gradle.api.Project
import com.benidict.master_details.configuration.PluginConfig

internal fun Project.commonPlugin(){
    project.plugins.apply(PluginConfig.kotlinAndroid)
    project.plugins.apply(PluginConfig.kotlinKapt)
    project.plugins.apply(PluginConfig.kotlinSerializer)
    project.plugins.apply(PluginConfig.kotlinAndroidExt)
    project.plugins.apply(PluginConfig.navigationSafeArgs)
}