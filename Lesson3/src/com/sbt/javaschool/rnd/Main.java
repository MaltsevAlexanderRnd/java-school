package com.sbt.javaschool.rnd;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        DataProcessing objDataProcessing = new DataProcessing();

        objDataProcessing.ReadFile();
        objDataProcessing.OutputNumberOfWordsInAFile();
        objDataProcessing.OutputNumberOfWordSize();
        objDataProcessing.OutputDuplicateWords();
        objDataProcessing.OutputReverseLineFile();
        objDataProcessing.OutputReverseLineFileWithMyIterator();
        objDataProcessing.OutputEnteredUserNumLines();
    }
}
