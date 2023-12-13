import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomsiswa_aplikasisiswa.model.DetailSiswa
import com.example.roomsiswa_aplikasisiswa.model.UIStateSiswa
import com.example.roomsiswa_aplikasisiswa.model.toSiswa
import com.example.roomsiswa_aplikasisiswa.model.toUiStateSiswa
import com.example.roomsiswa_aplikasisiswa.repository.RepositoriSiswa
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class EditViewModel (
    savedStateHandle: SavedStateHandle,
    private val repositoriSiswa: RepositoriSiswa
) : ViewModel() {
    var siswaUiState by mutableStateOf(UIStateSiswa())
        private set

    private val itemId: Int = checkNotNull(savedStateHandle[ItemEditDestination.itemIdArg])

    init {
        viewModelScope.launch {
            siswaUiState = repositoriSiswa.getSiswaStream(itemId)
                .filterNotNull()
                .first()
                .toUiStateSiswa()
        }
    }

    suspend fun updateSiswa() {
        if (validasiInput(siswaUiState.detailSiswa)) {
            repositoriSiswa.updateSiswa((siswaUiState.detailSiswa.toSiswa()))
        }
        else {
            println("Data tidak valid")
        }
    }

    fun updateUIState(detailSiswa: DetailSiswa) {
        siswaUiState =
            UIStateSiswa(detailSiswa = detailSiswa, isEntryValid = validasiInput(detailSiswa))
    }

    private fun validasiInput(uiState: DetailSiswa = siswaUiState.detailSiswa): Boolean {
        return with(uiState) {
            nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()
        }
    }
}