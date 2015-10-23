package jeb

import java.io.File

class Backuper(private val io: Io) {

    fun doBackup(state: State): State {

        val (newState, nextTapeNum) = state.selectNextTape()

        val tape = File(state.backupsDir, nextTapeNum.toString())
        val source = File(state.source)
        val latestBackup = io.latestDir(File(state.backupsDir))

        io.remove(tape)
        if (latestBackup == null) {
            io.copy(from = source,
                    to = tape)
        } else {
            io.sync(from = source,
                    base = latestBackup,
                    to = tape)
        }

        return newState
    }

}
