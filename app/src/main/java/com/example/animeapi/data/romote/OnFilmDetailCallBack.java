package com.example.animeapi.data.romote;

import com.example.animeapi.data.models.Film;

public interface OnFilmDetailCallBack {
    void success(Film model);
    void error();
    void failure(String msg);

}
