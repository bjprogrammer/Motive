package com.example.motive.search.model

import androidx.annotation.Keep
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.motive.BR

@Keep
class Geonames: BaseObservable() {
  @get:Bindable
  var requestId: String? = null
    set(value) {
      field = value
      notifyPropertyChanged(BR.requestId)
    }

  @get:Bindable
  var adminCode1: String? = null
    set(value) {
      field = value
      notifyPropertyChanged(BR.adminCode1)
    }

  @get:Bindable
  var lng: String? = null
    set(value) {
      field = value
      notifyPropertyChanged(BR.lng)
    }

  @get:Bindable
  var lat: String? = null
    set(value) {
      field = value
      notifyPropertyChanged(BR.lat)
    }

  @get:Bindable
  var geonameId: String? = null
    set(value) {
      field = value
      notifyPropertyChanged(BR.geonameId)
    }

  @get:Bindable
  var toponymName: String? = null
    set(value) {
      field = value
      notifyPropertyChanged(BR.toponymName)
    }

  @get:Bindable
  var countryId: String? = null
    set(value) {
      field = value
      notifyPropertyChanged(BR.countryId)
    }

  @get:Bindable
  var fcl: String? = null
    set(value) {
      field = value
      notifyPropertyChanged(BR.fcl)
    }

  @get:Bindable
  var name: String? = null
    set(value) {
      field = value
      notifyPropertyChanged(BR.name)
    }


  @get:Bindable
  var countryName: String? = null
    set(value) {
      field = value
      notifyPropertyChanged(BR.countryName)
    }

  @get:Bindable
  var adminName1: String? = null
    set(value) {
      field = value
      notifyPropertyChanged(BR.adminName1)
    }
}