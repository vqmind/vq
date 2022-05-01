package com.vqmind.vq;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Query query = new Query(getInput());
        if (args.length == 1) {
            String result = query.find(args[0]);
            System.out.println(result != null ? result : "");
            return;
        }

        System.out.println("");
    }

    private static String getInput() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.lines().collect(Collectors.joining("\n"));
    }
}
