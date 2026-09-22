package de.sharpsharp.stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    // counter for calls
    public int c = 0;
    private String tmp;

    public int add(String s) {
        c = c + 1;
        // System.out.println("add called with " + s);
        int r = 0;
        if (s == null || s.equals("")) {
            return 0;
        } else {
            String d = ",";
            List<String> ds = new ArrayList<String>();
            String n = s;
            if (s.startsWith("//")) {
                // custom delimiter
                if (s.charAt(2) == '[') {
                    // multiple or long delimiters
                    int i = 2;
                    String cur = "";
                    boolean in = false;
                    while (i < s.length()) {
                        char ch = s.charAt(i);
                        if (ch == '[') {
                            in = true;
                            cur = "";
                        } else if (ch == ']') {
                            in = false;
                            ds.add(cur);
                        } else if (ch == '\n') {
                            break;
                        } else {
                            if (in) {
                                cur = cur + ch;
                            }
                        }
                        i = i + 1;
                    }
                    n = s.substring(i + 1);
                } else {
                    d = "" + s.charAt(2);
                    ds.add(d);
                    n = s.substring(4);
                }
            } else {
                ds.add(",");
            }
            // replace all delimiters with commas
            for (int i = 0; i < ds.size(); i++) {
                String x = ds.get(i);
                String y = "";
                for (int j = 0; j < n.length(); j++) {
                    if (n.startsWith(x, j)) {
                        y = y + ",";
                        j = j + x.length() - 1;
                    } else {
                        y = y + n.charAt(j);
                    }
                }
                n = y;
            }
            // replace again, just to be sure
            for (int i = 0; i < ds.size(); i++) {
                String x = ds.get(i);
                String y = "";
                for (int j = 0; j < n.length(); j++) {
                    if (n.startsWith(x, j)) {
                        y = y + ",";
                        j = j + x.length() - 1;
                    } else {
                        y = y + n.charAt(j);
                    }
                }
                n = y;
            }
            // newlines
            String y = "";
            for (int j = 0; j < n.length(); j++) {
                if (n.charAt(j) == '\n') {
                    y = y + ",";
                } else {
                    y = y + n.charAt(j);
                }
            }
            n = y;
            String[] parts = n.split(",");
            String neg = "";
            int negc = 0;
            for (int i = 0; i < parts.length; i++) {
                if (parts[i].equals("")) {
                    continue;
                }
                int v = Integer.parseInt(parts[i]);
                if (v < 0) {
                    if (negc == 0) {
                        neg = neg + v;
                    } else {
                        neg = neg + "," + v;
                    }
                    negc = negc + 1;
                } else {
                    if (v > 1000) {
                        // ignore big numbers
                    } else {
                        r = r + v;
                    }
                }
            }
            if (negc > 0) {
                throw new IllegalArgumentException("negatives not allowed: " + neg);
            }
            tmp = neg;
            System.out.println("result " + r);
            return r;
        }
    }

    private int helper(String s) {
        // old version
        // return Integer.parseInt(s.trim());
        return 0;
    }
}
