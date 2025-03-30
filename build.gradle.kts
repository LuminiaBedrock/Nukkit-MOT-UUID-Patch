import java.io.ByteArrayOutputStream

tasks.register("applyPatches") {
    group = "patching"
    description = "Applies all patches from the patches directory to the Nukkit-MOT project"

    doLast {
        val patchesDir = file("patches")
        val projectDir = file("Nukkit-MOT")

        if (!projectDir.exists()) {
            throw GradleException("Nukkit-MOT directory not found! Clone the project first.")
        }

        if (!patchesDir.exists() || patchesDir.listFiles()?.isEmpty() == true) {
            throw GradleException("No patches found in the patches directory!")
        }

        patchesDir.listFiles { file -> file.extension == "patch" }?.forEach { patch ->
            println("Applying patch: ${patch.name}")

            val process = ProcessBuilder("git", "apply", "--ignore-whitespace", "--reject", "--directory=Nukkit-MOT", patch.absolutePath)
                .directory(rootDir)
                .redirectErrorStream(true)
                .start()

            val output = ByteArrayOutputStream()
            process.inputStream.copyTo(output)
            val exitCode = process.waitFor()

            if (exitCode != 0) {
                println("Failed to apply patch ${patch.name}:\n${output}")
                throw GradleException("Patch ${patch.name} failed to apply.")
            }
        }

        println("All patches applied successfully!")
    }
}
