package com.example.myapplication.composables.ui.main_menu

 import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
 import com.example.myapplication.db.domain.repository.NoteRepository
 import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MainMenuListViewModel @Inject constructor(
    private val repository: NoteRepository
) : ViewModel() {

    val noteList = repository.getAllNotes()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )
}