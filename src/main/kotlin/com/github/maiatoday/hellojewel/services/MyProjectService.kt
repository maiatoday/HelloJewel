package com.github.maiatoday.hellojewel.services

import com.github.maiatoday.hellojewel.MyBundle
import com.github.maiatoday.hellojewel.data.DogImageRepository
import com.intellij.openapi.components.Service
import com.intellij.openapi.diagnostic.thisLogger
import com.intellij.openapi.project.Project
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Service(Service.Level.PROJECT)
class MyProjectService(
    project: Project,
    //private val scope: CoroutineScope
) : DogAsAService {
    private val repository = DogImageRepository()
    private var latestUrl: String = ""

    init {
        thisLogger().info(MyBundle.message("projectService", project.name))
        thisLogger().warn("Don't forget to remove all non-needed sample code files with their corresponding registration entries in `plugin.xml`.")
      //  scope.launch { latestUrl = repository.getDogNameUrl() }
    }

    fun getRandomNumber() = (1..100).random()

    override fun getRandomDogImage(): String {
//        scope.launch {
//            latestUrl = repository.getDogNameUrl()
//            thisLogger().info("Fetched Dog url $latestUrl")
//        }
        return latestUrl
    }

}
