package io.usoamic.commons.crossplatform.repositories.api

import io.reactivex.Single
import io.usoamic.commons.crossplatform.models.repository.notes.NoteEntity
import io.usoamic.commons.crossplatform.models.usecases.notes.NoteItem
import java.math.BigInteger

interface NotesRepository {
    val numberOfPublicNotes: Single<BigInteger>
    val numberOfUserNotes: Single<BigInteger>

    fun getNote(refId: BigInteger): Single<NoteEntity>
    fun getNoteForAccount(id: BigInteger): Single<NoteEntity>
    fun addPublicNote(password: String, content: String): Single<String>
    fun addUnlistedNote(password: String, content: String): Single<String>
}