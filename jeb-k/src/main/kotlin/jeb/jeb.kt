package jeb

import java.io.File

val usage = "Usage: java jeb.jeb <init|backup dir>"

public fun main(args: Array<String>) {
    when {
        args.size == 0 -> println(usage)
        args[0] == "init" -> init()
        args[0] == "backup" -> backup(File(args[1]))
        else -> println(usage)
    }
}

private fun init() {
    val sourceDir = with(readLine("Source directory: ")) {
        if (this.endsWith('/')) this else "$this/"
    }

    val backupDir = readLine("Backups directory: ")
    val disksCount = readLine("Backups count: ").toInt()

    val state = State(backupDir, sourceDir, Hanoi(listOf((disksCount downTo 1).toList(), emptyList(), emptyList()), 0))
    saveState(File(backupDir, "jeb.json"), state)
}

private fun backup(backupDir: File) {
    val config = File(backupDir, "jeb.json")
    val state = loadState(config)
    val newState = Backuper(Io()).doBackup(state)
    saveState(config, newState)
}

private fun readLine(invitation: String): String {
    print(invitation)
    return System.`in`.bufferedReader().readLine()
}
