package com.spx.dev;

import sun.awt.datatransfer.ClipboardTransferable;

import java.awt.Toolkit;
import java.awt.datatransfer.*;

public class ClipBoardTest {

    public static void main(String[] args) throws InterruptedException {
        // 把文本设置到剪贴板（复制）
        setClipboardString("Hello System Clipboard!");

        // 从剪贴板中获取文本（粘贴）
        String text = getClipboardString();
        System.out.println("text: " + text);

        Toolkit.getDefaultToolkit().getSystemClipboard().addFlavorListener(new FlavorListener() {

            @Override
            public void flavorsChanged(FlavorEvent e) {
                System.out.println("e:"+e);
                try {
                    Clipboard systemClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                    DataFlavor[] availableDataFlavors = systemClipboard.getAvailableDataFlavors();
                    for (DataFlavor availableDataFlavor : availableDataFlavors) {
                        Object data = systemClipboard.getData(availableDataFlavor);
                        System.out.println(data.getClass());
                        System.out.println(data);
                    }
//                    Transferable tran = Toolkit.getDefaultToolkit().getSystemClipboard().ge(null);
//
//                    System.out.println(tran);
//                    if(tran instanceof sun.awt.datatransfer.ClipboardTransferable){
//                        sun.awt.datatransfer.ClipboardTransferable ct = (ClipboardTransferable) tran;
//                        DataFlavor[] transferDataFlavors = ct.getTransferDataFlavors();
//                        for (DataFlavor transferDataFlavor : transferDataFlavors) {
//                            Object transferData = ct.getTransferData(transferDataFlavor);
//                            System.out.println(transferData.getClass());
//                            System.out.println(transferData);
//                        }
//                    }
                } catch (Exception err) {
                    err.printStackTrace();
                }
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.currentThread().sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        Thread.currentThread().setDaemon(true);
    }

    /**
     * 把文本设置到剪贴板（复制）
     */
    public static void setClipboardString(String text) {
        // 获取系统剪贴板
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        // 封装文本内容
        Transferable trans = new StringSelection(text);
        // 把文本内容设置到系统剪贴板
        clipboard.setContents(trans, null);
    }

    public static void clearClipboard() {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//        Transferable trans = new FileTransfer(this.getSelectedFile());
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(trans, null);
    }


    /**
     * 从剪贴板中获取文本（粘贴）
     */
    public static String getClipboardString() {
        // 获取系统剪贴板
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

        // 获取剪贴板中的内容
        Transferable trans = clipboard.getContents(null);

        if (trans != null) {
            // 判断剪贴板中的内容是否支持文本
            if (trans.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                try {
                    // 获取剪贴板中的文本内容
                    String text = (String) trans.getTransferData(DataFlavor.stringFlavor);
                    return text;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }
}
