package com.example.josh.week7test711.model.remote;

import com.example.josh.week7test711.model.GitResponse;
import com.example.josh.week7test711.utils.NetworkAPI;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RemoteService {

    @GET(NetworkAPI.PATH)
    Observable<List<GitResponse>> getGit();
}
