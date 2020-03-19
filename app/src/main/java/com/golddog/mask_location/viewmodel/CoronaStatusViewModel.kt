package com.golddog.mask_location.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.golddog.mask_location.data.datasource.StatusDataSource
import com.golddog.mask_location.entity.AccumulateCoronaData
import com.golddog.mask_location.entity.CityCoronaData
import com.golddog.mask_location.entity.CoronaStatus
import io.reactivex.disposables.CompositeDisposable

class CoronaStatusViewModel(private val statusDataSource: StatusDataSource) : ViewModel() {
    var coronaList: MutableLiveData<AccumulateCoronaData> = MutableLiveData(
        AccumulateCoronaData(
            " ",
            CoronaStatus("0", "( + 0 )"),
            CoronaStatus("0", "( + 0 )"),
            CoronaStatus("0", "( + 0 )"),
            CoronaStatus("0", "( + 0 )")
        )
    )
    private val disposable = CompositeDisposable()

    init {
        setAccumulateData()
    }

    private fun setAccumulateData() {
        val accumulateDataDisposable = statusDataSource.getAccumulateData()
            .subscribe({
                coronaList.value = it
            }) {
                // TODO : Toast 띄워서 오류발생 알리기, 오류로그 : 데이터를 불러오지 못했습니다.
            }

        disposable.add(accumulateDataDisposable)
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}