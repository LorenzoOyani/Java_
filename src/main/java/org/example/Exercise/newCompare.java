package org.example.Exercise;

import java.io.File;
import java.util.Comparator;
import java.util.Map;

public class newCompare implements Comparator<String> {
    public static void main(String[] args) {
        newCompare compared = new newCompare();
        String s1 = "John";
        String s2 = "James";
        Object diff = compared.compare(s1, s2);
        System.out.println(diff);


    }

    @Override
    public int compare(String o1, String o2) {
        int n1 = o1.length();
        int n2 = o2.length();
        int min = Math.min(n1, n2);
        for (int i = 0; i < min; i++) {
            int c1 = o1.charAt(i);
            int c2 = o2.charAt(i);
            if(c1 != c2){
                return c1- c2;
            }
        }
        return n1 - n2;
    }


//    static class EntryComparator implements Comparator<Map<String, Object>> {
//        public int compare(Map.Entry<String, Object> s1,
//                           Map.Entry<String, Object> s2) {
//            newCompare entryCompare = new newCompare();
//            return entryCompare.compare(s1.getKey(), s2.getKey());
//
//        }


        public int compare(Map<String, Integer> o1, Map<String, Integer> o2) {
            int n1 = o1.size();
            int n2 = o2.size();
            int min = Math.min(n1, n2);
            for(int i = 0; i < min; i++){
                int c1 = o1.get(i);
                int c2 = o2.get(i);
                if(c1 != c2){
                    return c1 - c2;
                }

            }
            return n1 - n2;
        }
//        FileOutputStream

    }

     class Separator {
        public String[] pathFinder(String ldPath) {
            int dlen = ldPath.length();
            char ps = File.pathSeparatorChar;
            int psCount = 0;

            if (ldPath.indexOf('\"') >= 0) {
                char[] buffers = new char[dlen];
                int buffred = 0;
                for (int i = 0; i < dlen; i++) {
                    char ch = ldPath.charAt(i);
                    if (ch == '\"') {
                        while (++i < dlen && (ch = ldPath.charAt(i)) != '\"') {
                            buffers[buffred++] = ch;
                        }
                    } else {
                        if (ch == ps) {
                            psCount++;
                            ch = '\"';
                        }
                    }
                    buffers[buffred++] = ch;

                }
                ldPath = new String(buffers, 0, buffred);
                dlen = buffred;
                ps = '\"';

            } else {
                for (int i = ldPath.indexOf(ps); i >= 0; i = ldPath.indexOf(ps, i + 1)) {
                    psCount++;
                }
            }
            String[] path = new String[psCount + 1];
            int pathStart = 0;

            for (int j = 0; j < psCount; j++) {
                int pathEnd = ldPath.indexOf(ps, pathStart);
                path[j] = (pathStart < pathEnd) ? ldPath.substring(pathStart, pathEnd) : ".";
                pathStart = pathEnd + 1;
            }
            path[psCount] = (pathStart < dlen) ? ldPath.substring(pathStart, dlen) : ".";
            return path;
        }

    }


