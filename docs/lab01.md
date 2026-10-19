# Lab 1 - Réponses

## Questions d'exploration

1. Il y a 3 modules Gradle : shared, androidApp et desktopApp. Ils sont
   déclarés dans settings.gradle.kts. iosApp est un projet Xcode, pas un
   module Gradle.

2. Les versions sont Kotlin 2.0.21, Compose Multiplatform 1.7.1, AGP
   9.0.1 et Gradle 9.1.0. Elles sont dans gradle/libs.versions.toml et
   dans gradle/wrapper/gradle-wrapper.properties.

3. shared utilise les plugins Kotlin Multiplatform, Android Kotlin
   Multiplatform Library, Compose Multiplatform et Kotlin Compose.
   androidApp utilise le plugin Android Application et Kotlin Compose.
   Avec AGP 9, le plugin Kotlin Android séparé n'est pas nécessaire.

4. Le minSdk vaut 24 dans shared/build.gradle.kts et dans
   androidApp/build.gradle.kts. C'est une valeur en dur.

5. shared/src contient commonMain, commonTest, androidMain, jvmMain
   et iosMain. iosMain est commun aux cibles iOS, donc il n'y a pas de
   dossier iosArm64Main.

6. expect fun getPlatform() est dans Platform.kt. Il y a 3 actual :
   Platform.android.kt, Platform.jvm.kt et Platform.ios.kt.

7. L'applicationId est fr.m2.pokequiz. La classe Desktop est
   fr.m2.pokequiz.MainKt, car Kotlin ajoute Kt aux fonctions de niveau
   fichier.

8. App() est dans shared/src/commonMain/.../App.kt. Elle est appelée dans
   MainActivity.kt et Main.kt.

9. Le .gitignore ignore les fichiers Gradle et Android générés, build/,
   .gradle/, local.properties, .idea/ en partie, .kotlin/, les
   fichiers iOS générés et les fichiers de TP. local.properties contient un
   chemin propre à l'ordinateur.

10. L'IDE signale que java.io.File n'est pas disponible dans commonMain,
    car c'est une classe JVM.

## Questions de réflexion

1. Desktop permet de tester l'UI rapidement sans lancer d'émulateur.

2. Le Hot Reload recharge surtout le code d'interface. Renommer main ou
   changer une dépendance Gradle demande un redémarrage.

3. Un bloc androidTarget ancien peut être incompatible avec la configuration
   AGP 9 actuelle et provoquer une erreur Gradle.

4. Greeting appelle la fonction expect. Chaque source set fournit son
   actual pour la plateforme concernée.

5. Le bytecode JVM est généralement le plus facile à décompiler. Il ne faut
   donc pas mettre de secret dans commonMain.

6. Les tâches d'exécution sont surtout :desktopApp:run et les tâches Android
   de type installDebug. Le Hot Reload se lance depuis l'IDE.

7. Les .class sont dans shared/build/classes. Les .klib sont des sorties
   Kotlin/Native pour les cibles natives.

8. La dépendance skiko apparaît dans la configuration Desktop car Compose
   Desktop l'utilise pour le rendu graphique.

9. Les preflight checks vérifient l'environnement nécessaire au projet. Les
   vérifications iOS ne s'appliquent pas sous Windows.

10. Je n'ai pas pu lancer iOS sous Windows. Le rendu Android et iOS devrait
    être proche avec le même code Compose partagé.

## Observation

Après une rotation Android, le compteur revient à zéro : il est stocké avec
remember et non avec rememberSaveable.
