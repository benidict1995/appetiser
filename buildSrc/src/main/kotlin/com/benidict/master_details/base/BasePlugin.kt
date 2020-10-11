package com.benidict.master_details.base

import com.android.build.gradle.BaseExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType
import com.benidict.master_details.plugin.commonPlugin
import com.benidict.master_details.dependencies.commonDependencies
import com.benidict.master_details.extension.androidConfigPlugin

open class BasePlugin : Plugin<Project>{
    override fun apply(project: Project) {
        project.commonPlugin()
        project.extensions.getByType<BaseExtension>().apply{
            androidConfigPlugin()
        }
        project.commonDependencies()
    }
}