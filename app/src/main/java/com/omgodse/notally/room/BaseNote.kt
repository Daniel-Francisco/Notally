package com.omgodse.notally.room

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(indices = [Index(value = ["id", "folder", "pinned", "timestamp", "labels"])])
data class BaseNote(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val type: Type,
    val folder: Folder,
    val title: String,
    val pinned: Boolean,
    val timestamp: Long,
    val labels: HashSet<String>,
    val body: String,
    val spans: List<SpanRepresentation>,
    val items: List<ListItem>,
    val name: String,
    val phoneNumber: String,
    val email: String,
) : Item(ViewType.NOTE), Parcelable {

    companion object {

        fun createNote(id: Long, folder: Folder, title: String, pinned: Boolean, timestamp: Long, labels: HashSet<String>, body: String, spans: List<SpanRepresentation>): BaseNote {
            return BaseNote(id, Type.NOTE, folder, title, pinned, timestamp, labels, body, spans, emptyList(),"","","")
        }

        fun createList(id: Long, folder: Folder, title: String, pinned: Boolean, timestamp: Long, labels: HashSet<String>, items: List<ListItem>): BaseNote {
            return BaseNote(id, Type.LIST, folder, title, pinned, timestamp, labels, String(), emptyList(), items ,"","","")
        }

        fun createPhoneNumbers(id: Long, folder: Folder, title: String, pinned: Boolean, timestamp: Long, labels: HashSet<String>, body: String, spans: List<SpanRepresentation>, name: String, phoneNumber :String, email :String): BaseNote {
            return BaseNote(id, Type.PHONENUMBER, folder, title, pinned, timestamp, labels, body, spans, emptyList(),name,phoneNumber,email)
        }


    }
}