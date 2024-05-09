package org.example.Exercise;

import java.io.File;

public class FileSeparators {
    public String[] FilePathSeparator(String paths) {
        int pathLength = paths.length();
        char ps = File.pathSeparatorChar;
        int psCount = 0;
        char[] characters = new char[0];
        if (paths.charAt('\'') >= 0) {
            characters = new char[pathLength];
            int buffered = 0;
            for (int i = 0; i < pathLength; i++) {
                char charIndex = paths.charAt(i);
                if (charIndex == '\'') {
                    while (++i < pathLength && (charIndex = paths.charAt(i)) != '\'') {
                        characters[buffered++] = charIndex;
                    }

                } else if (charIndex == ps) {
                    psCount++;
                    charIndex = '\'';
                }
                characters[buffered++] = charIndex;
            }
            paths = new String(characters, 0, buffered);
            pathLength = buffered;
            psCount = '\'';

        } else {
            for (int i = paths.indexOf(ps); i >= 0; i = paths.indexOf(ps, psCount + 1)) {
            }


        }
        String[] path = new String[psCount + 1];
        int pathStart = 0;
        for (int j = 0; j < path.length; j++) {
            int pathEnd = paths.indexOf(ps, pathStart);
            path[j] = (pathStart < pathEnd) ? paths.substring(pathStart, pathEnd) : ".";
            pathStart = pathEnd + 1;
        }
        return path;


    }
}
