package com.example.game;

import java.util.ArrayList;

public interface IStorageWriter {
    ArrayList<String>  getValuesToWrite();
    void populateFields(ArrayList<String> data);
}
