/*
 * Copyright (c) 2014, Oracle America, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 *  * Neither the name of Oracle nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package jmhTest;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@State(Scope.Thread)
//@OutputTimeUnit(TimeUnit.MILLISECONDS)
//@BenchmarkMode(Mode.AverageTime)
public class MyBenchmarkDigit {
	
	private static int count = 300000;
	private final static String reg = "\\d+";

	private static String testWord = "123456a";
	
    @Benchmark
    public void test1CharacterisDigit() {
    	for(int i = 0; i < count; i++) {
    		test1(testWord);
    	}
    }
    
    @Benchmark
    public void test2IntegerParseInt() {
    	for(int i = 0; i < count; i++) {
    		test2(testWord);
    	}
    }
    
    @Benchmark
    public void test3Reg() {
    	for(int i = 0; i < count; i++) {
    		test3(testWord);
    	}
    }

    private static boolean test1(String s) {

        boolean isDigit = true;

        for (int i = 0; i < s.length(); i++) {
            isDigit = Character.isDigit(s.charAt(i));
            if (!isDigit) {
                break;
            }
        }

        return isDigit;
    }
    
    private static boolean test2(String s) {

        boolean isDigit = true;

        try {
            Integer.parseInt(s);
        } catch (Exception e) {
            isDigit = false;
        }

        return isDigit;

    }

    private static boolean test3(String s) {

        return s.matches(reg);

    }
    
    public static void main(String... args) throws RunnerException {

        Options opt = new OptionsBuilder().include(MyBenchmarkDigit.class.getSimpleName()).warmupIterations(5)
                .measurementIterations(5).forks(2).build();

        if(args.length > 0) {
        	count = Integer.parseInt(args[0]);
        }
        
        if(args.length > 1) {
        	testWord = args[1];
        }
        
        System.out.println("テスト設定 繰り返し数：" + count);
        System.out.println("テスト設定 判定ワード：" + testWord);
        
        System.out.println("------------");
        System.out.println("test1: " + test1(testWord));
        System.out.println("test2: " + test2(testWord));
        System.out.println("test3: " + test3(testWord));
        System.out.println("------------");
        
        new Runner(opt).run();
    }
    
}
