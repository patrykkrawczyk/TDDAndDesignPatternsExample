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
 * Singleton class, there should be only one instance of this object used to read *.prototype files from drive
 * Created by Patryk Krawczyk on 11.08.2016.
 */
public class PrototypeManager {

    private static PrototypeManager mInstance;
    private final List<Prototype> mPrototypes;

    /**
     * @return Returns instance of PrototypeManager
     */
    public static PrototypeManager getInstance() {
        if (mInstance == null) mInstance = new PrototypeManager();
        return mInstance;
    }

    private PrototypeManager() {
        mPrototypes = new ArrayList<>();
        getPrototypesFromCurrentDirectory();
    }

    /**
     * @return Amount of available Prototypes
     */
    public int getPrototypesCount() {
        return mPrototypes.size();
    }

    /**
     * @return List of available Prototypes
     */
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
            e.printStackTrace(); // TODO: add coverage
        }
    }

    private void parsePrototypeFile(Path path) {
        String fileName = path.getFileName().toString();
        Prototype prototype = new Prototype(fileName.substring(0, fileName.indexOf(".")));

        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(line -> prototype.addCommand(new Command(line)));
        } catch (IllegalArgumentException | IOException e) {
            e.printStackTrace(); // TODO: add coverage
        }

        if (prototype.isValid()) mPrototypes.add(prototype);
    }

}
