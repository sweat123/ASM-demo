/*
 * AddClassVisitor.java
 * Copyright 2019 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package com.github.laomei.asm;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.ASM5;

/**
 * @author luobo.hwz on 2019/3/4 14:48
 */
public class AddClassVisitor extends ClassVisitor {

    public AddClassVisitor(final ClassVisitor cv) {
        super(ASM5, cv);
    }

    @Override
    public MethodVisitor visitMethod(final int access, final String name, final String desc,
            final String signature,
            final String[] exceptions) {
        MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        if (!name.equals("<init>")) {
            return new AddMethodVisitor(mv, access, name, desc);
        }
        return mv;
    }
}
