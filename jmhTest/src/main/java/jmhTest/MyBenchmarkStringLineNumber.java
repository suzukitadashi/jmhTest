package jmhTest;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class MyBenchmarkStringLineNumber {

	private static String[] list = {"0","1","2","3","4","5","6","7","8", "9"};
	
	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder().include(MyBenchmarkStringLineNumber.class.getSimpleName()).warmupIterations(5)
				.measurementIterations(5).forks(2).build();
		new Runner(opt).run();

	}

	private static final int count = 100000;

	@Benchmark
	public void call1StringLine() {
		for (int i = 0; i < count; i++) {
			test1StringLine();
		}
	}

	@Benchmark
	public void call2StringConcat() {
		for (int i = 0; i < count; i++) {
			test2StringConcat();
		}
	}

	@Benchmark
	public void call3StringBuffer() {
		for (int i = 0; i < count; i++) {
			test3StringBuffer();
		}
	}

	@Benchmark
	public void call4StringBuilder() {
		for (int i = 0; i < count; i++) {
			test4StringBuilder();
		}
	}

	public void test1StringLine() {

		int i = 0;
		String str0 = String.valueOf(i);
		i++;
		String str1 = String.valueOf(i);
		i++;
		String str2 = String.valueOf(i);
		i++;
		String str3 = String.valueOf(i);
		i++;
		String str4 = String.valueOf(i);
		i++;
		String str5 = String.valueOf(i);
		i++;
		String str6 = String.valueOf(i);
		i++;
		String str7 = String.valueOf(i);
		i++;
		String str8 = String.valueOf(i);
		i++;
		String str9 = String.valueOf(i);

		String str = str0 + str1 + str2 + str3 + str4 + str5 + str6 + str7 + str8 + str9;

	}

	public void test2StringConcat() {

		int i = 0;
		String str0 = String.valueOf(i);
		i++;
		String str1 = String.valueOf(i);
		i++;
		String str2 = String.valueOf(i);
		i++;
		String str3 = String.valueOf(i);
		i++;
		String str4 = String.valueOf(i);
		i++;
		String str5 = String.valueOf(i);
		i++;
		String str6 = String.valueOf(i);
		i++;
		String str7 = String.valueOf(i);
		i++;
		String str8 = String.valueOf(i);
		i++;
		String str9 = String.valueOf(i);

		String str = str0.concat(str1).concat(str2).concat(str3).concat(str4).concat(str5).concat(str6).concat(str7)
				.concat(str8).concat(str9);

	}

	public void test3StringBuffer() {

		int i = 0;
		String str0 = String.valueOf(i);
		i++;
		String str1 = String.valueOf(i);
		i++;
		String str2 = String.valueOf(i);
		i++;
		String str3 = String.valueOf(i);
		i++;
		String str4 = String.valueOf(i);
		i++;
		String str5 = String.valueOf(i);
		i++;
		String str6 = String.valueOf(i);
		i++;
		String str7 = String.valueOf(i);
		i++;
		String str8 = String.valueOf(i);
		i++;
		String str9 = String.valueOf(i);

		StringBuffer bf = new StringBuffer();

		bf.append(str0).append(str1).append(str2).append(str3).append(str4).append(str5).append(str6).append(str7)
				.append(str8).append(str9);

		String str = bf.toString();
		
	}

	public void test4StringBuilder() {

		int i = 0;
		String str0 = String.valueOf(i);
		i++;
		String str1 = String.valueOf(i);
		i++;
		String str2 = String.valueOf(i);
		i++;
		String str3 = String.valueOf(i);
		i++;
		String str4 = String.valueOf(i);
		i++;
		String str5 = String.valueOf(i);
		i++;
		String str6 = String.valueOf(i);
		i++;
		String str7 = String.valueOf(i);
		i++;
		String str8 = String.valueOf(i);
		i++;
		String str9 = String.valueOf(i);
		StringBuilder bf = new StringBuilder();

		bf.append(str0).append(str1).append(str2).append(str3).append(str4).append(str5).append(str6).append(str7)
				.append(str8).append(str9);

		String str = bf.toString();
	}
}
