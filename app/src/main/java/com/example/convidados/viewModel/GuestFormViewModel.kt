package com.example.convidados.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.convidados.model.GuestModel
import com.example.convidados.repository.GuestRepository

class GuestFormViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = GuestRepository.getInstance(application)

    private val guestModel = MutableLiveData<GuestModel>()
    val guest: LiveData<GuestModel> = guestModel


    private val _saveGuest = MutableLiveData<String>()
    val saveGuest: LiveData<String> = _saveGuest


    fun save(guest: GuestModel) {
        if (guest.id == 0) {
            if (repository.insert(guest)) {
                _saveGuest.value = "Inserido com sucesso"
            } else {
                _saveGuest.value = "Falha ao Inserir Convidado"
            }
        } else {
            if (repository.update(guest)) {
                _saveGuest.value = "Alterado com sucesso"
            } else {
                _saveGuest.value = "Falha ao alterar convidado"
            }
        }
    }

    fun get(id: Int) {
        guestModel.value = repository.get(id)
    }

}