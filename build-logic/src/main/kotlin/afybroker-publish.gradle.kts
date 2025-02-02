plugins {
    java
    `maven-publish`
}

extensions.configure<PublishingExtension> {
    repositories {
        maven("https://maven.mcplugin.top/repository/minecraft/") {
            credentials(PasswordCredentials::class.java){
                username = project.findProperty("mavenUsername").toString()
                password = project.findProperty("mavenPassword").toString()
            }
        }
    }
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}
