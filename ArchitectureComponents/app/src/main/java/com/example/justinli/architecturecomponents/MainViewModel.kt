package com.example.justinli.architecturecomponents

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.os.Parcel
import android.os.Parcelable

class MainViewModel() : ViewModel(), Parcelable {

    private val textLiveData : MutableLiveData<String> = MutableLiveData()
    private val editTextLiveData : MutableLiveData<String> = MutableLiveData()

    constructor(parcel: Parcel) : this() {
        textLiveData.value = parcel.readString()
        editTextLiveData.value = parcel.readString()
    }

    fun text() : MutableLiveData<String> {
        return textLiveData
    }

    fun editText() : MutableLiveData<String> {
        return editTextLiveData
    }

    companion object CREATOR : Parcelable.Creator<MainViewModel> {
        override fun createFromParcel(parcel: Parcel): MainViewModel {
            return MainViewModel(parcel)
        }

        override fun newArray(size: Int): Array<MainViewModel?> {
            return arrayOfNulls(size)
        }
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(textLiveData.value)
        dest?.writeString(editTextLiveData.value)
    }

    override fun describeContents(): Int {
        return 0
    }

}