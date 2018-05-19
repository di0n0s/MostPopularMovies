package com.example.sfcar.mostpopularmovies.domain.interactor.usecase

import com.example.sfcar.mostpopularmovies.domain.interactor.params.Params
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver

abstract class BaseUseCase<T>(private val disposables: CompositeDisposable = CompositeDisposable()) {

    protected fun execute(params: Params, observer: DisposableObserver<T>) {
        val observable: Observable<T> = buildUseCaseObservable(params)
        addDisposable(observable.subscribeWith(observer))
    }


    fun dispose() {
        if (!disposables.isDisposed)
            disposables.dispose()
    }

    private fun addDisposable(disposable: Disposable) {
        checkNotNull(disposable)
        checkNotNull(disposables)
        disposables.add(disposable)
    }

    abstract fun buildUseCaseObservable(params: Params): Observable<T>


}