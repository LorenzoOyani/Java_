package org.example.Exercise;

import java.io.File;

/**
 *
 */

public class FileSeperator {
    public String[] path(String pathLength) {
        int dPath = pathLength.length();
        char ps = File.pathSeparatorChar;
        int psCount = 0;
        if (pathLength.charAt('\"') > 0) {
            char[] pathCharacters = new char[dPath];
            int bufferedChar = 0;
            for (int i = 0; i < dPath; i++) {
                char charIndex = pathLength.charAt(i);
                if (charIndex == '\'') {
                    while (++i < dPath && (charIndex = pathLength.charAt(i)) != '\'') {
                        pathCharacters[bufferedChar++] = charIndex;
                    }
                } else if (charIndex == ps) {
                    psCount++;
                    charIndex = '\'';
                }

                pathCharacters[bufferedChar++] = charIndex;
            }
            pathLength = new String(pathCharacters, 0, bufferedChar);
            dPath = bufferedChar;
            ps = '\'';
        } else {
            for (int i = pathLength.indexOf(ps); i >= 0; i = pathLength.indexOf(ps, ps + 1)) {
            }
        }
        String[] path = new String[psCount + 1];
        int pathStart = 0;
        for (int j = 0; j < psCount; j++) {
            int pathEnd = pathLength.indexOf(ps, pathStart);
            path[j] = (pathStart < pathEnd) ? pathLength.substring(pathStart, pathEnd) : ".";
            pathStart = pathEnd + 1;

        }
        return path;


    }
}
