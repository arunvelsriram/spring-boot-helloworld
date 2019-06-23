package io.kotlintest.provided

import io.kotlintest.AbstractProjectConfig
import io.kotlintest.extensions.ProjectLevelExtension
import io.kotlintest.spring.SpringAutowireConstructorExtension

// kotlintest configuration
// https://github.com/kotlintest/kotlintest/blob/master/doc/reference.md#project-config
object ProjectConfig : AbstractProjectConfig() {
    override fun extensions(): List<ProjectLevelExtension> = listOf(SpringAutowireConstructorExtension)
}