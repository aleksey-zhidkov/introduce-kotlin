package jeb

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.paranamer.ParanamerModule
import java.io.File

data class State @JsonCreator constructor(
        val backupsDir: String,
        val source: String,
        val hanoi: Hanoi) {

    fun selectNextTape(): Pair<State, Int> {
        val hanoi = with(hanoi) {
            if (done) reset() else this
        }

        val (newHanoi, disk) = hanoi.moveDisk()
        return Pair(copy(hanoi = newHanoi), disk)
    }

}

private val objectMapper = ObjectMapper().
        registerModule(ParanamerModule())

fun loadState(configFile: File): State {
    return objectMapper.readValue(configFile.readText(), State::class.java)
}

fun saveState(configFile: File, state: State) {
    configFile.parentFile.mkdirs()
    configFile.writeText(objectMapper.writeValueAsString(state))
}
