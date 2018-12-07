package com.example.josh.week7test711.model.remote;

import com.example.josh.week7test711.model.GitResponse;

import java.util.List;

public interface DataCallback {
    void onSuccess(List<GitResponse> bookList);

    void onFailure(String error);
}
