/*
 * MIT License
 *
 * Copyright (c) 17/11/2020 16:23   David Osemwota.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package io.davidosemwota.fudz.buildsource.extentions

import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import io.davidosemwota.fudz.buildsource.Libs

/**
 * Add debugImplementation configuration.
 * @param dependencyNotation name of dependency to add.
 * @return The dependency.
 */
fun DependencyHandler.debugImplementation(dependencyNotation: String): Dependency? =
        add("debugImplementation", dependencyNotation)

/**
 * Add implementation configuration.
 * @param dependencyNotation name of dependency to add.
 * @return The dependency.
 */
fun DependencyHandler.implementation(dependencyNotation: String): Dependency? =
        add("implementation", dependencyNotation)

/**
 * Add api configuration.
 * @param dependencyNotation name of dependency to add.
 * @return The dependency.
 */
fun DependencyHandler.api(dependencyNotation: String): Dependency? =
        add("api", dependencyNotation)

/**
 * Add kapt configuration.
 * @param dependencyNotation name of dependency to add.
 * @return The dependency.
 */
fun DependencyHandler.kapt(dependencyNotation: String): Dependency? =
        add("kapt", dependencyNotation)

/**
 * Add testImplementation configuration.
 * @param dependencyNotation name of dependency to add.
 * @return The dependency.
 */
fun DependencyHandler.testImplementation(dependencyNotation: String): Dependency? =
        add("testImplementation", dependencyNotation)

/**
 * Add androidTestImplementation configuration.
 * @param dependencyNotation name of dependency to add.
 * @return The dependency.
 */
fun DependencyHandler.androidTestImplementation(dependencyNotation: String): Dependency? =
        add("androidTestImplementation", dependencyNotation)

/**
 * Add testRuntimeOnly configuration.
 * @param dependencyNotation name of dependency to add.
 * @return The dependency.
 */
fun DependencyHandler.testRuntimeOnly(dependencyNotation: String): Dependency? =
        add("testRuntimeOnly", dependencyNotation)

/**
 * Add androidTestRuntimeOnly configuration.
 * @param dependencyNotation name of dependency to add.
 * @return The dependency.
 */
fun DependencyHandler.androidTestRuntimeOnly(dependencyNotation: String): Dependency? =
        add("androidTestRuntimeOnly", dependencyNotation)

/**
 * Adds all test dependencies
 */
fun DependencyHandler.addUnitTestsDependencies(){
    testImplementation(Libs.truth)
    testImplementation(Libs.mockWebServer)
    testImplementation(Libs.mockk)
    testImplementation(Libs.nhaarmanMock)
    testImplementation(Libs.archCore)
    testImplementation(Libs.robolectric)
    testImplementation(Libs.Coroutines.test)
    testImplementation(Libs.AndroidX.Test.core)
    testImplementation(Libs.AndroidX.Room.test)
    testImplementation(Libs.Junit5.api)

    testRuntimeOnly(Libs.Junit5.engine)
}