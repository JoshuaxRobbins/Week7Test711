package com.example.josh.week7test711.model.remote;

import com.example.josh.week7test711.model.GitResponse;
import com.example.josh.week7test711.utils.NetworkAPI;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteDataService {
    private Retrofit createClient() {

        return new Retrofit.Builder()
                .baseUrl(NetworkAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private Observable<List<GitResponse>> getBooksObs() {
        return createClient().create(RemoteService.class).getGit();
    }

    public void getBooks(final DataCallback callback) {

        getBooksObs()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<GitResponse>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<GitResponse> books) {
                        callback.onSuccess(books);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFailure(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
