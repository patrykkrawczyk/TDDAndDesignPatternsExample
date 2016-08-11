package com.patrykkrawczyk.tdddpexample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Patryk Krawczyk on 11.08.2016.
 */
public class PrototypeManager {

    private static PrototypeManager mInstance;
    private List<Prototype> mPrototypes;

    public static PrototypeManager getInstance() {
        if (mInstance == null) mInstance = new PrototypeManager();
        return mInstance;
    }

    private PrototypeManager() {
        mPrototypes = new ArrayList<>();
        getPrototypesFromCurrentDirectory();
    }

    public int getPrototypesCount() {
        return mPrototypes.size();
    }

    public List<Prototype> getPrototypes() {
        return new LinkedList<>(Collections.unmodifiableList(mPrototypes));
    }

    private void getPrototypesFromCurrentDirectory() {
        try {
            Files.walk(Paths.get(""))
                    .filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(".prototype"))
                    .forEach(this::parsePrototypeFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parsePrototypeFile(Path path) {
        String fileName = path.getFileName().toString();
        Prototype prototype = new Prototype(fileName.substring(0, fileName.indexOf(".")));

        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(line -> prototype.addCommand(new Command(line)));
        } catch (IllegalArgumentException | IOException e) {
            e.printStackTrace();
        }

        if (prototype.isValid()) mPrototypes.add(prototype);
    }

}
