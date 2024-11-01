package com.github.maiatoday.hellojewel.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import com.intellij.openapi.project.Project
import org.jetbrains.jewel.ui.component.DefaultButton
import org.jetbrains.jewel.ui.component.Text

@Composable
internal fun MyTestTab(project: Project) {
    Row {
        Text("Hello World!")
        DefaultButton({}) {
            Text("Shuffle")
        }
    }
}