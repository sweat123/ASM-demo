/*
 * Main.java
 * Copyright 2019 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package com.github.laomei.asm;

import org.apache.commons.io.FileUtils;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.IOException;

import static org.objectweb.asm.ClassWriter.COMPUTE_MAXS;

/**
 * @author luobo.hwz on 2019/3/4 14:46
 */
public class Main {

    public static void main(String[] args)
            throws IOException {
        ClassReader classReader = new ClassReader("com/github/laomei/asm/Hello");
        ClassWriter classWriter = new ClassWriter(COMPUTE_MAXS);
        AddClassVisitor metricClassVisitor = new AddClassVisitor(classWriter);
        classReader.accept(metricClassVisitor, ClassReader.SKIP_FRAMES);
        byte[] bytes = classWriter.toByteArray();
        File file = new File("Hello.class");
        file.createNewFile();
        FileUtils.writeByteArrayToFile(file, bytes);
    }
}
