package com.github.maiatoday.hellojewel.services

import com.github.maiatoday.hellojewel.MyBundle
import com.github.maiatoday.hellojewel.data.DogImageRepository
import com.intellij.openapi.components.Service
import com.intellij.openapi.diagnostic.thisLogger
import com.intellij.openapi.project.Project

@Service(Service.Level.PROJECT)
class MyProjectService(project: Project) {

    init {
        thisLogger().info(MyBundle.message("projectService", project.name))
        thisLogger().warn("Don't forget to remove all non-needed sample code files with their corresponding registration entries in `plugin.xml`.")
        val repository = DogImageRepository()
        // val response = repository.getRandomDogImage()
    }

    fun getRandomNumber() = (1..100).random()
}
