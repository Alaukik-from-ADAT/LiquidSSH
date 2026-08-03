package dev.alaukik.aloovoice;

import java.io.*;

public final class RootShell {
    public static boolean available() {
        try { Process p=new ProcessBuilder("su","-c","id").start(); return p.waitFor()==0; }
        catch(Exception e){ return false; }
    }
    public static boolean run(String command) {
        try { Process p=new ProcessBuilder("su","-c",command).start(); return p.waitFor()==0; }
        catch(Exception e){ return false; }
    }
}
