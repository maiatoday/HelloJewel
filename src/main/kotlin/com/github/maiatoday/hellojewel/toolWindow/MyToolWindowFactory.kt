package com.github.maiatoday.hellojewel.toolWindow

import com.intellij.openapi.components.service
import com.intellij.openapi.diagnostic.thisLogger
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBPanel
import com.intellij.ui.content.ContentFactory
import com.github.maiatoday.hellojewel.MyBundle
import com.github.maiatoday.hellojewel.services.MyProjectService
import com.github.maiatoday.hellojewel.ui.MyTestTab
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.util.NlsContexts.TabTitle
import org.jetbrains.jewel.bridge.addComposeTab
import javax.swing.JButton
import javax.swing.JComponent


class MyToolWindowFactory : ToolWindowFactory, DumbAware {

    init {
        thisLogger().warn("Don't forget to remove all non-needed sample code files with their corresponding registration entries in `plugin.xml`.")
    }

    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        toolWindow.addSwingTab(MyToolWindow(toolWindow).getContent(), "Hi")
        toolWindow.addComposeTab("My Test Tab") { MyTestTab() }
    }

    private fun ToolWindow.addSwingTab(component: JComponent, @TabTitle title: String) {
        val manager = contentManager
        val tabContent = manager.factory.createContent(component, title, true)
        tabContent.isCloseable = false
        manager.addContent(tabContent)
    }

    override fun shouldBeAvailable(project: Project) = true

    class MyToolWindow(toolWindow: ToolWindow) {

        private val service = toolWindow.project.service<MyProjectService>()

        fun getContent() = JBPanel<JBPanel<*>>().apply {
            val label = JBLabel(MyBundle.message("randomLabel", "?"))

            add(label)
            add(JButton(MyBundle.message("shuffle")).apply {
                addActionListener {
                    label.text = MyBundle.message("randomLabel", service.getRandomNumber())
                }
            })
        }
    }
}
